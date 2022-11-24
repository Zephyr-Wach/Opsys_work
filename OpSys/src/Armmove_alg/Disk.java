package Armmove_alg;

public class Disk {
    public int num;//磁道号

    public Disk(int number) {

        num = number;
    }

    public int getNumber() {

        return num;
    }

    public int distence(int pri, int cur){
        int dis;
        dis=Math.abs(pri-cur);
        return dis;
    }
}
