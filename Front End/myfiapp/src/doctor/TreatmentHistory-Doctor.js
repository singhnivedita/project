import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';

import DoctorHome from './DoctorHome';


class TreatmentHistoryDoctor extends React.Component{
    
    state = {
        bookings:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/doctor/treatment-history/'+this.props.match.params.doctorId).then(res=> {
            const bookings = res.data;
            this.setState({bookings})

        });
    }
    

	render(){
       
        
			return(
                <div>
                    <DoctorHome/> 
                        
                        <div id="tableDiv">
                        <h2 align='center'> Treatment History</h2>
                            <table  id="tableWrap" className="table table-responsive">
                            <thead>
                            <tr>
                            
                                <th>Name</th>
                                
                                <th>Symptoms</th>
                                <th>Diagnosis</th>
                                <th>Service Name</th>
                                
                                <th>Update Treatment</th>
                                
                                
                            </tr>
                            </thead>
                            <tbody>
                                {this.state.bookings.map(booking => <RowCreator item={booking}/>)}
                            </tbody>
                            
                        </table>
                        </div>

                
                        </div>
        
                    
                );
		

		
		
	}
}

class RowCreator extends React.Component{
    render(){
         var booking = this.props.item;
         return(
             <tr>
                 
                 <td>{booking.patientId.firstName+' '+booking.patientId.lastName}</td>
                 
                 
                 <td>{booking.symptoms}</td>
                 <td>{booking.diagnosis}</td>
                 {/* <td>{booking.doctorId.firstName}</td> */}
                 <td>{booking.diagnosticServiceId.serviceName}</td>
                 
                 <td><Link to={"/update-treatment-doctor"}>Update </Link></td>

             </tr>
         )
    }
}

export default TreatmentHistoryDoctor;