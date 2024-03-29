import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] house;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		house = new int[N];
		
		for(int i = 0; i < N; i++) {
			house[i] = sc.nextInt();
		}
		
		// 이분탐색은 무조건 정렬
		Arrays.sort(house);
		
		
		int lo = 1;
		int hi = house[N-1] - house[0] + 1;		// 가질 수 있는 최대값
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			// 설치할 수 있는 공유기가 M개보다 작다면, 
			if(canInstall(mid) < M) {
				hi = mid;
			}else {
				lo = mid+1;
			}
		}
		
		System.out.println(lo-1);
	}
	
	static int canInstall(int distance) {
		
		int count = 1;
		int lastLocate = house[0];
		
		for(int i = 1; i < house.length; i++) {
			int locate = house[i];
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		
		return count;
	}

}