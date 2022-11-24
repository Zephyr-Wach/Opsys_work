package Page_replace;

import java.util.ArrayList;
import java.util.Collections;

public class alg_FIFO {
    static void fifo(ArrayList<Integer> frame, ArrayList<Integer> page) {
        System.out.println("============先进先出置换算法============");
        int n_f = frame.size();
        int n_p = page.size(); // 框和页面长度
        int n_lack = n_f;// 缺页
        ArrayList<Integer> judge = new ArrayList<Integer>(n_f);
        for (int i = 0; i < n_f; i++) {
            judge.add(3 - i);
        }// 判断块:初始每个块对应的出现次数
        for (int i = 0; i < n_p; i++) {
            System.out.print(page.get(i) + "===");
            if (i < n_f) {
                frame.set(i, page.get(i));
                System.out.println(frame);// 预装入
            } else {
                // 每个页面存在次数加1
                for (int j = 0; j < n_f; j++) {
                    judge.set(j, judge.get(j) + 1);
                }
                if (frame.contains(page.get(i))) {
                    // 页面已经存在在物理块中
                    System.out.println("页面已经存在于物理块");
                } else {
                    // 根据存在最久的（即judge对应最大的）替换
                    int index_max = judge.indexOf(Collections.max(judge));
                    int rep_page = frame.get(index_max);
                    frame.set(index_max, page.get(i));
                    // 将新换进的存在状态设置为1
                    judge.set(index_max, 1);
                    System.out.print(frame);
                    System.out.println("  替换掉了页面：" + rep_page);
                    n_lack = n_lack + 1;
                }
            }
        }
        float p_lack = 100 * (float) n_lack / n_p;
        System.out.println("===================================");
        System.out.printf("缺页次数：%d\n", n_lack);
        System.out.printf("缺页率： %.2f%%\n", p_lack);
        System.out.println("===================================");
    }


}