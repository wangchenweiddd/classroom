using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionControl
{
    public class AirConditionStateModel
    {
        //设备ID，与服务器相匹配
        public int id { get; set; }

        public string randomid { get; set; }

        public int deviceId { get; set; }//设备的本地id

        public int deviceAddress { get; set; }//设备的物理地址

        public int devicePort { get; set; }

        public string atemp { get; set; }

        public string updateTime { get; set; }

        public string helec { get; set; }

        public string fmodel { get; set; }

        public string dwind { get; set; }

        public string aoc { get; set; }

        public string status { get; set; }

        public string aocTime { get; set; }

        public string openTime { get; set; }//开机持续时间

        public string errorMsg { get; set; }//空调故障信息

        public string etemp { get; set; }//环境温度.
    }

    public class AirConditionSetModel
    {
        public int deviceId { get; set; }//设备的本地id

        public int deviceAddress { get; set; }//设备的物理地址

        public int devicePort { get; set; }
    }

    public class AirConditionStatusModel
    {
        //设备ID，与服务器相匹配
        public int deviceId { get; set; }//设备的本地id

        public string atemp { get; set; }

        public string aoc { get; set; }

        public string dwind { get; set; }

        public string helec { get; set; }

        public string fmodel { get; set; }

        public string etemp { get; set; }//环境温度.

        public string errorMsg { get; set; }//空调故障信息

        public string aocTime { get; set; }

        public string updateTime { get; set; }
    }

    public class AirConditionControlModel
    {
        public int id { get; set; }

        public int deviceId { get; set; }//设备的本地id

        public string atemp { get; set; }

        public string aoc { get; set; }

        public string dwind { get; set; }

        public string fmodel { get; set; }

        public string helec { get; set; }

        public string updateTime { get; set; }

        public string status { get; set; }
    }

}
