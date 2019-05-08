package com.zonghe1;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrame extends JFrame implements ActionListener {
    private  JLabel accoutLabel ,passwordLabel ;
    private  JTextField accountField;
    private  JPasswordField passwordField;
    private  JButton comfirmButton ;
    private JButton cancleButton;
    private  JLabel bgLabel;

    public LoginFrame(){
        init();
        setTitle("登陆窗体");
        setSize(640,480);
        setLocationRelativeTo(null);
        //窗口大小不可变
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public  void init(){
        Font font = new Font("微软雅黑",Font.PLAIN,24);
        accoutLabel = new JLabel("用户 :");
        accoutLabel.setFont(font);
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("密码 :");
        passwordLabel.setFont(font);
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        cancleButton = new JButton("取消");
        comfirmButton = new JButton("登录");
        comfirmButton.addActionListener(this);
        comfirmButton.setFont(font);
        cancleButton.setFont(font);
        //窗口布局设为空布局，需要给每个组件定位
        setLayout(null);
        //setBounds 方法的四个参数分别为组件x、y坐标，组件宽高
        accoutLabel.setBounds(120,100,100,35);
        accountField.setBounds(240,100,300,35);
        passwordLabel.setBounds(120,180,100,35);
        passwordField.setBounds(240,180,300,35);
        comfirmButton.setBounds(70,310,170,50);
        comfirmButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
        cancleButton.setBounds(370,310,170,50);
        cancleButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        add(accoutLabel);
        add(accountField);
        add(passwordLabel);
        add(passwordField);
        add(comfirmButton);
        add(cancleButton);
        //背景
        bgLabel = new JLabel();
        Icon bgicon = new ImageIcon(LoginFrame.class.getResource("/img/55.jpg"));
        bgLabel.setIcon(bgicon);
        bgLabel.setBounds(0,0,640,480);
        add(bgLabel);


    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new LoginFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comfirmButton){
            this.dispose();//点击按钮时frame1销毁,new一个frame2
            try {
                new SupermarketFrame();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
