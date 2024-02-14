import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static int N;
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
		
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
        	String input = br.readLine();
        	for(int j = 0; j < N; j++) {
        		map[i][j] = input.charAt(j) - '0';
        	}
        }
        
        divandcon(0, 0, N);
        System.out.println(sb);
        
	}
	
	public static void divandcon(int x, int y, int size) {
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(map[i][j] != map[x][y]) {
					sb.append("(");
					divandcon(x, y, size / 2);
					divandcon(x, y + size / 2, size / 2);
					divandcon(x + size / 2, y, size / 2);
					divandcon(x + size / 2, y + size / 2, size / 2);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(map[x][y]);
		
	}

}