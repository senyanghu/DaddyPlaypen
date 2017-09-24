package dp4.hw14.laioffer.com;

// 一个unsorted一维数组最长连续1的问题

// M[i] represents the longest contiguous 1s from 0th to ith element (including the ith element)

// base case M[0] = A[0]
// induction rule: M[i] = M[i-1] + 1; if A[i] == 1
//					    = 0
public class LongestConsecutiveOne {

}
