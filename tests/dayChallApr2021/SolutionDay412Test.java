package dayChallApr2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionDay412Test {
    SolutionDay412 solution;
    int inputN, inputK;
    int[] result;

    @BeforeEach
    void setUp() {
        solution = new SolutionDay412();
    }

    @Test
    void constructArray31() {
        inputN = 3;
        inputK = 1;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 2, 3]", Arrays.toString(result));
    }

    @Test
    void constructArray32() {
        inputN = 3;
        inputK = 2;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 3, 2]" , Arrays.toString(result));
    }

    @Test
    void constructArray41() {
        inputN = 4;
        inputK = 1;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 2, 3, 4]", Arrays.toString(result));
    }

    @Test
    void constructArray42() {
        inputN = 4;
        inputK = 2;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 3, 2, 4]" , Arrays.toString(result));
    }

    @Test
    void constructArray43() {
        inputN = 4;
        inputK = 3;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 4, 2, 3]" , Arrays.toString(result));
    }

    @Test
    void constructArray53() {
        inputN = 5;
        inputK = 3;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 4, 2, 3, 5]" , Arrays.toString(result));
    }

    @Test
    void constructArray54() {
        inputN = 5;
        inputK = 4;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 5, 2, 4, 3]" , Arrays.toString(result));
    }

    @Test
    void constructArray63() {
        inputN = 6;
        inputK = 3;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 4, 2, 3, 5, 6]" , Arrays.toString(result));
    }

    @Test
    void constructArray64() {
        inputN = 6;
        inputK = 4;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 5, 2, 4, 3, 6]" , Arrays.toString(result));
    }


    @Test
    void constructArray65() {
        inputN = 6;
        inputK = 5;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 6, 2, 5, 3, 4]" , Arrays.toString(result));
    }

    @Test
    void constructArray73() {
        inputN = 7;
        inputK = 3;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 4, 2, 3, 5, 6, 7]" , Arrays.toString(result));
    }

    @Test
    void constructArray74() {
        inputN = 7;
        inputK = 4;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 5, 2, 4, 3, 6, 7]" , Arrays.toString(result));
    }

    @Test
    void constructArray75() {
        inputN = 7;
        inputK = 5;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 6, 2, 5, 3, 4, 7]" , Arrays.toString(result));
    }

    @Test
    void constructArray76() {
        inputN = 7;
        inputK = 6;
        result = solution.constructArray(inputN, inputK);
        assertEquals("[1, 7, 2, 6, 3, 5, 4]" , Arrays.toString(result));
    }
}