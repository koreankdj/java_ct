import java.util.*;

class Solution {
    
    
    public int solution(int k, int[] tangerine) {
		int answer = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		// Map 에 귤의 크기별 개수 담기
		for(int i : tangerine) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		// 귤의 크기 리스트 생성
		List<Integer> keyList = new ArrayList<>(map.keySet());
		keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));
		
		for(Integer i : keyList) {
			if(k <= 0) break;
			
			answer++;
			k -= map.get(i);
		}
		
		
		return answer;
    }
}