import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService'

class ListEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                employees: []
        }
        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
        this.deleteEmployee = this.deleteEmployee.bind(this);
    }

    //ADD
    addEmployee(){
        this.props.history.push('/add-employee/_add');
    }

    //DELETE
    deleteEmployee(id){
        EmployeeService.deleteEmployee(id).then( res => {
            this.setState({employees: this.state.employees.filter(employee => employee.id !== id)});
        });
    }

    //VIES
    viewEmployee(id){
        this.props.history.push(`/view-employee/${id}`);
    }

    //EDIT
    editEmployee(id){
        this.props.history.push(`/add-employee/${id}`);
    }

    //DIDMOUNT: service database
    componentDidMount(){
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data});
        });
    }


//RENDER:ekranda gösterme
    render() {
        return (
            <div>
                 <h2 className="text-center"> Listem</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addEmployee}> EKLEME</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Adı</th>
                                    <th> soyadı</th>
                                    <th> Email</th>
                                    <th> CRUD </th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.employees.map(
                                        employee => 
                                        <tr key = {employee.id}>
                                             <td> { employee.firstName} </td>   
                                             <td> {employee.lastName}</td>
                                             <td> {employee.emailId}</td>
                                             <td>
                                                 <button onClick={ () => this.editEmployee(employee.id)} className="btn btn-info">Güncelle </button>
                                                 <button style={{marginLeft: "15px"}} onClick={ () => this.deleteEmployee(employee.id)} className="btn btn-danger">Sil </button>
                                                 <button style={{marginLeft: "15px"}} onClick={ () => this.viewEmployee(employee.id)} className="btn btn-warning">Göster </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListEmployeeComponent
