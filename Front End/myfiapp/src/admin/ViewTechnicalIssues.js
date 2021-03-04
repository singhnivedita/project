import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import AdminHome from './AdminHome';


class ViewTechnicalIssues extends React.Component{
    state = {
        services:[]
    }
    componentWillMount(){
        axios.get('/admin/view-issue').then(res=> {
            const services = res.data;
            this.setState({services})

        })
    } 
	render(){
       
        
			return(
                <div>
                    <AdminHome/>
                     <div id="tableDiv">
                        <h2 align='center'>Technical Issues</h2>
                        <table id="tableWrap" className="table " >
                            <thead>
                            <tr>
                                <th> Issue Id</th>
                                <th>Issue</th>
                                <th>Issue Description</th>
                                <th>Reportee Role</th>
                                <th>Reportee Id</th>
                                
                                
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
                 <td>{service.issueId}</td>
                 <td>{service.issues}</td>
                 <td>{service.description}</td>
                 <td>{service.role}</td>
                 <td>{service.yourId}</td>
                 
                 
             </tr>
         )
    }
}

export default ViewTechnicalIssues;