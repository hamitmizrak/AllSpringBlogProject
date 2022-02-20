package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.EmployeeDto;
import com.hamitmizrak.business.services.EmployeeServices;
import com.hamitmizrak.data.entity.EmployeeEntity;
import com.hamitmizrak.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapperBean modelMapperBean;


    //SAVE
    @Override
    public void save(@RequestBody EmployeeDto employeeDto) {//@RequestBody
     EmployeeEntity employeeEntity=DtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);
    }

    //DELETE
    @Override
    public void delete(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    //FIND
    @Override
    public EmployeeDto find(Long employeeId) {

        EmployeeDto employeeDto=new EmployeeDto();
       Optional<EmployeeEntity>  optional=  employeeRepository.findById(employeeId);

       if(optional.isPresent()){
           EmployeeEntity employeeEntity=optional.get();
           employeeDto=EntityToDto(employeeEntity);//model mapper
       }else{
           employeeDto=EmployeeDto
                   .builder()
                   .id(0L)
                   .firstName("adınız")
                   .lastName("soyadınız")
                   .emailAddress("email adresiniz")
                   .build();
       }
        return employeeDto;
    }

    //LIST
    @Override
    public Iterable<EmployeeDto> getAllEmployess() {
        List<EmployeeDto>  listDto=new ArrayList<>();
        Iterable<EmployeeEntity> employeeEntities=employeeRepository.findAll();
        for(EmployeeEntity temp :employeeEntities ){
            EmployeeDto employeeDto=EntityToDto(temp);
            listDto.add(employeeDto);

        }
        return listDto;
    }

    //model Mapper
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        return null;
    }

    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        return null;
    }
}
