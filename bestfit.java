import java.util.*;

public class Main{
    static void bestfit(int blockSize[], int blocks, int processSize[], int processes)
    {
        int allocated[] = new int[processes];
        
        for(int i=0; i<processes; i++)
        {
            allocated[i] = -1;
        }
        
        for(int i=0; i<processes; i++)
        {
            int bestidx = -1;
            for(int j=0; j<blocks; j++)
            {
                if(blockSize[j] >= processSize[i])
                {
                    if(bestidx == -1)
                    {
                        bestidx = j;
                    }
                    else if(blockSize[bestidx] > blockSize[j])
                    {
                        bestidx = j;
                    }
                }
            }
            if(bestidx != -1)
            {
                allocated[i] = bestidx;
                blockSize[bestidx] -= processSize[i];
            }
        }
        
        System.out.println("\n ProcessNo. \tProcess \tBlockNo.");
        for(int i=0; i<processes; i++)
        {
            System.out.print(" " +(i+1) + "\t\t" + processSize[i] + "\t\t");
            if(allocated[i] != -1)
            {
                System.out.print(allocated[i] +1);
            }
            else
            {
                System.out.print("Not Allocated");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[])
    {
        int blockSize[] = {100, 500, 200, 300, 600};
        int processSize[] = {212, 417, 112, 426};
        int m = blockSize.length;
        int n = processSize.length;
        
        bestfit(blockSize, m, processSize, n);
    }
}