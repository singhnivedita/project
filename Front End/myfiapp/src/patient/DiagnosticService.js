import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import PatientHome from './PatientHome';


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
                    <PatientHome/>
                     <div id="tableDiv">
                        <h2 align='center'> Diagnostic Services</h2>
                        <table id="tableWrap" className="table " >
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