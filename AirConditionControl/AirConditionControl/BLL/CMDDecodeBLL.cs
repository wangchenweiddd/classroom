using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionControl.BLL
{
    class CMDDecodeBLL
    {
         /// <summary>
        /// 对——查询——返回数据进行解码
        /// </summary>
        /// <param name="data"></param>
        public static AirConditionStateModel QueryReturnDataDecode(byte[] data)
        {
            AirConditionStateModel airConditionStateModel = new AirConditionStateModel();
            airConditionStateModel.deviceAddress = Convert.ToInt32(data[6].ToString());
            airConditionStateModel.aoc = AocDecode(data);
            airConditionStateModel.atemp = AtempDecode(data);
            airConditionStateModel.dwind = DwindDecode(data);
            airConditionStateModel.fmodel = FmodelDecode(data);
            airConditionStateModel.helec = HelecDecode(data);
            airConditionStateModel.updateTime = UpdatetimeDecode();
            airConditionStateModel.errorMsg = ErrorMsgDecode(data);
            //airConditionStateModel.etemp = etempDecode(data);
            if (etempDecode(data).Trim().Length>3)
            {
                airConditionStateModel.errorMsg += ";";
                airConditionStateModel.errorMsg += etempDecode(data);
            }
            else
            {
                airConditionStateModel.etemp = etempDecode(data);
            }
            return airConditionStateModel;
    }

          /// <summary>
        /// 对——控制——返回数据进行解码
        /// </summary>
        /// <param name="data"></param>
        public static AirConditionStateModel ControlReturnDataDecode(AirConditionStateModel airConditionStateModel)
        {
            airConditionStateModel.updateTime = UpdatetimeDecode();
            return airConditionStateModel;
        }

        #region 下发-------------------查询---------------指令后，设备返回指令的解码
        /// <summary>
        /// 空调---------------------开关机------------------状态检查。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        private static string AocDecode(byte[] data)
        {
            string AocStatus = String.Empty;
            if ((data[8] & 0x01) != 0x01)
            {
                AocStatus = "关机";
            }
            else
            {
                AocStatus = "开机";
            }
            return AocStatus;
        }

        /// <summary>
        /// 空调----------------温度--------------------------状态检查。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        private static string AtempDecode(byte[] data)
        {
            byte temp = data[8];
            temp >>= 4;
            int tempnum = Convert.ToInt32(temp) + 16;
            return tempnum.ToString();
        }

        /// <summary>
        /// 空调-----------------更新时间-----------------------------。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        private static string UpdatetimeDecode()
        {
            string  UpdatetimeStatus = DateTime.Now.ToString();
            return UpdatetimeStatus;
        }

        /// <summary>
        /// 空调---------------电子锁-----------------------状态检查。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        private static string HelecDecode(byte[] data)
        {
            string HelecStatus = String.Empty;
            if ((data[15] & 0x20) == 0x20)
            {
                HelecStatus = "有效";
            }
            else
            {
                HelecStatus = "无效";
            }
            return HelecStatus;
        }

        /// <summary>
        /// 空调---------------模式--------------------------状态检查。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        private static string FmodelDecode(byte[] data)
        {
            string FmodelStatus = String.Empty;
            if ((data[13] & 0x00) == 0x00)
            {
                FmodelStatus = "自动";
            }
            if ((data[8 + 5] & 0x20) == 0x20)
            {
                FmodelStatus = "制冷";
            }
            if ((data[8 + 5] & 0x40) == 0x40)
            {
                FmodelStatus = "制热";
            }
            if ((data[8 + 5] & 0x60) == 0x60)
            {
                FmodelStatus = "送风";
            }
            if ((data[8 + 5] & 0x80) == 0x80)
            {
                FmodelStatus = "除湿";
            }
            return FmodelStatus;
        }

        /// <summary>
        /// 空调-------------风速------------------------------状态检查。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        private static string DwindDecode(byte[] data)
        {
            string DwindStatus = String.Empty;
            if ((data[8 + 3] & 0x20) == 0x20)
            {
                DwindStatus = "高风";
            }
            if ((data[8 + 3] & 0x40) == 0x40)
            {
                DwindStatus = "中风";
            }
            if ((data[8 + 3] & 0x60) == 0x60)
            {
                DwindStatus = "低风";
            }
            if ((data[8 + 3] & 0x80) == 0x80)
            {
                DwindStatus = "自动";
            }
            return DwindStatus;
        }

        /// <summary>
        /// 空调-----------------故障状态-----------------------状态检查。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        private static string ErrorMsgDecode(byte[] data)
        {
            string BugStateStatus = String.Empty;
            if ((data[8 + 15] & 0x1f) == 0x00)
            {
                BugStateStatus = "无";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x01)
            {
                BugStateStatus = "室温传感器故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x02)
            {
                BugStateStatus = "室内管温传感器故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x03)
            {
                BugStateStatus = "室内制热过载保护";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x04)
            {
                BugStateStatus = "室内制冷结冰保护";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x05)
            {
                BugStateStatus = "室内、外板通讯故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x06)
            {
                BugStateStatus = "面板与内机通信故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x07)
            {
                BugStateStatus = "模块故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x08)
            {
                BugStateStatus = "无负载";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x09)
            {
                BugStateStatus = "压机过热";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x0A)
            {
                BugStateStatus = "CT电流异常";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x0B)
            {
                BugStateStatus = "外环传感器故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x0C)
            {
                BugStateStatus = "外热交传感器故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x0D)
            {
                BugStateStatus = "电源超、欠压保护";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x0E)
            {
                BugStateStatus = "压力保护";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x0F)
            {
                BugStateStatus = "外蒸发传感器故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x10)
            {
                BugStateStatus = "制冷过载";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x11)
            {
                BugStateStatus = "EEPROM故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x12)
            {
                BugStateStatus = "外回气传感器故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x13)
            {
                BugStateStatus = "压机传感器故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x14)
            {
                BugStateStatus = "室内蒸发温度";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x15)
            {
                BugStateStatus = "排水故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x16)
            {
                BugStateStatus = "电源三相故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x17)
            {
                BugStateStatus = "湿度传感器故障"; 
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x18)
            {
                BugStateStatus = "室内风机故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x19)
            {
                BugStateStatus = "室外风机故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x1A)
            {
                BugStateStatus = "压力保护";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x1B)
            {
                BugStateStatus = "电子膨胀阀故障";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x1C)
            {
                BugStateStatus = "除尘网需清洗";
                return BugStateStatus;
            }
            if ((data[8 + 15] & 0x1f) == 0x1F)
            {
                BugStateStatus = "控制系统故障";
                return BugStateStatus;
            }
            else
            {
                return "无";
            }
        }

        /// <summary>
        /// 空调-------------环境温度------------------------------状态检查。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        private static string etempDecode(byte[] data)
        {
            int inttemp = Convert.ToInt32(data[8 + 8]);
            if (data[8+8]==0x00)
            {
                return "温度传感器开路";
            }
            if (data[8+8]==0x01)
            {
                return "未设温度传感器";
            }
            if (data[8+8]==0xff)
            {
                return "温度传感器短路";
            }
            if (inttemp>=34&&inttemp<=214)
            {
                return (inttemp - 64).ToString();
            }
            else
            {
                return "null";
            }
        }
        #endregion

        #region 代码正确性判断
        #region 返回指令的通用检查函数

        /// <summary>
        /// 检查设备返回指令是否符合协议标准。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        public static bool ReturnDataHeadRailCheck(byte[] data)
        {
            //控制返回指令长度长度为10，查询返回指令长度为26
            if (data.Length == 10 || data.Length == 26)
            {
                if (data[0] == 0xf4 && data[1] == 0xf5 && data[data.Length - 1] == 0xfb)
                {
                    if (ReturnDataCheckbyteCheck(data))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        /// <summary>
        /// 检查设备返回指令的校验位是否正确。
        /// </summary>
        /// <param name="data"></param>
        /// <returns></returns>
        public static bool ReturnDataCheckbyteCheck(byte[] data)
        {
            byte checkbyte = data[data.Length - 2];
            byte[] checkingbyte = data;//待求校验位的数据
            byte[] checkedbyte = CMD.CheckByteCount(checkingbyte);//已经求出的校验位数据
            if (checkbyte == checkedbyte[checkedbyte.Length - 2])
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        #endregion

        #region 控制指令部分
        /// <summary>
        /// 控制指令返回指令的命令属性的检测。控制指令是否重发，以该函数返回值为标准。
        /// </summary>
        /// <param name="RetData"></param>
        /// <returns></returns>
        public static bool ControlCmdRetDataProperityCheck(byte[] RetData)
        {
            if (ReturnDataHeadRailCheck(RetData))
            {
                if (RetData[7] == 0x10)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        /// <summary>
        /// 控制指令解码，不需要解码
        /// </summary>
        /// <param name="controldata"></param>
        public static void CrlReturnDataDecode(byte[] controldata)
        {

        }
        #endregion

        #region 查询指令部分
        /// <summary>
        /// 查询指令返回指令的命令属性的检测。控制指令是否重发，以该函数返回值为标准。
        /// </summary>
        /// <param name="RetData"></param>
        /// <returns></returns>
        public static bool QueryCmdRetDataProperityCheck(byte[] RetData)
        {
            if (ReturnDataHeadRailCheck(RetData))
            {
                if (RetData[7] == 0x3f)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        #endregion
        #endregion
    }
}

