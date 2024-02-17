import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int comp = p.length();
        
        for(int i = 0; i < t.length() - comp + 1; i++){
            if(Long.parseLong(t.substring(i, i + comp)) <= Long.parseLong(p)) answer++; 
        }
        
        
        return answer;
    }
}