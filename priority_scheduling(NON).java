import java.util.Scanner;

public class Main {
        
    public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    
    System.out.print("Enter the number of Process : ");
    int n = s.nextInt();

    int pid[] = new int[n];
    int pp[] = new int[n];
    int bt[] = new int[n];
    int wt[] = new int[n];
    int ta[] = new int[n];
 
    
   for(int i=0;i<n;i++)
    {
      System.out.print("Enter the process "+(i+1)+" burst time: ");
      bt[i] = s.nextInt();
      System.out.print("Enter the process "+(i+1)+" priority: ");
      pp[i] = s.nextInt();
      pid[i]=i+1;
    }
 
 int temp, avgta = 0, avgwt = 0;
//sorting on the basis of priority
  for(int i=0;i<n-1;i++)
   {
     for(int j=i+1;j<n;j++)
     {
       if(pp[i]<pp[j])
       {
            temp = pp[i];
            pp[i] = pp[j];
            pp[j] = temp;
            
            temp = bt[i];
            bt[i] = bt[j];
            bt[j] = temp;
            
            temp = pid[i];
            pid[i] = pid[j];
            pid[j] = temp;
        }
     }
   }
    

    wt[0]=0;
    avgwt=0;
    ta[0]=bt[0];
    avgta=ta[0];
    
    for(int i =1; i<n; i++)
    {
        wt[i] = ta[i-1];
        ta[i] = bt[i] + wt[i];
        
        avgwt += wt[i];
        avgta += ta[i];
    }

  System.out.print("Process Burst Wait Turn_Around Priority \n");
for(int i=0;i<n;i++)
  System.out.println(pid[i] + "\t" + bt[i]  + "\t" + wt[i]  + "\t" +  ta[i]  + "\t" + pp[i]);
avgwt/=n;
avgta/=n;
  System.out.print("\n Average Wait Time : "+(double)avgwt/n);
  System.out.print("\n Average Turn Around Time : "+(double)avgta/n);
 
        }
}
