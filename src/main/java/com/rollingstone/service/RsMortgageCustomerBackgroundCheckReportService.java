package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.jpa.RsMortgageCustomerBackgroundCheckReportRepository;
import com.rollingstone.domain.Customer;
import com.rollingstone.domain.BackgroundCheckReport;


/*
 * Service class to do CRUD for Customer BackgroundCheckReport through JPS Repository
 */
@Service
public class RsMortgageCustomerBackgroundCheckReportService {

    private static final Logger log = LoggerFactory.getLogger(RsMortgageCustomerBackgroundCheckReportService.class);

    
    @Autowired
    private RsMortgageCustomerBackgroundCheckReportRepository customerBackgroundCheckReportRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public RsMortgageCustomerBackgroundCheckReportService() {
    }

    public BackgroundCheckReport createBackgroundCheckReport(BackgroundCheckReport liability) {
        return customerBackgroundCheckReportRepository.save(liability);
    }

    public BackgroundCheckReport getBackgroundCheckReport(long id) {
        return customerBackgroundCheckReportRepository.findOne(id);
    }

    public void updateBackgroundCheckReport(BackgroundCheckReport liability) {
    	customerBackgroundCheckReportRepository.save(liability);
    }

    public void deleteBackgroundCheckReport(Long id) {
    	customerBackgroundCheckReportRepository.delete(id);
    }

    public Page<BackgroundCheckReport> getAllBackgroundCheckReportsByPage(Integer page, Integer size) {
        Page pageOfBackgroundCheckReports = customerBackgroundCheckReportRepository.findAll(new PageRequest(page, size));
        
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("com.rollingstone.getAll.largePayload");
        }
        return pageOfBackgroundCheckReports;
    }
    
    public List<BackgroundCheckReport> getAllBackgroundCheckReports() {
        Iterable<BackgroundCheckReport> pageOfBackgroundCheckReports = customerBackgroundCheckReportRepository.findAll();
        
        List<BackgroundCheckReport> customerBackgroundCheckReports = new ArrayList<BackgroundCheckReport>();
        
        for (BackgroundCheckReport liability : pageOfBackgroundCheckReports){
        	customerBackgroundCheckReports.add(liability);
        }
    	log.info("In Real Service getAllBackgroundCheckReports  size :"+customerBackgroundCheckReports.size());

    	
        return customerBackgroundCheckReports;
    }
    
  
}
