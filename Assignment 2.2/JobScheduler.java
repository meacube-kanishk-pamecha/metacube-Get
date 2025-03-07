public class JobScheduler {
    private int avgWaiting = 0;
    private int mxWaiting = 0;
    private int[] waitingTime;
    private int[] turnAroundTime;
    private int[] completionTime;

    // completion Time function
    protected int[] completionTime(int[][] timeArr) {
        int a = timeArr.length;
        completionTime = new int[a];
        completionTime[0] = timeArr[0][0] + timeArr[0][1]; // completion time for first process
        for (int i = 1; i < a; i++) {
            completionTime[i] = Math.max(completionTime[i - 1], timeArr[i][0]) + timeArr[i][1];
        }
        return completionTime;
    }

    // turn Around Time 
    protected int[] turnAroundTime(int[][] timeArr) {
        int a = timeArr.length;
        turnAroundTime = new int[a];
        completionTime = completionTime(timeArr);

        for (int i = 0; i < a; i++) {

            turnAroundTime[i] = completionTime[i] - timeArr[i][0];
        }

        return turnAroundTime; 
    }

    // waiting time 
    protected int[] waitingTime(int[][] timeArr) {
        int a = timeArr.length;
        turnAroundTime = turnAroundTime(timeArr);
        for (int i = 0; i < a; i++) {
            waitingTime[i] = turnAroundTime[i] - timeArr[i][1];
        }
        return turnAroundTime;
    }

    // average Waiting 
    protected int avgWaiting(int[][] timeArr) {
        int a = timeArr.length;
        waitingTime = waitingTime(timeArr);
        for (int i = 0; i < a; i++) {
            avgWaiting += waitingTime[i];
        }
        avgWaiting = avgWaiting / a;
        return avgWaiting;
    } 

    // maxWaiting Time 
    protected int mxWaiting(int[][] timeArr) {
        int a = timeArr.length;
        waitingTime = waitingTime(timeArr);
        for (int i = 0; i < a; i++) {
            mxWaiting = Math.max(mxWaiting, waitingTime[i]);
        }
        return mxWaiting;
    }

}
