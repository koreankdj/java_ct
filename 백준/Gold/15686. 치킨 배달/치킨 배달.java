import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans, min_ans;
	static int[][] map;
	
	static int chick_hs, house_cnt;		// 치킨 집의 개수
	static int[] chick_arr;
	
	static class pair{
		int x;
		int y;
		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<pair> chick_lst, house_lst;
	static ArrayList<pair> chick_selected;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chick_arr = new int[M];
		
		chick_lst = new ArrayList<>();
		house_lst = new ArrayList<>();
		chick_selected = new ArrayList<>(M);


	
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					pair new_house = new pair(i, j);
					house_lst.add(new_house);
					house_cnt++;
				}	else if(map[i][j] == 2) {
					pair new_chicken = new pair(i, j);
					chick_lst.add(new_chicken);
					chick_hs++;
				}
			}
		}
		
		ans = 0;
		min_ans = Integer.MAX_VALUE;
		Comb1(0, 0);
		System.out.println(min_ans);
		
	}
	
	private static void Comb1(int start, int depth) {
		
		if(depth == M) {
			ans = 0;
		
			
			// 집 도는 loop
			for(int j = 0; j < house_cnt; j++) {
				
				int dist = 0;
				int min_dist = Integer.MAX_VALUE;
				
				// 치킨 집 도는 loop
				for(int i = 0; i < M; i++) {
					dist = cal_dist(chick_selected.get(i).x, chick_selected.get(i).y, house_lst.get(j).x, house_lst.get(j).y);
					min_dist = Math.min(min_dist, dist);
					//System.out.println("*" + min_dist);
				}
				//System.out.println("min_dist:" + min_dist);
				ans += min_dist;
			}
			min_ans = Math.min(min_ans, ans);
			
			return;
		}
        for(int i = start; i < chick_hs; i++) { 
            chick_selected.add(chick_lst.get(i));
            Comb1(i + 1, depth + 1); // 
            chick_selected.remove(depth);
        }
	}
	
	private static int cal_dist(int x1, int y1, int x2, int y2) {
		
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
