package Armmove_alg;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

public class alg_SCAN {
    public int direction = 1;     // 1:up  -1:down
    public static void main(String[] args) {
        Creator creator = new Creator();
        HashMap<Thread, Integer> hm = creator.create();
        int requireNum = hm.size();
        Disk disk = new Disk();
        alg_SCAN s = new alg_SCAN();
        int n = s.scan(hm, disk);
        disk.set(requireNum, n);
    }


    public int scan(HashMap<Thread, Integer> hm, Disk disk) {
        System.out.println("----------------");
        System.out.println("SCAN算法调度序列:");
        System.out.println("磁头初始在100位置");
        int[] count = new int[200];
        this.require(hm, count);
        int n = this.release(hm, count, disk);
        return n;
    }

    public int release(HashMap<Thread, Integer> hm, int[] count, Disk disk) {
        int n = 0;
        if(this.direction == 1) {
            n += this.upscan(hm, count, disk);
            n += this.downscan(hm, count, disk);
        }
        else if(this.direction == -1){
            n += this.downscan(hm, count, disk);
            n += this.upscan(hm, count, disk);
        }
        return n;
    }

    public void require(HashMap<Thread, Integer> hm, int[] count) {
        Set<Thread> keys = hm.keySet();
        for(Thread key: keys) {
            count[hm.get(key)] += 1;
        }
    }

    public int downscan(HashMap<Thread, Integer> hm, int[] count, Disk disk) {
        int i = disk.getCurrentDist(), num = 0, absNum = 0;
        Thread removeKey = null;
        while(i >= 0) {
            while(i >= 0 && count[i] == 0) {
                i -= 1;
                absNum += 1;
            }
            if(i >= 0) {
                num += absNum;
                absNum = 0;
                count[i] -= 1;
                Set<Thread> keys = hm.keySet();
                for(Thread key: keys) {
                    if(hm.get(key) == i) {
                        System.out.println(key.getName() + " -- " + hm.get(key));
                        removeKey = key;
                        LockSupport.unpark(key);
                    }
                }
                hm.remove(removeKey);
                disk.setCurrentDist(i);
                i = disk.getCurrentDist();
            }
        }
        this.direction = 1;
        return num;
    }

    public int upscan(HashMap<Thread, Integer> hm, int[] count, Disk disk) {
        int i = disk.getCurrentDist(), num = 0, absNum = 0;
        Thread removeKey = null;
        while(i <= 199) {
            while(i <= 199 && count[i] == 0) {
                i += 1;
                absNum += 1;
            }
            if(i <= 199) {
                num += absNum;
                absNum = 0;
                count[i] -= 1;

                Set<Thread> keys = hm.keySet();
                for(Thread key: keys) {
                    if(hm.get(key) == i) {
                        System.out.println(key.getName() + " -- " + hm.get(key));
//						hm.remove(key);   //  错误做法
                        removeKey = key;
                        LockSupport.unpark(key);
                    }
                }
                hm.remove(removeKey);
                disk.setCurrentDist(i);
                i = disk.getCurrentDist();
            }
        }
        this.direction = -1;
        return num;
    }

}
