import React from 'react';



// import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class AgentHome extends React.Component{

    state ={};
    componentDidMount() {
        
        const userId = localStorage.getItem('userId');
        this.setState({userId})
        console.log("userid in home page is "+userId);
        // axios.get("menuapp/menu-items").then(
        //     res =>{
        //         this.setState({
        //             patientData = res.data
        //         })
        //     }
        // ).catch(
        //     err => {
        //         console.log(err);
        //     }
        // )
        // console.log(data);
    }
	render(){
       
        
			return(
                
                    <div className="wrapper d-flex">
                    <div className="sidebar"> <small className="text-muted pl-4"></small>
                        <ul className="list-bullet-no">
                            <li><Link to={'#'}><i className="fa fa-home"></i>Agent Dashboard</Link></li>
                            
                        </ul>
                        <ul className="list-bullet-no">
                        <li><Link to={'/diagnostic-service-agent'}>Diagnostic Service</Link></li>
                            <li><Link to={'/booking-agent'}>Book Appointment</Link></li>
                            <li><Link to={'/appointment-status-agent/'+this.state.userId}>Book Appointment Status</Link></li>
                            
                            <li><Link to={'/view-commission-agent/'+this.state.userId}>View Commission</Link></li>
                        </ul>
                        <small className="text-muted px-3">OTHERS</small>
                        
                        <ul>
                            <li><Link to={"/issue-reporting-agent"}><i class="fa fa-exclamation-triangle"></i> Report Technical Issue</Link></li>
                        </ul>
                    </div>
                </div>
               
                );
		

		
		
	}
}

export default AgentHome;