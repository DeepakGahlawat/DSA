// You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

// Your task is to find:

// The maximum number of jobs that can be completed within their deadlines.
// The total maximum profit earned by completing those jobs.
// Examples :

// Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
// Output: [2, 60]
// Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
// Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
// Output: [2, 127]
// Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).
// Input: deadline[] = [3, 1, 2, 2], profit[] = [50, 10, 20, 30]
// Output: [3, 100]
// Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).
// Constraints:
// 1 ≤ deadline.size() == profit.size() ≤ 105
// 1 ≤ deadline[i] ≤ deadline.size()
// 1 ≤ profit[i] ≤ 500

import java.util.*;

class Job {
    int jobId;
    int jobprofit;
    int jobdeadline;

    Job(int jobId, int jobprofit, int jobdeadline) {
        this.jobId = jobId;
        this.jobprofit = jobprofit;
        this.jobdeadline = jobdeadline;
    }
}

class JobSequences {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int maxdeadline = 0;
        Job[] jobs = new Job[deadline.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(i + 1, profit[i], deadline[i]);
            maxdeadline = Math.max(maxdeadline, deadline[i]);
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(b.jobprofit, a.jobprofit));

        int[] scheudle = new int[maxdeadline + 1];

        int maxprofit = 0;
        int jobcount = 0;
        for (int i = 0; i < jobs.length; i++) {
            int jobId = jobs[i].jobId;
            int jobprofit = jobs[i].jobprofit;
            int jobdeadline = jobs[i].jobdeadline;

            for (int k = jobdeadline; k > 0; k--) {
                if (scheudle[k] == 0) {
                    maxprofit += jobprofit;
                    jobcount++;
                    scheudle[k] = jobId;
                    break;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(jobcount);
        res.add(maxprofit);

        return res;
    }

    public static void main(String[] args) {
        JobSequences sol = new JobSequences();
        int[] deadlines = {4, 1, 1, 1};
        int[] profits = {20, 10, 40, 30};
        ArrayList<Integer> result = sol.jobSequencing(deadlines, profits);
        System.out.println("Jobs Done: " + result.get(0));
        System.out.println("Total Profit: " + result.get(1));
    }
}

