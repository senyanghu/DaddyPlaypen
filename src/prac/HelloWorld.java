package prac;

public class HelloWorld {
	
	static int size = 10;
	
	public int[] change(int[] arr) {
		System.out.println(size);
		arr[0] = 100;
		return arr;
	}

	public void show(int[] arr1, int[] arr2) {
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (int i : arr2) {
			System.out.print(i + " ");
		}
	}

	public static void main(String args[]) {
		int[] input = {1, 2, 3, 4};
		size = 20;
		HelloWorld hw = new HelloWorld();
		hw.change(input);
	}
}
