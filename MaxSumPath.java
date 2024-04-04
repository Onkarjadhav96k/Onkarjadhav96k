public class MaxSumPath {

  public static int findMaxSumPath(int[] X, int[] Y) {
    int sum = 0;
    int sumX = 0, sumY = 0; 
    int m = X.length, n = Y.length;
    int i = 0, j = 0;

    while (i < m && j < n) {
      // Handle duplicates in X
      while (i < m - 1 && X[i] == X[i + 1]) {
        sumX += X[i++];
      }
     
      while (j < n - 1 && Y[j] == Y[j + 1]) {
        sumY += Y[j++];
      }

     
      if (Y[j] < X[i]) {
        sumY += Y[j];
        j++;
     
      } else if (X[i] < Y[j]) {
        sumX += X[i];
        i++;
     
      } else {
        sum += Math.max(sumX, sumY) + X[i]; 
        i++;
        j++;
        sumX = 0;
        sumY = 0;
      }
    }

    // Process remaining elements (if any)
    while (i < m) {
      sumX += X[i++];
    }
    while (j < n) {
      sumY += Y[j++];
    }
    sum += Math.max(sumX, sumY);

    return sum;
  }

  public static void main(String[] args) {
    int[] X = {3, 6, 7, 8, 10, 12, 15, 18, 100};
    int[] Y = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};
    int maxSum = findMaxSumPath(X, Y);

    System.out.println("Maximum sum path: " + maxSum);
  }
}
