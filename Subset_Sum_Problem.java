import java.util.*;

public class Subset_Sum_Problem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        int sum = input.nextInt();
        System.out.println("Here");

        boolean[][] table = new boolean[n][sum+1];


        for(int i = 0;i < n;i++){
            table[i][0] = true;
        }


        for(int i = 0;i < n;i++){
            for(int j = 1;j <= sum;j++){
                if(i == 0){
                    if(arr[i] == j){
                        table[i][j] = true;
                    }
                    else{
                        table[i][j] = false;
                    }
                }
                else{
                    if(arr[i] > j){
                        table[i][j] = table[i-1][j];
                    }

                    else{
                        if(table[i-1][j] == true){
                            table[i][j] = true;
                        }
                        else{
                            int x = i - 1;
                            int y = j - arr[i];
                            if(table[x][y] == true){
                                table[i][j] = true;
                            }
                            else{
                                table[i][j] = false;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("The Table : ");

        for(int i = 0;i < n;i++){
            for(int j = 0;j <= sum;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }


        if(table[n-1][sum] == false){
            System.out.println("Subset does not exist.");
        }

        else{
            ArrayList<Integer> list = new ArrayList<Integer>();
            int x = n-1;
            int y = sum;
            while (y > 0){
                if(table[x][y] == true && table[x-1][y] == true){
                    x--;
                }
                else if(table[x][y] == true && table[x-1][y] == false){
                    list.add(arr[x]);
                    //System.out.println(y  + " " + arr[x]);
                    y = y - arr[x];
                    x--;
                    //System.out.println("y " + y);
                }

                if(x == 0){
                    if(table[x][y] == true){
                        list.add(arr[x]);
                        break;
                    }
                }

            }

            System.out.println("The Subset is :");
            for(int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
