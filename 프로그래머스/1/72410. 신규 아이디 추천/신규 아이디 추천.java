/*
    1. 유저들의 아이디를 생성하는 업무를 담당 -> 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 아이디와 유사하면서
    2. 길이는 3 이상 15 이하
    3. 알파벳 소문자, 숫자, -, _, . 사용 가능
    4. .는 처음과 끝 사용x & 연속 사용 x
    
    
    처리 과정
    1. 모든 대문자를 소문자로 치환
    2. 해당 없는 모든 문자 제거
    3. 마침표가 .. 2번 이상 연속된 부분을 하나의 마침표로 치환
    4. 마침표 첫, 끝 제거
    5. 빈 문자열 ? "a" 대입
    6. 16자 이상이라면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거. 제거 후 마침표가 끝이라면 끝 제거
    7. 길이가 2 이하라면, 마지막 문자를 3이 될 때 까지 끝에 붙임
    
*/



class Solution {
    public String solution(String new_id) {
        
        // 1. 모든 대문자를 소문자로 치환
        String id = new_id.toLowerCase();    
        
        // 2. 알파벳 소문자, 숫자, -, _,. 을 제외한 모든 문자 제거
        String id2 = "";
        
        char[] arr = id.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] - 'a' >= 0 && arr[i] - 'a' <= 25){    // 알파벳 소문자인 경우
                id2 += arr[i];
            }else if (arr[i] - '0' >= 0 && arr[i] - '0' <= 9){      // 숫자인 경우
                id2 += arr[i];
            }else if(arr[i] == '-' || arr[i] == '_' || arr[i] =='.'){       // 특수 문자 인 경우
                id2 += arr[i];
            }
        }
        //System.out.println("id2 :" + id2);
        
        // 3. new_id에서 .이 2번 이상 연속된 부분을 하나의 .으로 치환
        String id3 = "";
        char[] arr3 = id2.toCharArray();

        for(int i = 0; i < arr3.length; i++){
            if(arr3[i] == '.'){
                id3 += arr3[i];
                for(int j = i; j < arr3.length; j++){
                    if(arr3[j] != '.'){
                        i = j -1;
                        break;
                    }
                    if(j == arr3.length-1 && arr3[j] == '.'){
                        i = arr3.length-1;
                    }
                }
            }else{
                id3 += arr3[i];
            }
        }
        //System.out.println("id3 :" + id3);
        
        // 4. 마지막이 처음이나 끝이라면 제거
        
        
        if(id3.charAt(0) == '.'){
            id3 = id3.substring(1, id3.length());
        }
        
        
        int last = id3.length();
        String id4 = "";
        
        //System.out.println("size : " + last + " id3 :" + id3);
        
        if(last > 0 && id3.charAt(last-1) == '.'){
            for(int i = 0; i < last-1; i++){
                id4 += id3.charAt(i);
            }
        }else{
            id4 = id3;
        }
        
        // 5. 빈 문자열이라면 'a' 대입하기
        if(id4.equals("")) id4 = "a";
        
       //System.out.println("id5 :" + id4);
        
        // 6. 16자 이상이면, 첫 15자를 제외한 나머지 문자들 모두 제거
        if(id4.length() >= 16){
            if(id4.charAt(14) == '.'){
                id4 = id4.substring(0, 14);
            }else{
                id4 = id4.substring(0, 15);
            }
        }
        
        // 7. 길이가 2자 이하라면, 마지막 문자를 3이 될 때까지 반복해서 붙임
        if(id4.length() == 1){
            id4 += id4;
            id4 += id4.charAt(0);
        }else if(id4.length() == 2){
            id4 += id4.charAt(1);
        }
        
        String answer = id4;
        return answer;
    }
}