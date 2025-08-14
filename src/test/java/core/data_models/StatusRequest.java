package core.data_models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusRequest {
    @JsonProperty("order_id")
    private String orderId;

    public StatusRequest(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
