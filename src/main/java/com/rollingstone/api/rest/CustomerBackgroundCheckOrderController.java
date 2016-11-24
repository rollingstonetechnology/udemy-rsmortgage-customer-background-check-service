package com.rollingstone.api.rest;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.rollingstone.domain.Customer;
import com.rollingstone.domain.BackgroundCheckOrder;
import com.rollingstone.domain.BackgroundCheckOrderDetail;
import com.rollingstone.exception.HTTP400Exception;
/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */
import com.rollingstone.service.RsMortgageCustomerBackgroundCheckOrderService;

@RestController
@RequestMapping(value = "/rsmortgage-customer-background-check-service/v1/background-check-order")
public class CustomerBackgroundCheckOrderController extends AbstractRestController {

    private static final Logger log = LoggerFactory.getLogger(CustomerBackgroundCheckOrderController.class);

    
    @Autowired
    private RsMortgageCustomerBackgroundCheckOrderService customerBackgroundCheckOrderService;
  
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerBackgroundCheckOrder(@RequestBody BackgroundCheckOrder backgroundCheckOrder,
                                 HttpServletRequest request, HttpServletResponse response) {
    	
    	Set<BackgroundCheckOrderDetail> details = backgroundCheckOrder.getPastYearsAddresses();
    	if (details != null){
    		log.info("Controller Size of Details :"+details.size());
    	}
    	else {
    		log.info("Details is null");
    	}
    	
    	
    	BackgroundCheckOrder createdBackgroundCheckOrder = this.customerBackgroundCheckOrderService.createBackgroundCheckOrder(backgroundCheckOrder);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdBackgroundCheckOrder.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<BackgroundCheckOrder> getAllCustomersBackgroundCheckOrderByPage(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.customerBackgroundCheckOrderService.getAllBackgroundCheckOrdersByPage(page, size);
    }
    
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<BackgroundCheckOrder> getAllCustomerBackgroundCheckOrders(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
    
        return this.customerBackgroundCheckOrderService.getAllBackgroundCheckOrders();
    }
    
  
    
    @RequestMapping("/simple/{id}")
	public BackgroundCheckOrder getSimpleCustomerBackgroundCheckOrder(@PathVariable("id") Long id) {
    	BackgroundCheckOrder backgroundCheckOrder = this.customerBackgroundCheckOrderService.getBackgroundCheckOrder(id);
         checkResourceFound(backgroundCheckOrder);
         return backgroundCheckOrder;
	}

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    BackgroundCheckOrder getBackgroundCheckOrder(@PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
    	BackgroundCheckOrder backgroundCheckOrder = this.customerBackgroundCheckOrderService.getBackgroundCheckOrder(id);
        checkResourceFound(backgroundCheckOrder);
        return backgroundCheckOrder;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomerBackgroundCheckOrder(@PathVariable("id") Long id, @RequestBody BackgroundCheckOrder backgroundCheckOrder,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.customerBackgroundCheckOrderService.getBackgroundCheckOrder(id));
        if (id != backgroundCheckOrder.getId()) throw new HTTP400Exception("ID doesn't match!");
        this.customerBackgroundCheckOrderService.updateBackgroundCheckOrder(backgroundCheckOrder);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerBackgroundCheckOrder(@PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.customerBackgroundCheckOrderService.getBackgroundCheckOrder(id));
        this.customerBackgroundCheckOrderService.deleteBackgroundCheckOrder(id);
    }
}
