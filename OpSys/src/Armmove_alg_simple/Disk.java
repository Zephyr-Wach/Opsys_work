package Armmove_alg_simple;

import java.util.*;
import java.lang.Math;

public class Disk {
    protected ArrayList<Integer> diskCollection;//diskCollection ArrayList类型数据，为初始的磁道号序列
    protected int start;//start int类型数据，为磁道开始，默认向磁道号增加的方向访问
    protected ArrayList<Integer> movList = new ArrayList<>(); //timeList ArrayList类型数据，为访问磁道对应的移动距离
    protected int distanceSum; //distanceSum int类型数据，磁针寻道总道数
    protected ArrayList<Integer> diskList = new ArrayList<>(); //diskList ArrayList类型数据，为排序好的磁道访问顺序
    protected ArrayList<Integer> diskListBefore = new ArrayList<>();//diskListBefore ArrayList类型数据，为磁针优先访问的磁道序列 由里向外访问顺序
    protected ArrayList<Integer> diskListAfter = new ArrayList<>(); //diskListAfter ArrayList类型数据，为磁针后访问的磁道序列 由外向里访问顺序
    protected void separate() {// separate分割方法，以起始点为分界线，将磁道分为前后连个顺序
        // 遍历 diskCollection
        for (int item : diskCollection) {
            // 若在起始点外边在第一轮访问
            if (item > start) {
                diskListBefore.add(item);
                // 在起始点里边则在后一轮访问
            } else {
                diskListAfter.add(item);
            }
        }
    }
    protected int distance(int a, int b) {
        int dis=a-b;
        return Math.abs(dis);
    }
    public void calculateTravelDistance() {
        int pinhead = start;// 定义磁盘针头
        for (int i = 0; i < diskList.size(); i++) {// 计算访问磁道号时的移动距离
            // 将对应位置设置为距离 并统计总数
            movList.add(distance(pinhead, diskList.get(i)));
            distanceSum += movList.get(i);
            pinhead = diskList.get(i);
        }
    }
    public ArrayList<Integer> sort(ArrayList<Integer> arrayList, boolean reverse) {
        int len = arrayList.size();
        for (int i = 0; i < len; i++) {
            int index = i;
            for (int j = i + 1; j < len; j++) {
                // 若 reverse为false 升序排序 reverse为true则降序排序
                if (!reverse) {
                    if (arrayList.get(j) < arrayList.get(index)) {
                        index = j;
                    }
                } else {
                    if (arrayList.get(j) > arrayList.get(index)) {
                        index = j;
                    }
                }
            }
            //位置交换 将较小reverse=false  /较大reverse=true 的数提到前边
            int temp = arrayList.get(index);
            arrayList.set(index, arrayList.get(i));
            arrayList.set(i, temp);
        }
        return arrayList;
    }
}
