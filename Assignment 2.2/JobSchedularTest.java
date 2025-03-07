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

        job.schedule(timeArr);

        Sc.close();
    }
}
