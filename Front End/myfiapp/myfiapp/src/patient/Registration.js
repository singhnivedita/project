import axios from 'axios';
import React from 'react';
import { Link } from 'react-router-dom';


class Registration extends React.Component{

    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            firstName: this.firstName,
            lastName : this.LastName,
            email : this.email,
            password : this.password,
            // dob: this.dob,
            // gender:this.gender,
            // contactNumber:this.contactNumber,
            // password: this.password,
            // address: this.password,
            // role:this.roleID 
        };

        axios.post("patient/register", data).then(
            res =>{
                console.log(res);
            }
        ).catch(
            err => {
                console.log(err);
            }
        )
        console.log(data);
    }
	render(){
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Doctor Registration</div>
                            <form className="pt-3" onSubmit={this.handleSubmit} >
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="First Name" required className="" onChange = {e =>this.firstName = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Last Name" required className="" onChange = {e =>this.LastName = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="email" placeholder="Email" required className="" onChange = {e =>this.email = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Enter your Password" required className="" onChange = {e =>this.password = e.target.value }/> </div>
                                </div>
                                <div className="d-flex align-items-start">
                                    <div className="ml-auto"> <a href="#" id="forgot">Forgot Password?</a> </div>
                                </div> <button className="btn btn-block text-center my-3">Register</button>
                                <div className="text-center pt-3 text-muted">Already Registered? <Link to={"/"}>Login Here</Link></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default Registration;