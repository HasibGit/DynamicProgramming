/*
    Test :
6
1 3 5
2 5 6
4 6 5
6 7 4
5 8 11
7 9 2
 */


import java.util.*;
public class Job_Scheduling {

    static class Job implements Comparable<Job>{
        int startTime;
        int endTime;
        int profit;
        Job(int startTime,int endTime,int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        public int compareTo(Job other){
            if(this.endTime == other.endTime){
                return 0;
            }
            else if(this.endTime > other.endTime){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int noOfJobs = input.nextInt();
        Job[] arr = new Job[noOfJobs];

        for(int i = 0;i < noOfJobs;i++){
            int startTime = input.nextInt();
            int endTime = input.nextInt();
            int profit = input.nextInt();
            arr[i] = new Job(startTime,endTime,profit);
        }

        Arrays.sort(arr);

        int[] temp = new int[noOfJobs];

        for(int i = 0;i < noOfJobs;i++){
            temp[i] = arr[i].profit;
        }

        for(int i = 1;i < noOfJobs;i++){
            for(int j = 0;j < i;j++){
                if(arr[j].endTime <= arr[i].startTime){
                    temp[i] = Math.max(temp[i],temp[j] + arr[i].profit);
                }
            }
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int i : temp){
            maxProfit = Math.max(maxProfit,i);
        }
        System.out.println("Max Profit : " + maxProfit);
    }
}
