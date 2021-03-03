import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class UpdateTreatment extends React.Component{
    state={}
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            symptoms: this.symptoms,
            diet : this.diet,
            diagnosis : this.diagnosis,
            recommendation:this.recommendation,
            prescription : this.prescription,
            patientId: this.patientId,
            docId: this.docId,
            serviceId: this.serviceId,
            testresultId: this.testresultId
            
        };

        axios.post("doctor/update-treatment-history", data).then(
            res =>{
                console.log(res);
                
                toast.success("Treatment History Updated ",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    updated: true
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
        if(this.state.updated){
            return <Redirect to={'/doctorHome'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Update Treatment History</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Symptoms" required className="" onChange = {e =>this.symptoms = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Diet" required className="" onChange = {e =>this.diet = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Diagnosis" required className="" onChange = {e =>this.diagnosis = e.target.value }/> </div>
                                </div>
                                

                                
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



                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text"  required className="" placeholder="Recommendation"onChange = {e =>this.recommendation = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Prescription "   required className="" onChange = {e =>this.prescription = e.target.value }/> </div>
                                </div>

                                <div className="form-group py-2">
                                    <div className="input-field"><input type="number" placeholder="Patient Id" required className="" onChange = {e =>this.patientId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="number" placeholder="Service Id" required className="" onChange = {e =>this.serviceId = e.target.value }/> </div>
                                </div>    
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="number" placeholder="Test Result Id "   required className="" onChange = {e =>this.testresultId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="number" placeholder="Doctor Id "   required className=""onChange = {e =>this.docId = e.target.value }/> </div>
                                </div>







                                <div className="d-flex align-items-start">
                                <div className="text-center pt-3 ml-auto">Already Updated? <Link to={"/doctorHome"}> Go Back</Link></div>
                                </div> <button className="btn btn-block text-center my-3">Update</button>
                                <div className="text-center pt-3 text-muted">Already Updated? <Link to={"/doctorHome"}> Go Back</Link></div>
                            </form> 
                            
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default UpdateTreatment;