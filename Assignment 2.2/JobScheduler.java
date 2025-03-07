public class JobScheduler {
    private int avgWaiting = 0;
    private int mxWaiting = 0;
    private int[] waitingTime;
    private int[] turnAroundTime;
    private int completionTime[];

    void schedule(int[][] timeArr) {

        for (int i = 0; i < timeArr.length; i++) {
            System.out.println(timeArr[i][0] + " " + timeArr[i][1]);
        }
        int a = timeArr.length;
        completionTime = new int[a];
        turnAroundTime = new int[a];
        waitingTime = new int[a];
        completionTime[0] = timeArr[0][0] + timeArr[0][1]; // completion time for first process
        for (int i = 1; i < a; i++) {
            completionTime[i] = Math.max(completionTime[i - 1], timeArr[i][0]) + timeArr[i][1];
        }

        // turn Around Time
        for (int i = 0; i < timeArr.length; i++) {

            turnAroundTime[i] = completionTime[i] - timeArr[i][0];
        }

        // Waiting time , avgwaiting time and max Waiting time

        for (int i = 0; i < timeArr.length; i++) {
            waitingTime[i] = turnAroundTime[i] - timeArr[i][1];
            mxWaiting = Math.max(mxWaiting, waitingTime[i]);
            avgWaiting += waitingTime[i];

        }
        avgWaiting = avgWaiting / a;    // averaging the sum of time

        System.out.println("max waiting time " + mxWaiting); // 
        System.out.println("average waiting time " + avgWaiting);
        for (int i = 0; i < turnAroundTime.length; i++) {
            System.out.print("completion time  : " + completionTime[i] + "     ");
            System.out.print("turn around time : " + turnAroundTime[i] + "  ");
            System.out.println("Waiting time : " + waitingTime[i]);
            System.out.println();
        }

    }

}
