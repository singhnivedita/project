import React from 'react';



import axios from 'axios';

import { Link, Redirect } from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class Doctor extends React.Component{
    state ={}

    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            userId : this.email,
            password : this.password,
        };

        axios.post("doctor/login", data).then(
            res =>{
                const role =res.data.role;
                toast.success("Login Successful, Role: Doctor",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
               localStorage.setItem('userId', res.data.userId);
               localStorage.setItem('firstname', res.data.firstname);

               const userId = localStorage.getItem("userId");
               console.log(res);
               console.log("userId: "+userId);
               this.setState({
                   loggedIn: true
               });
               
            }
        ).catch(
            err => {
                toast.error("IncorrectId/Password ,Please Try Again",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                console.log(err);
            }
        )
        console.log(data);
    }
	render(){
        if(this.state.loggedIn){
            return <Redirect to={'/doctorHome'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            <div className="h2 text-center">Diagnostic Medical Center</div>
                            <div className="h4 text-muted text-center pt-2">Doctor Login</div>
                            <form className="pt-3" onSubmit= {this.handleSubmit}>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Username/Email" required className="" onChange = {e =>this.email = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Enter your Password" required className=""   onChange = {e =>this.password = e.target.value }/> </div>
                                </div>
                                <div className="d-flex align-items-start">
                                    <div className="ml-auto"> <a href="#" id="forgot" style={{color: "red"}}>Forgot Password?</a> </div>
                                </div> <button className="btn btn-block text-center my-3">Log in</button>
                                <div className="text-center pt-3 text-muted">Not Registered? <Link to={"/doctor-registration"} style={{color: "#23487a"}}>Register Here</Link></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default Doctor;