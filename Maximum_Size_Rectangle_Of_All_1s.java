/*
Test
4 6
1 0 0 1 1 1
1 0 1 1 0 1
0 1 1 1 1 1
0 0 1 1 1 1
 */

import java.util.*;
public class Maximum_Size_Rectangle_Of_All_1s {
    static int maxAreaRectangleInHistogram(int[] heights){
        int maxArea = Integer.MIN_VALUE;
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(0);

        int i = 1;

        while (true){
            if(heights[i] >= heights[stack.peek()]){
                stack.add(i);
                i++;
            }
            else{
                while (heights[stack.peek()] > heights[i]){
                    int top = stack.pop();
                    if(stack.isEmpty()){
                        area = heights[top] * i;
                        maxArea = Math.max(maxArea,area);
                        break;
                    }
                    else{
                        area = heights[top] * (i - stack.peek() - 1);
                        maxArea = Math.max(maxArea,area);
                    }
                }
                stack.add(i);
                i++;
            }
            if(i == heights.length){
                while (!stack.isEmpty()){
                    int top = stack.pop();
                    if(stack.isEmpty()){
                        area = heights[top] * i;
                        maxArea = Math.max(maxArea,area);
                        break;
                    }
                    else{
                        area = heights[top] * (i - stack.peek() - 1);
                        maxArea = Math.max(maxArea,area);
                    }
                }
                break;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();

        int[][] table = new int[rows][cols];

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                table[i][j] = input.nextInt();
            }
        }

        int[] temp = new int[cols];
        int maxSize = Integer.MIN_VALUE;
        int area = 0;
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(table[i][j] == 1)
                temp[j] += table[i][j];

                else{
                    temp[j] = 0;
                }
            }
            area = maxAreaRectangleInHistogram(temp);
            maxSize = Math.max(maxSize,area);
        }
        System.out.println("Maximum size rectangle consisting of only 1's : " + maxSize);
    }
}
