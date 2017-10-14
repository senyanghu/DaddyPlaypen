package hw08.laioffer.com;

/**
 * Assume both large and small are not NULL and if small is empty, return 0;
 * 
 * @author senyanghu
 *
 */
public class IsSubstring {
	public int strStr(String large, String small) {
		if (small.length() == 0)
			return 0;

		for (int i = 0; i < large.length(); i++) {
			int j = 0;
			for (; j < small.length(); j++) {
				if (large.charAt(i) != small.charAt(j)) {
					break;
				}
			}
			if (j == small.length()) {
				return i;
			}
		}
		return -1;
	}
}
