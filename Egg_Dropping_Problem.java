import java.util.*;

public class Egg_Dropping_Problem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int eggs = input.nextInt();
        int floors = input.nextInt();

        int[][] table = new int[eggs+1][floors+1];

        for(int i = 1;i <= floors;i++){
            table[1][i] = i;
        }

        for(int e = 2;e <= eggs;e++){
            for(int f = 1;f <= floors;f++){
                table[e][f] = Integer.MAX_VALUE;
                for(int k = 1;k <= f;k++){
                    int A1 = 1;  // broke
                    int floorsLeft = k - 1;
                    if(floorsLeft > 0){
                        A1 += table[e-1][floorsLeft];
                    }

                    int A2 = 1; // didn't broke
                    floorsLeft = f - k;
                    if(floorsLeft > 0){
                        A2 += table[e][floorsLeft];
                    }
                    int p = Math.max(A1,A2);

                    if(p < table[e][f]){
                        table[e][f] = p;
                    }
                }
            }
        }

        System.out.println("The table : ");

        for(int e = 1;e <= eggs;e++){
            for(int f = 1;f <= floors;f++){
                System.out.print(table[e][f] + " ");
            }
            System.out.println();
        }

        System.out.println("Minimum Number of attempts needed : " + table[eggs][floors]);


    }
}
