
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;
import javax.swing.*;
import java.util.*;

public class Scheduler {
	public static void RoundRobin(int processes[],int quantum, int n ) throws IOException
	{
		String filePath = "C:/Users/moussazs/Desktop/Paint.txt";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = br.readLine();
		int test;
		while (line != null)
		{
			//System.out.println(line);
			line = br.readLine();
			String command[]=line.split(" ",2);
			if (command[0].equals("CALCULATE")) {
				String numberOfCycles;
				numberOfCycles = command[1];
				test = Integer.parseInt(numberOfCycles);
				while(test != 0)
				{
					test--;
				}
				System.out.println(numberOfCycles);
            }
			 
            else if(command[0].equals("YIELD"))
            {
            		System.out.println("YIELDING");
            }
			 
            else if(command[0].equals("IO"))
            {
            		System.out.println("BLOCKED");
            }
			 
            else if(command[0].equals("OUT"))
            {
            	
            		System.out.println(command[1]);
            
            }
			 
  
		}

		br.close();
	
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
				
			 if(remainingBurstTime[sortedIndices[t]] > quantum)
			 {
				 remainingBurstTime[sortedIndices[t]] -= quantum;
				 System.out.println("P"+ sortedIndices[t]);
			 }
			 
			 if(remainingBurstTime[sortedIndices[t]] <= quantum && uniqueList.contains(t))
			 {
				 remainingBurstTime[sortedIndices[t]]-= remainingBurstTime[sortedIndices[t]];

			     
			        		
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
			public static void sjf(int proceses[]) throws IOException
			{
				int process[] = new int[proceses.length]; //process array
				int burstTime[] = new int[proceses.length]; //burst time array
				int waitTime[] = new int[proceses.length]; //waiting time or tracker array
				int arrivalTime[] =  new int [proceses.length];
				int temporary, x, total=0; //initializes the int we will use as index
				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(input);
				//Scanner scan = new Scanner(System.in); // user input
				//System.out.println("Enter number of processes:"); 
				x = proceses.length;
				
				for(int i=0; i<x; i++) // gets the process ID and burst time
				{
					//System.out.println("Enter Process " + (i+1) + " Name"); dont need name
					//process[i] = scan.nextInt();
					//System.out.println("Enter Process " + (i+1) + " Burst Time"); should be random
					Random num = new Random();
					int a = num.nextInt(50)+1;
					burstTime[i]=a;
					System.out.println("Enter the arrival time: ");
					arrivalTime[i]=Integer.parseInt(br.readLine());
					//burstTime[i] = scan.nextInt();
					//System.out.println("Enter Process " + (i+1) + " Arrival Time");
					//arrivalTime[i] = scan.nextInt();
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

//TODO figure out arrival time
				
		
		
		



