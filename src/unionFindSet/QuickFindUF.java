package unionFindSet;

/**
 * 快速查找的并查集
 *
 * 同一连通分量的所有节点的id值均相等
 * 查找的只需要返回数组值即可
 */
public class QuickFindUF extends UF {

    public QuickFindUF(int N) {
        super(N);
    }

    @Override
    public int find(int i) {
        return id[i];
    }

    /**
     * 将其中一个连通分量中
     * 的所有节点 id 值都修改为
     * 另一个节点的 id 值。
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId==qId)
            return;

        for (int i=0;i<id.length;i++){
            if (id[i]==pId){
                id[i]=qId;
            }

        }

    }
}
