package com.ashx.gfg.graph;

import java.util.Arrays;
import java.util.List;

public class GraphUtil {
    public static List<List<Integer>> getConnectedUndirectedGraph() {
        /*
            0 - 1 - 4 - 5
            |   |
            2 - 3
         */
        return Arrays.asList(
                Arrays.asList(1, 2), // V-0
                Arrays.asList(0, 3, 4), // V-1
                Arrays.asList(0, 3), // V-2
                Arrays.asList(1, 2), // V-3
                Arrays.asList(1, 5), // V-4
                Arrays.asList(4) // V-5
        );
    }

    public static List<List<Integer>> getDisconnectedUndirectedGraph() {
        /*
            0 - 1       4 - 5           9 - 10
            |   |       |   |
            2 - 3       6 - 7 - 8
         */
        return Arrays.asList(
                Arrays.asList(1, 2), // V-0
                Arrays.asList(0, 3), // V-1
                Arrays.asList(0, 3), // V-2
                Arrays.asList(1, 2), // V-3
                Arrays.asList(5, 6), // V-4
                Arrays.asList(4, 7), // V-5
                Arrays.asList(4, 7), // V-6
                Arrays.asList(5, 6, 8), // V-7
                Arrays.asList(7), // V-8
                Arrays.asList(10), // V-9
                Arrays.asList(9) // V-10
        );
    }

    public static List<List<Integer>> getDisconnectedDirectedGraph() {
        /*
            0 -> 1       4 -> 5           9 -> 10 <- 11 -> 12 -> 13
            i    !       i   i                              i     !
            2 -> 3       6 -> 7 -> 8                       15  <- 14
         */
        return Arrays.asList(
                Arrays.asList(1), // V-0
                Arrays.asList(3), // V-1
                Arrays.asList(0, 3), // V-2
                Arrays.asList(), // V-3
                Arrays.asList(5), // V-4
                Arrays.asList(), // V-5
                Arrays.asList(4, 7), // V-6
                Arrays.asList(5, 8), // V-7
                Arrays.asList(), // V-8
                Arrays.asList(10), // V-9
                Arrays.asList(), // V-10
                Arrays.asList(10, 12), // V-11
                Arrays.asList(13), // V-12
                Arrays.asList(14), // V-13
                Arrays.asList(15), // V-14
                Arrays.asList(12) // V-15
        );
    }

    public static int[][] getUndirectedWeightedGraph() {
        return new int[][]{
                {0, 5, 8, 0}, // V-0
                {5, 0, 10, 15}, // V-1
                {8, 10, 0, 20}, // V-2
                {0, 15, 20, 0} // V-3
        };
    }

    public static List<List<Weight>> getDirectedAcyclicWeightedGraph() {
        /*
            (0) -2> (1) -3> (2) -6> (3)
            !                i       i
            !   -1> (4)  -2> i       i
                     !   -4>  (5) -1>
         */
        return Arrays.asList(
                Arrays.asList(new Weight(1, 2), new Weight(4, 1)), // V-0
                Arrays.asList(new Weight(2, 3)), // V-1
                Arrays.asList(new Weight(3, 6)), // V-2
                Arrays.asList(), // V-3
                Arrays.asList(new Weight(2, 2), new Weight(5, 4)), // V-4
                Arrays.asList(new Weight(3, 1)) // V-5
        );
    }

    public static class Weight {
        int toVertex;
        int weight;

        public Weight(int toVertex, int weight) {
            this.toVertex = toVertex;
            this.weight = weight;
        }
    }
}
