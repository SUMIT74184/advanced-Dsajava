package GreedyAlgo;

import java.util.*;

public class JObSeq_Attem2 {
    //on2 approach


    public static ArrayList<Integer>jbs(int []deadline,int []profit){
        int n= deadline.length;;
        int cnt=0;
        int toProfit=0;

        //paring the deadline and profit of all the jobs together
        ArrayList<int[]>jobs=new ArrayList<>();
        for(int i=0;i<n;i++){
            jobs.add(new int[]{profit[i],deadline[i]});
        }

        //sort the job based on profit decreasing order
        jobs.sort((a,b)->Integer.compare(b[0],a[0]));
        int []slot=new int[n];


        for(int i=0;i<n;i++){
            int start=Math.min(n,jobs.get(i)[1])-1;
            for(int j=start;j>=0;j--){

                //if the slot is empty
                if(slot[j]==0){
                    slot[j]=1;
                    cnt++;
                    toProfit+=jobs.get(i)[0];
                    break;
                }
            }
        }

        ArrayList<Integer>result=new ArrayList<>();
        result.add(cnt);
        result.add(toProfit);
        return result;

    }

    // n long n time complexity

    public static ArrayList<Integer>jbs2(int []deadline,int[]profit){
        int n=deadline.length;

        ArrayList<Integer>ans=new ArrayList<>(Arrays.asList(0,0));
        List<int[]>jobs=new ArrayList<>();

        for(int i=0;i<n;i++){
            jobs.add(new int[]{deadline[i],profit[i]});

        }

        //sort the job ny deadline in ascending order

        jobs.sort(Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer>pq=new PriorityQueue<>();

        for(int i=0;i< jobs.size();i++){
            int []job=jobs.get(i);


            //if job can be scheduled within its deadline
            if(job[0]>pq.size()){
                pq.add(job[1]);
            }
            //replace the job with the lowest profit
            else if (!pq.isEmpty() && pq.peek()<job[1]) {
                pq.poll();
                pq.add(job[1]);

            }
        }
        while (!pq.isEmpty()) {
            ans.set(1, ans.get(1) + pq.poll());
            ans.set(0, ans.get(0) + 1);
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};

        ArrayList<Integer> ans = jbs(deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
