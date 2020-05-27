/*
Given array, we have to find the subsequence where sum would be maximum and
the elements of the subsequence will be non-adjacent

 */

import java.util.*;
public class Maximum_Sum_Subsequence_Non_Adjacent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }

        int exclusive = 0;
        int inclusive = arr[0];

        /*
        At any position i, exclusive will store the best we can do till i without taking input[i]
        inclusive will store the best we can do till i, also taking input[i] into ** consideration
         */


        for(int i = 1;i < n;i++){
            int old_inclusive = inclusive;

            inclusive = Math.max(inclusive,exclusive + arr[i]);

            exclusive = old_inclusive;

        }

        System.out.println(inclusive);
    }
}
