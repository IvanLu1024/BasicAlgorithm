package unionFindSet;

/**
 * 并查集
 *
 * 抽象类
 *
 */
public abstract class UF {
    protected int[] id;

    public UF(int N){
        id=new int[N];
        for (int i=0;i<N;i++)
        {
            id[i]=i;

        }
    }

    /**
     * 判断 p 和 q 节点是否连通
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
        return find(p)==find(q);


    }

    /**
     * 查找 p 所在的连通分量
     * @param i
     * @return
     */
    public abstract int find(int i);

    /**
     * 连接 p 和 q 节点
     * @param p
     * @param q
     */
    public abstract void union(int p,int q);

}
