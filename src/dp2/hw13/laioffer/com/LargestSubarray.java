package dp2.hw13.laioffer.com;

public class LargestSubarray {
	/*
	 * 
	 * Largest Sum of a subarray
	 * Index 0, 1, 2, 3, 4, 5,  6
	 * Input 1  2  4 -1 -2  10  -1
	 * M[i]  1  3  7  6  4  14  13
	 * 
	 * Index 0, 1, 2, 3, 4, 5,  6
	 * Input 1  2  4 -1 -12  10  -1
	 * M[i]  1  3  7  6  -6  10  9
	 * 
	 * 1. base case: M[0] = input[0]
	 * 2. induction rule: M[i] represents [from 0-th element to the i-th element]
	 * 		the largest sum of the subarray [must include the i-th element].
	 * 
	 * 	M[i] = M[i - 1] + input[i] iff M[i - 1] >= 0
	 * 	M[i] = input[i]
	 * 	
	 * 	Time = O(n)
	 * 	Space = O(n) -> O(1) if optimized
	 * 
	 * 	FollowUp:
	 * 	What if you are requested to return the let and right index of the subarray that has the largest sum.
	 * 	L            R
	 * 	Sol_L    Sol_R
	 * 
	 * 	when to update sol_L? when max is updated
	 * 	when to update sol_R? when max is updated
	 * 	when to update L (L = i, when M[i - 1] < 0)
	 * 	when to update R (update all the time each round)
	 * 		
	 * 
	 */
		// version 1
		public int getMaxVersion1(int[] s) {
			if (s == null || s.length < 1) {
				return 0;
			}
			int max = Integer.MIN_VALUE;
			int lastMax = s[0];
			for (int i = 1; i < s.length; i++) {
				lastMax = Integer.max(lastMax + s[i], s[i]);
				max = Math.max(max, lastMax);
			}
			return max;
		}
		
		// version 2
		public int[] getMaxVersion2(int[] s) {
			if (s == null || s.length < 1) {
				return null;
			}
			int max = Integer.MIN_VALUE;
			int lastMax = s[0];
			int sol_L = 0;
			int sol_R = 0;
			int l = 0;
			int r = 0;
			for (int i = 1; i < s.length; i++) {
				if (lastMax < 0) {
					l = i;
					r = i;
					lastMax = s[i];
				} else {
					lastMax = lastMax + s[i];
					r = i;
				}
				if (lastMax > max) {
					sol_L = l;
					sol_R = r;
					max = lastMax;
				}
			}
			return new int[] {sol_L, sol_R};
		}
}
