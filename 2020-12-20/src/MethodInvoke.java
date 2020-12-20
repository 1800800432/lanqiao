public class MethodInvoke {
    public static void main(String[] args) {
        System.out.println("AAAAAA");
        m1();
        System.out.println("CCCCCC");
        /*
        求阶乘
        1*2*3*4*5
         */
        int result=1;
        for (int i = 0; i<5;i++){
            result = result*(i+1);
        }
        System.out.println("5！的结果是"+result);
        m2(5);
        System.out.println("5！的递归结果是"+result);
    }
    static int m2(int n){
        int result=1;
        if(n!=0)
        result=n*m2(n-1);
        return result;
    }
    static void m1(){
        System.out.println("BBBBBB");
    }
}
