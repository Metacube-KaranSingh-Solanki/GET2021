import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		System.out.println("Enter number of processes: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] input = new int[n][2];
		System.out.println("Enter the values...");
		for (int i=0; i<n; i++) {
			System.out.printf("AT of P%d: ", i+1);
			input[i][0] = sc.nextInt();
			System.out.printf("CBT of P%d: ", i+1);
			input[i][1] = sc.nextInt();
		}
		
		JobScheduler jobScheduler = new JobScheduler(n, input);
		
		int[][] results = new int[n][];
		results = jobScheduler.getResults();

		System.out.println("---------------------------------");
		System.out.println("FCFC Scheduled Table is as follows...");
		display(results);
		System.out.println("\nMaximum Waiting Time: " + jobScheduler.getMaxWT() + " ms");
		System.out.println("Average Waiting Time: " + jobScheduler.getAvgWT() + " ms");
		
	}
	
	public static void display(int[][] jobs) {
		System.out.printf("%-6s%-6s%-6s%-6s%-6s", "AT", "ET", "WT", "CT", "TT");
		System.out.println();
		for (int[] i: jobs) {
			for (int j: i) {
				System.out.printf("%-6d", j);
			}
			System.out.println();
		}
	}
}
