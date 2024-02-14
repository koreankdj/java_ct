import java.util.Scanner;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] visited;
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		N=sc.nextInt();
		arr= new int[N];
		visited = new boolean[N];
		

		dfs(0,visited);
		
		
		// index = 열, 원소 = 행
		// [2,0,3,1]
		//
		// [f,f,f,f]
		
		System.out.println(count);
	}
	public static void dfs(int depth,boolean[] v)
	{
	
		if(depth==N)
		{
			count++;
			return;
		}
		
		for(int i=0;i<N;i++)
		{
			arr[depth]=i;
			if(isPossible(depth))
			{
				dfs(depth+1,v);
			}
			
		}
	}
	public static boolean isPossible(int d)
	{
		// index = 열, 원소 = 행
		// [2,1,0,0]
		//
		// [f,f,f,f]
		
		for(int i=0;i<d;i++)
		{
			
			if(arr[d]==arr[i])
			{
				return false;
				
				
			}
			if(Math.abs(d-i)==Math.abs(arr[d]-arr[i]))
			{
				return false;
			}
			
		}
		return true;
	}
	
	

}