import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Queue<Integer> cards = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			cards.offer(i+1);
		}
		
		int temp = 0;
		while(true) {
			if(cards.size() == 1) break;
			else{
				cards.poll();	// 한 장 버리기
				temp = cards.peek();
				cards.offer(temp);	// 앞 장 추가
				cards.poll();
			}
		}
		
		temp = cards.poll();
		System.out.println(temp);
	}

}
