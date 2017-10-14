package enhance1.laioffer.com;

/**
 * Rotate an N * N matrix clockwise 90 degrees. Assumptions
 * 
 * The matrix is not null and N >= 0
 * 
 * Examples 
 * { {1, 2, 3} 
 * {8, 9, 4}, 
 * {7, 6, 5} } 
 * 
 * after rotation is 
 * { {7, 8, 1} 
 * {6, 9, 2}, 
 * {5, 4, 3} }
 * 剥洋葱
 */
public class RotateMatrix {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		// this indicates how many rounds we need to do the clock wise rotation
		// round 0 -> 最外面一层
		// round 1 -> 往里面一层 ...
		int round = n / 2;
		
		for (int i = 0; i < round; i++) {
			int beginIndex = i;
			int endIndex = n - i - 2;
			for (int j = beginIndex; j <= endIndex; j++) {
				int temp = matrix[beginIndex][j];
				matrix[beginIndex][j] = matrix[n - 1 - j][beginIndex];
				matrix[n - 1 - j][beginIndex] = matrix[n - 1 - beginIndex][n -1 - j];
				matrix[n - 1 - beginIndex][n - 1 - j] = matrix[j][n - 1 - beginIndex];
				matrix[j][n - 1 - beginIndex] = temp;
			}
		}
	}
}
