/*

Find the longest increasing subsequence of an array where the sum of the elements
of the sequence will be maximum.

Test:
7
4 6 1 3 8 4 6
 */

import java.util.*;

public class Maximum_Sum_Increasing_Subsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }

        int[] maxSum = new int[n];
        int[] trace = new int[n];

        for(int i = 0;i < n;i++){
            maxSum[i] = arr[i];
            trace[i] = i;
        }

        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(arr[j] < arr[i]){
                    int sum = maxSum[j] + arr[i];
                    if(sum > maxSum[i]){
                        maxSum[i] = sum;
                        trace[i] = j;
                    }
                }
            }
        }

        for(int i : trace){
            System.out.print(i + " ");
        }
        System.out.println();

        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0;i < n;i++){
            if(max < maxSum[i]){
                max = maxSum[i];
                index = i;
            }
        }

        System.out.println("Maximum sum : " + max);

        System.out.println("The sequence : ");
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(arr[index]);
        while (true){
           index = trace[index];
           list.add(arr[index]);
           if(index == trace[index]){
               break;
           }
        }

        Collections.reverse(list);

        for(int i : list){
            System.out.print(i + " ");
        }

    }
}
