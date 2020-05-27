import java.util.*;

public class Zero_One_Knapsack {
    static class Item{
        int weight;
        int value;
        Item(int weight,int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int no_of_items = input.nextInt();
        int[] weight = new int[no_of_items];
        int[] value = new int[no_of_items];

        for(int i = 0;i < no_of_items;i++){
            weight[i] = input.nextInt();
            value[i] = input.nextInt();
        }

        int sackSize = input.nextInt();

        int[][] table = new int[no_of_items][sackSize+1];

        // for zero weight, we do not get any value

        for(int i = 0;i < no_of_items;i++){
            table[i][0] = 0;
        }

        for(int row = 0;row < no_of_items;row++){
            for(int col = 1;col <= sackSize; col++){
                if(col < weight[row]){  // item cannot be included
                    if(row == 0){
                        continue;
                    }
                    else{
                        table[row][col] = table[row-1][col];
                    }
                }
                else{
                    if(row == 0){
                        // no items in the sack, so value will maximize anyway
                        table[row][col] = value[row];
                    }
                    else{
                        int val1 = table[row-1][col]; // value without including the item

                        int val2 = value[row];  // value with including the item

                        int weight_left = col - weight[row];

                        val2 += table[row-1][weight_left];

                        table[row][col] = Math.max(val1,val2);
                    }
                }
            }
        }

        System.out.println("The Table : ");

        for(int i = 0;i < no_of_items;i++){
            for(int j = 0;j <= sackSize;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Maximum value : " + table[no_of_items-1][sackSize]);

        ArrayList<Item> list = new ArrayList<Item>();
        int i = no_of_items-1;
        int j = sackSize;

        while (true){
            if(j == 0){
                break;
            }
            if(i > 0){
                int val1 = table[i][j];
                int val2 = table[i-1][j];
                if(val1 == val2){
                    i--;
                }
                else {
                    list.add(new Item(weight[i],value[i]));
                    int left = j - weight[i];
                    j = left;
                    i--;
                    // System.out.println("After adding " + i + " " + j);
                }
            }
            else{
                if(table[i][j] > 0){
                    list.add(new Item(weight[i],value[i]));
                }
                break;
            }
        }

        System.out.println("Items Included : ");
        System.out.println("Weight      Value");
        for(Item p : list){
            System.out.println(p.weight + "              " + p.value);
        }
    }
}
