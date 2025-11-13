import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
		System.out.println("Enter values in sorted order");
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			arr.add(num);
		}
		
		int target = sc.nextInt();
		boolean found = false;
		int low = 0;
		int high = n-1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr.get(mid) == target) {
				System.out.println("Target Found at index " + mid);
				found = true;
				break;
			}
			else if(arr.get(mid) > target) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		if(!found) {
			System.out.println("Target not Found");
		}
		
		sc.close();
	}

}
