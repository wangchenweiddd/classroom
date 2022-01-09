# coding=utf-8
# encoding=utf-8
from flask import Flask
from flask import request
from flask import Response
from flask import render_template
from WSGI import WSGIBLL
from DataBase import Model
import Helper.ConfigHelper as config
import json
from Helper import JsonHelper
#
# ###########################################################
# # 设置Flask返回类型
# ###########################################################
# class WsgiResponse(Response):
#     default_mimetype = 'application/json'
#
# class WsgiFlask(Flask):
#     response_class =WsgiResponse

app = Flask(__name__)
# 初始化一个WsgiFlask实体类app
headers = {"Content-type": "application/json"}


###########################################################
# 设置Flask的api函数
###########################################################
@app.route('/aircondition/api/control/post', methods=['GET', 'POST'])
def home():
    # # request.headers.get('headers')
    # print (request.get_json())
    # return request.get_json()
    # # return '<h1>Home</h1>'
    if request.method == 'POST':

        IniData = request.get_data()
        CrlJsonData = json.loads(IniData,encoding='utf-8')
        # print CrlJsonData
        responsedata = WSGIBLL.RecDataConduct(Crljsonobject=CrlJsonData)
        jsonresponsedata = json.dumps(responsedata,cls=JsonHelper.ResponseEncoder)
        return jsonresponsedata
    else:
        return str(Model.Response().failure(failmessage='只接受post请求！'))
        # return '<h1>只接受post请求！</h1>'

# 启动WSGI
def startwsgi():
    # 空调网关地址：http://localhost:8000/aircondition/api/control/post
    app.run(host=config.getConfig(section='address',key='localhost'),
            port=int(config.getConfig(section='address',key='localport')))