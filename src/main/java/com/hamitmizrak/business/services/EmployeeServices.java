package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.EmployeeDto;
import com.hamitmizrak.data.entity.EmployeeEntity;

public interface EmployeeServices {

    //CRUD
    public void save(EmployeeDto employeeDto);
    public void delete(Long employeeId);
    public EmployeeDto find(Long employeeId);
    public Iterable<EmployeeDto> getAllEmployess();

    //model mapper
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity);
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto);


}
