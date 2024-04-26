import java.util.*;
import java.io.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        
        // map에 넣는 과정
        for(int i = 0; i < len; i++){
            map.put(phone_book[i], 1);
        }
        
        // map에 있는 단어가 접두사인지 확인하는 과정
        for(int i = 0; i < len; i++){
            char[] target = phone_book[i].toCharArray();
            String check = "";
            
            for(int j = 0; j < target.length-1; j++){
                check+=target[j];
                if(map.get(check) != null) return false;
            }
        }
        
        return true;
    }
}