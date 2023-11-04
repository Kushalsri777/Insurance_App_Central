package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
    @Id
    @GeneratedValue
    private Integer orderId;
    private Integer userId;
    private Boolean isPaymentDone;
    @ElementCollection
    private List<Integer> policyIds;
}
