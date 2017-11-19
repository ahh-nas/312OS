
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class Scheduler {
	public static void RoundRobin(int processes[],int quantum, int n )
	{
	
		boolean RRdone= false;
	
		int count= 0;
		int burstTime[] = new int [n];
		int remainingBurstTime[]= new int [n];
		int arivalTime[] = new int[n];
	
		for(int i = 0; i<processes.length; i++)
		{
			int Ram =(int) (Math.random()*20+20);
			burstTime[i]= Ram;
			remainingBurstTime[i]= burstTime[i];
		}
		for(int i = 0; i<processes.length; i++)
		{
			int Ram =(int) (Math.random()*n+0);
			arivalTime[i]= Ram;
			System.out.println("Arrival Time:" + arivalTime[i]);
		}
		
		int[] sortedIndices = IntStream.range(0, arivalTime.length)
                .boxed().sorted((i, j) ->  (arivalTime[i]) -(arivalTime[j]) )
                .mapToInt(ele -> ele).toArray();
		for(int i = 0; i<processes.length; i++)
			System.out.println( sortedIndices[i]);
		
				//t=sortedIndices[0];
		//quickSort(arivalTime);
		 Set<Integer> uniqueList = new HashSet<Integer>();//This is the set which is used to make sure elements in the array are printed only once
	        for( count=0;count<processes.length;count++){
	            uniqueList.add(count);
	        }
	       
		do
		{
			
			for(int t = 0 ; t<processes.length; t++ )
			{
				
		
				if (remainingBurstTime[t] != 0) 
		        {
		        	RRdone= false;
		        }	
				
			 if(remainingBurstTime[t] > quantum)
			 {
				 remainingBurstTime[t] -= quantum;
				 System.out.println("P"+ sortedIndices[t]);
			 }
			 
			 if(remainingBurstTime[t] <= quantum && uniqueList.contains(t))
			 {
				 remainingBurstTime[t]-= remainingBurstTime[t];

			     
			        		
		                uniqueList.remove(t);
		                
		                System.out.println("Process finished P: "+ sortedIndices[t] );
		                
			 }
			
			
			
			
				}
		 
			RRdone = RRSched(remainingBurstTime);
			
		}while(RRdone !=true);
	}

	public static boolean RRSched(int[] RRdone){
        for(int j=1; j<RRdone.length; j++){
            if(RRdone[0] != RRdone[j]){
                return false;
            }
        }

        return true;
    }
	public static int[] quickSort(int[] arrivalTime)
	{
	 int i, j;
	 int  tempArray[]= new int [arrivalTime.length];
	 for(i = 0;i<arrivalTime.length;i++)
	 {
		 tempArray[arrivalTime[i]]=i;
	 }
	 for(i = 0;i<arrivalTime.length;i++)
	 System.out.println("Process " + arrivalTime[tempArray[i]]+ " Has arrival time " +tempArray[i]);
	  
return tempArray;
      

	}

	public static void main(String[] args) throws IOException 
	{
 
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
				
		
		
		



