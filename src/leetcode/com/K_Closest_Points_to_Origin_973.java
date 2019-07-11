package leetcode.com;

import java.util.PriorityQueue;

/**
 * link: https://leetcode.com/problems/k-closest-points-to-origin/description/
 */
public class K_Closest_Points_to_Origin_973 {

    public int[][] kClosest(int[][] points, int K) {
        // create a min-heap
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][];
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
