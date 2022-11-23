import java.util.*;

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of processes: ");
        int n = sc.nextInt();
        
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];
        
        int tot = 0, st = 0;
        for(int i=0; i<n; i++)
        {
            System.out.println("Enter the at: ");
            at[i] = sc.nextInt();
            System.out.println("Enter the bt: ");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
            f[i] = 0;
        }
        int avgta=0, avgwt=0;
        while(true)
        {
            int c=n, min=999;
            if(tot==n)
            {
                break;
            }
            
            for(int i=0; i<n; i++)
            {
                if((at[i]<=st) && (f[i]==0) && (bt[i] < min))
                {
                    if(bt[i] == min)
                    {
                        if(at[i] < at[c])
                        {
                            min = bt[i];
                            c = i;
                        }
                    }
                    else
                    {
                        min = bt[i];
                        c = i;
                    }
                }
            }
            if(c==n)
            {
                st++;
            }
            else
            {
                ct[c] = bt[c] + st;
                st+=bt[c];
                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                f[c] = 1;
                tot++;
            }
        }
        System.out.println("\npid  arrival brust  complete turn waiting");
    for (int i = 0; i < n; i++) {
      avgwt += wt[i];
      avgta += ta[i];
      System.out.println(
        pid[i] +
        "\t" +
        at[i] +
        "\t" +
        bt[i] +
        "\t" +
        ct[i] +
        "\t" +
        ta[i] +
        "\t" +
        wt[i]
      );
    }
    System.out.println("\naverage tat is " + (float) (avgta / n));
    System.out.println("average wt is " + (float) (avgwt / n));
    sc.close();
        
    }
}