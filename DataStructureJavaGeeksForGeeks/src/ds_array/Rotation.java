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
	 * block swap algorithm
	 * divide A[N] into B[0, d-1] , C[d, n-1]
	 * 
	 * while C.length != B.length
	 * 		if B.length < C.length
	 * 			divide C[] into Cl and Cr , where Cr.length == B.length
	 * 			swap B with Cr, so that change B Cl Cr into Cr Cl B
	 * 				so that B is at its final place
	 * 			recur on pieces on C 
	 * 		
	 * 		else B.length > C.length
	 * 			divide  B[] into Bl and Br, where Bl.length == C.length
	 * 			swap Bl with C, so that change Bl Br C into C Br Bl
	 * 				so that C is at its final place
	 * 			recur on pieces on B
	 * 
	 * finally, while B.length == C.length , block swap them
	 */
	
	/*
	 * recursive implementation
	 * @param d: length of B
	 * @param n : length of C
	 */
	void blockSwapRecursive(int d, int n) {
		if (0 == d || d == n) {
			return;
		}
		// if number of elements to be rotated is exactly 
		// half of array size
		// block swap them
		if (d == n - d) {
			swap(0, d, n-d);
		}
		// if B.length < C.length
		if (d < n-d) {
			swap(0, n-d, d);
			blockSwapRecursive(d, n-d);
		}
		else {
			swap(0, d, n-d);
			blockSwapRecursive(2*d-n, d);
		}
		
	}
	
	
	
	/*
	 * iterative implementation
	 * 
	 */
	void blockSwap(int d) {
		
		if ( 0 == d || d == A.length) {
			return;
		}
		
		int m = d; // length of sub-array B[]
		int n = A.length-d; // length of sub-array C[]
		while (m != n) {
			if (m < n) {
//				swap(d-m, )
			}
		}
	}
	/*
	 * swap d elements starting at bs with d elements starting as cs
	 */
	private void swap(int bs, int cs, int d) {
		int tmp = 0;
		for (int i = 0; i < d; i++) {
			tmp = A[bs+i];
			A[bs+i] = A[cs+i];
			A[cs+i] = tmp;
		}
	}
	
	
	/*
	 * reversal algorithm
	 * 
	 * divide A[N] into B[0, d-1], C[d, n-1]
	 * reverse B to get rB C, where rB is reverse of B
	 * reverse C to get rB rC, where rC is reverse of C
	 * 
	 * reverse all, we get r(rB rC) 
	 */
	void reverse(int d) {
		// reverse B to get rB C, where rB is reverse of B
		int n = d-1;
		int i = 0;
		for (i = 0; i <d/2; i++ ) {
			swap(i, n-i);
		}
		n = A.length-1;
		// reverse C to get rB rC, where rC is reverse of C
		for ( i = 0; i < (A.length - d) / 2 ; i++) {
			swap(d+i, n - i);
		}
		// reverse all, we get r(rB rC) 
		for ( i = 0; i < n / 2; i++  ) {
			swap(i, n-i);
		}
	}
	
	private void swap(int h, int t) {
		int tmp = A[h];
		A[h] = A[t];
		A[t] = tmp;
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
	 * use a helper function rotate1()
	 */
	void leftRotate(int d) {
		for (int i = 0; i < d; i++) {
			rotate1();
		}
	}
	/*
	 * rotate1()
	 * rotate one element at a time
	 */
	private void rotate1() {
		int tmp = A[0];
		int i = 0;
		for (; i < A.length - 1; i++){
			A[i] = A[i+1];
		}
		A[i] = tmp;
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
		int n = 10;
		Rotation r = new Rotation(n);
		r.display("original");
		r.blockSwapRecursive(5, n);
		r.display("after rotated 5 elements");
	}
}
