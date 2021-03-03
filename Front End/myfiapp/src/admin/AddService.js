import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class AddService extends React.Component{
    state={}
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            centreId: this.centreId,
            serviceId : this.serviceId,
            
            
        };

        axios.put("admin/add-service/"+data.centreId+'/'+data.serviceId).then(
            res =>{
                console.log(res);
                
                toast.success("Service added to centre",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    added: true
                });
            }
        ).catch(
            err => {
                toast.error("Something went wrong....,Please Try Again",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                console.log(err);
            }
        )
        console.log(data);
    }

    setGender(event) {
        console.log(event.target.value);
      }
	render(){
        if(this.state.added){
            return <Redirect to={'/doctorHome'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Add Services</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                                {/* <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Symptoms" required className="" onChange = {e =>this.symptoms = e.target.value }/> </div>
                                </div> */}
                                
                                

                                
                                {/* <div className="form-group py-1 pb-2" onChange={e => this.gender = e.target.value }>
                                    <span className="input-field"> Select Gender : 
                                        <select>
                                            <option selected disabled>Gender</option>
                                            <option value="Other">Others</option>
                                            <option value="Female">Female</option>
                                            <option value="Male">Male</option>
                                            
                                        </select>
                                    </span>    
                                </div> */}



                                

                                <div className="form-group py-2">
                                    <div className="input-field"><input type="number" placeholder="Centre Id " required className="" onChange = {e =>this.centreId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="number" placeholder="Service Id" required className="" onChange = {e =>this.serviceId = e.target.value }/> </div>
                                </div>    
                                







                                <div className="d-flex align-items-start">
                                <div className="text-center pt-3 ml-auto">Already Added? <Link to={"/adminHome"}> Go Back</Link></div>
                                </div> <button className="btn btn-block text-center my-3">Add</button>
                                <div className="text-center pt-3 text-muted">Already Added? <Link to={"/adminHome"}> Go Back</Link></div>
                            </form> 
                            
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default AddService;