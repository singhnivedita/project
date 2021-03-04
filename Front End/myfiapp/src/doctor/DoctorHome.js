import React from 'react';



// import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class DoctorHome extends React.Component{

    state ={};
     componentDidMount() {
        const userId = localStorage.getItem('userId');
        this.setState({userId})
        console.log("userid in home page is "+userId);
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
    }
	render(){
       
       
			return(
                
                    <div className="wrapper d-flex">
                    <div className="sidebar"> <small className="text-muted pl-4"></small>
                        <ul  className="list-bullet-no">
                            <li className="active"><Link to={"/doctorHome"}><i className="fa fa-home"></i>Doctor Dashboard</Link></li>
                            
                        </ul> 
                        <ul className="list-bullet-no">
                            <li><Link to={"/appointment-request/"+this.state.userId}>Appointment Request</Link></li>
                            <li><Link to={"/test-result-doctor/"+this.state.userId}>Test Result</Link></li>
                            <li><Link to={"/treatment-history-doctor/"+this.state.userId}>Treatment History</Link></li>
                            <li><Link to={"/patient-record/"+this.state.userId}>Patient Record</Link></li>
                        </ul> 
                        <small className="text-muted px-3">OTHERS</small>
                        
                        <ul>
                            <li><Link to={"/issue-reporting-doctor"}><i class="fa fa-exclamation-triangle"></i> Report Technical Issue</Link></li>
                        </ul>
                    </div>
                </div>
            
        
                    
                );
		

		
		
	}
}

export default DoctorHome;