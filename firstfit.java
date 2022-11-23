import java.util.*;

public class Main{

    static void firstfit(int blockSize[], int blocks, int processSize[], int processes)
    {
        int allocated[] = new int[processes];

        for(int i=0; i<processes; i++)
        {
            allocated[i] = -1;
        }

        for(int i=0; i<processes; i++)
        {
            for(int j=0; j<blocks; j++)
            {
                if(blockSize[j] >= processSize[i])
                {
                    allocated[i] = j;
                    blockSize[j] -= processSize[i];
                    break;
                }
            }
        }

        System.out.println("\nProcessNo. \tProcess \tBlockNo.")
        for(int i=0; i<n; i++)
        {
            System.out.println(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");
            if(allocated[i] != -1)
            {
                System.out.println(allocated[i] + 1);
            }
            else
            {
                System.out.println("Not Allocated");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int blockSize[] = {100, 500, 200, 300, 600};
        int processSize[] = {212, 417, 112, 426};
        int blocks = blockSize.length;
        int processes = processSize.length;

        firstfit(blockSize, blocks, processSize, processes);
}