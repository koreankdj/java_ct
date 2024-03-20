import java.util.*;

class Solution {
    static int[] parents;
    public int solution(int n, int[][] wires) {
        
        int answer = 101;
        int idx = 0;
        parents = new int[n+1];
        
        while(idx < n-1){
            
            // 처음에 부모를 모두 본인으로 설정
            for(int i = 1; i < n+1; i++){
                parents[i] = i;
            }
            
            for(int i = 0; i < n-1; i++){
                if(idx == i) continue; // 이번에 끊을 전력망은 cnt 번째 전력망
                
                union(wires[i][0], wires[i][1]); // union
            }
            
            
            int temp = 0;
            for(int i = 1; i < n+1; i++){
                if(find(parents[i]) == 1) temp++;
            }
            answer = Math.min(answer, Math.abs(temp - (n - temp)));
            idx++;
            
        }
        
        return answer;
    }

    
   static int find(int v){
        if(parents[v] == v) return v;
        
        return parents[v] = find(parents[v]);
    }
    
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        
        if(aRoot < bRoot){
            parents[bRoot] = aRoot;
        }else{
            parents[aRoot] = bRoot;
        }
    }
}