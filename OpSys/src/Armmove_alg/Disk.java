package Armmove_alg;

public class Disk {
    public int currentDist = 100;
    public int requireNum = 0;
    public int n;                 // 跨越的磁道数
    public void set(int rn, int n) {
        this.requireNum = rn;
        this.n = n;
    }
    public int getCurrentDist() {//获取当前所在磁道
        return currentDist;
    }
    public void setCurrentDist(int newCurrentDist) {//设置所在磁道
        this.currentDist = newCurrentDist;
    }

}
