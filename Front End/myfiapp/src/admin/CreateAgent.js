import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class CreateAgent extends React.Component{
    state={
        serviceList:[]
    }
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            agentId: this.agentId,
            firstName: this.firstName,
            lastName : this.LastName,
            bankName : this.bankName,

            bankAccNo :this.accountNumber,
            email:this.email,
            ifsc:this.ifsc,
            password : this.password,
            dob: this.dob,
            gender:this.gender,
            contactNumber:this.contactNumber,
            password: this.password,
            
            roleId:"4"
        };

        axios.post("/admin/create-agent", data).then(
            res =>{
                console.log(res);
                
                toast.success("Agent Created  ",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    registered: true
                });
            }
        ).catch(
            err => {
                toast.error("Something went wrong....Agent Creation failed,Please Try Again",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
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

        axios.get('/admin/roles/4').then(
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
            return <Redirect to={'/adminHome'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Agent Creation</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >

                             <select id="diagnosticServiceId" name="diagnosticServiceId" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                                    
                                    {this.renderServices()}
                            </select>
                             <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Unique Agent ID" required className="" onChange = {e =>this.agentId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="First Name" required className="" onChange = {e =>this.firstName = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Last Name" required className="" onChange = {e =>this.LastName = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="mail" placeholder="Enter email" required className="" onChange = {e =>this.email = e.target.value }/> </div>
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
                                    <div className="input-field"><input type="text" placeholder="Enter Bank Name" required className="" onChange = {e =>this.bankName = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Enter Bank Account Number" required className="" onChange = {e =>this.accountNumber = e.target.value }/> </div>
                                </div>    
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Enter IFS Code "   required className="" onChange = {e =>this.ifsc = e.target.value }/> </div>
                                </div>







                                <div className="d-flex align-items-start">
                                    
                                    <div className="text-center pt-3 text-muted ml-auto">No more Agent?  <Link to={"/adminHome"}>Go Back</Link></div>

                                </div> <button className="btn btn-block text-center my-3">Register</button>
                                {/* <div className="text-center pt-3 text-muted">Already Registered? <Link to={"/doctorLogin"}>Login Here</Link></div> */}
                            </form> 
                            
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default CreateAgent;