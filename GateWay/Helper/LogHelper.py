# coding=utf-8
# encoding=utf-8

import logging
import sys

# 获取logger实例，如果参数为空则返回root logger
logger = logging.getLogger("AppName")

# 指定logger输出格式
formatter = logging.Formatter('%(asctime)s %(levelname)-8s: %(message)s')

# 文件日志
file_handler = logging.FileHandler("applog.log")
file_handler.setFormatter(formatter)  # 可以通过setFormatter指定输出格式
# 为logger添加的日志处理器
logger.addHandler(file_handler)

def warn(buglist):
    for row in buglist:
        logger.warn(row)