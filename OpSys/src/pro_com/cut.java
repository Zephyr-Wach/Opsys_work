package pro_com;
class Cut implements Runnable {
    Tub wctub;
    Tub cetub;
    int total = 10;//设定苹果数量
    int num = total;//num为未经处理的苹果数量



    public Cut(Tub wctub, Tub cetub) {
        this.wctub = wctub;
        this.cetub = cetub;
        }
        @Override
        public void run() {
        while(true) {
            synchronized (cetub) {
                if(wctub.num >= 20) {
                    System.out.println(Thread.currentThread().getName()+":苹果切完啦");
                    break;
                }
            }
            int apple = wctub.get();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":切好了第"+apple+"个苹果");
            cetub.add(apple);
        }
    }
}