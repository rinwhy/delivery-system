package com.solvd.delivery.bin;

public class ReturnRequest extends BaseTable{

    private String reason;
    private String status;
    private Order order;

    public int getId() {
        return super.id;
    }

    public void setId(int id) {
        super.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String returnReason) {
        this.reason = returnReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderID() {
        return order.getId();
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
