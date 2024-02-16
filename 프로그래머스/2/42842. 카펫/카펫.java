import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        int sqr = (int) Math.sqrt(total);
        
        System.out.println(sqr);
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 3; i <= sqr; i++){
            if(total % i == 0){
                int mok = total / i;
                list.add(new int[]{mok, i});
            }
        }
        
        int[] answer = new int[2];
        for(int i = 0; i < list.size(); i++){
            int[] opt = new int[]{list.get(i)[0], list.get(i)[1]};
            
            if(brown == (opt[0] + opt[1]) * 2 - 4){
                answer = opt;
                break;
            }
        }
        
        
        return answer;
    }
}