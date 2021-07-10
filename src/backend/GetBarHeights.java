package backend;
import java.util.Map;
import java.util.TreeMap;

public class GetBarHeights<T extends Comparable<T>> {
    
    public Integer[] get(T[] list)
    {
        Integer[] barHeights = new Integer[list.length];

        TreeMap<T, Integer> map = new TreeMap<>();

        for(int i = 0; i < list.length; ++i)
            map.put(list[i], i);
        
        int c = 10;
        for(Map.Entry<T, Integer> m : map.entrySet())
        {
            barHeights[m.getValue()] = c;
            c += 3;
        }

        for(int i = 0; i < barHeights.length; ++i)//for duplicates
        {
            if(barHeights[i] == null)
            {
                int temp = map.get(list[i]);
                barHeights[i] = barHeights[temp];
            }
        }
        
        return barHeights;
            
    }

}
