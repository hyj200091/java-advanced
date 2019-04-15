package com.week1;

/**
 * 多线程售票程序1
 * @author 侯粤嘉
 * 2019.4.9
 */
public class TicketThreadTest1 {
    public static void main(String[] args) {
        TicketThread1 tt1 = new TicketThread1();
        tt1.start();
        TicketThread1 tt2 = new TicketThread1();
        tt2.start();
        TicketThread1 tt3 = new TicketThread1();
        tt3.start();
    }
}
//通过继承Thread的方法实现
class  TicketThread1 extends  Thread{
    private  int tickets = 10;

    @Override
    public void run() {
        while (tickets>0){
            //先减 currentThread当前票数
            System.out.println(Thread.currentThread().getName()+" 售票，当前票数"+ --tickets);
        }
    }
}
