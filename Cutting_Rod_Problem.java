import java.util.*;

/*
4
1 2
2 5
3 7
4 8
5
 */

public class Cutting_Rod_Problem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] size = new int[n];
        int[] profit = new int[n];

        for(int i = 0;i < n;i++){
            size[i] = input.nextInt();
            profit[i] = input.nextInt();
        }

        int rod_length = input.nextInt();

        int[][] table = new int[n][rod_length+1];

        for(int i = 0;i < n;i++){
            table[i][0] = 0;
        }

        for(int i = 1;i <= rod_length; i++){
            if(i < size[0]){
                table[0][i] = 0;
            }
            else{
                int p1 = (i / size[0]) * profit[0];
                int left = (i % size[0]);
                p1 += table[0][left];
                table[0][i] = p1;
            }
        }

        for(int i = 1;i < n;i++){
            for(int j = 1;j <= rod_length; j++){
                if(j < size[i]){
                    table[i][j] = table[i-1][j];
                }
                else{
                    int p1 = (j / size[i]) * profit[i];
                    int left = (j % size[i]);
                    p1 += table[i][left];
                    table[i][j] = Math.max(table[i-1][j],p1);
                }
            }
        }

        System.out.println("The table : ");

        for(int i = 0;i < n;i++){
            for(int j = 0;j <= rod_length;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("Max profit : " + table[n-1][rod_length]);

        System.out.println("Cut sizes : ");
        ArrayList<Integer> list = new ArrayList<Integer>();

        int i = n-1;
        int j = rod_length;

        while (true){
            if(table[i][j] == table[i-1][j]){
                i--;
            }
            else{
                list.add(size[i]);
                j = j - size[i];
            }
            if(j == 0){
                break;
            }
            if(i == 0){
                list.add(size[i]);
                break;
            }
        }
        for(int p : list){
            System.out.print(p + " ");
        }
    }
}
