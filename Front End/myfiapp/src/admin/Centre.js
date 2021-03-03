


import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import AdminHome from './AdminHome';


class DiagnosticCentre extends React.Component{
    state = {
        services:[]
    }
    componentWillMount(){
        axios.get('/admin/diagnostic-centre').then(res=> {
            const services = res.data;
            this.setState({services})

        })
    } 
	render(){
       
        
			return(
                <div>
                    <AdminHome/>
                        <div id="tableDiv">
                        <h2 align='center'> Diagnostic Centre</h2>
                        <table id="tableWrap" className="table table-responsive">
                            <thead>
                            <tr>
                            
                                <th>Id</th>
                                <th>Brief</th>
                                <th>Address</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Email</th>
                                <th>Website</th>
                                <th>Contact Info</th>
                                <th>Zip</th>
                                <th>Update</th>
                                
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
                 <td>{service.centreId}</td>
                 <td>{service.brief}</td>
                 <td>{service.address}</td>
                 <td>{service.city}</td>
                 <td>{service.state}</td>
                 <td>{service.email}</td>
                 <td>{service.website}</td>
                 <td>{service.contactno}</td>
                 <td>{service.zip}</td>
                 <td><Link to={'/update-centre/'+service.centreId}>Update</Link></td>
                 
             </tr>
         )
    }
}

export default DiagnosticCentre;