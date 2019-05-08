package com.zonghe1;
/**
 * 期中大作业 运用所学知识设计或者仿制界面
 *
 * @author 侯粤嘉
 * 2019.4.20-4.28
 */

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SupermarketFrame extends JFrame implements ActionListener {
    public JPanel topJPanel, recomdJPanel;
    public JButton remecomdBtn, sellBtn, manageBtn, musicBtn, tuichuBtn;
    private JLabel bgLabel, imgLabel, textLabel, rightLabel;
    private JLabel accountLabel, passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton confirmButton, cancelButton;
    private TextArea textArea;
    private  Icon icon;


    public SupermarketFrame() {
        init();
        setTitle("欣鑫网上超市");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void init() {
        //顶部面板
        topJPanel = new JPanel();
        Font font = new Font("微软雅黑", Font.BOLD, 25);
        Font font1 = new Font("微软雅黑", Font.BOLD, 50);
        remecomdBtn = new JButton("今日推荐");
        manageBtn = new JButton("顾客评价");
        sellBtn = new JButton("支付方式");
        musicBtn = new JButton("每日一听");
        tuichuBtn = new JButton();
        remecomdBtn.setBackground(new Color(176, 176, 254));
        manageBtn.setBackground(new Color(176, 176, 254));
        sellBtn.setBackground(new Color(176, 176, 254));
        tuichuBtn.setBackground(new Color(176, 176, 254));
        musicBtn.setBackground(new Color(176, 176, 254));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String timeString = simpleDateFormat.format(date);
        tuichuBtn.setText(timeString);

        //多行文本域
        textArea = new TextArea();

        //字体大小
        remecomdBtn.setFont(font);
        sellBtn.setFont(font);
        musicBtn.setFont(font);
        manageBtn.setFont(font);
        tuichuBtn.setFont(font);


        //中间划分为四个面板 在一个container容器里面
        Container container = new Container();
        container.setLayout(new GridLayout(2, 2, 10, 10));

        //第一个面板
        recomdJPanel = new JPanel();
        recomdJPanel.setLayout(new BorderLayout());
        recomdJPanel.setBackground(new Color(231, 234, 213));
        //加入图片轮播
        bgLabel = new JLabel();
        recomdJPanel.add(bgLabel);
        CarouselThread1 ct = new CarouselThread1();
        ct.setBgLabel(bgLabel);
        new Thread(ct).start();

        //第二个面板
        JPanel jPanel2 = new JPanel();
        imgLabel = new JLabel();
        jPanel2.setLayout(new BorderLayout());
        jPanel2.setBackground(new Color(231, 234, 213));
        jPanel2.add(imgLabel);
        CarouseThread2 carouseThread2 = new CarouseThread2();
        carouseThread2.setBgLabel(imgLabel);
        new Thread(carouseThread2).start();
        jPanel2.setLayout(new GridLayout(1, 1, 10, 10));

        //第三个
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new BorderLayout());
        jPanel3.setBackground(new Color(231, 234, 213));
        textLabel = new JLabel();
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(font1);
        jTextArea.setLineWrap(true);
        TextThread thread = new TextThread();
        thread.setjTextArea(jTextArea);
        jPanel3.add(jTextArea);
        container.add(jPanel3);
        new Thread(thread).start();

        //第四个
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new BorderLayout());
        jPanel4.setBackground(new Color(255, 255, 255));
        rightLabel = new JLabel();
        rightLabel.setFont(font1);
        countdown testThread1 = new countdown();
        new Thread(testThread1).start();
        testThread1.setRightLabel(rightLabel);
        jPanel4.add(rightLabel);
        container.add(jPanel4);
        System.out.println(rightLabel);


        container.add(recomdJPanel);
        container.add(jPanel2);
        container.add(jPanel3);
        container.add(jPanel4);


        //按钮点击事件
        remecomdBtn.addActionListener(this);
        sellBtn.addActionListener(this);
        musicBtn.addActionListener(this);
        manageBtn.addActionListener(this);
        tuichuBtn.addActionListener(this);

        topJPanel.add(remecomdBtn);
        topJPanel.add(manageBtn);
        topJPanel.add(musicBtn);
        topJPanel.add(sellBtn);
        topJPanel.add(tuichuBtn);
        topJPanel.setLayout(new GridLayout(1, 5));
        add(topJPanel, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);

    }

    public static void main(String[] args) throws Exception {
        new SupermarketFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == musicBtn) {
            music music = new music();
            new Thread(music).start();
        }
        if (e.getSource() == sellBtn) {
            sellJD sellJD = new sellJD(SupermarketFrame.this);
            sellJD.setVisible(true);
        }
        if (e.getSource() == tuichuBtn) {
            this.dispose();
        }
        if (e.getSource() == manageBtn) {
            TxtJD txtJD = new TxtJD(SupermarketFrame.this);
            txtJD.setVisible(true);
        }
    }

    class music implements Runnable {
        @Override
        public void run() {
            URL url;
            File file = new File("D:\\2.wav");
            int i = 1;
            while (i >= 1) {
                try {
                    url = file.toURL();
                    AudioClip audioClip = Applet.newAudioClip(url);
                    audioClip.play();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
            }
        }
    }
}

class TxtJD extends JDialog{
    public TxtJD (SupermarketFrame frame){
        super(frame,"顾客评价",true);
        Container container = getContentPane();
        String url = "http://www.fmx.cn/";
        Connection connection = Jsoup.connect(url);
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.getElementsByClass("wz");
        for (Element element : elements) {
            //5 取出div中的子元素
            Element link = element.child(1);
            //6 得到a标记中的内容
            String titletring = link.text();
            System.out.println(titletring);
            JTextArea jTextArea = new JTextArea(titletring);
            jTextArea.setFont(new Font("微软雅黑",Font.BOLD,30));
            jTextArea.setLineWrap(true);
            container.add(jTextArea);
        }
        setBounds(600,300,800,600);
    }
}
class sellJD extends JDialog{
    public sellJD(SupermarketFrame frame1){
        super(frame1,"支付方式",true);
        Container container1 = getContentPane();
        container1.setLayout(null);
        container1.setBackground(new Color(17, 200, 176));
        setBounds(540,230,750,700);
        Font font1 = new Font("微软雅黑",Font.BOLD,30);
        JButton wxBtn = new JButton("微信支或支付宝扫一扫：");
        //微信图片的加入
        JLabel wzLabel = new JLabel();
        File srcFile = new File("D:\\1.png");
        InputStream in;
        byte[] bytes = null;
        try {
            in = new FileInputStream(srcFile);
            bytes = new byte[(int) srcFile.length()];
            in.read(bytes);
        }catch (IOException e){
            System.out.println("IO异常");
        }
        ImageIcon icon = new ImageIcon(bytes);
        wzLabel.setIcon(icon);
        wxBtn.setBackground(new Color(17, 200, 176));
        wxBtn.setFont(font1);
        //图片位置
        wzLabel.setBounds(235,350,270,220);
        //按钮位置
        wxBtn.setBounds(200,200,400,50);
        container1.add(wxBtn);
        container1.add(wzLabel);

    }
}