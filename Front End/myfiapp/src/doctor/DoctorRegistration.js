import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class DoctorRegistration extends React.Component{
    state={
        roleList:[]
    }
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            firstName: this.firstName,
            lastName : this.LastName,
            qualification : this.qualification,
            speciality:this.speciality,
            password : this.password,
            dob: this.dob,
            gender:this.gender,
            contactNumber:this.contactNumber,
            password: this.password,
            address: this.password,
            role:{roleId:this.state.roleID}
        };

        axios.post("doctor/registration", data).then(
            res =>{
                console.log(res);
                
                toast.success("Registration Successful, for role doctor ",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
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

        console.log("calling hadnle changed")
        console.log(event.target.value)
        switch(name) {
            
            case "roleID":
                this.setState({
                    roleID: value
                });
                break;
        }
    }

    
    componentWillMount(){

        axios.get('/admin/roles/1').then(
            response =>{
                    
                    const roleList=response.data
                    this.setState({
                        roleList: roleList
                    });
                    console.log(roleList);
    
            }
        )
     }
    
    

   

    renderServices = () => {
        return (
            this.state.roleList.map((company) => {
                return (
                    <option key={company.roleId} value={company.roleId}>{company.roleName}</option>
                );
            })
        );
    }
	render(){
        if(this.state.registered){
            return <Redirect to={'/doctorLogin'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Doctor Registration</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >

                                <select id="roleID" name="roleID" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                                    <option value="select....">Select Doctor</option>
                                    {this.renderServices()}
                                </select>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="First Name" required className="" onChange = {e =>this.firstName = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Last Name" required className="" onChange = {e =>this.LastName = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Enter your Password" required className="" onChange = {e =>this.password = e.target.value }/> </div>
                                </div>
                                

                                {/* <div className="form-group py-1 pb-2" onChange={this.setGender.bind(this)}>
                                    <input type="radio" value="MALE" name="gender"/> Male
                                    <input type="radio" value="FEMALE" name="gender"/> Female
                                </div> */}

                                <div className="form-group py-1 pb-2" onChange={e => this.gender = e.target.value }>
                                    <span className="input-field"> Select Gender : 
                                        <select>
                                            <option selected disabled>Gender</option>
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

                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Qualification" required className="" onChange = {e =>this.qualification = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Speciality" required className="" onChange = {e =>this.speciality = e.target.value }/> </div>
                                </div>    
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Enter your Address "   required className="" name="address"onChange = {e =>this.address = e.target.value }/> </div>
                                </div>







                                <div className="d-flex align-items-start">
                                    <div className="ml-auto"> <a href="#" id="forgot">Forgot Password?</a> </div>
                                </div> <button className="btn btn-block text-center my-3">Register</button>
                                <div className="text-center pt-3 text-muted">Already Registered? <Link to={"/doctorLogin"}>Login Here</Link></div>
                            </form> 
                            
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default DoctorRegistration;