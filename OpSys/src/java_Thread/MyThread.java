package java_Thread;

//多个取餐窗口同时对一个快餐资源进行操作，并且使得资源不会扣减至负数。

public class MyThread extends Thread{
    static int rice = 10;//餐总数
    static Object key = "KEY";
    private final String name;
    public MyThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        while (rice > 0){ //有则可以出售
            synchronized ("KEY"){
               try{
                   if(rice > 0){
                       sleep(100);
                   }else {
                        System.out.println("餐已售罄！");
                    }
              } catch (InterruptedException e) {
                    e.printStackTrace();
               }
            }
        }
    }

    public static void main(String[] args) {
        new MyThread("取餐口1").start();
        new MyThread("取餐口2").start();
        new MyThread("取餐口3").start();
    }

}

