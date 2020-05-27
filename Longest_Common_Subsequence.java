import javafx.scene.transform.MatrixType;

import java.util.*;
public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();

        int rows = s1.length() + 1;
        int cols = s2.length() + 1;

        int[][] matrix = new int[rows][cols];

        for(int i = 0;i < cols;i++){
            matrix[0][i] = 0;
        }
        for(int i = 0;i < rows;i++){
            matrix[i][0] = 0;
        }
        for(int i = 1;i < rows;i++){
            for(int j = 1;j < cols;j++){
                 if(s1.charAt(i-1) == s2.charAt(j-1)){
                     matrix[i][j] = matrix[i-1][j-1] + 1;
                 }
                 else {
                     matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                 }
            }
        }

        System.out.println("Length of lcs : " + matrix[rows-1][cols-1]);

        ArrayList<Character> res = new ArrayList<Character>();

        int i = rows-1;
        int j = cols-1;
        while (i != 0 || j != 0){
            if(matrix[i][j] == matrix[i-1][j]){
                i--;
            }
            else if(matrix[i][j] == matrix[i][j-1]){
                j--;
            }
            else{
                res.add(s1.charAt(i-1));
                i--;
                j--;
            }
        }
        Collections.reverse(res);
        System.out.print("LCS is : ");
        for(char c : res){
            System.out.print(c);
        }

    }
}
