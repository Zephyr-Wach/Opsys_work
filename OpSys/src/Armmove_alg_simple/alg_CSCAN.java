package Armmove_alg_simple;

import java.util.ArrayList;

public class alg_CSCAN extends Disk {
    public alg_CSCAN(ArrayList<Integer> diskCollection, int start) {
        this.diskCollection = diskCollection;
        this.start = start;
    }

    public void run() {
        separate();
        // diskList接收排序好的顺序
        diskList = sort(diskListBefore, false);
        diskList.addAll(sort(diskListAfter, false));
        // 计算移动距离
        calculateTravelDistance();
    }
    @Override
    public String toString() {
        return "\n循环扫描（CSCAN）算法" +
                "\n从" + start + "号磁道开始" +
                "\n被访问的下一个磁道号\t" + diskList +
                "\n移动距离（磁道数）\t" + movList +
                "\n总道数：" + distanceSum + "\t平均寻道长度：" + String.format("%.2f", (double) distanceSum / movList.size());

    }

}
