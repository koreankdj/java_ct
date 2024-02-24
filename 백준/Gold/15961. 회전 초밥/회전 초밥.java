import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int belt[] = new int[N+k];
        int selected[] = new int[d+1];

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            belt[i] = n;
        }

        int result=1;

        selected[c]++;
        for(int i=N;i<N+k;i++){
            belt[i]=belt[i-N];
            if(selected[belt[i]]==0){
                result++;
            }
            selected[belt[i]]++;

        }

        int temp = result;

        for(int i=k;i<N+k;i++){

            int deleteNum = belt[i-k];
            selected[deleteNum]--;
            
            // 초밥이 없는 경우
            if(selected[deleteNum]==0){
                temp--;
            }

            int addNum = belt[i];
            selected[addNum]++;

            // 새로 들어온 경우
            if(selected[addNum]==1){
                temp++;
            }

            result = Integer.max(result, temp);
        }
        System.out.println(result);


    }
}