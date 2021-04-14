package com.casestudy.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Transaction")
public class Payment {
    @Id
    private String id;
    private  String payment_status;
    private String Transaction_id;
    private int userid;
    private int orderId;
    private double amount;


}
