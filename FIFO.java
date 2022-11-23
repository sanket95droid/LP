import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    static int pageFaults(int incomingStream[], int frames)
    {
        HashSet set = new HashSet<>(frames);
        Queue queue = new LinkedList<>();
        int n = incomingStream.length;
        
        int page_faults = 0;
        for(int i=0; i<n; i++)
        {
            if(set.size() < frames)
            {
                if(!set.contains(incomingStream[i]))
                {
                    set.add(incomingStream[i]);
                    page_faults++;
                
                    queue.add(incomingStream[i]);
                }
                
            }
            else
            {
                if(!set.contains(incomingStream[i]))
                {
                    int val = (int) queue.peek();
                    queue.poll();
                    
                    set.remove(val);
                    set.add(incomingStream[i]);
                    
                    queue.add(incomingStream[i]);
                    page_faults++;
                }
            }
            
            System.out.println(incomingStream[i] + "\t");
            System.out.println(queue + "\n");
        }
        return page_faults;
    }
    
    public static void main(String args[])
    {
        int incomingStream[] = {7, 0, 1, 2, 0 , 3, 0, 4, 2, 3, 0, 3, 2, 1};
        int frames = 3;
        int pageFaults = pageFaults(incomingStream, frames);
        int hit = incomingStream.length - pageFaults;
        
        System.out.println("Page faults: " + pageFaults);
        System.out.println("Page fault Ratio: " + (double) pageFaults/incomingStream.length);
        System.out.println("Hits: " + hit);
        System.out.println("Hit Ratio : " + (double) hit/incomingStream.length);
    }
}

