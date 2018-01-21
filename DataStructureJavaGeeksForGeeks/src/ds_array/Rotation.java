package ds_array;


import java.util.*;

public class Rotation {
	private int[] A;
	private Random rand;
	
	Rotation(int N){
		A = new int[N];
		rand = new Random();
		for (int i = 0; i < N; i++) {
			A[i] = rand.nextInt(50);
		}
	}
	
	void display(String s) {
		System.out.println(s);
		for (int n : A) {
			System.out.print(n + ", ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		
	}
}
