import java.util.*;

/*

 1. 최소 필요 피로도, 소모 피로도
 2. 이 유저가 던전들을 최대한 많이 탐험하려 한다.
 3. 현재 피로도 k와, 던전별 최소 필요 피로도, 소모 피로도가 담긴 2차원 배열


 1. 완탐으로 다 찾기(순열).
 
*/

class Solution {
    
    static int[] arr;
    static int d_size, ans;
    
    public int solution(int k, int[][] dungeons) {
        
        d_size = dungeons.length;
        
        // 초기 세팅
        arr = new int[d_size];
        for(int i = 0; i < d_size; i++){
            arr[i] = i;
        }
        
        ans = Integer.MIN_VALUE;
        perm(0, k, dungeons);
        
        return ans;
    }
    
    public static void perm(int depth, int k, int[][] d){
        
        // 기저
        if(depth == d_size){
            int temp = 0;
            int cnt = 0;
            
            //System.out.println(Arrays.toString(arr));
            
            while(cnt < d_size && k > 0){
                
                int target = arr[cnt];
                
                if(k >= d[target][0]){
                    temp++;
                    k-=d[target][1];
                }
                
                cnt++;
            }
            
            ans = Math.max(ans, temp);
            
            return;
        }
        
        
        for(int i = depth; i < d_size; i++){
            swap(i, depth);
            perm(depth + 1, k, d);
            swap(depth, i);
        }
        
    }
    
    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}