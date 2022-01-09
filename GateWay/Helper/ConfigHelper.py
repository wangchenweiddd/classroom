# coding=utf-8
# encoding=utf-8

import ConfigParser
import os


# 获取config配置文件
def getConfig(section, key):
    config = ConfigParser.ConfigParser()
    # config.readfp(fp=open('E:\\pythonProject\\GateWay\\Helper\\appconfig.conf', mode='r'))
    config.readfp(fp=open(getConfipath(), mode='r'))
    returndata = config.get(section, key)
    return returndata


def getConfipath():
    config = ConfigParser.ConfigParser()
    path = os.getcwd() + '/appconfig.conf'
    config.read(path)
    return path
