package com.example.dao;

import com.example.entity.Discount;
import com.example.repo.DiscountRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountDaoImplTest {

    @InjectMocks
    private DiscountDaoImpl discountDao;

    @Mock
    private DiscountRepo discountRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddDiscount() {
        Discount discount = Discount.builder()
                .policyId(1L)
                .value(0.2)
                .build();

        discountDao.addDiscount(discount);

        verify(discountRepo, times(1)).save(discount);
    }


    @Test
    public void testGetDiscountByPolicyId() {
        Long policyId = 1L;
        List<Discount> discountList = Arrays.asList(
                Discount.builder().policyId(policyId).value(0.2).build(),
                Discount.builder().policyId(policyId).value(0.3).build()
        );

        when(discountRepo.findByPolicyId(policyId)).thenReturn(discountList);

        List<Discount> result = discountDao.getDiscountByPolicyId(policyId);

        assertNotNull(result);
        assertEquals(discountList, result);
    }
}
