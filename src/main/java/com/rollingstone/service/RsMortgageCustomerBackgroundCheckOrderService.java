package com.rollingstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.jpa.RsMortgageCustomerBackgroundCheckOrderRepository;
import com.rollingstone.domain.BackgroundCheckOrder;
import com.rollingstone.domain.BackgroundCheckOrderDetail;


/*
 * Service class to do CRUD for Customer BackgroundCheckOrder through JPS Repository
 */
@Service
public class RsMortgageCustomerBackgroundCheckOrderService {

    private static final Logger log = LoggerFactory.getLogger(RsMortgageCustomerBackgroundCheckOrderService.class);

    @Autowired
    private RsMortgageCustomerBackgroundCheckOrderRepository customerBackgroundCheckOrderRepository;
    
  
    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public RsMortgageCustomerBackgroundCheckOrderService() {
    }

    public BackgroundCheckOrder createBackgroundCheckOrder(BackgroundCheckOrder backgroundCheckOrder) {
    	Set<BackgroundCheckOrderDetail> details = backgroundCheckOrder.getPastYearsAddresses();
    	if (details != null){
    		log.info("Size of Details :"+details.size());
    	}
    	else {
    		log.info("Details is null");
    	}
    	
        return customerBackgroundCheckOrderRepository.save(backgroundCheckOrder);
    }

    public BackgroundCheckOrder getBackgroundCheckOrder(long id) {
        return customerBackgroundCheckOrderRepository.findOne(id);
    }

    public void updateBackgroundCheckOrder(BackgroundCheckOrder backgroundCheckOrder) {
    	customerBackgroundCheckOrderRepository.save(backgroundCheckOrder);
    }

    public void deleteBackgroundCheckOrder(Long id) {
    	customerBackgroundCheckOrderRepository.delete(id);
    }

    public Page<BackgroundCheckOrder> getAllBackgroundCheckOrdersByPage(Integer page, Integer size) {
        Page pageOfBackgroundCheckOrders = customerBackgroundCheckOrderRepository.findAll(new PageRequest(page, size));
        
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("com.rollingstone.getAll.largePayload");
        }
        return pageOfBackgroundCheckOrders;
    }
    
    public List<BackgroundCheckOrder> getAllBackgroundCheckOrders() {
        Iterable<BackgroundCheckOrder> pageOfBackgroundCheckOrders = customerBackgroundCheckOrderRepository.findAll();
        
        List<BackgroundCheckOrder> customerBackgroundCheckOrders = new ArrayList<BackgroundCheckOrder>();
        
        for (BackgroundCheckOrder backgroundCheckOrder : pageOfBackgroundCheckOrders){
        	customerBackgroundCheckOrders.add(backgroundCheckOrder);
        }
    	log.info("In Real Service getAllBackgroundCheckOrders  size :"+customerBackgroundCheckOrders.size());

    	
        return customerBackgroundCheckOrders;
    }
    
}
