package com.soft1841.gui;

import javax.swing.*;

public class Computer {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton 我的电脑Button;
    private JButton 硬件检测Button;
    private JButton 驱动管理Button;
    private JButton 电源管理Button;
    private JButton 我的服务Button;
    private JButton 智能客服Button;
    private JButton 个性定制Button;
    private JButton 我的手机Button;
    private JPanel centerpanel;
    private JPanel bmpanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Computer");
        frame.setContentPane(new Computer().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1191,744);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
