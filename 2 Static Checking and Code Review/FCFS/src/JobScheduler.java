/* 
 * Index Mapping is as follows...
 * 		0 :  Arrival Time 		(AT)
 *      1 :  CPU Burst Time 	(CBT)
 *      2 :  Waiting Time 		(WT)
 *      3 :  Completion Time 	(CT)
 *      4 :  Turn Around Time 	(TT) 
 * */

public class JobScheduler {
	private int[][] jobs;
	private int n;
	
	public JobScheduler(int n, int[][] input) {		// n: number of processes
		this.n = n;
		jobs = new int[n][5];
		
		for (int i=0; i<n; i++) {					// Filling the AT and CBT received as input to jobs
			jobs[i][0] = input[i][0];
			jobs[i][1] = input[i][1];
		}
		
		// Calculating the results...
		waitingTime();
		completionTime();
		turnAroundTime();
	}
	
	// WT: Time for which the process waited inside CPU
	public void waitingTime() {
		jobs[0][2] = 0;								// Waiting time of first process will be 0
		for (int i=1; i<n; i++) {
			// WT = WT(previous process) + CBT(previous process) + AT(previous process) - AT(current process)
			jobs[i][2] = jobs[i-1][2] + jobs[i-1][1] + jobs[i-1][0] - jobs[i][0];
			if (jobs[i][2] < 0) 
				jobs[i][2] = 0;
		}
	}
	
	// CT: Timestamp at which the process completed its execution
	public void completionTime() {
		for (int i=0; i<n; i++) {
			// CT = AT + CBT + WT
			jobs[i][3] = jobs[i][0] + jobs[i][1] + jobs[i][2];
		}
	}
	
	// TT: Total time spent by process inside CPU
	public void turnAroundTime() {
		for (int i=0; i<n; i++) {
			// TT = CT - AT
			jobs[i][4] = jobs[i][3] - jobs[i][0];
		}
	}
	
	public double getAvgWT() {
		int totalWT = 0;
		for (int i=0; i<n; i++) {
			totalWT += jobs[i][2];
		}
		return totalWT / (double)n;
	}
	
	public int getMaxWT() {
		int maxWT = jobs[0][2];
		for (int i=0; i<n; i++) {
			if (jobs[i][2] > maxWT)
				maxWT = jobs[i][2];
		}
		return maxWT;
	}
	
	public int[][] getResults() {
		return jobs;
	}
}
