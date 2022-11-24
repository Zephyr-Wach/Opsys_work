package pro_com;
import java.util.LinkedList;
class Tub {
    int num = 0;
    private LinkedList<Integer> list = new LinkedList<>();
    //父母处理好的苹果的编号会放入list，供消费者调取
    public synchronized void add(int apple) {
        list.add(apple);
        this.notifyAll();
    }

    public synchronized int get() {
        while(list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int apple = list.pop();
        num++;
        return apple;
    }
}
public class pro {
    public static void main(String[] args) {
        Tub wctub = new Tub();
        Tub cetub = new Tub();
        Wash wash = new Wash(wctub);
        Cut cut = new Cut(wctub, cetub);
        Eat eat = new Eat(cetub);
        //创建一个洗苹果的进程：爸爸，一个切苹果的进程：妈妈，两个吃苹果的进程：女儿和儿子
        Thread washer = new Thread(wash);
        Thread cutter = new Thread(cut);
        Thread eater1 = new Thread(eat);
        Thread eater2 = new Thread(eat);
        washer.setName("爸爸");
        cutter.setName("妈妈");
        eater1.setName("女儿");
        eater2.setName("儿子");
        washer.start();
        cutter.start();
        eater1.start();
        eater2.start();

    }

}






