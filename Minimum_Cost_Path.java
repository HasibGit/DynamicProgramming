import java.util.*;
public class Minimum_Cost_Path {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();
        int[][] arr = new int[rows][cols];

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                arr[i][j] = input.nextInt();
            }
        }

        int[][] table = new int[rows][cols];

        table[0][0] = arr[0][0];

        for(int i = 1;i < cols;i++){
            table[0][i] = arr[0][i] + table[0][i-1];
        }

        for(int i = 1;i < rows;i++){
            table[i][0] = arr[i][0] + table[i-1][0];
        }

        for(int i = 1;i < rows;i++){
            for(int j = 1;j < cols;j++){
                table[i][j] = arr[i][j] + Math.min(table[i][j-1],table[i-1][j]);
            }
        }


        System.out.println("The table : ");
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Minimum cost to reach end : " + table[rows-1][cols-1]);

        ArrayList<Integer> list = new ArrayList<Integer>();


        int i = rows - 1;
        int j = cols - 1;

        while (true){
            list.add(arr[i][j]);
            if(i == 0 && j == 0){
                break;
            }

            if(i == 0 || j == 0){
                if(i == 0){
                    j--;
                }
                else{
                    i--;
                }
            }

            else if(table[i-1][j] <= table[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }

        Collections.reverse(list);

        System.out.println("The path : ");

        for(int p : list){
            System.out.print(p + " ");
        }
        System.out.println();
    }
}
