package Armmove_alg;

public class alg_SCAN {

    static void scan(int n,int io[]){
        int start;  //起始磁道号
        int m=300;//最大磁道数

        start=io[0];
        int arr[]=new int[m];
        int j;
        for(j=0;j<n;j++){
            arr[j]=io[j];
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int i=0;
        int temp=arr[i];
        for(;temp!=start;i++){}
        for(j=i;j>=0;j--){System.out.printf("\n",arr[j]);}
        for(j=i;j<n;j++){System.out.printf("\n",arr[j]);}
    }
}
