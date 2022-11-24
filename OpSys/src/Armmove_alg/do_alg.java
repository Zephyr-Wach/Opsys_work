package Armmove_alg;

import static Armmove_alg.alg_SCAN.*;
import static Armmove_alg.alg_SSTF.*;
//例如，考虑一个磁盘队列，其 I/O 请求块的柱面的顺序如下：
//98, 183, 37, 122, 14, 124, 65, 67

public class do_alg {
    public static void main(String[] args) {
        int io[] = {98, 183, 37, 122, 14, 124, 65, 67};
        scan(8,io);
    }
}
