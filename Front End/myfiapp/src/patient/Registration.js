import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class Registration extends React.Component{
    state={
        serviceList:[]
    }
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            firstName: this.firstName,
            lastName : this.LastName,
            password : this.password,
            dob: this.dob,
            gender:this.gender,
            contactNumber:this.contactNumber,
            password: this.password,
            address: this.address,
            role:{roleId:this.state.diagnosticServiceId}
        };

        axios.post("patient/register", data).then(
            res =>{
                console.log(res);
                
                toast.success("Registration Successful, for role patient ",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    registered: true
                });
            }
        ).catch(
            err => {
                toast.error("Something went wrong....Registration Failed ,Please Try Again",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                console.log(err);
            }
        )
        console.log(data);
    }

    handleChanged = (event) => {
        const { name, value } = event.target;

        switch(name) {
            
            case "diagnosticServiceId":
                this.setState({
                    diagnosticServiceId: value
                });
                break;
        }
    }

    
    componentWillMount(){

        axios.get('/admin/roles/3').then(
            response =>{
                    
                    const serviceList=response.data
                    this.setState({
                        serviceList: serviceList
                    });
                    console.log(serviceList);
    
            }
        )
     }
    
    

   

    renderServices = () => {
        return (
            this.state.serviceList.map((company) => {
                return (
                    <option key={company.roleId} value={company.roleId}>{company.roleName}</option>
                );
            })
        );
    }
	render(){
        if(this.state.registered){
            return <Redirect to={'/'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Patient Registration</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >

                             <select id="diagnosticServiceId" name="diagnosticServiceId" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                             <option value="select....">Select Role(Required)</option>
                                    {this.renderServices()}
                             </select>

                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="First Name" required className="" onChange = {e =>this.firstName = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Last Name" required className="" onChange = {e =>this.LastName = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="password" placeholder="Enter your Password" required className="" onChange = {e =>this.password = e.target.value }/> </div>
                                </div>
                                

                                {/* <div className="form-group py-1 pb-2" onChange={this.setGender.bind(this)}>
                                    <input type="radio" value="MALE" name="gender"/> Male
                                    <input type="radio" value="FEMALE" name="gender"/> Female
                                </div> */}

                                <div className="form-group py-1 pb-2" onChange={e => this.gender = e.target.value }>
                                    <span className="">  
                                        <select className="form-control input-field">
                                            <option selected disabled>Select Gender</option>
                                            <option value="Other">Others</option>
                                            <option value="Female">Female</option>
                                            <option value="Male">Male</option>
                                            
                                        </select>
                                    </span>    
                                </div>



                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="date"  required className="" name="dob"onChange = {e =>this.dob = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="number" placeholder="Enter contact Number "   required className="" name="contactNumber"onChange = {e =>this.contactNumber = e.target.value }/> </div>
                                </div>

                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Enter your Address "   required className="" name="address"onChange = {e =>this.address = e.target.value }/> </div>
                                </div>







                                <div className="d-flex align-items-start">
                                    <div className="ml-auto"> <a href="#" id="forgot">Forgot Password?</a> </div>
                                </div> <button className="btn btn-block text-center my-3">Register</button>
                                <div className="text-center pt-3 text-muted">Already Registered? <Link to={"/"}>Login Here</Link></div>
                            </form> 
                            {/* <form action="#non" method="post" className="fcorn-register container">
                                <p className="register-info">PATIENT REGISTRATION FORM</p>
                                <div>
                                    
                                    
                                
                                    <p className="col-md-6 role-wrap"/>
                                        <select>
                                            <option value="0" selected disabled>Gender</option>
                                            <option value="1">Others</option>
                                            <option value="2">Female</option>
                                            <option value="2">Male</option>
                                            
                                        </select>
                                
                                </div> 
                                <div className="row">
                                    <p className="col-md-6"><input type="text" placeholder="First Name" required/></p>
                                    <p className="col-md-6"><input type="text" placeholder="Last Name" required/></p>
                                </div>
                                
                                <p><input type="password" placeholder="Password" required/>
                                    <span className="extern-type">Atleast 8 characters long.</span>
                                </p>
                                <p>Date Of Birth<input type="date"/></p> 
                                <p><input type="text" placeholder="Contact NUmber" required/></p>
                                <p><input type="address" placeholder="Address" required/></p>
                            
                                

                                

                                    <div className="row" id="formButton">
                                        <p className="register-toggle"> </p>
                                        <p className="register-submit"><input type="submit" value="Register"/></p>
                                    </div>
                            </form> */}
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default Registration;