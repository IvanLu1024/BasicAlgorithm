package shopee;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author Ivan 15:30
 * @Description TODO
 */
public class Main2019 {

    @Test
    public static void test01(){
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        String[] strings = line.split(" ");
        int n = Integer.parseInt(strings[2]);
        int[] xArray=new int[n];
        int[] yArray=new int[n];
        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        for (int i = 0; i < n; i++) {
            strings=sc.nextLine().split(" ");
            xArray[i]=Integer.parseInt(strings[0]);
            yArray[i]=Integer.parseInt(strings[1]);
        }
        int[][] martix=new int[x+1][y+1];
        for (int i = 0; i < n; i++) {
            martix[xArray[i]][yArray[i]]=1;
        }
        int i = pathNum(martix);
        System.out.println(i);

    }

    private static int pathNum(int[][] martix){
        int m=martix.length;
        if (m==0){
            return 0;
        }
        int n = martix[0].length;
        //起始位置为右下角
        int[][] memo=new int[m][n];
        for(int i=m-1;i>=0;i--){
            if(martix[i][0]!=1){
                memo[i][0]=1;
            }else{
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(martix[0][i]!=1){
                memo[0][i]=1;
            }else{
                break;
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(martix[i][j]!=1){
                    memo[i][j]=memo[i+1][j]+memo[i][j+1];
                }
            }
        }
        return memo[0][0];
    }

    public static void test04(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=n*n;
        //空地，map0[count0][0]:横坐标；map0[count0][1]:纵坐标；
        int[][] map0=new int[count][2];
        //建筑物的坐标
        int[][] map1=new int[count][2];
        int res=Integer.MAX_VALUE;
        int count0=0,count1=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int t = sc.nextInt();
                if (t==1){
                    map1[count1][0]=i;
                    map1[count1][1]=j;
                    count1++;
                }else {
                    map0[count0][0]=i;
                    map0[count0][1]=j;
                    count0++;
                }
            }
        }
        if (count1==0||count1==count) {
            System.out.println(-1);
        }
        for (int i = 0; i < count0; i++) {
            int sum=0;
            for (int j = 0; j < count1; j++) {
                sum+=Math.abs(map1[j][0]-map0[i][0]);
                sum+=Math.abs(map1[j][1]-map0[i][1]);
            }
            res=Math.min(res,sum);

        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        test04();
    }
}
