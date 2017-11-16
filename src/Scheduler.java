import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

	public static void main(String[] args) throws IOException 
	{
System.out.println("hello world");
	}
}
