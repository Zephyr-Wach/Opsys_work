package Armmove_alg_simple;


import java.util.ArrayList;


public class do_alg {
    public static void main(String[] args) {
        // 磁盘号顺序
        int[] track = new int[]{55, 58, 39, 18, 90, 160, 150, 38,184};
        ArrayList<Integer> ta = new ArrayList<>();
        for (int t : track) {
            ta.add(t);
        }

        // CSCAN
        alg_CSCAN st = new alg_CSCAN( ta,100);
        st.run();
        System.out.println(st);

        // SCAN
        SCAN ff = new SCAN( ta,100);
        ff.run();
        System.out.println(ff);

    }
}
