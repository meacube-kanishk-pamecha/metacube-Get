import java.util.Arrays;
import java.util.Scanner;
// Main Class 
public class time {
    public static void main(String[] args) {

        System.out.println("Enter the num of Process");
        Scanner Sc = new Scanner(System.in);
        
        int a = Sc.nextInt(); // Num Of Process
        int avgWaiting = 0;
        int mxWaiting = 0;
        System.out.println("For this " + a + " Number of timeArr give start time after that burst time");
        int[][] timeArr = new int[a][2];
        for (int i = 0; i < a; i++) {
            timeArr[i][0] = Sc.nextInt();  // Arrival Time of Each Process
            timeArr[i][1] = Sc.nextInt();  // Burst Time for Each Process
        }
        Arrays.sort(timeArr,(n1,n2)->Integer.compare(n1[0], n2[0]));
        // completion Time for Each Process 
        int completionTime[] = new int[a];

        // waiting time and Turn Around Time
        int[] waitingTime = new int[a];
        int[] turnAroundTime = new int[a];

        completionTime[0] = timeArr[0][0] + timeArr[0][1]; // completion time for first process 
        for (int i = 1; i < a; i++) {
            completionTime[i] = Math.max(completionTime[i - 1], timeArr[i][0]) + timeArr[i][1];
        }
        // turn Around Time 
        for (int i = 0; i < timeArr.length; i++) {
            turnAroundTime[i] = completionTime[i] - timeArr[i][0]; 
        }
        // Waiting time , avgw
        for (int i = 0; i < timeArr.length; i++) {
            waitingTime[i] = turnAroundTime[i] - timeArr[i][1];
            avgWaiting += waitingTime[i];
            mxWaiting = Math.max(mxWaiting, waitingTime[i]);
        }
        avgWaiting = avgWaiting / a;
        System.out.println("max waiting time " + mxWaiting);
        System.out.println( "average waiting time "+avgWaiting);
        for (int i = 0; i < turnAroundTime.length; i++) {
            System.out.println("completion time for "+i +" :"+completionTime[i]);
        }
        for (int i = 0; i < turnAroundTime.length; i++) {
            System.out.println("turn around time  for "+i +" :" +turnAroundTime[i]);
        }
        for (int i = 0; i < turnAroundTime.length; i++) {
            System.out.println("Waiting time for "+i  +" :"+ waitingTime[i]);
        }
        Sc.close();
    }
}
