import java.util.*;

class Solution {
    
    static HashMap<String, ArrayList<Integer>> hmap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        
        for(int i = 0; i < info.length; i++){
            Combi(info[i].split(" "), "", 0);
        }
        
        // 이분탐색을 위해 정렬
        for(ArrayList list : hmap.values()){
            Collections.sort(list);
        }
        
        int[] answer = new int[query.length];
        
        for(int i = 0; i < query.length; i++){
            answer[i] = BinarySearch(query[i]);
        }
        return answer;
    }
    
    public int BinarySearch(String query){
        String[] str = query.split(" and ");
        int score = Integer.parseInt(str[3].split(" ")[1]);
        
        String cur_query = str[0] + str[1] + str[2] + str[3].split(" ")[0];
        
        if(!hmap.containsKey(cur_query)) return 0;
        
        ArrayList<Integer> scores = hmap.get(cur_query);
        int start = 0;
        int end = scores.size();
        
        while(start < end){
            
            int mid = (start + end) / 2;
            
            if(scores.get(mid) >= score){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return scores.size() - start;
    }
    
    // 가능한 모든 문자열 조합
    public void Combi(String[] p_info, String str, int depth){
        
        if(depth == 4){
            int score = Integer.parseInt(p_info[depth]);
            //System.out.println("str : " + str);
            
            if(hmap.containsKey(str)){
                hmap.get(str).add(score);
            }else{
                ArrayList list = new ArrayList<>();
                list.add(score);
                hmap.put(str, list);
            }
            
            return;
        }
        Combi(p_info, str+"-", depth+1);
        Combi(p_info, str+p_info[depth], depth+1);
    }
}