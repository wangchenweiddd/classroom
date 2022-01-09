# coding=utf-8
# encoding=utf-8

import json
import DataBase.DAL as DAL
import time
from Helper import LogHelper as log
from PostConduct import PostBLL as Post
import DataBase.Model as model
import Helper.ConfigHelper as config
import WSGI.WSGIIni as localwsgi
from time import ctime,sleep
import threading


def post():
    while True:
        try:
            postingcrldata = DAL.RetCrlSended()
            if len(postingcrldata) is not 0:
                Post.PostCrlDataWhole(postingcrldata)
            sleep(1)
            postingwaterdata = DAL.RetAcSendingList()
            if len(postingwaterdata) is not 0:
                Post.PostWaterDataWhole(postingwaterdata)
            sleep(1)
        except Exception as e:
            log.warn([e])

if __name__ == '__main__':
    threadpost = threading.Thread(target=post())
    threadpost.setDaemon(True)
    threadpost.start()
