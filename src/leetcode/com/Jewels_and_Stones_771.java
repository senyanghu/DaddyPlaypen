package leetcode.com;

/**
 * link: https://leetcode.com/problems/jewels-and-stones/description/
 */
public class Jewels_and_Stones_771 {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char c : S.toCharArray()) {
            if (J.indexOf(c) != -1) {
                count += 1;
            }
        }
        return count;
    }
}
