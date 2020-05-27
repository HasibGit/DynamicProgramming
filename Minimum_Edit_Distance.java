import java.util.*;

public class Minimum_Edit_Distance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();

        char[] first = new char[s1.length()+1];

        first[0] = ' ';
        for(int i = 0;i < s1.length(); i++){
            first[i+1] = s1.charAt(i);
        }

        char[] second = new char[s2.length()+1];

        second[0] = ' ';
        for(int i = 0;i < s2.length();i++){
            second[i+1] = s2.charAt(i);
        }


        int[][]  table = new int[second.length][first.length];

        for(int i = 0;i < first.length; i++){
            table[0][i] = i;
        }

        for(int i = 0;i < second.length; i++){
            table[i][0] = i;
        }

        for(int i = 1;i < second.length;i++){
            for(int j = 1;j < first.length; j++){
                if(second[i] == first[j]){
                    table[i][j] = table[i-1][j-1];
                }
                else{
                    table[i][j] = Math.min( table[i][j-1], Math.min(table[i-1][j-1],table[i-1][j]) ) + 1;
                }
            }
        }

        System.out.println("The table : ");
        for(int i = 0;i < second.length;i++){
            for(int j = 0;j < first.length;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }



        System.out.println("Minimun number of operation needed : " + table[second.length-1][first.length-1]);
    }
}
