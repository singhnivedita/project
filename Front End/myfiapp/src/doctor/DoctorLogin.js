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
			<div class="container-fluid">
                <div class="row">
                    <div class="col" id="bg1"></div>
                    <div class="col" id="b2">
                        <div class="wrapper bg-white">
                            <div class="h2 text-center">Diagnostic Medical Center</div>
                            <div class="h4 text-muted text-center pt-2">Doctor Login</div>
                            <form class="pt-3" onSubmit= {this.handleSubmit}>
                                <div class="form-group py-2">
                                    <div class="input-field"><input type="text" placeholder="Username/Email" required class="" onChange = {e =>this.email = e.target.value }/> </div>
                                </div>
                                <div class="form-group py-1 pb-2">
                                    <div class="input-field"><input type="text" placeholder="Enter your Password" required class=""   onChange = {e =>this.password = e.target.value }/> </div>
                                </div>
                                <div class="d-flex align-items-start">
                                    <div class="ml-auto"> <a href="#" id="forgot" style={{color: "red"}}>Forgot Password?</a> </div>
                                </div> <button class="btn btn-block text-center my-3">Log in</button>
                                <div class="text-center pt-3 text-muted">Not Registered? <Link to={"/registration"} style={{color: "#23487a"}}>Register Here</Link></div>
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