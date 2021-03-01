import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class AppointmentStatus extends React.Component{
    
    state = {
        bookings:[]
        
    }
    
    componentWillMount(){
        console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/patient/status/'+this.props.match.params.patiendId).then(res=> {
            const bookings = res.data;
            this.setState({bookings})

        });
    }
    constructor(props) {
        super(props);
        console.log(this.props )
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
                        <h2 align='center'> Patient Booking Status:</h2>
                        <table align='center'>
                            <thead>
                            <tr>
                                <th>Request Id</th>
                                <th>Date</th>
                                <th>Time</th>
                                <th>Remark</th>
                                <th>Doctor Name</th>
                                <th>Service Name</th>
                                <th>Status</th>
                                <th>Booked By</th>
                                
                            </tr>
                            </thead>
                            <tbody>
                                {this.state.bookings.map(booking => <RowCreator item={booking}/>)}
                            </tbody>
                            
                        </table>

                
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
                 <td>{booking.doctorId.firstName}</td>
                 <td>{booking.diagnosticService.serviceName}</td>
                 <td>{booking.status}</td>
                 <td>{booking.agentId.firstName}</td>

             </tr>
         )
    }
}

export default AppointmentStatus;