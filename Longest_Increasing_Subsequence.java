import java.util.*;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }

        int[] temp = new int[n];
        Arrays.fill(temp,1);

        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(arr[j] < arr[i]){
                    temp[i] = Math.max(temp[i], temp[j]+1);
                }
            }
        }

        int maxLen = Integer.MIN_VALUE;

        for(int i : temp){
            maxLen = Math.max(maxLen,i);
        }

        System.out.println("Length of lis : " + maxLen);
    }
}
