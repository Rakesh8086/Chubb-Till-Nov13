import java.util.*;

public class Prime {

	public static ArrayList<Integer> sieve(int n){
		ArrayList<Integer> isPrime = new ArrayList<>(Collections.nCopies(n+1, 1));
		isPrime.set(0, 0);
        isPrime.set(1, 0);
		for(int i=2;i*i<=n;i++) {
			if(isPrime.get(i) == 1) {
				for(int j=i*i;j<=n;j+=i) {
					isPrime.set(j, 0);
				}
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2;i<=n;i++) {
			if(isPrime.get(i) == 1) {
				primes.add(i);
			}
		}
		
		return primes;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
		ArrayList<Integer> primes = sieve(n);
		
		for(int i=0;i<primes.size();i++) {
			System.out.print(primes.get(i) + " ");
		}
	}

}
