package com.laioffer.hw11.dp_1;

/**
 * Given a rope with positive integer-length n, how to cut the rope into m
 * integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the
 * maximal product of p[0]*p[1]* ... *p[m-1]?
 * 
 * m is determined by you and must be greater than 0 (at least one cut must be
 * made).
 * 
 * Return the max product you can have. Assumptions n >= 2 Examples n = 12, the
 * max product is 3 * 3 * 3 * 3 = 81 (cut the rope into 4 pieces with length of
 * each is 3).
 */
// M[1] = 0
// M[i] represents the max product that can be achieved by cutting i-meter long
// rope at least one time
public class Q02_MaxProductOfCuttingRope {
	// 左大段 右小段
	public int maxProduct(int ropeLength) {
		int[] M = new int[ropeLength + 1];
		// M[0] = 0;
		M[1] = 0;
		M[2] = 1;

		for (int i = 3; i <= ropeLength; i++) {
			for (int j = 1; j < i; j++) {
				int temp = Math.max(j, M[j]) * (i - j);
				M[i] = Math.max(M[i], temp);
			}
		}
		return M[ropeLength];
	}

	public static void main(String args[]) {
		Q02_MaxProductOfCuttingRope mpcr = new Q02_MaxProductOfCuttingRope();
		System.out.println(mpcr.maxProduct(12));
	}
}
