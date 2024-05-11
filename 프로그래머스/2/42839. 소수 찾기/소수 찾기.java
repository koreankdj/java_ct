import java.util.*;

class Solution {
    
    
    static int n, answer;
    static int[] nums;
    
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(String numbers) {
        
        n = numbers.length();
        nums = new int[n];
        
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }
        
        for(int i = 1; i <= n; i++){
            perm(0, i, numbers);
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        for(int i = 0; i < keys.size(); i++){
            
            int now = keys.get(i);
            //System.out.println("수 : " + now);
            
            if(check(now)) answer++;
        }
        
        return answer;
    }
    
    public static void perm(int depth, int target, String str){
        if(depth == target){
            String check = "";
            for(int i = 0; i < target; i++){
                check += str.charAt(nums[i]);
            }
            
            map.put(Integer.parseInt(check), 1);
            
            return;
        }
        
        for(int i = depth; i < n; i++){
            swap(i, depth);
            perm(depth + 1, target, str);
            swap(depth, i);
        }
    }
    
    public static void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    
    public static boolean check(int k){
        if(k == 0 || k == 1) return false;
        for(int i = 2; i <= Math.sqrt(k); i++){
            if(k%i == 0) return false;
        }
        return true;
    }
}