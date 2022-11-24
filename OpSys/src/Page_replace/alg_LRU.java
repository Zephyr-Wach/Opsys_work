package Page_replace;

import java.util.ArrayList;
import java.util.Collections;

public class alg_LRU {
    static void lru(ArrayList<Integer> frame, ArrayList<Integer> page) {
        System.out.println("===========最近最久未使用算法===========");
        int n_f = frame.size();
        int n_p = page.size();
        int n_lack = n_f;
        ArrayList<Integer> judge = new ArrayList<Integer>(n_f);
        for (int i = 0; i < n_f; i++) {
            judge.add(3 - i);
        }
        for (int i = 0; i < n_p; i++) {
            System.out.print(page.get(i) + "===");
            if (i < n_f) {
                frame.set(i, page.get(i));
                System.out.println(frame);// 预装入
            } else {// 每个页面存在次数加1
                for (int j = 0; j < n_f; j++) {
                    judge.set(j, judge.get(j) + 1);
                }
                if (frame.contains(page.get(i))) {
                    System.out.println("页面已经存在于物理块");
                    judge.set(frame.indexOf(page.get(i)), 1);  // 将页面的使用重置为1
                } else {// 根据最久未使用的（即judge对应最大的）替换
                    int index_max = judge.indexOf(Collections.max(judge));
                    int rep_page = frame.get(index_max);
                    frame.set(index_max, page.get(i));
                    judge.set(index_max, 1);// 将新换进的使用状态设置为1
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
