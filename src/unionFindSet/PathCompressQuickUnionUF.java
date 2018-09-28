package unionFindSet;

/**
 * 路径压缩的加权quick-union算法
 *
 *
 * 在理想情况下，我们都希望所有的节点都直接连接在它的根节点上，
 *
 * 这样就只需一次操作就能找到其根节点，能表现出常数时间，
 *
 * 这种方法被称为路径压缩方法。
 */
public class PathCompressQuickUnionUF extends UF {
    //保存节点的数量信息
    private int[] sz;

    public PathCompressQuickUnionUF(int N) {
        super(N);
        this.sz=new int[N];
        for (int i=0;i<sz.length;i++){
            sz[i]=1;
        }
    }

    @Override
    public int find(int i) {
        int temp=i;
        while (i!=id[i])
            i=id[i];
        id[temp]=id[i];
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
