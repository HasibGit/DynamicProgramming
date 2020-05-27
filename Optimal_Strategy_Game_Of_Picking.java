import java.util.*;

public class Optimal_Strategy_Game_Of_Picking {

    static class Cell{
        int first;
        int second;
        Cell(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }

        Cell[][] table = new Cell[n][n];


        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                table[i][j] = new Cell(-1,-1);
            }
        }

        for(int i = 0;i < n;i++){
            table[i][i].first = arr[i];
            table[i][i].second = 0;
        }

        for(int i = 0;i < n-1;i++){
            if(arr[i] > arr[i+1]){
                table[i][i+1].first = arr[i];
                table[i][i+1].second = arr[i+1];
            }
            else{
                table[i][i+1].first = arr[i+1];
                table[i][i+1].second = arr[i];
            }
        }

        for(int len = 3; len <= n;len++){

            for(int i = 0;i < n - len + 1;i++){
                int j = len + i - 1;

                int first = arr[i];

                int second = table[i+1][j].first;

                first += table[i+1][j].second;


                int first_2 = arr[j];
                int second_2 = table[i][j-1].first;
                first_2 += table[i][j-1].second;

                if(first >= first_2){
                    table[i][j].first = first;
                    table[i][j].second = second;
                }
                else{
                    table[i][j].first = first_2;
                    table[i][j].second = second_2;
                }

            }
        }


        System.out.println("The table : ");

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                System.out.print(" (" + table[i][j].first + " " + table[i][j].second + ")  ");
            }
            System.out.println();
        }


        System.out.println("First Player : " + table[0][n-1].first);
        System.out.println("Second Player : " + table[0][n-1].second);
    }
}
