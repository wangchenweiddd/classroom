using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Diagnostics;
using System.Threading;

namespace AirConditionControl
{
    public partial class Form1 : Form
    {
        delegate void TextBoxEventHandler(string text);  //委托，此为重点.
        private TextBoxEventHandler textBox1EventHandler;


        public Form1()
        {
            InitializeComponent();
        }
        public void SeriaPortSendData(byte[] data)
        {
            SerialPortTest.Write(data, 0, data.Length);
            SerialPortTest.DiscardOutBuffer();
        }

        private void queryBt_Click(object sender, EventArgs e)
        {
            AirConditionStateModel acModel = new AirConditionStateModel();
            acModel.deviceAddress = Convert.ToInt16(textBox3.Text);
            CMD cmd = new CMD();
            CMDEncodeBLL.ControlCMDEndode(acModel, cmd);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Process.GetCurrentProcess().Kill();
            Application.Exit();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            textBox1EventHandler += new TextBoxEventHandler(addText);
        }

        private void addText(String str)
        {
            textBox1.AppendText(str);
        }

        private void openComBt_Click(object sender, EventArgs e)
        {
            try
            {
                SerialPortTest.PortName = serialportCb.SelectedItem.ToString();

                SerialPortTest.Open();
                if (SerialPortTest.IsOpen)
                {
                    serialStatusCb.Checked = true;
                }
                else
                {
                    MessageBox.Show("串口打开失败！");
                }
            }
            catch (Exception exception)
            {
                MessageBox.Show(exception.Message);
            }

        }

        private void getSysArgBt_Click(object sender, EventArgs e)
        {
            AirConditionStateModel acModel = new AirConditionStateModel();
            acModel.deviceAddress = Convert.ToInt16(textBox3.Text);
            CMD cmd = new CMD();
            CMDEncodeBLL.QueryCMDEncode(acModel, cmd);
            SeriaPortSendData(cmd.QueryCMD);
            textBox1.AppendText("查询指令：" + '\n' + BitConverter.ToString(cmd.QueryCMD).Replace('-', ' ') + "\n");
        }

        private void button5_Click(object sender, EventArgs e)
        {
            AirConditionStateModel acModel = new AirConditionStateModel();
            //  状态
            if (comboBox2.SelectedItem == null || String.IsNullOrEmpty(comboBox2.SelectedItem.ToString()))
            {
                acModel.aoc = "关机";
            }
            else
            {
                acModel.aoc = comboBox2.SelectedItem.ToString();
            }
            //  屏蔽
            if (comboBox3.SelectedItem == null || String.IsNullOrEmpty(comboBox3.SelectedItem.ToString()))
            {
                acModel.helec = "无效";
            }
            else
            {
                acModel.helec = comboBox3.SelectedItem.ToString();
            }
            //  模式
            if (comboBox4.SelectedItem == null || String.IsNullOrEmpty(comboBox4.SelectedItem.ToString()))
            {
                acModel.fmodel = "制热";
            }
            else
            {
                acModel.fmodel = comboBox4.SelectedItem.ToString();
            }
            //  风速
            if (comboBox5.SelectedItem == null || String.IsNullOrEmpty(comboBox5.SelectedItem.ToString()))
            {
                acModel.dwind = "高风";
            }
            else
            {
                acModel.dwind = comboBox5.SelectedItem.ToString();
            }
            // 机号
            acModel.deviceAddress = Convert.ToInt16(textBox3.Text);
            acModel.atemp = textBox2.Text;
            CMD cmd = new CMD();
            CMDEncodeBLL.ControlCMDEndode(acModel, cmd);
            textBox1.AppendText("状态控制指令依次为：" + acModel.aoc + ' ' + acModel.atemp + ' ' + acModel.helec + ' ' + acModel.fmodel + ' ' + acModel.dwind + ' ' + '\n');
            SeriaPortSendData(cmd.ControlCMD);
            textBox1.AppendText(BitConverter.ToString(cmd.ControlCMD).Replace('-', ' ') + "\n");
        }


        private void SerialPortTest_DataReceived(object sender, System.IO.Ports.SerialDataReceivedEventArgs e)
        {
            Thread.Sleep(200);

            int datalength = SerialPortTest.BytesToRead;// datalength 为返回值长度
            byte[] datastore = new byte[datalength];
            while (SerialPortTest.BytesToRead > 0)
            {
                datalength = SerialPortTest.Read(datastore, 0, datalength);
            }
            if (datalength == 10)
            {
                if (datastore[7] == 0x10)
                {
                    this.Invoke(textBox1EventHandler, "接收正确\n");
                }
                if (datastore[7] == 0x11)
                {
                    this.Invoke(textBox1EventHandler, "接收错误\n");
                }

            }
            if (datalength == 26)
            {
                if ((datastore[8] & 0x01) == 0x00)
                {
                    this.Invoke(textBox1EventHandler, "空调状态为：关机\n");
                }
                if ((datastore[8] & 0x01) == 0x01)
                {
                    this.Invoke(textBox1EventHandler, "空调状态为：开机\n");
                }
                if ((datastore[15] & 0x20) == 0x20)
                {
                    this.Invoke(textBox1EventHandler, "电子锁状态为：有效\n");
                }
                if ((datastore[15] & 0x20) == 0x00)
                {
                    this.Invoke(textBox1EventHandler, "电子锁状态为：无效\n");
                }
                if ((datastore[13] & 0xE0) == 0x00)
                {
                    this.Invoke(textBox1EventHandler, "空调模式为：自动\n");
                }
                if ((datastore[13] & 0xE0) == 0x20)
                {
                   this.Invoke(textBox1EventHandler, "空调模式为：制冷\n");
                }
                if ((datastore[13] & 0xE0) == 0x40)
                {
                    this.Invoke(textBox1EventHandler, "空调模式为：制热\n");
                }
                if ((datastore[13] & 0xE0) == 0x60)
                {
                    this.Invoke(textBox1EventHandler, "空调模式为：送风\n");
                }
                if ((datastore[13] & 0xE0) == 0x80)
                {
                    this.Invoke(textBox1EventHandler, "空调模式为：除湿\n");
                }
                if ((datastore[11] & 0xE0) == 0x20)
                {
                    this.Invoke(textBox1EventHandler, "空调风速为：高风\n");
                }
                if ((datastore[11] & 0xE0) == 0x40)
                {
                    this.Invoke(textBox1EventHandler, "空调风速为：中风\n");
                }
                if ((datastore[11] & 0xE0) == 0x60)
                {
                   this.Invoke(textBox1EventHandler, "空调风速为：低风\n");
                }
                if ((datastore[11] & 0xE0) == 0xA0)
                {
                    this.Invoke(textBox1EventHandler, "空调风速为：自动\n");
                }
        
                if ((datastore[8 + 15] & 0x1f) == 0x01)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：室温传感器故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x02)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：室内管温传感器故障\n");
                   
                }
                if ((datastore[8 + 15] & 0x1f) == 0x03)
                {
                   this.Invoke(textBox1EventHandler, "故障状态为：室内制热过载保护\n");
                   
                }
                if ((datastore[8 + 15] & 0x1f) == 0x04)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：室内制冷结冰保护\n");
                 
                }
                if ((datastore[8 + 15] & 0x1f) == 0x05)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：室内、外板通讯故障\n");
                    
                }
                if ((datastore[8 + 15] & 0x1f) == 0x06)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：面板与内机通信故障\n");
                 
                }
                if ((datastore[8 + 15] & 0x1f) == 0x07)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：模块故障\n");
                    
                }
                if ((datastore[8 + 15] & 0x1f) == 0x08)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：无负载\n");
                   
                }
                if ((datastore[8 + 15] & 0x1f) == 0x09)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：压机过热\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x0A)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：CT电流异常\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x0B)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：外环传感器故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x0C)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：外热交传感器故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x0D)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：电源超、欠压保护\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x0E)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：压力保护\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x0F)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：外蒸发传感器故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x10)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：制冷过载\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x11)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：EEPROM故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x12)
                {
                   this.Invoke(textBox1EventHandler, "故障状态为：外回气传感器故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x13)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：压机传感器故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x14)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：室内蒸发温度\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x15)
                {
                   this.Invoke(textBox1EventHandler, "故障状态为：排水故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x16)
                {
                   this.Invoke(textBox1EventHandler, "故障状态为：电源三相故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x17)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：湿度传感器故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x18)
                {
                   this.Invoke(textBox1EventHandler, "故障状态为：室内风机故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x19)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：室外风机故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x1A)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：压力保护\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x1B)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：电子膨胀阀故障\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x1C)
                {
                   this.Invoke(textBox1EventHandler, "故障状态为：除尘网需清洗\n");
                }
                if ((datastore[8 + 15] & 0x1f) == 0x1F)
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：控制系统故障\n");
                }
                else
                {
                    this.Invoke(textBox1EventHandler, "故障状态为：无\n");
                }
                byte temp = datastore[8];
                temp >>= 4;
                int tempnum = Convert.ToInt32(temp) + 16;
                this.Invoke(textBox1EventHandler, "温度为："+tempnum.ToString()+"\n");
            }
        }


    }
}
