class Solution {
    public int solution(int n) {

        int num = translate(n);
        int answer = 0;
        
        while(true){
            if(translate(++n) == num) break;
        }
        
        return n;
    }
    
    static public int translate(int n){
        int ans = 0;
            
        while(n > 0){
            int k = n % 2;
            if(k==1) ans++;
            n /= 2;
        }
        
        return ans;
    }
}