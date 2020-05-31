public class Percolation {

  private int[][] matrix;
  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = 0;
      }
    }
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    if (matrix[row][col] == 0) { matrix[row][col] = 1; }
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    return matrix[row][col] == 1;
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    return matrix[row][col] == 0;
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    int count = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] == 1) { count++; }
      }
    }
  }

  // does the system percolate?
  public boolean percolates() {
    
  }

  // test client (optional)
  public static void main(String[] args)
  
}

