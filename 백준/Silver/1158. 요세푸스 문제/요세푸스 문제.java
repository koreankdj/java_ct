import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

	static int N, K;
	
	static LinkedList<Integer> yo;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		yo = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			yo.offer(i);
		}
		
		sb.append("<");
		int cnt = 0;
		while(!yo.isEmpty()) {
			//System.out.println(yo.get(0));
			if(cnt == K-1) {
				sb.append(yo.poll() + ", ");
				cnt = 0;
			}else {
				yo.add(yo.poll());
				cnt++;
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
	
}