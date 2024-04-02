import java.util.*;


class Solution {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        
        int words_len = words.length;
        Map<String, Integer> dict = new HashMap<>();
        
        String prev = words[0];
        dict.put(prev, 1);
        
        for(int i = 1; i < words_len; i++){
            
            String cur = words[i];
            
            if(dict.get(cur)!= null || prev.charAt(prev.length()-1) != cur.charAt(0)){
                int times = 0;
                int person = 0;
                
                if((i+1) % n==0){
                   times = (i+1)/n; 
                }else{
                    times = (i+1)/n + 1;
                }
                
                person = i % n + 1;
                answer[1] = times;
                answer[0] = person;
                break;
            }else{
                prev = cur;
                dict.put(cur, 1);
            }
        }
        
        
          
        return answer;
    }
}