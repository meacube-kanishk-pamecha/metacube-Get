public class Orders {
    private int id;
    private String orderDate;
    private double orderTotal;
    public Orders(int id, String orderDate, double orderTotal) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public double getOrderTotal() {
        return orderTotal;
    }
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
    @Override
    public String toString() {
        return "Orders [id=" + id + ", orderDate=" + orderDate + ", orderTotal=" + orderTotal + "]";
    }
    
}
