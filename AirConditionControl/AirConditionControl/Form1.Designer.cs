namespace AirConditionControl
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.queryBt = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.serialportCb = new System.Windows.Forms.ComboBox();
            this.serialStatusCb = new System.Windows.Forms.CheckBox();
            this.openComBt = new System.Windows.Forms.Button();
            this.closeComBt = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.comboBox5 = new System.Windows.Forms.ComboBox();
            this.label8 = new System.Windows.Forms.Label();
            this.getSysArgBt = new System.Windows.Forms.Button();
            this.comboBox4 = new System.Windows.Forms.ComboBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.comboBox3 = new System.Windows.Forms.ComboBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.comboBox2 = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.button5 = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.SerialPortTest = new System.IO.Ports.SerialPort(this.components);
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(97, 80);
            this.textBox3.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(159, 25);
            this.textBox3.TabIndex = 22;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(27, 80);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 15);
            this.label1.TabIndex = 23;
            this.label1.Text = "机号";
            // 
            // queryBt
            // 
            this.queryBt.Location = new System.Drawing.Point(30, 133);
            this.queryBt.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.queryBt.Name = "queryBt";
            this.queryBt.Size = new System.Drawing.Size(100, 27);
            this.queryBt.TabIndex = 24;
            this.queryBt.Text = "查询";
            this.queryBt.UseVisualStyleBackColor = true;
            this.queryBt.Click += new System.EventHandler(this.queryBt_Click);
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(156, 133);
            this.button4.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(100, 27);
            this.button4.TabIndex = 25;
            this.button4.Text = "退出";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label4.Location = new System.Drawing.Point(337, 80);
            this.label4.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(89, 20);
            this.label4.TabIndex = 26;
            this.label4.Text = "串口号：";
            // 
            // serialportCb
            // 
            this.serialportCb.FormattingEnabled = true;
            this.serialportCb.Items.AddRange(new object[] {
            "COM1",
            "COM2",
            "COM3",
            "COM4",
            "COM5",
            "COM6",
            "COM7",
            "COM8"});
            this.serialportCb.Location = new System.Drawing.Point(434, 77);
            this.serialportCb.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.serialportCb.Name = "serialportCb";
            this.serialportCb.Size = new System.Drawing.Size(160, 23);
            this.serialportCb.TabIndex = 27;
            // 
            // serialStatusCb
            // 
            this.serialStatusCb.AutoSize = true;
            this.serialStatusCb.Location = new System.Drawing.Point(434, 113);
            this.serialStatusCb.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.serialStatusCb.Name = "serialStatusCb";
            this.serialStatusCb.Size = new System.Drawing.Size(89, 19);
            this.serialStatusCb.TabIndex = 28;
            this.serialStatusCb.Text = "串口状态";
            this.serialStatusCb.UseVisualStyleBackColor = true;
            // 
            // openComBt
            // 
            this.openComBt.Location = new System.Drawing.Point(341, 145);
            this.openComBt.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.openComBt.Name = "openComBt";
            this.openComBt.Size = new System.Drawing.Size(100, 27);
            this.openComBt.TabIndex = 29;
            this.openComBt.Text = "打开串口";
            this.openComBt.UseVisualStyleBackColor = true;
            this.openComBt.Click += new System.EventHandler(this.openComBt_Click);
            // 
            // closeComBt
            // 
            this.closeComBt.Location = new System.Drawing.Point(494, 145);
            this.closeComBt.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.closeComBt.Name = "closeComBt";
            this.closeComBt.Size = new System.Drawing.Size(100, 27);
            this.closeComBt.TabIndex = 30;
            this.closeComBt.Text = "关闭串口";
            this.closeComBt.UseVisualStyleBackColor = true;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.comboBox5);
            this.groupBox1.Controls.Add(this.label8);
            this.groupBox1.Controls.Add(this.getSysArgBt);
            this.groupBox1.Controls.Add(this.comboBox4);
            this.groupBox1.Controls.Add(this.textBox2);
            this.groupBox1.Controls.Add(this.label7);
            this.groupBox1.Controls.Add(this.comboBox3);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.comboBox2);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.button5);
            this.groupBox1.Location = new System.Drawing.Point(30, 231);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.groupBox1.Size = new System.Drawing.Size(564, 275);
            this.groupBox1.TabIndex = 31;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "空调控制";
            // 
            // comboBox5
            // 
            this.comboBox5.FormattingEnabled = true;
            this.comboBox5.Items.AddRange(new object[] {
            "高风",
            "低风"});
            this.comboBox5.Location = new System.Drawing.Point(88, 108);
            this.comboBox5.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.comboBox5.Name = "comboBox5";
            this.comboBox5.Size = new System.Drawing.Size(160, 23);
            this.comboBox5.TabIndex = 29;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(41, 112);
            this.label8.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(37, 15);
            this.label8.TabIndex = 28;
            this.label8.Text = "风速";
            // 
            // getSysArgBt
            // 
            this.getSysArgBt.Location = new System.Drawing.Point(181, 200);
            this.getSysArgBt.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.getSysArgBt.Name = "getSysArgBt";
            this.getSysArgBt.Size = new System.Drawing.Size(128, 40);
            this.getSysArgBt.TabIndex = 26;
            this.getSysArgBt.Text = "查询";
            this.getSysArgBt.UseVisualStyleBackColor = true;
            this.getSysArgBt.Click += new System.EventHandler(this.getSysArgBt_Click);
            // 
            // comboBox4
            // 
            this.comboBox4.FormattingEnabled = true;
            this.comboBox4.Items.AddRange(new object[] {
            "制冷",
            "制热"});
            this.comboBox4.Location = new System.Drawing.Point(88, 72);
            this.comboBox4.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.comboBox4.Name = "comboBox4";
            this.comboBox4.Size = new System.Drawing.Size(160, 23);
            this.comboBox4.TabIndex = 25;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(379, 72);
            this.textBox2.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(159, 25);
            this.textBox2.TabIndex = 17;
            this.textBox2.Text = "26";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(41, 75);
            this.label7.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(37, 15);
            this.label7.TabIndex = 24;
            this.label7.Text = "模式";
            // 
            // comboBox3
            // 
            this.comboBox3.FormattingEnabled = true;
            this.comboBox3.Items.AddRange(new object[] {
            "有效",
            "无效"});
            this.comboBox3.Location = new System.Drawing.Point(379, 20);
            this.comboBox3.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.comboBox3.Name = "comboBox3";
            this.comboBox3.Size = new System.Drawing.Size(160, 23);
            this.comboBox3.TabIndex = 23;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(291, 25);
            this.label6.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(52, 15);
            this.label6.TabIndex = 22;
            this.label6.Text = "电子锁";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(41, 25);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(37, 15);
            this.label5.TabIndex = 21;
            this.label5.Text = "状态";
            // 
            // comboBox2
            // 
            this.comboBox2.FormattingEnabled = true;
            this.comboBox2.Items.AddRange(new object[] {
            "开机",
            "关机"});
            this.comboBox2.Location = new System.Drawing.Point(88, 20);
            this.comboBox2.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.comboBox2.Name = "comboBox2";
            this.comboBox2.Size = new System.Drawing.Size(160, 23);
            this.comboBox2.TabIndex = 18;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label3.Location = new System.Drawing.Point(290, 75);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(69, 20);
            this.label3.TabIndex = 10;
            this.label3.Text = "温度：";
            // 
            // button5
            // 
            this.button5.Location = new System.Drawing.Point(344, 125);
            this.button5.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(128, 27);
            this.button5.TabIndex = 10;
            this.button5.Text = "发送控制指令";
            this.button5.UseVisualStyleBackColor = true;
            this.button5.Click += new System.EventHandler(this.button5_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(690, 83);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(52, 15);
            this.label2.TabIndex = 32;
            this.label2.Text = "接收：";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(693, 113);
            this.textBox1.Margin = new System.Windows.Forms.Padding(4, 2, 4, 2);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(491, 416);
            this.textBox1.TabIndex = 33;
            // 
            // SerialPortTest
            // 
            this.SerialPortTest.DataReceived += new System.IO.Ports.SerialDataReceivedEventHandler(this.SerialPortTest_DataReceived);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1236, 584);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.closeComBt);
            this.Controls.Add(this.openComBt);
            this.Controls.Add(this.serialStatusCb);
            this.Controls.Add(this.serialportCb);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.button4);
            this.Controls.Add(this.queryBt);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBox3);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button queryBt;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox serialportCb;
        private System.Windows.Forms.CheckBox serialStatusCb;
        private System.Windows.Forms.Button openComBt;
        private System.Windows.Forms.Button closeComBt;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ComboBox comboBox5;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Button getSysArgBt;
        private System.Windows.Forms.ComboBox comboBox4;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.ComboBox comboBox3;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox comboBox2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBox1;
        private System.IO.Ports.SerialPort SerialPortTest;
    }
}