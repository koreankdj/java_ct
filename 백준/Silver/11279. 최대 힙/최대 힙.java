import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input != 0) {
				pq.add(input);
			}else {
				if(pq.isEmpty()) pq.add(0);
				System.out.println(pq.poll());
			}
		}
		
	}
}
