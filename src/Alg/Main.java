package Alg;

import java.util.Arrays;

public class Main {
    public static int[] Kadane(int[] arr) {
        int maximumWithCurrent = arr[0];
        int withCurrentStart = 0;

        int maximumGlobal = arr[0];
        int globalStart = 0;
        int globalEnd = 0;

        for (int i = 1; i < arr.length; ++i) {
            if (maximumWithCurrent > 0) {
                maximumWithCurrent = maximumWithCurrent + arr[i];
            } else {
                maximumWithCurrent = arr[i];
                withCurrentStart = i;
            }

            if (maximumGlobal < maximumWithCurrent) {
                maximumGlobal = maximumWithCurrent;
                globalStart = withCurrentStart;
                globalEnd = i;
            }
        }
        return new int[] {globalStart, globalEnd};
    }

    public static void main(String[] args) {
        int[] arr = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int[] delta = new int[arr.length - 1];
        for (int idx = 0; idx < delta.length; ++idx) {
            delta[idx] = arr[idx + 1] - arr[idx];
        }
        int[] result = Kadane(delta);
        System.out.println("i = " + result[0] + "; j = " + (result[1] + 1) + ";");
    }
}
