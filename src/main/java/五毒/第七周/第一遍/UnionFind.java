package 五毒.第七周.第一遍;

public class UnionFind {
    private int count;
    int[] parent;

    public UnionFind(int n) {
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP != parentQ) {
            parent[q] = parentP;
            count--;
        }
    }

    public int getCount(){
        return count;
    }
}
