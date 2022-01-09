using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionControl
{
    class CMDEncodeBLL
    {

        /// <summary>
        /// 查询指令的编码
        /// </summary>
        /// <param name="airConditionStateModel，Query_Table的传入数据"></param>
        public static void QueryCMDEncode(AirConditionStateModel airConditionStateModel, CMD cmd)
        {
            cmd.QueryCMD[6] = Convert.ToByte(airConditionStateModel.deviceAddress);
            cmd.QueryCMD = CMD.CheckByteCount(cmd.QueryCMD);
        }

        /// <summary>
        /// 控制指令的编码
        /// </summary>
        /// <param name="airConditionStateModel"></param>
        public static void ControlCMDEndode(AirConditionStateModel airConditionStateModel, CMD cmd)
        {

            cmd.ControlCMD[6] = Convert.ToByte(airConditionStateModel.deviceAddress);
            //功能位编码
            ControlCMDEndodeAoc(airConditionStateModel, cmd);
            ControlCMDEndodeAtemp(airConditionStateModel, cmd);
            ControlCMDEndodeHelec(airConditionStateModel, cmd);
            ControlCMDEndodeFmodel(airConditionStateModel, cmd);
            ControlCMDEndodeDwind(airConditionStateModel, cmd);
            cmd.ControlCMD = CMD.CheckByteCount(cmd.ControlCMD);//校验和计算

        }

        #region 单功能控制指令编码
         /// <summary>
         /// 开关机设置
         /// </summary>
         /// <param name="airConditionStateModel"></param>
         private static void ControlCMDEndodeAoc(AirConditionStateModel airConditionStateModel, CMD cmd)
         {
             switch (airConditionStateModel.aoc)
             {
                 case "开机":
                     cmd.ControlCMD[8 + 0] &= 0xfe;//将开关机位置零
                     cmd.ControlCMD[8 + 0] |= 0x01;
                     break;
                 case "关机":
                     cmd.ControlCMD[8 + 0] &= 0xfe;
                     cmd.ControlCMD[8 + 0] |= 0x00;
                     break;
                 default:
                     break;
             }
         } /// <summary>
         /// 电子锁设置
         /// </summary>
         /// <param name="airConditionStateModel"></param>
         private static void ControlCMDEndodeHelec(AirConditionStateModel airConditionStateModel, CMD cmd)
         {
             switch (airConditionStateModel.helec)
             {
                 case "有效":
                     cmd.ControlCMD[8 + 8] &= 0xdf;
                     cmd.ControlCMD[8 + 8] |= 0x20;
                     break;
                 case "无效":
                     cmd.ControlCMD[8 + 8] &= 0xdf;
                     cmd.ControlCMD[8 + 8] |= 0x00;
                     break;
                 default:
                     break;
             }
         }

         /// <summary>
         /// 模式设置
         /// </summary>
         /// <param name="airConditionStateModel"></param>
         private static void ControlCMDEndodeFmodel(AirConditionStateModel airConditionStateModel, CMD cmd)
         {
             switch (airConditionStateModel.fmodel)
             {
                 case "自动":
                     cmd.ControlCMD[8 + 5] &= 0x1f;
                     cmd.ControlCMD[8 + 5] |= 0x00;
                     break;
                 case "制冷":
                     cmd.ControlCMD[8 + 5] &= 0x1f;
                     cmd.ControlCMD[8 + 5] |= 0x20;
                     break;
                 case "制热":
                     cmd.ControlCMD[8 + 5] &= 0x1f;
                     cmd.ControlCMD[8 + 5] |= 0x40;
                     break;
                 case "送风":
                     cmd.ControlCMD[8 + 5] &= 0x1f;
                     cmd.ControlCMD[8 + 5] |= 0x60;
                     break;
                 case "除湿":
                     cmd.ControlCMD[8 + 5] &= 0x1f;
                     cmd.ControlCMD[8 + 5] |= 0x80;
                     break;
                 default:
                     break;
             }
         }

         /// <summary>
         /// 风速设置
         /// </summary>
         /// <param name="airConditionStateModel"></param>
         private static void ControlCMDEndodeDwind(AirConditionStateModel airConditionStateModel, CMD cmd)
         {
             switch (airConditionStateModel.dwind)
             {
                 case "高风":
                     cmd.ControlCMD[8 + 3] &= 0x1f;
                     cmd.ControlCMD[8 + 3] |= 0x20;
                     break;
                 case "中风":
                     cmd.ControlCMD[8 + 3] &= 0x1f;
                     cmd.ControlCMD[8 + 3] |= 0x40;
                     break;
                 case "低风":
                     cmd.ControlCMD[8 + 3] &= 0x1f;
                     cmd.ControlCMD[8 + 3] |= 0x60;
                     break;
                 case "自动":
                     cmd.ControlCMD[8 + 3] &= 0x1f;
                     cmd.ControlCMD[8 + 3] |= 0x80;
                     break;
                 default:
                     break;
             }
         }

         /// <summary>
         /// 温度设置
         /// </summary>
         /// <param name="airConditionStateModel"></param>
         private static void ControlCMDEndodeAtemp(AirConditionStateModel airConditionStateModel, CMD cmd)
         {
             byte Temp = Convert.ToByte(airConditionStateModel.atemp);
             Temp <<= 4;
             cmd.ControlCMD[8 + 0] &= 0x0f;//将其高4位置零
             cmd.ControlCMD[8 + 0] |= Temp;
         }
        #endregion

    }
}
