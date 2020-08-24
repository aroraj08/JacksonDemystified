package com.jackson.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jackson.deserialization.CustomDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@JsonRootName(value = "payment")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    @JsonProperty("paymentId")
    private Long id;
    private String mode;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using= CustomDateDeserializer.class)
    private LocalDateTime paymentDate;
}
