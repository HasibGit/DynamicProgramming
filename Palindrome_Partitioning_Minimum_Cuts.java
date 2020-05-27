import java.util.*;

public class Palindrome_Partitioning_Minimum_Cuts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        boolean[][] table = new boolean[s.length()][s.length()];

        for(int i = 0;i < s.length();i++){
            table[i][i] = true;
        }

        for(int i = 0;i < s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1] = true;
            }
            else{
                table[i][i+1] = false;
            }
        }


        for(int len = 3; len <= s.length(); len++){

            for(int i = 0;i < s.length() - len + 1;i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)){
                    table[i][j] = table[i+1][j-1];
                }
                else{
                    table[i][j] = false;
                }
            }
        }

        System.out.println("The Table : ");

        for(int i = 0;i < s.length();i++){
            for(int j = 0;j < s.length();j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        int[] cuts = new int[s.length()];

        for(int i = 0;i < s.length();i++){

            int min = Integer.MAX_VALUE;

            if(table[0][i] == true){
                cuts[i] = 0;
            }
            else{

                for(int j = 0;j < i;j++){
                    if(table[j+1][i] == true && min > cuts[j] + 1){
                        min = cuts[j] + 1;
                    }
                }
                cuts[i] = min;
            }
        }
        System.out.println("Minimum cuts needed : " + cuts[s.length()-1]);

    }
}
