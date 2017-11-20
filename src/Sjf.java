import java.util.*;
public class Sjf {
public static void main(String args[])
{
	int process[] = new int[5]; //process array
	int burstTime[] = new int[5]; //burst time array
	int waitTime[] = new int[5]; //waiting time or tracker array
	int arrivalTime[] =  new int [5];
	int temporary, x, total=0; //initializes the int we will use as index
	
	Scanner scan = new Scanner(System.in); // user input
	
	System.out.println("Enter number of processes:"); 
	x = scan.nextInt();
	
	for(int i=0; i<x; i++) // gets the process ID and burst time
	{
		System.out.println("Enter Process " + (i+1) + " Name");
		process[i] = scan.nextInt();
		System.out.println("Enter Process " + (i+1) + " Burst Time");
		burstTime[i] = scan.nextInt();
		System.out.println("Enter Process " + (i+1) + " Arrival Time");
		arrivalTime[i] = scan.nextInt();
	}
	
	for(int i=0; i<x; i++)
	{
		for(int j=i+1; j<x; j++)	
		{ if(burstTime[i] > burstTime[j])
		{
			temporary = burstTime[i];
			burstTime[i] = burstTime[j];
			burstTime[j] = temporary;
			temporary = process[i];
			process[i] = process[j];
			process[j] = temporary;
		}
	}
		for(int t=0; t<x; t++)
		{
			for(int j=i+1; j<x; j++)
			{
				if(arrivalTime[i] > arrivalTime[j])
				{
					temporary = arrivalTime[i];
					arrivalTime[i] = arrivalTime[j];
					arrivalTime[j] = temporary;
					temporary = process[i];
					process[i] = process[j];
					process[j] = temporary;
					
				}
			}
		}
	
}
	waitTime[0] = 0;
	arrivalTime[0] = 0;
	for(int i=1; i<x; i++)
	{
		
		waitTime[i] = waitTime[i-1] + burstTime[i-1];
		total = total + waitTime[i];
	}
	for(int i=0; i<x; i++)
	{
		if(arrivalTime[i] < x)
		{
			arrivalTime[i] = arrivalTime[i];
		}
		arrivalTime[i] = arrivalTime[i];
	}
	
	for(int i=0; i<x; i++)
	{
		System.out.println(process[i] +"\t"+burstTime[i]+"\t"+arrivalTime[i] + "\t" + waitTime[i]); // sorts process times in table format

	}
}
}
