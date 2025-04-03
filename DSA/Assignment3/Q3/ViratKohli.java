package Q3;
import java.util.PriorityQueue;
import java.util.Scanner;



public class ViratKohli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bowlers");
        int noOfBowlers = sc.nextInt();
        System.out.println("Enter the number of balls Virat play");
        int ballsRemainingVK = sc.nextInt();

        PriorityQueue<Bowler> pq = new PriorityQueue<>();

        System.out.println("Enter bowler names and their balls ");
        for (int i = 0; i < noOfBowlers; i++) {
            String name = sc.next();
            int quota = sc.nextInt();
            pq.add(new Bowler(name, quota));
        }

       
        while (ballsRemainingVK > 0 && !pq.isEmpty()) {
            Bowler b = pq.poll();
            System.out.print(b.name + " ");
            b.balls--;
            ballsRemainingVK--;

            if (b.balls > 0) {
                pq.add(b); 
            }
        }
        sc.close();
    }
}
