package leetcode.com;

/**
 * link: https://leetcode.com/problems/robot-return-to-origin/description/
 */
public class Robot_Return_To_Origin_657 {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U': {
                    y++;
                    break;
                }
                case 'D': {
                    y--;
                    break;
                }
                case 'L': {
                    x--;
                    break;
                }
                case 'R': {
                    x++;
                    break;
                }
            }
        }
        return x == 0 && y == 0;
    }
}
