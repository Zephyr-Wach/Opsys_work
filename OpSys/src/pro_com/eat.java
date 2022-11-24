package pro_com;
class Eat implements Runnable {
    Tub tub;

    public Eat(Tub tub) {
        this.tub = tub;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (tub) {
                if(tub.num >= 10) {
                    System.out.println(Thread.currentThread().getName()+":苹果吃完啦");
                    break;
                }
            }
            int apple = tub.get();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":吃掉了第"+apple+"个苹果");

        }
    }
}