package Page_replace;

import java.util.*;

import static Page_replace.alg_FIFO.fifo;
import static Page_replace.alg_LRU.lru;
import static Page_replace.alg_OPT.opt;

public class do_alg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入分配给该作业的物理页框块数：");
        int n_frame = scanner.nextInt(); // 物理页框数
        ArrayList<Integer> frame = new ArrayList<Integer>(n_frame);
        for (int i = 0; i < n_frame; i++) {
            frame.add(-1);
        }

        System.out.print("请输入该作业的页面走向：");
        scanner.nextLine(); // 控制输入格式
        String inputPages = scanner.nextLine();
        String[] split = inputPages.split("\\s+|,|，");
        int n_page = split.length; // 作业的页面走向总次数
        ArrayList<Integer> page = new ArrayList<Integer>(n_page); // 作业的页面走向
        for (int i = 0; i < n_page; i++) {
            page.add(Integer.parseInt(split[i]));
        }
        scanner.close();
        opt(frame,page);
        fifo(frame, page);
        lru(frame, page);
    }
}
//在考虑如何实现判断那一个页面被置换出时，原本是想通过一次次的遍历来得到答案，但是这样代码显得臃肿，于是我添加了一个和frame一样长度的ArrayList：judge，
//        在 opt 算法中，judge中的数代表页面在以后出现的位置，初始judge给的很大；
//        在 fifo 算法中，judge中的数代表页面在物理块中存在的时间，初始为0，越大代表存在的时间越长；
//        在 lru 算法中 judge 中的数代表没被使用的时间，每访问一个页面将访问时间设置为 1，没被访问的其他页面则加1。
//        如此一来，三种算法都是将judge对应frame中最大的替换出去（就是说三种算法有冗余，还请各位自己修改修改^ - ^。