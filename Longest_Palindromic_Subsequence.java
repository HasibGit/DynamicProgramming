import java.util.*;

public class Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        int[][] table = new int[s.length()][s.length()];

        for(int i = 0;i < s.length(); i++){
            table[i][i] = 1;
        }

        int times = s.length()-1;
        int leap = 1;
        while (times > 0){
            for(int i = 0;i < times;i++){
                int j = i + leap;
                if(times == s.length()-1){
                    if(s.charAt(i) == s.charAt(j)){
                        table[i][j] = 2;
                    }
                    else{
                        table[i][j] = Math.max(table[i][j-1],table[i+1][j]);
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        table[i][j] = table[i+1][j-1] + 2;
                    }
                    else{
                        table[i][j] = Math.max(table[i][j-1],table[i+1][j]);
                    }
                }
            }
            leap++;
            times--;
        }

        System.out.println("The Table : ");
        for(int i = 0;i < s.length();i++){
            for(int j = 0;j < s.length(); j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Length of the longest palindromic subsequence : " + table[0][s.length()-1]);
        ArrayList<Character> list1 = new ArrayList<Character>();
        ArrayList<Character> list2 = new ArrayList<Character>();

        int i = 0;
        int j = s.length()-1;

        while (i != j){
            if(s.charAt(i) == s.charAt(j)){
                list1.add(s.charAt(i));
                list2.add(s.charAt(j));
                i++;
                j--;
            }

            else{
                if(table[i][j] == table[i][j-1]){
                    j--;
                }
                else{
                    i++;
                }
            }
            if(i == j){
                list1.add(s.charAt(i));
                break;
            }
        }

        Collections.reverse(list2);
        System.out.print("The longest palindromic subsequence : ");
        for(char c : list1){
            System.out.print(c);
        }
        for(char c : list2){
            System.out.print(c);
        }
        System.out.println();


    }
}
