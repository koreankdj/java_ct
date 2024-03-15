/*
 * 1) 좋아하는 학생이 인접한 칸에 가장 많은 칸
 * 2) 1을 만족하는 칸이 여러 개이면, 비어있는 칸이 가장 많은 칸
 * 3) 행의 번호가 가장 작은 칸으로, 열의 번호가 가장 작은 칸
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[][] map;
	static int[][] likes;
	static int[] points = {0, 1, 10, 100, 1000};
	static int[][] dir = {
			{1, 0},		// 하
			{0, 1},		// 우
			{0, -1},	// 좌
			{-1, 0}		// 상
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int T = N * N;
		map = new int[N][N];
		likes = new int[T+1][4];
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			int[] target_like = new int[4];
			
			// 좋아하는 사람들 4명이 담긴 배열
			for(int j = 0; j < 4; j++) {
				int cur = Integer.parseInt(st.nextToken());
				target_like[j] = cur;
				likes[target][j] = cur;
			}
			
			solve(target, target_like);
		}
		
		//print();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				ans += calc_ans(i, j, map[i][j]);
			}
		}
		
		System.out.println(ans);
	}
	
	public static void solve(int target, int[] target_like) {
		
		// 조건 1, 조건 2
		int m_cd1 = 0, m_cd2 = 0;
		
		// 저장될 인덱스
		int h = 0, w = 0;
		int min_h = N-1, min_w = N-1;
		
		boolean flag = false;
		
		// 전체 순회
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(map[i][j]!=0) continue;
				
				if(!flag) {
					flag = true;
					min_h = i;
					min_w = j;	
				}
				
				int cd1 = calc_cd1(i, j, target_like);
				int cd2 = calc_cd2(i, j);
				
				// (조건 1) 확인, 큰 경우
				if(m_cd1 < cd1) {
					h = i;
					w = j;
					m_cd1 = cd1;
					m_cd2 = cd2;
					//System.out.printf("[%d] : [%d, %d] 으로 위치 변경 ! \n", target, h, w);
				}else if(m_cd1 == cd1) {	// (조건 1)이 같은 경우 (조건 2) 확인
					if(m_cd2 < cd2) {
						h = i;
						w = j;
						m_cd2 = cd2;
						//System.out.printf("[%d] : [%d, %d] 으로 위치 변경 ! \n", target, h, w);
					}
				}
			}
		}
		if(m_cd1 == 0 && m_cd2 == 0) {
			h = min_h;
			w = min_w;
		}
		//System.out.printf("[%d] -> [%d, %d]\n", target, h, w);
		map[h][w] = target;
		
	}
	
	public static int calc_ans(int h, int w, int target) {
		
		int point = 0;
		
		for(int i = 0; i < 4; i++) {
			int nh = h + dir[i][0];
			int nw = w + dir[i][1];
			
			if(!inMap(nh, nw)) continue;
			
			for(int j = 0; j < 4; j++) {
				if(likes[target][j] == map[nh][nw]) point++;
			}
		}
		
		return points[point];
	}
	
	public static int calc_cd1(int h, int w, int[] target_like) {
		
		int cd1 = 0;
		
		for(int i = 0; i < 4; i++) {
			int nh = h + dir[i][0];
			int nw = w + dir[i][1];
			
			if(!inMap(nh, nw)) continue;
			
			for(int j = 0; j < 4; j++) {
				if(target_like[j]==map[nh][nw]) {
					cd1++;
					break;
				}
			}
		}
		
		return cd1;
	}
	
	public static int calc_cd2(int h, int w) {
		
		int cd2 = 0;
		
		for(int i = 0; i < 4; i++) {
			int nh = h + dir[i][0];
			int nw = w + dir[i][1];
			
			if(!inMap(nh, nw)) continue;
			
			if(map[nh][nw] == 0) cd2++;
		}
		
		return cd2;
	}
	
	public static boolean inMap(int h, int w) {
		return(0 <= h && h < N && 0 <= w && w < N);
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}