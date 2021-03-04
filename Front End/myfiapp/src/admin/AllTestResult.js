import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import AdminHome from './AdminHome';


class AllTestResult extends React.Component{
    
    state = {
        tests:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/admin/all-test/').then(res=> {
            const tests = res.data;
            this.setState({tests})

            //localStorage.setItem('patientId', res.data.patientId.patientId);

            //const patientId = localStorage.getItem('patientId');
        //this.setState({userId})
        //console.log(patientId)

        });
    }
    

	render(){
       
        
			return(
                <div>
                    <AdminHome/> 
                    <div id="tableDiv">
                        <h2 align='center'> Test Result</h2>
                        <table  id="tableWrap" className="table table-responsive">
                            <thead>
                            <tr>
                                <th>Test Id</th>
                                <th>Patient Id</th>
                                {/* <th>Patient Name</th> */}
                                <th>Test Name</th>
                                <th>Test Result</th>
                                <th>Service</th>
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
         //localStorage.setItem('patientId', res.data.patientId.patientId);
         return(
             <tr>
                 <td>{test.testId}</td>
                 <td>{test.patientId.patientId}</td>
                 
                 {/* <td>{test.patientId.firstName+' '+patientId.lastName}</td> */}
                 <td>{test.testName}</td>
                 <td>{test.testResult}</td>
                 <td>{test.diagnosticServiceId.serviceName}</td>
                 <td><Link to={'/update-test-result-admin/'+test.testId}>Update</Link></td>
                 

             </tr>
         )
    }
}

export default AllTestResult;