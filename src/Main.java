import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[]check = new String[100];
        Scanner scn = new Scanner(System.in);
        String str = "";

        System.out.println("身分證字號");
        String str1 = scn.next();
        System.out.println("生日");
        String str2 = scn.next();
        String nstr = str1+str2;
        char [] array = nstr.toCharArray();
        fun(array, 0, array.length);
        Boolean flag = true;
        int n = 1;
        while(check[n-1]!=null){
            if(check[n-1]==str){
                flag = false;
            }
            n++;
            if(n>check.length){
               String[] cmp = new String[n*2];
                for(int i=0; i<check.length; i++){
                    cmp[i] = check[i];
                }
                check = new String[n*2];
                check = cmp;
                break;
            }
        }
        if(flag == true){
            check[n-1] = str;
            System.out.println(str);
        }
    }

    public static void fun(char[] a,int s, int e){
     String str = "";
        if(s==e){
            for(int i=0; i<e; i++) {
                System.out.print(a[i]+" ");
            }
             System.out.println();
        }
        else {
            for (int i = s; i < e; i++) {
                swap(a, s, i);
                fun(a, s + 1, e);
                swap(a, i, s);
            }
        }
    }

    private static void swap(char[]a,int x1, int x2){
        char tmp = a[x1];
        a[x1] = a[x2];
        a[x2] = tmp;
    }
}