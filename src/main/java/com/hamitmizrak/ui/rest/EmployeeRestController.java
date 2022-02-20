package com.hamitmizrak.ui.rest;


import com.hamitmizrak.business.dto.EmployeeDto;
import com.hamitmizrak.business.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000") //CORS
@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

    @Autowired
    public EmployeeServices employeeServices;

    //LIST
    // http://localhost:8080/api/v1/employees/list
    @GetMapping("/employees/list")
    public List<EmployeeDto> listEmployees(){
        List<EmployeeDto> employeeDtos=employeeServices.getAllEmployess();
        return  employeeDtos;
    }



    //FIND
    // http://localhost:8080/api/v1/employees/find/1
    @GetMapping("/employees/find/{id}")
    public EmployeeDto findEmployees(@PathVariable(value = "id") Long id){
        EmployeeDto employeeDto=employeeServices.find(id);
        return  employeeDto;
    }


    //POST
    // http://localhost:8080/api/v1/employees/post
    @PostMapping("/employees/post")
    public EmployeeDto postEmployees(@RequestBody  EmployeeDto employeeDto){
        employeeServices.save(employeeDto);
        return  employeeDto;
    }

    //PUT
    // http://localhost:8080/api/v1/employees/put
    @PutMapping("/employees/put")
    public void putEmployees(EmployeeDto employeeDto){
        employeeServices.save(employeeDto);
    }

    //DELETE
    // http://localhost:8080/api/v1/employees/delete/1
    @DeleteMapping ("/employees/delete/{id}")
    public void deleteEmployees( @PathVariable(value = "id") Long id){
        employeeServices.delete(id);
    }


}
