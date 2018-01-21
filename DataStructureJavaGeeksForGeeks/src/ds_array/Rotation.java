package ds_array;


import java.util.*;

/**
 * 
 * @author Guangzhuan Mo
 * 
 * rotate an array A[n] by d elements
 * 
 *  ex. 
 *  Input:
 *  	A[] 4, 2, 5, 7, 4, 6
 *  	d = 2
 *  Output:
 *  	A[] 5, 7, 4, 6, 4, 2
 *  
 *
 */
public class Rotation {
	private int[] A;
	private Random rand;

	/*
	 * initialize the A[N] with random numbers
	 * 
	 * @param N the size of the array A[]
	 * 
	 */

	Rotation(int N){
		A = new int[N];
		rand = new Random();
		for (int i = 0; i < N; i++) {
			A[i] = rand.nextInt(50);
		}
	}
	
	/*
	 * use tmp space
	 * 
	 * 1. store the elements needed to rotate into tmp[d] 
	 * 2. move the each element of A[d, n-1] to the left.
	 * 3. restore tmp[] to the tail of A[n-d, n-1]
	 */
	void rotate(int d) {
		int tmp[] = new int[d];
		int i = 0;
		// store the elements needed to rotate into tmp[d]
		for (i = 0; i< d; i++) {
			tmp[i] = A[i];
		}
		//move the each element of A[d, n-1] to the left.
		for (i = d; i < A.length; i++) {
			A[i-d] = A[i];
		}
		// restore tmp[] to the tail of A[n-d, n-1]
		for (i = 0; i < d; i++) {
			A[A.length-d+i] = tmp[i];
		}
	}
	
	
	/*
	 * display the result 
	 * @param s the prompt info
	 */
	void display(String s) {
		System.out.println(s);
		for (int n : A) {
			System.out.print(n + ", ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		Rotation r = new Rotation(10);
		r.display("original");
		r.rotate(2);
		r.display("after rotated 2 elements");
	}
}
