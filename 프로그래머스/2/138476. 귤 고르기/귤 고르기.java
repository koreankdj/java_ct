import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        
        Map<Integer, Integer> hmap = new HashMap<>();
        int len = tangerine.length;
        
        for(int i = 0; i < len; i++){
            hmap.put(tangerine[i], hmap.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> values = new ArrayList<>(hmap.values());
        Collections.sort(values);
        Collections.reverse(values);
        
        for(int i = 0; i < values.size(); i++){
            
            //System.out.println(values.get(i));
            k -= values.get(i);
            if(k > 0) answer++;
            else{
                break;
            }
        }
        
        return answer;
    }
}