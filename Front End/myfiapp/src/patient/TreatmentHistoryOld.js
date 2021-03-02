import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class TreatmentHistoryOld extends React.Component{
    
    state = {
        treatments:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/patient/treatment-history/'+this.props.match.params.patientId).then(res=> {
            const treatments = [res.data];
            this.setState({treatments})

        });
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
                        <h2 align='center'> Treatment History</h2>
                        <table  id="initialWrap">
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
                 <td>{treatment.diagnosticService.serviceName}</td>

             </tr>
         )
    }
}

export default TreatmentHistoryOld;