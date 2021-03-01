import React from 'react';



// import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class PatientHome extends React.Component{

    // state ={};
    // componentDidMount() {
        
    //     axios.get("menuapp/menu-items").then(
    //         res =>{
    //             this.setState({
    //                 patientData = res.data
    //             })
    //         }
    //     ).catch(
    //         err => {
    //             console.log(err);
    //         }
    //     )
    //     console.log(data);
    //}
	render(){
       
        
			return(
                
                    <div className="wrapper d-flex">
                    <div className="sidebar"> <small className="text-muted pl-4"></small>
                        <ul className="list-bullet-no">
                            <li><a href="#"><i className="fa fa-home"></i>Patient Dashboard</a></li>
                            <li><Link to={"/diagnosticService"}><i className="fa fa-credit-card"></i>Diagnostic Services</Link></li>
                        </ul> 
                        <small className="text-muted px-3">APPOINTMENT</small>
                        <ul className="list-bullet-no">
                            <li><a href="#"><i className="far fa-calendar-alt"></i>Book Appointment</a></li>
                            <li><a href="#"><i className="fas fa-video"></i>Appointment Status</a></li>
                        </ul> <small className="text-muted px-3">TEST REPORTS</small>
                        <ul className="list-bullet-no">
                            <li><a href="#"><i className="fa fa-external-link-alt"></i>Test Results</a></li>
                            <li><a href="#"><i className="fa fa-help"></i>Treatment History</a></li>
                        </ul> {/*<small className="text-muted px-3">OTHERS</small>
                        
                        <ul>
                            <li><a href="#"><i className="fa fa-external-link-alt"></i>Help</a></li>
                        </ul> */}
                    </div>
                </div>
            
        
                    
                );
		

		
		
	}
}

export default PatientHome;