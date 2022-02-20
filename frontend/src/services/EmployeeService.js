import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/employees";

class EmployeeService {

    //LISTE   http://localhost:8080/api/v1/employees
    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

    //FIND  http://localhost:8080/api/v1/employees/1
    getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    }

    //CREATE    http://localhost:8080/api/v1/employees
    createEmployee(employee){
        return axios.post(EMPLOYEE_API_BASE_URL, employee);
    }

    //UPDATE   http://localhost:8080/api/v1/employees/1
    updateEmployee(employee, employeeId){
        return axios.put(EMPLOYEE_API_BASE_URL + '/' + employeeId, employee);
    }

    //DELETE  http://localhost:8080/api/v1/employees/1
    deleteEmployee(employeeId){
        return axios.delete(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    }
}

export default new EmployeeService()