import java.util.*;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
		int first = 1;
		int second = 1;
		System.out.print(first + " ");
		System.out.print(second + " ");
		n -= 2;
		while(n > 0) {
			int newSecond = first + second;
			System.out.print(newSecond + " ");
			first = second;
			second = newSecond;
			n--;
		}
	}

}
