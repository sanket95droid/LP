import java.util.*;
import java.io.*;

public class Main{
    static boolean search(int key, int fr[])
    {
        for(int i=0; i<fr.length; i++)
        {
            if(fr[i] == key)
            {
                return true;
            }
        }
        return false;
    }
    
    public static int predict(int pages[], int fr[], int page_len, int index)
    {
        int res = -1, farthest = index;
        for(int i=0; i<fr.length; i++)
        {
            int j;
            for(j=index; j<page_len; j++)
            {
                if(fr[i] == pages[i])
                {
                    if(j > farthest)
                    {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }
            if(j == page_len)
            {
                return i;
            }
        }
        
        if(res == -1)
        {
            return 0;
        }
        else
        {
            return res;
        }
    }
    
    public static void optimalPage(int pages[], int page_len, int frames)
    {
        int fr[] = new int[frames];
        
        int hit=0;
        int index=0;
        for(int i=0; i<page_len; i++)
        {
            if(search(pages[i], fr))
            {
                hit++;
                continue;
            }
            
            if(index < frames)
            {
                fr[index++]= pages[i];
            }
            else
            {
                int replace = predict(pages, fr, page_len, i+1);
                fr[replace] = pages[i];
            }
        }
        System.out.println("faults: "+(page_len - hit));
        System.out.println("hits: "+hit);
    }
    
    public static void main(String args[]){
        int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        int page_len= pages.length;
        int frames= 4;
        
        optimalPage(pages, page_len, frames);
        
    }
}