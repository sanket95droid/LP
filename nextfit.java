import java.util.*;

public class Main{
    static void nextfit(int blockSize[], int blocks, int processSize[], int processes)
    {
        int allocated[] = new int[processes];
        for(int i=0; i<processes; i++)
        {
            allocated[i] = -1;
        }
        
        int j = 0;
        for(int i=0; i<processes; i++)
        {
            int count = 0;
            while(j<blocks)
            {
                count++;
                if(blockSize[j] >= processSize[i])
                {
                    allocated[i] = j;
                    blockSize[j] -= processSize[i];
                    break;
                }
                j = (j+1)%blocks;
            }
        }
        System.out.println("\nProcessNo. \tProcess \tBlockNo.");
        for(int i=0; i<processes; i++)
        {
            System.out.print((i+1) + "\t\t" + processSize[i] + "\t\t");
            if(allocated[i] != -1)
            {
                System.out.print(allocated[i] + 1);
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

        nextfit(blockSize, m, processSize, n);
    }
}