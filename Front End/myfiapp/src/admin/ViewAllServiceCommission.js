import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import AdminHome from './AdminHome';


class ViewAllServiceCommission extends React.Component{
    
    state = {
        tests:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/admin/view-commission').then(res=> {
            const tests = res.data;
            this.setState({tests})

        });
    }
    

	render(){
       
        
			return(
                <div>
                    <AdminHome/> 
                    <div id="tableDiv">
                        <h2 align='center'> View Commission</h2>
                        <table  id="tableWrap" className="table ">
                            <thead>
                            <tr>
                                <th>Commission Id</th>
                                <th>Service Name</th>
                                <th>BaseLine Value</th>
                                <th>Update</th>
                                
                                
                            </tr>
                            </thead>
                            <tbody>
                                {this.state.tests.map(test => <RowCreator item={test}/>)}
                            </tbody>
                            
                        </table>

                </div>
                        </div>
        
                    
                );
		

		
		
	}
}

class RowCreator extends React.Component{
    render(){
         var test = this.props.item;
         return(
             <tr>
                 <td>{test.commissionId}</td>
                 <td>{test.diagnosticServiceId.serviceName}</td>
                 
                 <td>{test.baselineValue}</td>
                 <td><Link to={'/update-service-baseline/'+test.diagnosticServiceId.serviceId}>Update</Link></td>
                 

             </tr>
         )
    }
}

export default ViewAllServiceCommission;