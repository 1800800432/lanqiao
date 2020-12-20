public class Test {
    public static void main(String args[]) {
        recusion(5);
    }

    private static int ii = 0;//递推过程计数
    private static int jj = 0;//回归过程计数

    static long recusion(long n) {
        long lngReturn = 1;
        if (n >= 1)//判断条件，防止无限递归(递归结束条件)
        {
            ii++;
            System.out.println("第" + ii + "次递推：n=" + n);
            lngReturn = n * recusion(n - 1);
            jj++;
            System.out.println("第" + jj + "次回归：lngReturn=" + lngReturn);
        }
        return lngReturn;
    }
}