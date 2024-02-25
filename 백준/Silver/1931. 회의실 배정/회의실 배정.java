import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Meeting implements Comparable<Meeting>{
		int start, end;
		public Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			return this.end!=o.end ? this.end - o.end : this.start - o.start;
		}
	}
	
	static int N;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(meetings);
		
		int end_t = 0;
		int cnt = 0;
		for(Meeting meeting : meetings) {
			if(meeting.start >= end_t) {
				end_t = meeting.end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}

}