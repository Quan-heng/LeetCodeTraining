package 五毒.第四周.第一遍;

public class search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int right =m*n-1;
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            int x = mid/n;
            int y = mid%n;
            if(matrix[x][y]==target){
                return true;
            }else if(matrix[x][y]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
