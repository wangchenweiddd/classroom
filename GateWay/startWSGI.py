# coding=utf-8
# encoding=utf-8
import json
import DataBase.DAL as DAL
import time
from PostConduct import PostBLL as Post
import DataBase.Model as model
import Helper.ConfigHelper as config
import WSGI.WSGIIni as localwsgi
from time import ctime,sleep
import threading


def wsgi():
    localwsgi.startwsgi()

if __name__ == '__main__':
    threadwsgi = threading.Thread(target=wsgi())
    threadwsgi.setDaemon(True)
    threadwsgi.start()

