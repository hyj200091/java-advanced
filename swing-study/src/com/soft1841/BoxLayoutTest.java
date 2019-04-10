package com.soft1841;
/**
 * BoxLayout 布局实列
 * @author 侯粤嘉
 * 2019.3.29
 */

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoxLayoutTest extends JFrame {
    private JLabel dateLabel;
    public BoxLayoutTest(){
        init();
        setTitle("BoxLayout布局");
        setSize(410,730);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
        //重新设置窗体布局为水平和垂直距离的Borrlayout
        setLayout(new BorderLayout(20,20));
        //顶部面板
        JPanel topPanel = new JPanel();
        //对topPanel进行水平方向排列的Boxlayout布局
        BoxLayout boxLayout = new BoxLayout(topPanel, BoxLayout.X_AXIS);
        topPanel.setLayout(boxLayout);
        //topPanel设置背景色和合适的按钮
        topPanel.setBackground(new Color(255,127,0));
        topPanel.setPreferredSize(new Dimension(414,100));

        //左侧按钮
        JButton leftbutton = new JButton("扫一扫");
        leftbutton.setPreferredSize(new Dimension(80,30));
        topPanel.add(leftbutton);

        //加入一个giue 会挤占两个按钮之间的空间
        topPanel.add(Box.createHorizontalGlue());

        //右侧按钮
        JButton rightbutton = new JButton("会员码");
        rightbutton.setPreferredSize(new Dimension(80,30));
        topPanel.add(rightbutton);

        //topPanel加入窗体顶部
        add(topPanel, BorderLayout.NORTH);

        //中间的middlePanel面板 垂直方向的Boxlayout布局
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        //创建三个面板，加入middlePanel
        for (int i=0;i<3;i++){
            JPanel jPanel = new JPanel();
            jPanel.setPreferredSize(new Dimension(410,120));
            jPanel.setBackground(new Color(246,162,173));
            //分别将每次创建的面板加入middlePanel
            middlePanel.add(jPanel);
            //每个加入的面板下方，加入一个垂直方向的Strut，空出一点距离
            middlePanel.add(Box.createVerticalStrut(20));
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
         dateLabel = new JLabel(date);
         add(dateLabel,BorderLayout.SOUTH);

        //最后将middlePanel加入窗体的中间区域
        add(middlePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle=BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;

            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new BoxLayoutTest();
    }
}
