import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class DiagnosticService extends React.Component{
    state = {
        services:[]
    }
    componentWillMount(){
        axios.get('/patient/diagnostic-service').then(res=> {
            const services = res.data;
            this.setState({services})

        })
    } 
	render(){
       
        
			return(
                <div>
                    <div className="wrapper d-flex">
                    <div className="sidebar"> <small className="text-muted pl-4"></small>
                        <ul className="list-bullet-no">
                            <li><a href="#"><i className="fa fa-home"></i>Patient Dashboard</a></li>
                            <li><a href="#"><i className="fa fa-credit-card"></i> Diagnostic Services </a></li>
                        </ul> <small className="text-muted px-3">APPOINTMENT</small>
                        <ul className="list-bullet-no">
                            <li><a href="#"><i className="far fa-calendar-alt"></i>Book Appointment</a></li>
                            <li><a href="#"><i className="fas fa-video"></i>Appointment Status</a></li>
                        </ul> <small className="text-muted px-3">TEST REPORTS</small>
                        <ul className="list-bullet-no">
                            <li><a href="#"><i className="fa fa-external-link-alt"></i>Test Results</a></li>
                            <li><a href="#"><i className="fa fa-help"></i>Treatment History</a></li>
                        </ul> 
                        {/*<small className="text-muted px-3">OTHERS</small>
                        
                        <ul>
                            <li><a href="#"><i className="fa fa-external-link-alt"></i>Help</a></li>
                        </ul>*/} 
                    </div>
                    </div> 
                        <h2 align='center'> Diagnostic Services</h2>
                        <table align='center'>
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Cost</th>
                                <th>Time</th>
                                <th>Instruction</th>
                                
                            </tr>
                            </thead>
                            <tbody>
                                {this.state.services.map(service => <RowCreator item={service}/>)}
                            </tbody>
                            
                        </table>

                
                        </div>
        
                    
                );
		

		
		
	}
}

class RowCreator extends React.Component{
    render(){
         var service = this.props.item;
         return(
             <tr>
                 <td>{service.serviceId}</td>
                 <td>{service.serviceName}</td>
                 <td>{service.cost}</td>
                 <td>{service.time}</td>
                 <td>{service.instruction}</td>
                 
             </tr>
         )
    }
}

export default DiagnosticService;