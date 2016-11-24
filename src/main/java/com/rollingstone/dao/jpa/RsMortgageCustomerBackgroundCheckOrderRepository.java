package com.rollingstone.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.BackgroundCheckOrder;
import com.rollingstone.domain.LoanApplication;



public interface RsMortgageCustomerBackgroundCheckOrderRepository extends PagingAndSortingRepository<BackgroundCheckOrder, Long> {
    List<BackgroundCheckOrder> findCustomerBackgroundCheckOrderBackgroundCheckOrderByloanApplication(LoanApplication loanApplication);

    Page findAll(Pageable pageable);
}
