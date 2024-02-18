class Solution {
    
    static boolean[] visited;
    static int depth;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        depth = computers.length;
        
        visited = new boolean[depth];
        
        for(int i = 0; i < depth; i++){
            if(!visited[i]){
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int cur, int[][] arr){
        visited[cur] = true;
        
        for(int i = 0; i < depth; i++){
            if(!visited[i] && arr[cur][i] == 1){
                dfs(i, arr);
            }
        }
    }
}