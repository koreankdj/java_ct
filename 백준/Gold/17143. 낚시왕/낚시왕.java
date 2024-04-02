import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int R, C, M, ans;
	static int[][] map;
	
	static int[][] dir = {
			
			{-1, 0},	// 위
			{1, 0},		// 아래
			{0, 1},		// 오른쪽
			{0, -1}		// 왼쪽
	};
	
	static class Shark{
		int idx, h, w, s, d, z;
		public Shark(int idx, int h, int w, int s, int d, int z) {
			super();
			this.idx = idx;
			this.h = h;
			this.w = w;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "Shark [idx=" + idx + ", h=" + h + ", w=" + w + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

		
		
	}
	
	static Map<Integer, Shark> sharks = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R+2][C+2];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[h][w] = i+1;		// map 배열에는 상어 id 만 넣어놓음.
			
			sharks.put(i+1, new Shark(i+1, h, w, s, d, z));
		}
		//System.out.println(sharks);
		//print_map();
		//print_shark();
		solve();
		System.out.println(ans);
		
	}
	
	public static void solve() {
		
		for(int j = 1; j <= C; j++) {
			// 현재 상어왕의 위치는 i 열
			
			for(int i = 1; i <= R; i++) {	// 처음 만나는 상어를 잡음
			
				if(map[i][j] != 0) {
					// 상어 잡기
					Shark cur = sharks.get(map[i][j]);
					//System.out.println("열 : " + j +" catch shark : " + cur);
					ans += cur.z;
					sharks.remove(map[i][j]);
					
					break;
				}
			}
			// 상어 이동
			sharks_moving();
			sharks_set();
			//print_map();
			//print_shark();
		}
	}
	
	public static void print_shark() {
		System.out.println("=== print shark ===");
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(map[i][j]==0) {
					System.out.print(map[i][j] + " ");
				}else {
					System.out.print(sharks.get(map[i][j]).z + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void print_map() {
		System.out.println("=== print map ===");
		for(int i = 1; i <= R+1; i++) {
			for(int j = 1; j <= C+1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void sharks_moving() {
		List<Integer> sharks_idx = new ArrayList<>(sharks.keySet());
		
		for(int idx : sharks_idx) {
			Shark cur = sharks.get(idx);
			int h = cur.h;
			int w = cur.w;
			int s = cur.s;	// 속력
			int d = cur.d;
			int z = cur.z;
			
			int size = 0;
			if(d == 1 || d == 2) {
				size = R;
			}else {
				size = C;
			}
			
			s = s % (2*size-2); 
			
			for(int speed = 0; speed < s ; speed++) {
				h += dir[d-1][0];
				w += dir[d-1][1];
				
				if(h==0) {			// 위로 이동하는 상어
					d = 2;
					h = 2;
				}else if(h==R+1) {	// 아래로 이동하던 상어
					d = 1;
					h = R-1;
				}else if(w==0) {	// 왼쪽으로 이동하던 상어
					d = 3;
					w = 2;
				}else if(w==C+1) {	// 오른쪽으로 이동하던 상어
					d = 4;
					w = C-1;
				}
			}
			
			
			
			
			// 이동 끝.
			sharks.put(idx, new Shark(idx, h, w, s, d, z));
		}
	}
	
	public static void sharks_set() {
		map = new int[R+2][C+2];
		List<Integer> sharks_idx = new ArrayList<>(sharks.keySet());
		
		for(int idx : sharks_idx) {
			Shark cur = sharks.get(idx);
			
			if(map[cur.h][cur.w] == 0) {	// 아무도 없을 때,
				map[cur.h][cur.w] = idx;
			}else {							// 상어가 있다면,
				Shark prev = sharks.get(map[cur.h][cur.w]);
				
				if(prev.z < cur.z) {		// 새로 들어온 상어가 더 크다면
					map[cur.h][cur.w] = idx;
					//System.out.println("이전에 있던 상어 죽음 ! " + prev.z + " 현재 : " + cur.z + " map 값 : " + map[cur.h][cur.z] + " " + cur.h + " " + cur.w + " idx : " + idx);
					sharks.remove(prev.idx);	// 원래 상어 죽음
				}else {							// 원래 상어가 더 크다면
					sharks.remove(idx);
				}
			}
		}
	}
	
	
}