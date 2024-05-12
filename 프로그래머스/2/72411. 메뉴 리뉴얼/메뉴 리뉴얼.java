import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<String> answerList = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // 1. orders 메뉴 정렬
        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        // 2. course에 맞게 조합 뽑기
        for(int c : course){
            for(String o : orders){
                Combi("", o, c);
            }
            
            // 3. 길이 별로 max값 뽑기
            if(!map.isEmpty()){
                List<Integer> countList = new ArrayList<>(map.values());
                int m_value = Collections.max(countList);
                
                // 2번 이상 주문됐다면,
                if(m_value > 1){
                    for(String k : map.keySet()){
                        if(map.get(k) == m_value){
                            answerList.add(k);
                        }
                    }
                }
            }
            map.clear();
        }
        
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public void Combi(String order, String others, int depth){
        if(order.length() == depth){
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        
        for(int i = 0; i < others.length(); i++){
            Combi(order + others.charAt(i), others.substring(i+1), depth);
        }
    }
}