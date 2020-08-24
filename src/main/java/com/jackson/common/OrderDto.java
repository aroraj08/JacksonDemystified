package com.jackson.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"id", "price"})
public class OrderDto {

    private Long id;
    private BigDecimal price;
    private Integer qty;
    private OrderStatus orderStatus;

}
