import java.util.*;
import java.io.*;

class Solution {
    
    static int[] numbers = {0, 1, 2, 3};
    static String[] words = {"aya", "ye", "woo", "ma"};
    static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[] babbling) {
        
        for(int i = 1; i <= 4; i++){
            perm(0, i);
        }
        
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++){
            if(map.get(babbling[i]) != null) answer++;
        }
        
        return answer;
    }
    
    static public void perm(int depth, int target){
        if(depth == target){
            String str = "";
            for(int i = 0; i < target; i++){
                str += words[numbers[i]];
            }
            //System.out.println(str);
            map.put(str, 1);
            return;
        }
        for(int i = depth; i < 4; i++){
            swap(i, depth);
            perm(depth + 1, target);
            swap(depth, i);
        }
    }
    
    static public void swap(int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
}