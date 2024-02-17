import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int words_len = words.length;
        
        ArrayList<String>[] alps = new ArrayList[26];
        
        for(int i = 0; i < 26; i++){
            alps[i] = new ArrayList<String>();
        }
        
        alps[words[0].charAt(0) - 'a'].add(words[0]);
        
        for(int i = 1; i < words_len; i++){
            
            // 이전 마지막 글자랑 다음 마지막 글자가 다른 경우
            if(words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)){
                answer[0] = (i) % n + 1;
                answer[1] = (i) / n + 1;
                break;
            }
            
            // 등장했던 단어가 또 나오는 경우
            if(alps[words[i].charAt(0) - 'a'].contains(words[i])){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }else{
                alps[words[i].charAt(0) - 'a'].add(words[i]);
            }
            
        }

        return answer;
    }
}