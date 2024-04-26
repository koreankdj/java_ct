import java.util.*;
import java.io.*;

class Solution {
    
    /*
        1. 아이디의 길이는 3자 이상 15자 이하
        2. 아이디는 알파벳 소문자, 숫자, -, _, .
        3. .는 처음과 끝에 사용할 수 없으며 연속으로 사용할 수 없다.
        
        
        1. 모두 소문자로 치환
        2. (2)에 해당하는 조건 수행
        3. 마침표 2번 이상 ~ 하나로 치환
        4. 마침표 처음이나 끝이면 제거
        5. 빈 문자열이면 "a" 대입
        6. 16자 이상이면, 첫 15를 제외한 나머지 문자들을 모두 제거.
            제거 후, 마침표가 끝이라면 마침표 제거
        7. 길이가 2자 이하라면 마지막 문자를 3이 될 때까지 반복
    
    */
    
    public String solution(String new_id) {

        // 조건 1
        String cond1 = new_id.toLowerCase();
        //System.out.println("1: " + cond1);
        
        // 조건 2 & 3
        String cond2 = Cond2(cond1);
        //System.out.println("2&3: " + cond2);

        
        // 조건 4 & 5
        String cond4 = Cond4(cond2);
        //System.out.println("4&5: " + cond4);

        
        // 조건 6
        String cond6 = Cond6(cond4);
        //System.out.println("6: " + cond6);
        
        
        // 조건 7
        String cond7 = Cond7(cond6);
        //System.out.println("7: " + cond7);
        
        return cond7;
    }
    
    public static String Cond2(String cond1){
        
        char[] arr = cond1.toCharArray();
        int len = cond1.length();
        
        String cond2 = "";
        boolean flag = false;
        
        for(int i = 0; i < len; i++){
            
            if(arr[i] - 'a' <= 25 && arr[i] - 'a' >= 0){
                cond2 += arr[i];
            }else if(arr[i] == '-' || arr[i] == '_' || arr[i] == '.'){
                cond2 += arr[i];
            }else if(Character.isDigit(arr[i])){
                cond2 += arr[i];
            }
            
            int k = cond2.length();
            if(arr[i] == '.' && k > 1 && cond2.charAt(cond2.length()-2) == '.'){
                cond2 = cond2.substring(0, cond2.length()-1);
            }
        }
        
        return cond2;
    }
    
    public static String Cond4(String cond3){
        
        if(cond3.length() == 0) return "a";
        
        String cond4 = "";
        
        // 앞이 . 이라면
        if(cond3.charAt(0) == '.'){
            cond4 = cond3.substring(1);
        }else{
            cond4 = cond3;
        }
        
        if(cond4.length() == 0) return "a";
        
        // 뒤가 . 이라면
        if(cond4.charAt(cond4.length()-1) == '.'){
            cond4 = cond4.substring(0, cond4.length()-1);
        }
        
        return cond4;
    }
    
    public static String Cond6(String cond5){
        int len = cond5.length();
        String cond6 = "";
        
        if(len >= 16){
            cond6 = cond5.substring(0, 15);
            if(cond6.charAt(cond6.length()-1) == '.'){
            cond6 = cond6.substring(0, 14);
            }
        }else{
            cond6 = cond5;
        }
        
        return cond6;
    }
    
    public static String Cond7(String cond6){
        int len = cond6.length();
        String cond7 = "";
        
        if(len == 1){
            cond7 = cond6 + cond6 + cond6;
        }else if(len == 2){
            cond7 = cond6 + cond6.charAt(1);
        }else{
            cond7 = cond6;
        }
        
        return cond7;
    }

}