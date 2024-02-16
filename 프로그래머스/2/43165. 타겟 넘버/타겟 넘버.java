class Solution {
    
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        subset(0, numbers.length, 0, numbers, target);
        return cnt;
    }
    
    static public void subset(int idx, int R, int sum, int[] numbers, int target){
        
        if(idx == R){
            if(sum == target) cnt++;
            return;
        }
        // 합함
        subset(idx + 1, R, sum + numbers[idx], numbers, target);
        // 뺌
        subset(idx + 1, R, sum - numbers[idx], numbers, target);
    }
    
}