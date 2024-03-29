import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	
	static ArrayList<Meeting> meetings = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			Meeting meeting = new Meeting(s, e);
			meetings.add(meeting);
		}
		
		Collections.sort(meetings);
		int time = 0;
		int cnt = 0;
		
		for(int i = 0; i < meetings.size(); i++) {
			Meeting mt = meetings.get(i);
			// System.out.println(mt);
			
			if(time <= mt.start) {
				time = mt.end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static class Meeting implements Comparable<Meeting>{
		int start, end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
			
		}
		
		public int compareTo(Meeting o) {
			
			return this.end==o.end?this.start-o.start:this.end-o.end;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		
		
	}

}