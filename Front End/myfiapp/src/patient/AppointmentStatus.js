import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import PatientHome from './PatientHome';


class AppointmentStatus extends React.Component{
    
    state = {
        bookings:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/patient/status/'+this.props.match.params.patientId).then(res=> {
            const bookings = res.data;
            this.setState({bookings})
           
        });
        
    }
    

	render(){
       
        
			return(
                <div>
                    <PatientHome/>
                    <div id="tableDiv"> 
                        <h2 align='center'> Patient Booking Status:</h2>
                        <table   className="table table-responsive">
                            <thead>
                            <tr>
                                <th>Request Id</th>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Remark</th>
                                <th>Doctor Name</th>
                                <th>Service Name</th>
                                <th>Status</th>
                                
                                
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
                 <td>{booking.requestId}</td>
                 <td>{booking.date}</td>
                 <td>{booking.time}</td>
                 <td>{booking.remark}</td>
                 <td>{booking.doctorId.firstName +" "+ booking.doctorId.lastName}</td>
                 <td>{booking.diagnosticService.serviceName}</td>
                 <td>{booking.status.toString()}</td>
                 {/* <td>{booking.agentId.firstName+' '+booking.agentId.lastName}</td> */}

             </tr>
         )
    }
}

export default AppointmentStatus;