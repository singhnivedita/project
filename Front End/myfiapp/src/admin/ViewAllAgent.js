import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import AdminHome from './AdminHome';


class ViewAgent extends React.Component{
    state = {
        services:[]
    }
    componentWillMount(){
        axios.get('/admin/all-agent').then(res=> {
            const services = res.data;
            this.setState({services})

        })
    } 
	render(){
       
        
			return(
                <div>
                    <AdminHome/>
                     <div id="tableDiv">
                        <h2 align='center'> Agent List</h2>
                        <span className="float-right"><Link to={'/create-agent'}>Create New Agent</Link></span>
                        <table id="tableWrap" className="table table-responsive" >
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Phone </th>
                                <th>Email</th>
                                <th>Bank Name</th>
                                <th>Account Number </th>
                                <th>IFSC</th>
                                
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
                 <td>{service.agentId}</td>
                 <td>{service.firstName+' '+service.lastName}</td>
                 <td>{service.contactNumber}</td>
                 <td>{service.email}</td>
                 <td>{service.bankName}</td>
                 <td>{service.bankAccNo}</td>
                 <td>{service.ifsc}</td>
                 
             </tr>
         )
    }
}

export default ViewAgent;