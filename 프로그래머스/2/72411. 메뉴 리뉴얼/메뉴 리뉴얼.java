import java.util.*;

/*
 1.최소 2가지 이상의 단품 메뉴로 코스요리를 구성.
 2.최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만 메뉴 후보에 포함 시키기.
 
 - orders 배열과 course 배열
*/

class Solution {
    
    static Map<String, Integer> hmap = new HashMap<>();
    static ArrayList<String> menulist = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // 1. 메뉴를 오름차순으로 정렬하기
        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        // 2. course 에 맞게 모든 경우의 조합을 HashMap에 넣기
        for(int c : course){
            for(String o: orders){
                Combi("", o, c);
            }
            

            // 3. HashMap에서 2번 이상 들어간 메뉴 고르기.
            if(!hmap.isEmpty()){
                
                List<Integer> values = new ArrayList<>(hmap.values());
                int m_value = Collections.max(values);
                
                // 4. 메뉴가 2번 이상 담겼을 때, 해당 메뉴를 list에 넣기.
                if(m_value > 1){
                    for(String k : hmap.keySet()){
                        if(hmap.get(k)==m_value) menulist.add(k);
                    }
                }
                hmap.clear();
            }
        }
        
        // 5. 정렬하기 -> 배열로 변환 후 return
        Collections.sort(menulist);
        int m_size = menulist.size();
        String[] answer = new String[m_size];
        for(int i = 0; i < m_size; i++){
            answer[i] = menulist.get(i);
        }
        
        return answer;
    }
    
    public static void Combi(String order, String others, int depth){
        
        // 기저 조건
        if(order.length() == depth){
           hmap.put(order, hmap.getOrDefault(order, 0) + 1);
           return;
        }
        
        for(int i = 0 ; i < others.length(); i++){
            Combi(order + others.charAt(i), others.substring(i+1), depth);
        }
        
    }
}