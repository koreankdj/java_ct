class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 조건 1
        String id = "";
        id = new_id.toLowerCase();
        
        // 조건2
        String id2 = "";
        for(int i = 0; i < id.length(); i++){
            char c = id.charAt(i);
            
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c =='.'){
                id2 += c;
            }
        }
        
        // 조건3
        String id3 = id2.replace("..", ".");
        while(id3.contains("..")){
            id3 = id3.replace("..", ".");
        }
        //System.out.println("조건3 : " + id3);

        // 조건4
        String id4 = id3;
        if(id4.length() > 0){
            if(id4.charAt(0) == '.'){
                id4 = id4.substring(1, id4.length());
            }
        }
        if(id4.length() > 0){
            if(id4.charAt(id4.length()-1) == '.'){
                id4 = id4.substring(0, id4.length()-1);
            }
        }
        //System.out.println("조건4 : " + id4);
        
        // 조건5
        String id5 = "";
        if(id4.length() == 0){
            id5 += 'a';
        }else{
            id5 = id4;
        }
        //System.out.println("조건5 : " + id5);
        
        // 조건6
        String id6 = id5;
        if(id6.length() >= 16){
            id6 = id6.substring(0, 15);
            if(id6.charAt(14) == '.'){
                id6 = id6.substring(0, 14);
            }
        }
        //System.out.println("조건6 : " + id6);
        
        // 조건7
        String id7 = id6;
        if(id7.length() == 1){
            char c = id7.charAt(0);
            id7 += c;
            id7 += c;
        }else if(id7.length() == 2){
            char c = id7.charAt(1);
            id7 += c;
        }
        //System.out.println("조건7 : " + id7);
        
        return id7;
    }

}