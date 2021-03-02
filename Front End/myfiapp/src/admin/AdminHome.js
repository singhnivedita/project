import React from 'react';



// import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class AdminHome extends React.Component{
    state ={};
    componentDidMount() {
       const userId = localStorage.getItem('userId');
       this.setState({userId})
       console.log("userid in home page is "+userId);
    }
    
	render(){
       
        
			return(
                
                    <div className="wrapper d-flex " id="dashWrap">
                    <div className="sidebar"> <small className="text-muted pl-4"></small>
                        <ul className="list-bullet-no">
                            <li><a href="#"><i className="fa fa-home"></i>Admin Dashboard</a></li>
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
                        </ul> */}
                    </div>
                </div>
            
        
                    
                );
		
			
		}

		
		
	
}

export default AdminHome;