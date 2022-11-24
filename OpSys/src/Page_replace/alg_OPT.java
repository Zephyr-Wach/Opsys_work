package Page_replace;

import java.util.*;

public class alg_OPT {
    static void opt(ArrayList<Integer> frame, ArrayList<Integer> page) {
        System.out.println("============最佳页面置换算法============");
        // 框和页面长度
        int n_f = frame.size();
        int n_p = page.size();
        // 缺页
        int n_lack = n_f;
        // 判断块:初始每个块对应的页面很大
        ArrayList<Integer> judge = new ArrayList<Integer>(n_f);
        for (int i = 0; i < n_f; i++) {
            judge.add(99);
        }
        for (int i = 0; i < n_p; i++) {
            System.out.print(page.get(i) + "===");
            if (i < n_f) {
                // 预装入
                frame.set(i, page.get(i));
                System.out.println(frame);
            } else {
                if (frame.contains(page.get(i))) {
                    // 页面已经存在在物理快中
                    System.out.println("页面已经存在于物理块");
                } else {
                    // 更新往后页面第一次出现的位置
                    for (int j = 0; j < 3; j++) {
                        int index = 99;
                        for (int k = i + 1; k < n_p; k++) {
                            if (frame.get(j) == page.get(k)) {
                                index = k;
                                break;
                            }
                        }
                        // 更新（
                        judge.set(j, index);
                    }
                    // 根据出现最后的（即judge对应最大的）替换
                    int index_max = judge.indexOf(Collections.max(judge));
                    int rep_page = frame.get(index_max);
                    frame.set(index_max, page.get(i));
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
