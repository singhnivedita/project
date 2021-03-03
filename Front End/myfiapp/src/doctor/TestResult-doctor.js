import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import DoctorHome from './DoctorHome';


class TestResultDoctor extends React.Component{
    
    state = {
        tests:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/doctor/treatment-history/'+this.props.match.params.doctorId).then(res=> {
            const tests = res.data;
            this.setState({tests})

        });
    }
    

	render(){
       
        
			return(
                <div>
                    <DoctorHome/> 
                        <h2 align='center'> Test Result</h2>
                        <table  id="initialWrap">
                            <thead>
                            <tr>
                                <th>Test Id</th>
                                <th>Test Name</th>
                                <th>Test Result</th>
                                <th>Service</th>
                                <th>Update Test Result</th>
                                
                                
                            </tr>
                            </thead>
                            <tbody>
                                {this.state.tests.map(test => <RowCreator item={test}/>)}
                            </tbody>
                            
                        </table>

                
                        </div>
        
                    
                );
		

		
		
	}
}

class RowCreator extends React.Component{
    render(){
         var test = this.props.item;
         return(
             <tr>
                 <td>{test.testresultId.testId}</td>
                 <td>{test.testresultId.testName}</td>
                 <td>{test.testresultId.testResult}</td>
                 <td>{test.testresultId.diagnosticServiceId.serviceName}</td>
                 <td><Link to={"/update-testresult-doctor/"}>Update</Link></td>
                 

             </tr>
         )
    }
}

export default TestResultDoctor;