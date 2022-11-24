package pro_com;
class Wash implements Runnable {
    int total = 10;//设定苹果数量
    int num = total;//num为未经处理的苹果数量
    Tub tub;
    public Wash(Tub tub) {
        this.tub = tub;
    }
    @Override
    public void run() {
        int apple;
        while(true) {
            synchronized (this) {
                if(num > 0) {
                    apple = total-(--num);
                }else {
                    System.out.println(Thread.currentThread().getName()+":苹果洗完啦");
                    break;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":洗好了第"+apple+"个苹果");
            tub.add(apple);
        }
    }
}