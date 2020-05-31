public class QuickUnionUF {
  private int[] id;
  private int[] sz;
  private int count;

  public QuickUnionUF(int N) {
    count = N;
    id = new int[N];
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  // returns the number of sets
  public int count() {
    return count;
  }

  // returns the canonical element (root) of the set containing element
  private int root(int i) {
    while (i != id[i]) {
      // Make every other node in path point to its grandparent, thereby having path length
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }

  // returns true if the two elements are in the same set
  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  // Merges set containing element p with set containing element q
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (i == j) return;
    // link root of smaller tree to root of larger tree; update sz[] array
    if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
    else { id[j] = i; sz[i] += sz[j]; }
    count--;
  }

  // Hint: Maintain extra array that stores root 'i', the large element in the connected component containing i
  public int findLargest(int i) {
    int x = 0;
    for (int y = 0; y < id.length; y++) {
      if (connected(id[y], id[i])) { x = Math.max(id[y], id[i]); }
    }
    return x;
  }
}
