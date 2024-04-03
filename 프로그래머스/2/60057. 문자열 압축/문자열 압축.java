import java.util.*;

class Solution {
    public int solution(String s) {
        //s = "abccd";
        int len = s.length();
        int ans = len;

        
        // 자를 길이
        for(int l = 1; l <= len/2; l++){
            String str1 = "";
            String temp = s.substring(0, l);
            int cnt = 1;
            
            // 시작할 인덱스
            for(int i = l; i <= len; i+=l){
                int endIdx = Math.min(i+l, len);
                
                String comp = s.substring(i, endIdx);

                if(temp.equals(comp)){      // 만약 같다면,
                    cnt++;
                }else{                      // 같지 않다면
                    if(cnt > 1){
                        str1 += String.valueOf(cnt);
                    }
                    str1 += temp;
                    temp = comp;
                    cnt = 1;
                }   
            }
            str1 += temp;
            ans = Math.min(ans, str1.length());
            
        }

        return ans;
    }
}