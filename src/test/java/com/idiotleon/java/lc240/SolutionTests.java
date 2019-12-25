package com.idiotleon.java.lc240;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {

    private final Solution solution = new Solution();

    private final int[][] matrix1 = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };

    @Test
    void test() {
        assertEquals(true, solution.searchMatrix(matrix1, 5));
        assertEquals(false, solution.searchMatrix(matrix1, 20));
    }
}