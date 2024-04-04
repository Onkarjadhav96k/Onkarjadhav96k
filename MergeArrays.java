public class MergeArrays {

  public static void merge(int[] X, int m, int[] Y, int n) {
    // Find the index of the last non-vacant cell in X
    int i = m - 1;

    // Merge Y into X starting from the end
    int j = n - 1;
    while (i >= 0 && j >= 0) {
      if (X[i] > Y[j]) {
        X[i--] = X[i]; // Shift non-vacant elements of X one position back
      } else {
        X[i--] = Y[j--]; // Insert Y[j] into the vacant cell in X
      }
    }

    // Copy the remaining elements of Y, if any
    while (j >= 0) {
      X[i--] = Y[j--];
    }
  }

  public static void main(String[] args) {
    int[] X = {0, 2, 0, 3, 0, 5, 6, 0, 0};
    int[] Y = {1, 8, 9, 10, 15};
    int m = X.length;
    int n = Y.length;

    merge(X, m, Y, n);

    System.out.println("Merged array:");
    for (int num : X) {
      System.out.print(num + " ");
    }
  }
}
