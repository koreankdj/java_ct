import java.util.*;

class Solution {
    
    static int[] parents;
    
    public int solution(int n, int[][] wires) {

        int answer = n+1;
        
        for(int i = 0; i < n-1; i++){
            make(n);
            
            for(int j = 0; j < n-1; j++){
                if(j == i) continue;
                union(wires[j][0], wires[j][1]);
            }
            
            int temp = 0; 
            for(int j = 1;  j <= n; j++){
                if(find(parents[j]) == 1) temp++;
            }
            
            answer = Math.min(answer, Math.abs(temp - (n-temp)));
        }
        
        return answer;
    }
    
    static public void make(int n) {
        parents = new int[n+1];
        for(int i = 1; i <= n; i++){
            parents[i] = i;
        }
    }
    
    static public int find(int v){
        if(v == parents[v]) return v;
        
        return parents[v] = find(parents[v]);
    }
    
    static public void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot < bRoot){
            parents[bRoot] = aRoot;
        }else{
            parents[aRoot] = bRoot;
        }
    }
}