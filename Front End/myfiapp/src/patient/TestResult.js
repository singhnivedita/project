import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import PatientHome from './PatientHome';


class TestResult extends React.Component{
    
    state = {
        tests:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/patient/test-result/'+this.props.match.params.patientId).then(res=> {
            const tests = res.data;
            this.setState({tests})

        });
    }
    

	render(){
       
        
			return(
                <div>
                    <PatientHome/> 
                    <div id="tableDiv">
                        <h2 align='center'> Test Result</h2>
                        <table  id="tableWrap" className="table ">
                            <thead>
                            <tr>
                                <th>Test Id</th>
                                <th>Test Name</th>
                                <th>Test Result</th>
                                <th>Service</th>
                                
                                
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
                 <td>{test.testId}</td>
                 <td>{test.testName}</td>
                 <td>{test.testResult}</td>
                 <td>{test.diagnosticServiceId.serviceName}</td>
                 

             </tr>
         )
    }
}

export default TestResult;