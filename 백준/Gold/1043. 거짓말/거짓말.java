import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cnt;
	
	static int[] parents;
	static boolean[] visited_true, visited_false, party_check;	// 거짓말 한 배열
	
	static ArrayList<Integer>[] party;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new ArrayList[M];
		make();
		
		// 진실을 아는 사람들의 부모를 0으로 세팅
		st = new StringTokenizer(br.readLine());
		int truth = Integer.parseInt(st.nextToken());
		for(int i = 0; i < truth; i++) {
			int person = Integer.parseInt(st.nextToken());
			union(0, person);
		}
		
		// 파티 시작
		boolean flag;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken());
			
			party[i] = new ArrayList<>();	// 파티 세팅
			
			flag = false;
			
			// 거짓말 해도 되는가.
			for(int j = 0; j < people; j++) {
				int cur = Integer.parseInt(st.nextToken());
				
				party[i].add(cur);
				
				if(find(cur) == 0) flag = true;
			}
			
			// 만약 진실을 아는 사람이 있을 경우.
			if(flag) {
				for(int j = 0; j < party[i].size(); j++) {
					union(0, party[i].get(j));	// 모두 0으로 설정
				}
			}else {
				for(int j = 1; j < party[i].size(); j++) {
					union(party[i].get(0), party[i].get(j));	// 모두 0으로 설정
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			flag = false;
			int size = party[i].size();
			
			for(int j = 0; j < size; j++) {
				if(find(party[i].get(j)) == 0) {
					flag = true;
					break;
				}
			}
			
			if(flag) cnt++;
		}
		
		System.out.println(M-cnt);
	}
	
	public static void make() {
		parents = new int[N + 1];
		party_check = new boolean[M];
		visited_true = new boolean[N + 1];
		visited_false = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int v) {
		if(parents[v] == v) return v;
		
		return parents[v] = find(parents[v]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(aRoot < bRoot) {
			parents[bRoot] = aRoot;
		}else {
			parents[aRoot] = bRoot;
		}
		return true;
		
	}
}