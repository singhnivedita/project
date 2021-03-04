import React from 'react';



// import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class PatientHome extends React.Component{

    state ={};
     componentDidMount() {
        const userId = localStorage.getItem('userId');
        this.setState({userId})
        console.log("userid in home page is "+userId);
    
    }
	render(){
       
        
			return(
                
                    <div className="wrapper d-flex">
                    <div className="sidebar"> <small className="text-muted pl-4"></small>
                        <ul className="list-bullet-no">
                            <li><a href="#"><i className="fa fa-home"></i>Patient Dashboard</a></li>
                            
                        </ul> 
                        
                        <ul className="list-bullet-no">
                        <li><Link to={"/diagnosticService"}><i className="fa fa-credit-card"></i> Diagnostic Services</Link></li>
                            <li><Link to={"/appointment-booking"}><i className="fa fa-credit-card"></i> Book Appointment</Link></li>
                            <li> <Link to={"/appointment-status/"+this.state.userId}><i className="fa fa-credit-card"></i> Appointment Status</Link></li>
                            <li> <Link to={"/test-result/"+this.state.userId}><i className="fa fa-credit-card"></i> Test Results</Link></li>
                            <li><Link to={"/treatment-history/"+this.state.userId}><i className="fa fa-credit-card"></i> Treatment History</Link></li>
                        </ul> 
                        
                        
                        <small className="text-muted px-3">OTHERS</small>
                        
                        <ul>
                            <li><Link to={"/issue-reporting-patient"}>Report Technical Issue</Link></li>
                        </ul>
                    </div>
                </div>
            
        
                    
                );
		

		
		
	}
}

export default PatientHome;