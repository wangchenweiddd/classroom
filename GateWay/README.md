#GateWayDateMonitor

1.将流水表中的数据中存在的数据上传到服务器。
2.为服务器提供接口，接收控制指令数据。
3.将控制指令执行结果上传（0000）

注意：
记住去修正config文件中的路径信息


操作流程：
1.将Helper文件夹下的ConfigHelper.py文件中的config.readfp(fp=open('C:\\Users\\Administrator\\Desktop\\GateWay\\Helper\\appconfig.conf', mode='r'))中fp指向的地址改为脚本所在文件夹。
2.注意修改Helper文件夹下的appconfig.conf文件中的各项文件配置信息。