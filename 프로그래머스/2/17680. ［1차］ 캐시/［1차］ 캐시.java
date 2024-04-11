import java.util.*;

class Solution {
    static LinkedList<String> queue;
    
    public int solution(int cacheSize, String[] cities) {
        
        queue = new LinkedList<String>();
        int len = cities.length;
        
        int time = 0;
        
        for(int i = 0; i < len; i++){
            String city = cities[i].toLowerCase();
            if(queue.indexOf(city) != -1){  
                time += 1;
                int idx = queue.indexOf(city);
                queue.remove(idx);
                queue.addLast(city);
            }else{
                if(queue.size() != 0 && queue.size() == cacheSize){
                    queue.removeFirst();                 
                }
                if(cacheSize != 0) queue.addLast(city);    
                
                time += 5;
            }
        }
        
        return time;
        
    }
}