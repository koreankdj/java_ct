import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
    static int[][] dir = {
            {0, 0},
            {-1, 0},    // 상
            {0, 1},        // 우
            {1, 0},        // 하
            {0, -1}        // 좌
    };

	static int M, A, ans;
	
	static int[] posA, posB;
	static int[] pathA, pathB;
	static int[][] Charger;
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= T; tc++) {
            
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());        // 이동 횟수
            A = Integer.parseInt(st.nextToken());        // 충전소 개수
            
            pathA = new int[M+1];
            pathB = new int[M+1];
            Charger = new int[A][4];

            st = new StringTokenizer(br.readLine());	// A의 이동 정보 
            for(int i = 1; i < M+1; i++) {
            	pathA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());	// B의 이동 정보
            for(int i = 1; i < M+1; i++) {
            	pathB[i] = Integer.parseInt(st.nextToken());
            }
            
            // 충전소 정보 입력 받음 
            for(int i = 0; i < A; i++) {
            	st = new StringTokenizer(br.readLine());
            	Charger[i][1] = Integer.parseInt(st.nextToken());
            	Charger[i][0] = Integer.parseInt(st.nextToken());
            	Charger[i][2] = Integer.parseInt(st.nextToken());
            	Charger[i][3] = Integer.parseInt(st.nextToken());
            }
            
            posA = new int[] {1, 1};
            posB = new int[] {10, 10};
            ans = 0;
            move();
            System.out.printf("#%d %d\n", tc, ans);
        }
	}
	
	public static void move() {
		
		for(int i = 0; i < M+1; i++) {
			int max = 0;
			posA[0] += dir[pathA[i]][0];
			posA[1] += dir[pathA[i]][1];
			
			posB[0] += dir[pathB[i]][0];
			posB[1] += dir[pathB[i]][1];
			 
			for(int a = 0; a < A; a++) {		// a 와 충전소 사이의 거리 구함 
				int sum = 0;
				int fillA = 0;
				
				int d1 = getDistance(posA[0], posA[1], Charger[a][0], Charger[a][1]);
				
				for(int b = 0; b < A; b++) {	// b 와 충전소 사이 거리 구함 
					int fillB = 0;
					
					int d2 = getDistance(posB[0], posB[1], Charger[b][0], Charger[b][1]);
					//System.out.println(b + "에서 b와의 거리 : " + d2);
					
					if(d1 <= Charger[a][2]) {
						fillA = Charger[a][3];
						//System.out.printf("a : [%d] - %d 만큼 획득 가능 \n", a, Charger[a][3]);
					}
					if(d2 <= Charger[b][2]) {
						fillB = Charger[b][3];
						//System.out.printf("b : [%d] - %d 만큼 획득 가능 \n", b, Charger[b][3]);
					}
					
					// 두 충전소가 같지 않는 경우 
					if(a != b) sum = fillA + fillB;
					else {
						sum = Math.max(fillA, fillB);
					}
					
					if(max < sum) max = sum;
				}
			}
			ans += max;
			//System.out.printf(" ** %d 에서 %d 더해짐! **\n", i, max);
		}
	}

	
	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}