import java.util.*;
/*
    1. 길이가 1인 모든 단어를 포함하도록 사전 초기화
    2. w 찾기
    3. w에 해당하는 색인 번호 출력, w 제거
    4. 남은 글자 c. w+c에 해당하는 단어 사전에 등록

*/


class Solution {
    public int[] solution(String msg) {

        List<Integer> ans_list = new ArrayList<>();
        
        //msg = "KAKAO";
        
        // 1. 길이가 1인 모든 단어를 포함하도록 사전 초기화
        Map<String, Integer> dict = new HashMap<>();
        for(int i = 0; i <= 25; i++){
            dict.put(String.valueOf((char) ('A' + i)), i + 1);  
        }
        
        while(msg.length()>0){
            
            // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
            char[] arr = msg.toCharArray();
            String w = "" + arr[0]; 
            String input_w = "";
            
            boolean flag = true;
            
            if(arr.length > 1){
                for(int i = 1; i <= arr.length; i++){
                    if(dict.get(w) == null) {
                        //System.out.println("다음 사전에 들어갈 단어 : " + w);
                        flag = false;
                        break;
                    }
                    if(i < arr.length) w += arr[i];
                } 
                
                
                if(flag){
                    input_w = w;
                }else{
                    input_w = w.substring(0, w.length() - 1);  // 가장 긴 문자열      
                }
                
                //input_w = w.substring(0, w.length() - 1);  // 가장 긴 문자열
                
            }else{
                input_w = w;
            }
            
            //System.out.println("가장 긴 문자열 : " + input_w);
            
            // 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
            ans_list.add(dict.get(input_w));    // 정답 리스트에 추가
            msg = msg.substring(input_w.length());
            
            // 4. 입력에서 처리되지 않은 다음 글자가 남아있따면, w+c에 해당하는 단어를 사전에 등록.

            dict.put(w, dict.size() + 1);

            
            //System.out.println("남은 문자열 : " + msg);
        }
        
        int[] answer = new int[ans_list.size()];
        for(int i = 0; i < ans_list.size(); i++){
            answer[i] = ans_list.get(i);
        }
        
        return answer;
    }
}