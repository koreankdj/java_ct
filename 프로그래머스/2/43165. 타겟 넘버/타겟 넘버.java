import java.util.*;

class Solution {
    
    static int answer, len;
    
    public int solution(int[] numbers, int target) {
        
        
        answer = 0;
        len = numbers.length;
        
        subset(numbers, 0, 0, target);
        
        return answer;
    }
    
    static public void subset(int[] arr, int depth, int value, int target){
        if(depth == len){
            if(value == target){
                answer++;
            }
            return;
        }
        
        // 더해줌
        subset(arr, depth+1, value+arr[depth], target);
        // 빼줌
        subset(arr, depth+1, value-arr[depth], target);
    }
}