package com.zonghe1;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class countdown implements Runnable {
    private JLabel rightLabel;

    public void setRightLabel(JLabel rightLabel) {
        this.rightLabel = rightLabel;
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            long timenow = date.getTime();
            timenow = 60 * 60 * 1000 - timenow;
            date = new Date(timenow);
            rightLabel.setText(sdf.format(date));
            if (sdf.format(date).equals("24:59:00")) {
                JOptionPane.showMessageDialog(rightLabel, "本场活动现在开始！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("1");
            }
        }
    }
}

