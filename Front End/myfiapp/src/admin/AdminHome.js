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
                        <ul className="list-bullet-no" >
                            <li><Link to={"/adminHome"}><i className="fa fa-home"></i>Admin Dashboard</Link></li>
                            <li><Link to={"/view-centre"}> View Diagnostic Centre</Link></li>
                            <li><Link to={"/add-services"}>Add Diagnostic Services</Link></li>
                        
                        
                            
                            <li><Link to={"/view-agent"}>View Agent</Link></li>
                        
                        
                            <li><Link to={"/view-test-admin"}>View Test Result</Link></li>
                            <li><Link to={"/view-all-commission-admin"}>Commission</Link></li>
                         
                         
                            <li><Link to={"/view-review-question"}>Review Questionarie</Link></li>
                            <li><Link to={"#"}><i className="fa fa-credit-card"></i> Generate Report</Link></li>
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