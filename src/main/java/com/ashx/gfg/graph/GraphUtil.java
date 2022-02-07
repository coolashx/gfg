package com.ashx.gfg.graph;

import java.util.Arrays;
import java.util.List;

public class GraphUtil {
    public static List<List<Integer>> getDummyConnectedGraph() {
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

    public static List<List<Integer>> getDummyDisconnectedGraph() {
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
}
