public class OrderForm {
    //定义属性
    private String formNumber;
    private float ammout;

    //与Customer关联
    private Customer Customer;

    //加封装后

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }

    public float getAmmout() {
        return ammout;
    }

    public void setAmmout(float ammout) {
        this.ammout = ammout;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }
}
