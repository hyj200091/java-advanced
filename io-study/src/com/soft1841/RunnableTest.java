package com.soft1841;

public class RunnableTest extends Object implements Runnable{
    private int x = 10;
    @Override
    public void run() {
       while (true){
          System.out.print(x + " ");
          if (--x == 0){
              break;
        }
      }
   }

    public static void main(String[] args) {
        //实现Runnabel接口
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        //启动线程
        thread.start();
    }
}
