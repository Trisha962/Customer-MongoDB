package com.example.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Document
public class Customer {
    private String customerName;
    @Id
    private int customerId;
    private int customerPhone;
    private Product customerProduct;

}
