public class Solution {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                new int[]{1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 0, 0, 0, 0},
                new int[]{1, 1, 1, 0, 0, 0},
                new int[]{0, 9, 2, -4, -4, 0},
                new int[]{0, 0, 0, -2, 0, 0},
                new int[]{0, 0, -1, -2, -4, 0}
        };
        int[][] hourGlassWithLargestSum = findHourGlassWithLargestSum(arr);

        System.out.println(sum(hourGlassWithLargestSum));

        arr = new int[][]{
                new int[]{-1, -1, 0, -9, -2, -2},
                new int[]{-2, -1, -6, -8, -2, -5},
                new int[]{-1, -1, -1, -2, -3, -4},
                new int[]{-1, -9, -2, -4, -4, -5},
                new int[]{-7, -3, -3, -2, -9, -9},
                new int[]{-1, -3, -1, -2, -4, -5}};
        hourGlassWithLargestSum = findHourGlassWithLargestSum(arr);

        System.out.println(sum(hourGlassWithLargestSum));
    }

    /**
     * A non-null, not-empty, square-shaped array is expected.
     *
     * @param input
     * @return
     */
    public static int[][] findHourGlassWithLargestSum(int[][] input) {
        int length = input.length;

        int subArrayLength = length / 2;
        int largestSoFar = Integer.MIN_VALUE;
        int sum;

        int[][] temp = new int[subArrayLength][subArrayLength];
        int[][] candidate = new int[subArrayLength][subArrayLength];

        for (int i = 0; i <= length - subArrayLength; i++) {
            for (int j = 0; j <= length - subArrayLength; j++) {
                for (int k = i; k < subArrayLength + i; k++) {
                    for (int l = j; l < j + subArrayLength; l++) {
                        temp[k - i][l - j] = input[k][l];
                    }
                }
                sum = sum(temp);
                if (sum > largestSoFar) {
                    largestSoFar = sum;
                    candidate = deepCopy(temp);
                }
            }
        }
        return candidate;
    }

    /**
     * Sums all the elements in the array.
     *
     * @param matrix
     * @return
     */

    private static int sum(int[][] matrix) {
        int length = matrix.length;

        int middle = length / 2;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == middle && j != middle) {
                    continue;
                }
                sum += matrix[i][j];
            }

        }
        return sum;

        /*return Arrays.stream(matrix).mapToInt(
                column -> Arrays.stream(column).sum()).sum();*/
    }

    private static int[][] deepCopy(int[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }
}
