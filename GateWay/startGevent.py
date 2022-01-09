# coding=utf-8

import Helper.ConfigHelper as config
from gevent.wsgi import WSGIServer
from WSGI.WSGIIni import app
print config.getConfig(section='address', key='localhost')
print int(config.getConfig(section='address', key='localport'))
http_server = WSGIServer((config.getConfig(section='address', key='localhost'),
                          int(config.getConfig(section='address', key='localport'))), app)
http_server.serve_forever()
