import React from 'react';
import {Link} from "react-router-dom";



class Nav extends React.Component{
    handleLogout= () =>{
        localStorage.clear();
        this.props.setUser(null);
        console.log("Logged out")

    }
	render(){
        let buttons;
        if(this.props.userInfo != null){

            buttons =(  
                        <ul className="navbar-nav ml-auto"> 
                        <li className="nav-item"> 
                        
                            <Link to={"#"} className="nav-link"><i className = "fa fa-user"></i> {this.props.userInfo.firstName}</Link> 
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