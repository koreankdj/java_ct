import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	static int N;
	static long  D[] = new long[101];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++)
		{
			N = Integer.parseInt(br.readLine());

			D[1] = 1;
			D[2] = 1;
			D[3] = 1;
			D[4] = 2;
			D[5] = 2;
			for (int i = 6; i <= N; i++)
			{
				D[i] = D[i-1] + D[i-5];
			}
			
			System.out.println(D[N]);
		}
	}
}