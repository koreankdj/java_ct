import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	static int n, m;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		BigInteger ans = fac(1, n).divide(fac(1, m).multiply(fac(1,n-m)));
		System.out.println(ans);
		
	}
	

	
	private static BigInteger fac(int start, int end) {
		
		BigInteger result = new BigInteger("1");
		
		for(int i = start; i <= end; i++) {
			result = result.multiply(new BigInteger(String.valueOf(i)));
		}
		
		return result;
		
	}

}
