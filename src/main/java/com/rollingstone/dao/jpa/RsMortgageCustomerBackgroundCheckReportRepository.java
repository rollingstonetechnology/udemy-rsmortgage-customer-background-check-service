package com.rollingstone.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.domain.BackgroundCheckReport;
import com.rollingstone.domain.Customer;



public interface RsMortgageCustomerBackgroundCheckReportRepository extends PagingAndSortingRepository<BackgroundCheckReport, Long> {

    Page findAll(Pageable pageable);
}
