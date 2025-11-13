import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			arr.add(num);
		}
		
		int target = sc.nextInt();
		boolean found = false;
		for(int i=0;i<n;i++) {
			if(arr.get(i) == target) {
				System.out.println("Target Found at Index " + i);
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Target not Found");
		}
		
		sc.close();
	}

}
