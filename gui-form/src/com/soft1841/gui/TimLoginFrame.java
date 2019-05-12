package com.soft1841.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimLoginFrame {
    private JPanel mainPanel;
    private JLabel bannerLabel;
    private JLabel avatarLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox 记住密码CheckBox;
    private JCheckBox 自动登录CheckBox;
    private JButton loginBtn;

    public TimLoginFrame() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"登录成功");
            }
        });
    }

    public static void main(String[] args) throws Exception{
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.Windows.WindowsLookAndFeel");
        JFrame frame = new JFrame("TimLoginFrame");
        frame.setContentPane(new TimLoginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //自适应容器大小
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
