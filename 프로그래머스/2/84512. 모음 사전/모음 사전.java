import java.util.*;

class Solution {
    
    static String[] arr;
    static List<String> strs = new ArrayList<>();

    public int solution(String word) {
        int answer = 0; 
        arr = new String[]{"A", "E", "I", "O", "U"};
        
        recur(0, "");
        
        for(int i = 0; i < strs.size(); i++){
            if(strs.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public void recur(int depth, String word){
         
        strs.add(word);
        
        if(depth == 5){
            return ;
        }
        
        for(int i = 0; i < 5; i++){
            recur(depth + 1, word + arr[i]);
        }

    }
    
    
}