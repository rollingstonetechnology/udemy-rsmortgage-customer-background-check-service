package com.rollingstone.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.rollingstone.domain.BackgroundCheckReport;
import com.rollingstone.exception.HTTP400Exception;
/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */
import com.rollingstone.service.RsMortgageCustomerBackgroundCheckReportService;

@RestController
@RequestMapping(value = "/rsmortgage-customer-background-check-service/v1/background-check-report")
public class CustomerBackgroundCheckReportController extends AbstractRestController {

    @Autowired
    private RsMortgageCustomerBackgroundCheckReportService customerBackgroundCheckReportService;
  
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerBackgroundCheckReport(@RequestBody BackgroundCheckReport propertyAppraisalOrder,
                                 HttpServletRequest request, HttpServletResponse response) {
    	BackgroundCheckReport createdBackgroundCheckReport = this.customerBackgroundCheckReportService.createBackgroundCheckReport(propertyAppraisalOrder);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdBackgroundCheckReport.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Page<BackgroundCheckReport> getAllCustomersBackgroundCheckReportByPage(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.customerBackgroundCheckReportService.getAllBackgroundCheckReportsByPage(page, size);
    }
    
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<BackgroundCheckReport> getAllCustomerBackgroundCheckReports(@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
    
        return this.customerBackgroundCheckReportService.getAllBackgroundCheckReports();
    }
    
  
    
    @RequestMapping("/simple/{id}")
	public BackgroundCheckReport getSimpleCustomerBackgroundCheckReport(@PathVariable("id") Long id) {
    	BackgroundCheckReport propertyAppraisalOrder = this.customerBackgroundCheckReportService.getBackgroundCheckReport(id);
         checkResourceFound(propertyAppraisalOrder);
         return propertyAppraisalOrder;
	}

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    BackgroundCheckReport getBackgroundCheckReport(@PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
    	BackgroundCheckReport propertyAppraisalOrder = this.customerBackgroundCheckReportService.getBackgroundCheckReport(id);
        checkResourceFound(propertyAppraisalOrder);
        return propertyAppraisalOrder;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomerBackgroundCheckReport(@PathVariable("id") Long id, @RequestBody BackgroundCheckReport propertyAppraisalOrder,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.customerBackgroundCheckReportService.getBackgroundCheckReport(id));
        if (id != propertyAppraisalOrder.getId()) throw new HTTP400Exception("ID doesn't match!");
        this.customerBackgroundCheckReportService.updateBackgroundCheckReport(propertyAppraisalOrder);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerBackgroundCheckReport(@PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.customerBackgroundCheckReportService.getBackgroundCheckReport(id));
        this.customerBackgroundCheckReportService.deleteBackgroundCheckReport(id);
    }
}
