import React from 'react';
import {Link} from "react-router-dom";

import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();



class Nav extends React.Component{
    componentWillMount(){
        const userId = localStorage.getItem('userId');
        const firstname = localStorage.getItem('firstname');
        this.setState({userId})
        this.setState({firstname})
        console.log(firstname)

        
    } 

    handleLogout= () =>{
        localStorage.clear();
        this.state.userId = null;
        console.log("Logged out")
        toast.info("Logged Out Successfully",{autoClose:4000,position:toast.POSITION.TOP_CENTER});

    }
	render(){
        let buttons;
        if(this.state.userId !=null ){

            buttons =(  
                        <ul className="navbar-nav ml-auto"> 
                        <li className="nav-item"> 
                        
                            <Link to={"#"} className="nav-link"><i className = "fa fa-user"></i> {this.state.firstname}</Link> 
                        </li>&nbsp;&nbsp;&nbsp;&nbsp;
                        <li className="nav-item"> 
                        
                            <Link to={"/"} onClick = {this.handleLogout} className="nav-link"><i className = "fa fa-sign-out"></i>Logout</Link> 
                        </li> 
                        
                    </ul>
                  )
                  

        }else{
                  buttons =(  <ul className="navbar-nav ml-auto"> 
                        <li className="nav-item"> 
                        
                            <Link to={"/"} className="nav-link"><i className = "fa fa-user-md"></i> Patient</Link> 
                        </li> &nbsp;
                        <li className="nav-item"> 
                           
                            <Link to={"/agentLogin"} className="nav-link"><i className=" fa fa-lock"></i> Agent</Link> 
                        </li> &nbsp;
                        <li className="nav-item"> 
                        
                            <Link to={"/doctorLogin"} className="nav-link"><i className = "fa fa-user-md"></i> Doctor</Link> 
                        </li> &nbsp;
                        <li className="nav-item"> 
                           
                            <Link to={"/adminLogin"} className="nav-link"><i className=" fa fa-lock"></i> Admin</Link> 
                        </li> 
                        
                    </ul>
                  )
        }
		return(
			<div>
			<nav className="navbar navbar-expand-sm ">
  
                <span className="navbar-brand" > <i className = "fa fa-heartbeat"></i>   Diagnostic Medical Center </span>
                <button className="navbar-toggler custom-toggler" type="button" data-toggle="collapse" data-target="#navI" aria-controls="navI" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navI">
                    {buttons}
                </div>
                </nav>
			</div>

			
		);
		
	}
}

export default Nav;