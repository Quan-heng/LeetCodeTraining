package 每日一题;

public class search_a_binary_matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1}};
        System.out.println(searchMatrix(matrix, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int mTemp = mid / n;
            int nTemp = mid % n;
            if (matrix[mTemp][nTemp] == target) {
                return true;
            } else if (matrix[mTemp][nTemp] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
