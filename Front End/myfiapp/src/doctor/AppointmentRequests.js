import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';

import DoctorHome from './DoctorHome';


class AppointmentRequests extends React.Component{
    
    state = {
        bookings:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/doctor/appointment/'+this.props.match.params.doctorId).then(res=> {
            const bookings = res.data;
            this.setState({bookings})

        });
    }
    

	render(){
       
        
			return(
                <div>
                    <DoctorHome/> 
                        
                        <div id="tableDiv">
                        <h2 align='center'> Booking Appointment Requests</h2>
                            <table  id="tableWrap" className="table table-responsive">
                            <thead>
                            <tr>
                                <th>Request Id</th>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Remark</th>
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
                 {/* <td>{booking.doctorId.firstName}</td> */}
                 <td>{booking.diagnosticService.serviceName}</td>
                 
                 <td><Link to={"/approve/"+booking.status}>Appproved</Link></td>

             </tr>
         )
    }
}

export default AppointmentRequests;