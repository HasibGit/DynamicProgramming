import java.util.*;
public class CoinChange_NumberOfWays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] coinVal = new int[n];
        for(int i = 0;i < n;i++){
            coinVal[i] = input.nextInt();
        }
        Arrays.sort(coinVal);
        int sum = input.nextInt();
        int[][] table = new int[n][sum+1];

        for(int i = 0;i < n;i++){
            table[i][0] = 1;
        }

        // fill the first row

        for(int j = 1;j <= sum;j++){
            if(j < coinVal[0]){
                table[0][j] = 0;
            }
            else{
                table[0][j] = table[0][j - coinVal[0]];
            }
        }

        // fill the rest of the rows

        for(int i = 1;i < n;i++){
            for(int j = 1;j <= sum;j++){
                if(coinVal[i] > j){
                    table[i][j] = table[i-1][j];
                }
                else{
                    table[i][j] = (table[i-1][j]) + (table[i][j - coinVal[i]]);
                }
            }
        }

        System.out.println("The Table :");

        for(int i = 0;i < n;i++){
            for(int j = 0;j <= sum;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Number of ways to achieve the sum from the given coins : ");
        System.out.println(table[n-1][sum]);

    }
}
