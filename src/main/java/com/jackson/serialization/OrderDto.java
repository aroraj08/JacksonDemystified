package com.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jackson.common.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private BigDecimal price;
    private Integer qty;
    private OrderStatus orderStatus;

    // this is only for serialization
    @JsonValue
    public String toJson() {
        return this.id + "," + this.price + "," + this.qty + "," + this.orderStatus
                + "," + this.toString();
    }
}
