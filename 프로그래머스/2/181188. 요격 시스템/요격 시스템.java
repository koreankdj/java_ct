import java.util.*;

class Solution {
    public int solution(int[][] targets) {
Arrays.sort(targets, (x, y) -> x[0]- y[0]);

		int answer = 0;
		
		int pre_start = targets[0][0];
		int pre_end = targets[0][1];
		
		for(int[] target : targets) {
			if(answer == 0) {
				// 첫 타겟이 들어왔을 때
				answer++;
				continue;
			}
				
			int cur_start = target[0];
			int cur_end = target[1];
			
			if(pre_start <= cur_start && cur_start < pre_end) {
				pre_start = Math.max(pre_start, cur_start);
				pre_end = Math.min(pre_end, cur_end);
			}else {
				pre_start = cur_start;
				pre_end = cur_end;
				answer++;
			}
			
		}
		
		return answer;
    }
}