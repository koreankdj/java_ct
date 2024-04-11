import java.util.*;

class Solution {
    static Map<String, ArrayList<String>> hmap = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int len = clothes.length;
        
        for(int i = 0; i < len; i++){
            String category = clothes[i][1];
            String cloth = clothes[i][0];
            
            if(hmap.containsKey(category)){
                hmap.get(category).add(cloth);
            }else{
                hmap.put(category, new ArrayList<String>());
                hmap.get(category).add(cloth);
            }
        }
        
        List<String> keyList = new ArrayList<>(hmap.keySet());
        int answer = 1;
        for(String key : keyList){
            answer *= (hmap.get(key).size() + 1);
        }
        
        return answer-1;
    }
}