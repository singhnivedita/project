import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import PatientHome from './PatientHome';



class TreatmentHistory extends React.Component{
    
    state = {
        treatments:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/patient/treatment-history/'+this.props.match.params.patientId).then(res=> {
            const treatments = [res.data];
            // this.state = {treatments :[]}
            this.setState({treatments})

            console.log("Something is printing")
            console.log(treatments)

        });
    }
    

	render(){
       
        
			return(
                <div>
                    <PatientHome/> 
                    <div id="tableDiv">
                        <h2 align='center'> Treatment History</h2>
                        <table  id="tableWrap" className="table table-responsive">
                            <thead>
                            <tr>
                                <th>Treatment Id</th>
                                <th>Symptoms</th>
                                <th>Diagnosis</th>
                                <th>Precription</th>
                                <th>Recommendation</th>
                                <th>Diet</th>
                                <th>Doctor Name</th>
                                <th>Test </th>
                                <th>Service </th>
                                
                                
                            </tr>
                            </thead>
                            <tbody>
                                {this.state.treatments.map(treatment => <RowCreator item={treatment}/>)}
                            </tbody>
                            
                        </table>
                        </div>

                
                        </div>
        
                    
                );
		

		
		
	}
}

class RowCreator extends React.Component{
    render(){
         var treatment = this.props.item;
         return(
             <tr>
                 <td>{treatment.treatmentId}</td>
                 <td>{treatment.symptoms}</td>
                 <td>{treatment.diagnosis}</td>
                 <td>{treatment.precription}</td>
                 
                 
                 <td>{treatment.recommendation}</td>
                 <td>{treatment.diet}</td>
                 <td>{treatment.doctorId.firstaName}</td>
                 <td>{treatment.testresultId.testName}</td>
                 <td>{treatment.diagnosticServiceId .serviceName}</td>
                 

             </tr>
         )
    }
}

export default TreatmentHistory;