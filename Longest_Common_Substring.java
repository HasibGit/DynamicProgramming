import java.util.*;
public class Longest_Common_Substring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();

        char[] first = new char[s1.length() + 1];
        char[] second = new char[s2.length() + 1];
        first[0] = ' ';
        second[0] = ' ';
        for(int i = 1;i <= s1.length();i++){
            first[i] = s1.charAt(i-1);
        }
        for(int i = 1;i <= s2.length();i++){
            second[i] = s2.charAt(i-1);
        }

        int[][] table = new int[second.length][first.length];
        for(int i = 0;i < first.length;i++){
            table[0][i] = 0;
        }
        for(int i = 0;i < second.length;i++){
            table[i][0] = 0;
        }

        int maxLen = Integer.MIN_VALUE;
        int x = 0,y=0;

        for(int i = 1;i < second.length;i++){
            for(int j = 1;j < first.length;j++){
                if(second[i] != first[j]){
                    table[i][j] = 0;
                }
                else{
                    table[i][j] = table[i-1][j-1] + 1;
                }
                if(table[i][j] > maxLen){
                    maxLen = table[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("The Table : ");

        for(int i = 0;i < second.length;i++){
            for(int j = 0;j < first.length;j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Length of longest common substring : " + maxLen);
        if(maxLen == 0){
            System.out.println("No lcs");
        }
        else{
            System.out.println("Longest Common Substring : ");
            ArrayList<Character> list = new ArrayList<Character>();
            while (true){
                list.add(second[x]);
                x--;
                y--;
                if(table[x][y] == 0){
                    break;
                }
            }
            Collections.reverse(list);
            for(char c : list){
                System.out.print(c);
            }
            System.out.println();
        }


    }
}
