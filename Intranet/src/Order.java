/**
* @generated
*/
public class Order {

    public Order() {}

    public Order(OrderStatus status) {
        this.status = status;
    }

    /**
    * @generated
    */
    private OrderStatus status;


    //                          Operations                                  

    /**
     * @generated
     */
    public OrderStatus getStatus() {
        return this.status;
    }

    /**
     * @generated
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                '}';
    }
}
