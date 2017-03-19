package algorithm;

public class Algorithm {

    public static Interval kadaneAlgorithm(int[] arr) {
        Interval global = new Interval(0, 0, arr[0]);
        Interval right = new Interval(0, 0, arr[0]);

        for (int idx = 1; idx < arr.length; ++idx) {
            if (right.getWeight() > 0) {
                right.setWeight(right.getWeight() + arr[idx]);
                right.setEnd(idx);
            } else {
                right.setWeight(arr[idx]);
                right.setStart(idx);
            }

            if (global.getWeight() < right.getWeight()) {
                right.copyTo(global);
            }
        }

        return global;
    }

    public static Interval hardAlgorithm(int[] arr) {
        Interval result = new Interval(0, 0, 0);
        for (int i = 0; i < arr.length; ++i) {
            int weight = 0;
            for (int j = i; j < arr.length; ++j) {
                weight += arr[j];
                if (result.getWeight() < weight) {
                    result.setStart(i);
                    result.setEnd(j);
                    result.setWeight(weight);
                }
            }
        }
        return result;
    }

}
