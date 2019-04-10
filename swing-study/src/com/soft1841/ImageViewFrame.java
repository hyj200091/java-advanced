package com.soft1841;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用卡片布局实现多图浏览的功能
 * @author 侯粤嘉
 * 2019.4.2
 */
public class ImageViewFrame extends JFrame implements ActionListener {
    private JButton chooseBtn,nextBtn,preBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel,bottomPanle,imgLabel;
    private Icon icon;
    private CardLayout cardLayout;

    public ImageViewFrame(){
        init();
        setTitle("使用卡片布局实现多图浏览功能");
        setSize(1024,768);
        //窗体居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        bottomPanle = new JPanel();
        chooseBtn = new JButton("选择图片");
        nextBtn = new JButton("下一张");
        preBtn= new JButton("前一张");
        add(chooseBtn,BorderLayout.NORTH);
        chooseBtn.addActionListener(this);
        bottomPanle.add(chooseBtn);
        bottomPanle.add(preBtn);
        bottomPanle.add(nextBtn);

        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        add(bottomPanle,BorderLayout.SOUTH);

        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(59, 60, 60));
        add(centerPanel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle=BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new ImageViewFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==chooseBtn){
            fileChooser = new JFileChooser();
            //设置文件选择器的默认路径 设置目录
//        fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setCurrentDirectory(new File("D:\\img\\img"));
            //设置文件为多选模式
            fileChooser.setMultiSelectionEnabled(true);
            //打开对话框  判定0与1 的操作
            int result = fileChooser.showOpenDialog(null);
            //用户点击了“确认”按钮  用户选择了文件
            if (result ==JFileChooser.APPROVE_OPTION){
                //获取选中的所有文件 放到一个文件类型的数组中
                File[] files = fileChooser.getSelectedFiles();
                //遍历数组
                for (File f:files) {
                    System.out.println(f.getAbsolutePath());
                    //对每个f文件，创建字节输入流读入字节数组 构建Icon从，并设置JLabel
                    InputStream in;
                    byte[] bytes = null;
                    try {
                        in = new FileInputStream(f);
                        bytes = new byte[(int) f.length()];
                        in.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        centerPanel.add(imgLabel);
                    }catch (IOException e1){
                        JOptionPane.showMessageDialog(null,"IO异常");
                    }
                }
            }
        }
        if (e.getSource() == preBtn){
            cardLayout.previous(centerPanel);
        }
        if (e.getSource() == nextBtn){
            cardLayout.next(centerPanel);
        }
    }
}
