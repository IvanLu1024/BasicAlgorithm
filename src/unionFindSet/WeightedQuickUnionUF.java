package unionFindSet;

/**
 * 加权的快速合并的并查集
 */
public class WeightedQuickUnionUF extends UF {

    //保存节点的数量信息
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        super(N);
        this.sz=new int[N];
        for (int i=0;i<sz.length;i++){
            sz[i]=1;
        }

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

        int i = find(p);
        int j = find(q);

        if (i==j)
            return;

        if (sz[i]<sz[j])
        {
            id[i]=j;
            sz[j]+=sz[i];
        }else {
            id[j]=i;
            sz[i]+=sz[j];
        }

    }
}
