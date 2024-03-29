import java.util.*;

class Solution {
    
    static long answer = Long.MAX_VALUE;
    
    public long solution(int n, int[] times) {
        
        // 시간 배열 정렬
        Arrays.sort(times);
        
        binarySearch(n, times);
        
        return answer;
    }
    
    static public void binarySearch(int n, int[] times){
        long left = times[0];
        long right = (long) n*times[times.length-1];
        
        while(left <= right){
            long mid = (left+right) / 2;
         
            long cntPerson = 0;
            for(int time : times){
                cntPerson += mid/time;
            }
            
            // 심사를 다 받았다. 시간을 더 줄여도 될 듯
            if(cntPerson >= n){
                right = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                left = mid + 1;
            }
        }
        
    }
}