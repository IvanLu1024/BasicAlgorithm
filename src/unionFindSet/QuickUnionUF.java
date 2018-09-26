package unionFindSet;

public class QuickUnionUF extends UF {

    public QuickUnionUF(int N) {
        super(N);
    }


    @Override
    public int find(int i) {
        while (i!=id[i]){
            i=id[i];
        }

        return i;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot!=qRoot){
            id[pRoot]=qRoot;
        }


    }
}
