import java.util.*;
public class Regular_Expression_Matching {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pattern = input.nextLine();
        String text = input.nextLine();

        boolean[][] table = new boolean[text.length()+1][pattern.length()+1];

        table[0][0] = true;

        for(int i = 1;i <= text.length();i++){
            table[i][0] = false;
        }
        for(int i = 1;i <= pattern.length();i++){
            table[0][i] = false;
        }

        for(int i = 1;i <= text.length();i++){
            for(int j = 1;j <= pattern.length();j++){
                if(text.charAt(i-1) != pattern.charAt(j-1) && pattern.charAt(j-1) != '.' && pattern.charAt(j-1) != '*'){
                    table[i][j] = false;
                }
                else if(pattern.charAt(j-1) == '.'){
                    table[i][j] = table[i-1][j-1];
                }
                else if(text.charAt(i-1) == pattern.charAt(j-1)){
                    table[i][j] = table[i-1][j-1];
                }
                else if(pattern.charAt(j-1) == '*'){
                    if(table[i][j-2] == true){
                        table[i][j] = true;
                    }
                    else{
                        if(pattern.charAt(j-2) == text.charAt(i-1)){
                            table[i][j] = table[i-1][j];
                        }
                        else{
                            table[i][j] = false;
                        }
                    }
                }
            }
        }

        System.out.println("The table : ");
        for(int i = 0;i <= text.length();i++){
            for(int j = 0;j <= pattern.length();j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        if(table[text.length()][pattern.length()] == true){
            System.out.println("Text matched with pattern");
        }
        else{
            System.out.println("Text didn't match with pattern");
        }

    }
}
