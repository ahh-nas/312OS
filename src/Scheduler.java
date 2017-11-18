import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Random;

public class Scheduler {
	public static void RoundRobin(int processes[],int quantum, int n)
	{
		boolean RRdone= false;
		
		int count= 0;
		int burstTime[] = new int [n];
		int remainingBurstTime[]= new int [n];
		ArrayList<String> usedNumbers = new ArrayList<String>();
		for(int i = 0; i<processes.length; i++)
		{
			int Ram =(int) (Math.random()*20+20);
			burstTime[i]= Ram;
			remainingBurstTime[i]= burstTime[i];
		}
		 Set<Integer> uniqueList = new HashSet<Integer>();//This is the set which is used to make sure elements in the array are printed only once
	        for( count=0;count<processes.length;count++){
	            uniqueList.add(count);
	        }
		do
		{
			
			for(int i = 0; i<processes.length; i++)
			{
				if (remainingBurstTime[i] != 0) 
		        {
		        	RRdone= false;
		        }	
				
			 if(remainingBurstTime[i] > quantum)
			 {
				 remainingBurstTime[i] -= quantum;
				 System.out.println("P"+i);
			 }
			 
			 if(remainingBurstTime[i] <= quantum && uniqueList.contains(i))
			 {
				 remainingBurstTime[i]-= remainingBurstTime[i];

			       // while(!uniqueList.isEmpty()){
			        	//if(uniqueList.contains(i)){
			        		
		                uniqueList.remove(i);
		                System.out.println("Process finished P: "+ i);
		                
			        	//}
			        //}
			 }
			
			
			
			 if(i  >= processes.length)
			 {
				 i=0;
			 }
			
		 }
			RRdone = RRSched(remainingBurstTime);
			
		}while(RRdone !=true);
	}

	public static boolean RRSched(int[] RRdone){
        for(int i=1; i<RRdone.length; i++){
            if(RRdone[0] != RRdone[i]){
                return false;
            }
        }

        return true;
    }

	



	public static void FirstComeFistServe(int proceses[]) throws IOException
	{
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		//System.out.println("Enter the number of processes:");
		//int n = Integer.parseInt(br.readLine());
		
		int bursttime[]= new int[proceses.length];
		for(int i= 0;i<proceses.length;i++)
		{
		Random num = new Random();
		int a = num.nextInt(50)+1;
		bursttime[i]=a;
		}
		
		
		int arrivaltime[]=new int[proceses.length];
		for(int i=0;i<proceses.length;i++)
		{
		System.out.println("Enter the arrival time for process: "+(i+1));
		arrivaltime[i]=Integer.parseInt(br.readLine());
		}
		int waittime[]= new int[proceses.length];
		waittime[0]=0;
		for(int i=1;i<proceses.length;i++)
		{
			waittime[i] = waittime[i-1] + bursttime[i-1];
			waittime[i] = waittime[i] - arrivaltime[i];
		}
		
		int completiontime[]=new int[proceses.length];
		int averagewaittime=0;
		for(int i=0;i<proceses.length;i++)
		{
		completiontime[i] = waittime[i] + bursttime[i];
		averagewaittime = averagewaittime + waittime[i];
		}
		
			for(int i=0;i<proceses.length;i++) 
			{
				System.out.println("Process: "+(i+1));
				System.out.println("BurstTime: "+bursttime[i]);
				System.out.println("WaitTime: "+waittime[i]);
				System.out.println("");
			}
		
	}
}
//TODO figure out what's wrong with my code then implement switch
				
		
		
		



