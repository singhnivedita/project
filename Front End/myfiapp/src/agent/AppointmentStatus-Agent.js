import React from 'react';



import axios from 'axios';

import AgentHome from './AgentHome';


class AppointmentStatusAgent extends React.Component{
    
    state = {
        bookings:[]
        
    }
    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        axios.get('/agent/status/'+this.props.match.params.agentId).then(res=> {
            const bookings = res.data;
            this.setState({bookings})
           
        });
        
    }
    

	render(){
       
        
			return(
                <div>
                    <AgentHome/>
                    <div id="tableDiv"> 
                        <h2 align='center'> Patient Booking Status:</h2>
                        <table   className="table table-responsive">
                            <thead>
                            <tr>
                                <th>Request Id</th>
                                <th>Patient Name</th>
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
                 <td>{booking.patientId.firstName+' '+booking.patientId.lastName}</td>
                 <td>{booking.date}</td>
                 <td>{booking.time}</td>
                 <td>{booking.remark}</td>
                 <td>{booking.doctorId.firstName +" "+ booking.doctorId.lastName}</td>
                 <td>{booking.diagnosticService.serviceName}</td>
                 <td>{booking.status.toString()}</td>
                 <td>{booking.agentId.firstName+' '+booking.agentId.lastName}</td>

             </tr>
         )
    }
}

export default AppointmentStatusAgent;