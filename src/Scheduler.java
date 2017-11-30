
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;


public class Scheduler {
	static Clock clock = new Clock();
	static int numberOfprograms = 0;
	public static void RoundRobin(int processes[],int quantum, int n ) throws IOException
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

	public static void jobHandle() throws IOException
	{
		ArrayList<Process> obj = new ArrayList<Process>();
		boolean rightInput = false;
		Scanner userInput = new Scanner(System.in);
		while(rightInput == false)
		{
		System.out.println("Enter number of programs you would like to load: ");
		if(userInput.hasNextInt())
		{
		numberOfprograms = userInput.nextInt();
		rightInput = true;
		}
		else
			System.out.println("Wrong input");
		}
		userInput.nextLine();
		for(int i = 0; i< numberOfprograms; i++)
		{
			System.out.println("Enter Program you would like to load: ");
			//Process newProc = new Process(100,paint,a)
			//obj.add(newProc);
		}
		System.out.println(Arrays.toString(obj.toArray()));
		Scanner nextInput = new Scanner(System.in);
		String input = nextInput.nextLine();
		
		String filePath = "C:/Users/Test/git/312OS/"+Process.getName() +".txt";
		Path myPAth = Paths.get(filePath);
		String strings = Files.lines(myPAth).findFirst().get();
		String state = OS.state(input, "New",strings);
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = br.readLine();
		int test;
		clock.getClock();
		while (!line.trim().isEmpty() )
		{
			//System.out.println(line);
			//if (line.trim().isEmpty())
				//return;
			//if(!line.isEmpty())
			//{
			line = br.readLine();
			String command[]=line.split(" ",2);
			if (command[0].equals("CALCULATE")) {
				String numberOfCycles;
				numberOfCycles = command[1];
				test = Integer.parseInt(numberOfCycles);
				clock.restartClock();
				while(test != 0)
				{
					//System.out.println("Calculate " + test);
					test--;
					clock.advancedClock();
				}
				System.out.println("CALCULATED " + clock.getClock());
				
            }
			//}
			 
            else if(command[0].equals("YIELD"))
            {
            		System.out.println("YIELDING");
            }
			 
            else if(command[0].equals("IO"))
            {
            	
            	clock.restartClock();
            	int cycle = OS.operationCycle();
            	System.out.println("BLOCKED");
            	while(cycle !=0)
            	{
            		clock.advancedClock();
            		cycle--;
            	}
            	System.out.println("How long the I/O burst lasted for: "+ clock.getClock());
            }
			 
            else if(command[0].equals("OUT"))
            {
            	
            		System.out.println(command[1]);
            
            }
			if(line.trim().isEmpty())
				OS.state(input, "EXIT",strings);
			
		}
			
	
		
		br.close();
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
				
		
		
		



