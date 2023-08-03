package com.example.ecommerce.controller;

import com.example.ecommerce.domain.Customer;
import com.example.ecommerce.service.E_CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class E_CommerceController {
    @Autowired
    E_CommerceService eCommerceService;

    //http://localhost:6666/api/v1/addCustomer
    @PostMapping("/addCustomer")
    public ResponseEntity<?> saveDetails(@RequestBody Customer customer)
    {
        Customer customer1 = eCommerceService.saveDetails(customer);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }

    //http://localhost:6666/api/v1/getCustomers
    @GetMapping("/getCustomers")
    public ResponseEntity<?>getCustomers(HttpServletRequest httpServletRequest)
    {
        int customerId = (Integer) httpServletRequest.getAttribute("attr1");
        return new ResponseEntity<>(eCommerceService.getCustomers(customerId),HttpStatus.OK);
    }

    //http://localhost:6666/api/v1/delBy/111
    @DeleteMapping("/delBy/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId)
    {
        return new ResponseEntity<>(eCommerceService.deleteCustomer(customerId),HttpStatus.OK);
    }

    //http://localhost:6666/api/v1/admin/getAllCustomers
    @GetMapping("/admin/getAllCustomers")
    public ResponseEntity<?>getAllUsersByAdmin(HttpServletRequest httpServletRequest)
    {
        if(httpServletRequest.getAttribute("attr2").equals("role-admin"))
        {
            return new ResponseEntity<>(eCommerceService.getAllUsersByAdmin(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("You are not Authorized User!!!",HttpStatus.BAD_REQUEST);
        }
    }
}
