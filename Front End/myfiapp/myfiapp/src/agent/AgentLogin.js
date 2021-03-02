import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


class Agent extends React.Component{
    state = {}
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            userId : this.email,
            password : this.password,
        };

        axios.post("agent/login", data).then(
            res =>{
               localStorage.setItem('token', res.data.token);

               const token = localStorage.getItem("token");
               console.log(res);
               console.log("token: "+token);
               this.setState({
                   loggedIn: true
               });
               
            }
        ).catch(
            err => {
                console.log(err);
            }
        )
        console.log(data);
    }
	render(){
        if(this.state.loggedIn){
            return <Redirect to={'/agentHome'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                    <div className="wrapper bg-white">
                        <div className="h2 text-center">Diagnostic Medical Center</div>
                        <div className="h4 text-muted text-center pt-2">Agent Login</div>
                        <form className="pt-3" onSubmit = {this.handleSubmit}>
                            <div className="form-group py-2">
                                <div className="input-field"><input type="text" placeholder="Username/Email" required className="" onChange = {e =>this.email = e.target.value }/> </div>
                            </div>
                            <div className="form-group py-1 pb-2">
                                <div className="input-field"><input type="text" placeholder="Enter your Password" required className="" onChange = {e =>this.password = e.target.value }/> </div>
                            </div>
                            <div className="d-flex align-items-start">
                                <div className="ml-auto "> <a href="#" id="forgot" style={{color: "red"}}>Forgot Password?</a> </div>
                            </div> <button className="btn btn-block text-center my-3">Log in</button>
                            <div className="text-center pt-3 text-muted" >Not Registered? <Link to={"/registration"} style={{color: "#23487a"}}>Register Here</Link></div>
                        </form>
                    </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default Agent;