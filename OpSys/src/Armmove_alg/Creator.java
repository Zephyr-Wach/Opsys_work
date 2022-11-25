package Armmove_alg;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

public class Creator {
    public HashMap<Thread, Integer> create() {
        HashMap<Thread, Integer> hm = new HashMap<Thread, Integer>();  // 容器：存放  线程-请求  键值对

        MyThread mt = new MyThread();
        for(int i = 0; i < 8; i++) {
            int req = new Random().nextInt(200);
            Thread t = new Thread(mt, "Thread_"+i);
            t.start();
            hm.put(t, req);
        }
        System.out.println("请求序列: 线程--请求");
        Set<Thread> keys = hm.keySet();
        for(Thread key: keys) {
            System.out.println(key.getName() + " -- " + hm.get(key));
        }
        return hm;
    }

}
class MyThread implements Runnable{
    @Override
    public void run() {
        LockSupport.park();
        // 模拟调度的线程被创建后立即进入阻塞状态，等相应的调度算法按调度顺序将他们唤醒
    }
}