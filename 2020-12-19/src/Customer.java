import java.util.List;

public class Customer {
    //定义属性
    private String customerNmae;
    private String passWord;
    private String address;
    private String phone;
    //与OrderForm关联
    private OrderForm OrderForm;
    //加封装后
    public String getCustomerNmae() {
        return customerNmae;
    }

    public void setCustomerNmae(String customerNmae) {
        this.customerNmae = customerNmae;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrderForm getOrderForm() {
        return OrderForm;
    }

    public void setOrderForm(OrderForm orderForm) {
        this.OrderForm = orderForm;
    }
}
