
import java.util.Arrays;
import java.util.Scanner;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void jobSequence(Job[] jobs, int n) {  //This line defines a method named jobSequence that takes an array of Job objects and an integer n as parameters. This method is used to find the job sequence with the maximum profit.
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit); // This line sorts the jobs array in descending order of profit using a lambda expression.

        boolean[] slot = new boolean[n];
        char[] result = new char[n]; //These lines define two arrays: slot to keep track of available time slots for jobs and result to store the job sequence.

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) { // This line starts a loop to iterate through the time slots (starting from the job's deadline) in reverse order.
                if (!slot[j]) {
                    //These lines mark the time slot as occupied, assign the job ID to the result array, and exit the loop when a suitable time slot is found.
                    slot[j] = true;
                    result[j] = jobs[i].id;
                    break;
                }
            }
        }

        int totalProfit = 0; //These lines initialize a variable to track the total profit and start a loop to iterate through the time slots.
        for (int i = 0; i < n; i++) {
            if (slot[i]) {
                System.out.println("Job " + result[i] + " with profit " + jobs[i].profit + " and deadline " + jobs[i].deadline);
                totalProfit += jobs[i].profit; //This line updates the total profit with the profit of the selected job
            }
        }

        System.out.println("Total Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of jobs: ");
        int n = scanner.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter job ID, deadline, and profit for job " + (i + 1) + ": ");
            char id = scanner.next().charAt(0);
            int deadline = scanner.nextInt();
            int profit = scanner.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        System.out.println("Job Sequence with Maximum Profit:");
        jobSequence(jobs, n);
        
        scanner.close();
    }
}


