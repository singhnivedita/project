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
                            <li><Link to={"/adminHome"}><i className="fa fa-home"></i>Admin Dashboard</Link></li>
                            <li><Link to={"/create-diagnostic-Service"}><i className="fa fa-credit-card"></i> Create Diagnostic Services</Link></li>
                        </ul> <small className="text-muted px-3">APPOINTMENT</small>
                        <ul className="list-bullet-no">
                            
                            <li><Link to={"/create-agent"}><i className="fa fa-credit-card"></i>Create Agent</Link></li>
                        </ul> <small className="text-muted px-3">TEST RESULTS</small>
                        <ul className="list-bullet-no">
                            <li><Link to={"/update-test-result"}><i className="fa fa-credit-card"></i>Update Test Result</Link></li>
                            <li><Link to={"/update-commission"}><i className="fa fa-credit-card"></i>Update Commission</Link></li>
                         </ul>
                         <ul className="list-bullet-no">
                            <li><Link to={"/create-questions"}><i className="fa fa-credit-card"></i>Create Review Questionarie</Link></li>
                            <li><Link to={"/generate-report"}><i className="fa fa-credit-card"></i>Generate Report</Link></li>
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