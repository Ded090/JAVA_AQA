package org.example.task2;

public class Main {
    public static void main(String[] args){
//        //Use a for loop to print the first 10 positive integers to the console.
//        for(int i = 1; i < 11; i++) {
//            System.out.print(i);
//        }
//
//        //Use a while loop to print the first 10 positive integers to the console.
//        int x = 1;
//        while (x < 11) {
//            System.out.println(x);
//            x++;
//        }
    }

    public int[] t2(int n, Range range){
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            int r = range.getLow() + i;
            if (r - range.getHigh() <= 0){
                res[i] = r;
            }

        }

        return res;
    }
}
