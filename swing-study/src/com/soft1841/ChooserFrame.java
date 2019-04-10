package com.soft1841;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooserFrame extends  JFrame implements ActionListener {
    private JButton chooserBtn;
    private JLabel bgLabel,pathLabel;
    private  JPanel imgPanel;
    private JProgressBar progressBar;

    private ChooserFrame(){
        init();
        setTitle("轮播窗体");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        bgLabel = new JLabel();
        chooserBtn = new JButton("选择图片");
        pathLabel = new JLabel();
        imgPanel = new JPanel();
        add(imgPanel);
        chooserBtn.setSize(new Dimension(80,60));
        chooserBtn.addActionListener(this);
        //创建进度条
        final JProgressBar progressBar = new JProgressBar();
        progressBar.setForeground(new Color(0, 2, 77));
        progressBar.setBackground(new Color(254, 233, 154));
        getContentPane().add(progressBar,BorderLayout.SOUTH);
        progressBar.setStringPainted(true);
        Thread thread  = new Thread(){
            int count = 0;
            public  void run(){
                while (true){
                    progressBar.setValue(++count);
                    try {
                        if (count == 80){
                            interrupt();
                        }
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        System.out.println("当前线程被中断");
                        break;
                    }
                }
            }
        };
        thread.start();

        add(chooserBtn,BorderLayout.NORTH);
        add(bgLabel, BorderLayout.CENTER);
        add(pathLabel,BorderLayout.WEST);

    }

    public static void main(String[] args) {
        new ChooserFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == chooserBtn) {
            JLabel imgLabel = new JLabel();
            imgPanel.add(imgLabel);
            ChooserThread ct = new ChooserThread();
            ct.setBgLabel(bgLabel);
            new Thread(ct).start();
        }
    }

}
