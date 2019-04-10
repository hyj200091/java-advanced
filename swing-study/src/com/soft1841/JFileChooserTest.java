package com.soft1841;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 文件选择器
 * @author 侯粤嘉
 * 2019.4.2
 */
public class JFileChooserTest extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JLabel pathLabel;
    private  JFileChooser fileChooser;

    public JFileChooserTest(){
        init();
        setTitle("JFileChooseTest");
        setSize(800,600);
        //窗体居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private  void init(){
        chooseBtn = new JButton("选择文本");
        pathLabel = new JLabel("暂无选择");
        add(chooseBtn, BorderLayout.NORTH);
        //按钮监听
        chooseBtn.addActionListener(this);

        Font font = new Font("微软雅黑",Font.BOLD,26);
        pathLabel.setFont(font);
        add(pathLabel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle=BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;

            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new JFileChooserTest();
    }
    //事件监听
    @Override
    public void actionPerformed(ActionEvent e) {
        //创建选择器对象
        fileChooser = new JFileChooser();
        //设置文件选择器的默认路径 设置目录
//        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setCurrentDirectory(new File("D:\\"));
        //打开对话框  判定0与1 的操作
        int result = fileChooser.showOpenDialog(null);
        System.out.println(result);
        //用户点击了“确认”按钮
        if (result ==JFileChooser.APPROVE_OPTION){
            //getSelectedFile 得到的就是一个文件不能多选择
            File file = fileChooser.getSelectedFile();
//            //将file的绝对路径显示在窗体中间
//            pathLabel.setText(file.getAbsolutePath());
            try {
                InputStream inputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                pathLabel.setText(scanner.nextLine());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}
