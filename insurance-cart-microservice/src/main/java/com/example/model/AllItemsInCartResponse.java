package com.example.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AllItemsInCartResponse {
    private Integer userId;
    private List<Integer> listOfPolicyIds;
}
