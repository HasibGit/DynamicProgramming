/*
   Find the maximum sum submatrix in a matrix

   Test Case :
4 5
2 1 -3 -4 5
0 6 3 4 1
2 -2 -1 4 -5
-3 3 1 0 3
 */

import java.util.*;

public class Maximum_Sum_Submatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                matrix[i][j] = input.nextInt();
            }
        }

        int[] temp = new int[rows];

        int maxLeft = 0;
        int maxRight = 0;
        int maxTop = 0;
        int maxBottom = 0;
        int maxSum = Integer.MIN_VALUE;


        int left, right, bottom, top, mTop, mBottom, globalSum,max;
        for(int i = 0;i < cols;i++){
            for(int j = i;j < cols;j++){
                if(i == j){
                    Arrays.fill(temp,0);
                    for(int k = 0;k < rows;k++){
                        temp[k] = matrix[k][i];
                    }
                    left = i;
                    right = j;
                    top = 0;
                    bottom = 0;
                    mTop = 0;
                    mBottom = 0;

                    globalSum = temp[0];
                    max = temp[0];

                    for(int p = 1;p < temp.length; p++){
                        if(temp[p] + globalSum >= temp[p]){
                            globalSum += temp[p];
                            bottom = p;
                        }
                        else{
                            globalSum = temp[p];
                            top = p;
                            bottom = p;
                        }

                        if(globalSum > max){
                            max = globalSum;
                            mTop = top;
                            mBottom = bottom;
                        }
                    }
                    if(max > maxSum){
                        maxSum = max;
                        maxTop = mTop;
                        maxBottom = mBottom;
                        maxLeft = left;
                        maxRight = right;
                    }
                }


                else{
                    for(int k = 0;k < rows;k++){
                        temp[k] = temp[k] + matrix[k][j];
                    }

                    left = i;
                    right = j;
                    top = 0;
                    bottom = 0;
                    mTop = 0;
                    mBottom = 0;

                    globalSum = temp[0];
                    max = temp[0];

                    for(int p = 1;p < temp.length; p++){
                        if(temp[p] + globalSum >= temp[p]){
                            globalSum += temp[p];
                            bottom = p;
                        }
                        else{
                            globalSum = temp[p];
                            top = p;
                            bottom = p;
                        }

                        if(globalSum > max){
                            max = globalSum;
                            mTop = top;
                            mBottom = bottom;
                        }
                    }
                    if(max > maxSum){
                        maxSum = max;
                        maxTop = mTop;
                        maxBottom = mBottom;
                        maxLeft = left;
                        maxRight = right;
                    }
                }
            }
        }


        System.out.println("Maximum Sum : " + maxSum);
        System.out.println("Submatrix Boundaries : ");
        System.out.println("Top : " + maxTop + " Bottom : " + maxBottom + " Left " + maxLeft + " Right " + maxRight);

    }
}
