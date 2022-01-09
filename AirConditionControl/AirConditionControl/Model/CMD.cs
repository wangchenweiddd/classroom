using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionControl
{
    public class CMD
    {
        public enum SendCodeStatus
        {
            waittingToSend = 2,
            successful = 1,
            failed = 0,
        };

        public byte[] QueryReturenCMD = new byte[26];

        public byte[] ControlReturenCMD = new byte[10];

        public byte[] QueryCMD = new byte[]//单设备查询指令。
        {
            0xf4,//帧头,0
            0xf5,//帧头,1
            0x06,//有效字节数,2
            0x00,//检测器地址,3
            0xff,//检测器地址,4
            0x00,//5
            0X00,//6
            0x3f,//命令属性,7
            0x00,//8
            0xfb//9
        };

        public byte[] ControlCMD = new byte[]//单设备控制指令。
        {
            //F4 F5 16 00 FF 00 10 3F 90 20 00 60 00 20 40 10 65 64 00 00 00 00 00 00 AD FB 
            0XF4,//帧头,0
            0XF5,//帧头,1
            0X10,//有效字节数,2
            0X00,//计算机地址,3
            0XFF,//计算机地址,4
            0X00,//空调地址,5
            0X00,//空调地址,6
            0X00,//命令属性,7
            0X90,//A,8
            0X20,//B,9
            0X00,//C,10
            0X60,//D,11
            0X00,//E,12
            0X00,//F,13
            0X00,//G,14
            0X00,//H,15
            0X00,//I,16
            0X00,//J,17
            0X00,//校验,18
            0XFB,//帧尾,19
        };

        /// <summary>
        /// 校验位计算
        /// </summary>
        /// <param name="buffer，即将设置校验位的数据"></param>
        /// <returns></returns>
        public static byte[] CheckByteCount(byte[] buffer)
        {
            byte checkByte = 0X00;
            for (int i = 2; i < (buffer.Length - 2); i++)
            {
                checkByte += buffer[i];
            }
            buffer[buffer.Length - 2] = checkByte;
            return buffer;
        }
    }
}
