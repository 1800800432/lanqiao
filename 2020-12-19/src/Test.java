public class Test {
    public static void main(String[] args) {
        //创建客户
        Customer Customer0 = new Customer();
        /*Customer0.address = "桂林电子科技大学";
        Customer0.customerNmae = "阿洋";
        Customer0.passWord = "11223344";
        Customer0.phone = "1878781345";*/

        Customer0.setAddress("桂林电子科技大学");
        Customer0.setCustomerNmae("阿洋");
        Customer0.setPassWord("11223344");
        Customer0.setPhone("1878781345");
        //创建商品
        OrderForm OrderForm0= new OrderForm();
        /*OrderForm0.ammout = 1888F;
        OrderForm0.formNumber = "000001";*/
        OrderForm0.setAmmout(1888F);
        OrderForm0.setFormNumber("000001");
        //关联
        Customer0.setOrderForm(OrderForm0);

        //System.out.println("订单金额："+Customer0.orderForm.ammout);
    }
}
