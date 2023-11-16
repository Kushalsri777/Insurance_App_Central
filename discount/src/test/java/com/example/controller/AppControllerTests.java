package com.example.controller;

import com.example.controller.AppController;
import com.example.dao.DiscountDao;
import com.example.entity.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppControllerTests {

    @InjectMocks
    private AppController appController;

    @Mock
    private DiscountDao discountDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddDiscount() throws URISyntaxException {
        Discount discount = Discount.builder()
                .policyId(1L)
                .value(0.2)
                .build();

        doNothing().when(discountDao).addDiscount(any(Discount.class));

        ResponseEntity<String> response = appController.addDiscount(discount);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        HttpHeaders headers = response.getHeaders();
        assertTrue(headers.containsKey("Policy-Id"));
        assertEquals("Discount created successfully", response.getBody());
    }

    // @Test
    // public void testShowDiscountByPolicyId() {
    // List<Long> policyId = Arrays.asList(1L, 2L);
    // List<Discount> discountList = Arrays.asList(
    // Discount.builder().policyId(policyId).value(0.2).build(),
    // Discount.builder().policyId(policyId).value(0.3).build());

    // when(discountDao.getDiscountByPolicyId(policyId)).thenReturn(discountList);

    // ResponseEntity<Object> response =
    // appController.showDiscountByPolicyId(policyId);

    // assertNotNull(response);
    // assertEquals(200, response.getStatusCodeValue());
    // HttpHeaders headers = response.getHeaders();
    // assertTrue(headers.containsKey("Policy-Id"));
    // assertEquals(discountList, response.getBody());
    // }

}
