package Medium._826.MostProfitAssigningWork;

import java.util.Arrays;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        // Pair difficulty with profit and sort by difficulty
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sort the workers by their capability
        Arrays.sort(worker);

        int maxProfit = 0;
        int currentMaxProfit = 0;
        int jobIndex = 0;

        // Assign jobs to workers
        for (int ability : worker) {
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                currentMaxProfit = Math.max(currentMaxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            maxProfit += currentMaxProfit;
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] difficulty =
                {2,4,6,8,10};
       int[] profit =
               {10,20,30,40,50};
        int[] worker =
                {4,5,6,7};
        Solution solution=new Solution();
        int result=solution.maxProfitAssignment(difficulty,profit,worker);
        System.out.println(result);
    }
}