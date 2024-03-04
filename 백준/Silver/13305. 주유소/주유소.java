import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[] street;
	static long[] country;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		street = new long[N-1];
		country = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N-1 ; i++) {
			street[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < N ; i++) {
			country[i] = Integer.parseInt(str.nextToken());
		}
		
		long gas = country[0];
		ans = country[0]*street[0];
		
		for(int i = 1 ; i < country.length-1 ; i++) {
			if(gas > country[i]) {
				gas = country[i];
				ans += gas*street[i];
			}else {
				ans += gas*street[i];
			}
		}

		System.out.println(ans);
		
		}
	
}