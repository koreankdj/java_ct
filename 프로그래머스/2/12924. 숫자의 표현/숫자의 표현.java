class Solution {
    public int solution(int n) {
        int start = 1;
        int sum = 0;
        int ans = 0;
        
        for(int i = 0; i <= n; i++){
            sum += i;
            
            while(sum > n) {
                sum -= start++;
            }
            if(sum == n){
                ans++;
                //System.out.println("i : " + i);
            }
        }
        return ans;
    }
}