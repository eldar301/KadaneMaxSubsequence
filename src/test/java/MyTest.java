import algorithm.Algorithm;
import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MyTest {

    private int randomTestsAmount = 10;
    private int minimumArraySize = 10;
    private int maximumArraySize = 50;
    private int dispersion = 100;

    /*
     * Task test
     */
    @Test
    public void taskTest() {
        int[] arr = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int[] delta = new int[arr.length - 1];
        for (int idx = 0; idx < delta.length; ++idx) {
            delta[idx] = arr[idx + 1] - arr[idx];
        }
        assertEquals(Algorithm.hardAlgorithm(delta), Algorithm.kadaneAlgorithm(delta));
    }

    @Test
    public void randomArraysTest() {
        Random random = new Random(System.currentTimeMillis());
        for (int test = 0; test < randomTestsAmount; ++test) {
            int[] arr = new int[minimumArraySize + random.nextInt(maximumArraySize - minimumArraySize + 1)];
            for (int idx = 0; idx < arr.length; ++idx) {
                int sign = Integer.signum(random.nextInt());
                arr[idx] = sign * random.nextInt(dispersion);
            }

            assertEquals(Algorithm.hardAlgorithm(arr), Algorithm.kadaneAlgorithm(arr));
        }
    }
}
