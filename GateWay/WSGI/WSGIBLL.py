# coding=utf-8
# encoding=utf-8

from DataBase import Model,DAL
from Helper import LogHelper as log


def RecDataConduct(Crljsonobject):
    '''
    # 接受到的控制指令写入数据库
    :param Crljsonobject:
    :return:
    '''
    try:
        accrllist=Model.ACControl().Json2ModelList(obj=Crljsonobject)
        '''
        将accrllist写入数据库
        '''
        DAL.insertBatch(element_list=accrllist)
        responseprint = Model.Response().success(data='OK')
        return responseprint
    except Exception as e:
        log.warn(e)
        return Model.Response().failure(failmessage=e)
