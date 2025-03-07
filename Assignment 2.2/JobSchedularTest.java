import java.util.Arrays;
import java.util.Scanner;

// Main Class 
public class JobSchedularTest {
    public static void main(String[] args) {

        System.out.println("Enter the num of Process");
        Scanner Sc = new Scanner(System.in);
        int a = Sc.nextInt();
        System.out.println("For this " + a + " Number of timeArr give start time after that burst time");

        int[][] timeArr = new int[a][2];
        for (int i = 0; i < a; i++) {
            timeArr[i][0] = Sc.nextInt(); // Arrival Time of Each Process
            timeArr[i][1] = Sc.nextInt(); // Burst Time for Each Process
        }
        Arrays.sort(timeArr, (n1, n2) -> Integer.compare(n1[0], n2[0]));
        JobScheduler job = new JobScheduler();
        System.out.println("1 : completionTime \n 2 : WaitingTime \n 3 : turnAroundTime \n 4 : Average Waiting \n 5 : Max Waiting");
        int option = Sc.nextInt();
        switch (option) {
            case 1:
                int[] completionTime = job.completionTime(timeArr);
                for (int i : completionTime) {
                    System.out.println(i);
                }
                break;
            case 2:
                int[] waitingTime = job.waitingTime(timeArr);
                for (int i : waitingTime) {
                    System.out.println(i);
                }
                break;
            case 3:
                int[] turnAroundTime = job.turnAroundTime(timeArr);
                for (int i : turnAroundTime) {
                    System.out.println(i);
                }
                break;
            case 4:
                int avgWaiting = job.avgWaiting(timeArr);
                System.out.println(avgWaiting);
                break;
            case 5:
                int maxWaiting = job.mxWaiting(timeArr);
                System.out.println(maxWaiting);
                break;

            default:
                break;
        }

        Sc.close();
    }
}
