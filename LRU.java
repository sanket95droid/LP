import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> stack = new ArrayList<Integer>();
        
        int frames, pointer = 0, fault = 0, ref_len, hit= 0;
        Boolean isFull = false;
        
        System.out.println("Please enter the number of Frames: ");
		frames = sc.nextInt();
		System.out.println("Please enter the length of the Reference string:");
		ref_len = sc.nextInt();
		
		int reference[] = new int[ref_len];
		int mem_layout[][] = new int[ref_len][frames];
		int buffer[] = new int[frames];
		
		for(int j=0; j<frames; j++)
		{
		    buffer[j] = -1;
		}
		
		System.out.println("Please enter the reference string: ");
		for(int i = 0; i < ref_len; i++)
		{
			reference[i] = sc.nextInt();
		}
		
		System.out.println();
		for(int i=0; i<ref_len; i++)
		{
		    if(stack.contains(reference[i]))
		    {
		        stack.remove(stack.indexOf(reference[i]));
		    }
		    stack.add(reference[i]);
		    int search = -1;
		    for(int j=0; j<frames; j++)
		    {
		        if(buffer[j] == reference[i])
		        {
		            search = j;
		            hit++;
		            break;
		        }
		    }
		    if(search == -1)
		    {
		        if(isFull)
		        {
		            int min_loc = ref_len;
		            for(int j=0; j<frames; j++)
		            {
		                if(stack.contains(buffer[j]))
		                {
		                    int temp = stack.indexOf(buffer[j]);
		                    if(temp < min_loc)
		                    {
		                        min_loc = temp;
		                        pointer = j;
		                    }
		                }
		            }
		        }
		        buffer[pointer] = reference[i];
		        fault++;
		        pointer++;
		        if(pointer == frames)
		        {
		            pointer = 0;
		            isFull = true;
		        }
		    }
		    for(int j=0;  j<frames; j++)
		    {
		        mem_layout[i][j] = buffer[j];
		    }
		}
		for(int i = 0; i < frames; i++)
		{
			for(int j = 0; j < ref_len; j++)
			System.out.printf("%3d ",mem_layout[j][i]);
			System.out.println();
		}
		System.out.println("The number of Hits: " + hit);
		System.out.println("Hit Ratio: " + (float)((float)hit/ref_len));
		System.out.println("The number of Faults: " + fault);
    }
}