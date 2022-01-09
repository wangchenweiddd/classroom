# coding=utf-8
# encoding=utf-8

from __future__ import print_function
import urllib
import httplib
import json
import DataBase.DAL as DAL
import Helper.LogHelper as log
import Helper.ConfigHelper as config
from DataBase import Model


def PostData(postData):
    """
    将数据库函数DAL中获得的模型数据队列发送至服务器
    :param postData: DAL中获得的模型数据队列!!直接查询到的队列数据
    :return:
    """
    httpClient = None
    try:
        # params = urllib.urlencode(dicstr)
        headers = {"Content-type": "application/json"}

        httpClient = httplib.HTTPConnection(host='localhost', port=8000, strict=False, timeout=30)
        httpClient.request(method="POST", url='', body=json.dumps(postData), headers=headers)

        response = httpClient.getresponse()
        print(response.status)
        print(response.reason)
        print(response.read())
        print(response.getheaders())
        return response.read()
    except Exception as e:
        print(e)
    finally:
        if httpClient:
            httpClient.close()


def PostDataSingle(postingdata, moreurl='/'):
    """
    待Post数据单次Post流程
    :param postingdata: 流水表数据
    :return: response结构体
    """
    httpClient = None
    try:
        headers = {"Content-type": "application/json"}
        httpClient = httplib.HTTPConnection(host=config.getConfig(section='address', key='severhost'),
                                            port=int(config.getConfig(section='address', key='severport')),
                                            strict=False,
                                            timeout=30)
        httpClient.request(method="POST", url=moreurl, body=json.dumps(postingdata), headers=headers)
        response = httpClient.getresponse()
        responsereadstr = response.read()
        resposemodeldict = json.loads(responsereadstr)
        resposeModel = Model.Response.Json2ModelList(resposemodeldict)
        # print type(resposeModel[0])
        # print resposeModel.meta.success
        return resposeModel.meta.success
    except Exception as e:
        log.warn(e)
    finally:
        if httpClient:
            httpClient.close()


def PostWaterDataWhole(waterdata):
    """
    流水表发送全过程。发送失败则按照原数据循环发送N=3次，保留未发送数据；发送成功则删除已发送的流水表数据。
    :param waterdata: 流水表数据
    :return:
    """
    count = 3

    while count != 0:
        count = count - 1
        if PostDataSingle(waterdata, moreurl=config.getConfig(section='address', key='wateryurl')):
            '''
            如果服务器的返回结果为True，数据Post成功； 
            下一步则删除流水表中的这些数据。
            '''
            for row in waterdata:
                DAL.deleteWaterData(element=row)
            return True
        else:
            continue


def PostCrlDataWhole(ctrldata):
    """
    控制表发送全过程。发送失败则按照原数据循环发送N=3次，保留未发送数据；发送成功则删除已发送控制表数据。
    :param ctrldata: 流水表数据
    :return:
    """
    count = 3
    while count != 0:
        count = count - 1
        if PostDataSingle(ctrldata, moreurl=config.getConfig(section='address', key='controlurl')):
            '''
            如果服务器的返回结果为True，数据Post成功；
            下一步则删除控制表表中的这些数据。
            '''
            for row in ctrldata:
                DAL.deleteSendedCrlData(element=row)
            return True
        else:
            continue
