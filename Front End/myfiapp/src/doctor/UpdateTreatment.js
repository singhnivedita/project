import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class UpdateTreatment extends React.Component{
    state={
        serviceList:[]
    }
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            treatmentId:this.treatmentId,
            symptoms: this.symptoms,
            diet : this.diet,
            diagnosis : this.diagnosis,
            recommendation:this.recommendation,
            prescription : this.prescription,
            patientId:{patientId:this.patientId} ,
            docId: this.state.userId,
            diagnosticServiceId:{serviceId:this.state.serviceId},
            testresultId: {testId:this.props.match.params.testId}
            
        };

        axios.put("doctor/update-treatment-history", data).then(
            res =>{
                console.log(res);
                
                toast.success("Treatment History Updated ",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    updated: true
                });
            }
        ).catch(
            err => {
                toast.error("Something went wrong....Please Try Again",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                console.log(err);
            }
        )
        console.log(data);
    }

    handleChanged = (event) => {
        const { name, value } = event.target;

        switch(name) {
            
            case "serviceId":
                this.setState({
                    serviceId: value
                });
                break;
        }
    }

    
    componentWillMount(){

        const userId = localStorage.getItem('userId');
        this.setState({userId})

        axios.get('/patient/diagnostic-service').then(
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
                    <option key={company.serviceId} value={company.serviceId}>{company.serviceName}</option>
                );
            })
        );
    }
    
	render(){
        if(this.state.updated){
            return <Redirect to={'/treatment-history-doctor/'+this.state.userId} />;
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
                                    <div className="input-field"><input type="number" placeholder="Treatment Id" required className="" onChange = {e =>this.treatmentId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Symptoms" required className="" onChange = {e =>this.symptoms = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Diet" required className="" onChange = {e =>this.diet = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Diagnosis" required className="" onChange = {e =>this.diagnosis = e.target.value }/> </div>
                                </div>
                                

                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text"  required className="" placeholder="Recommendation"onChange = {e =>this.recommendation = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Prescription "   required className="" onChange = {e =>this.prescription = e.target.value }/> </div>
                                </div>

                                <div className="form-group py-2">
                                    <div className="input-field"><input type="number" placeholder="Patient Id" required className="" onChange = {e =>this.patientId = e.target.value }/> </div>
                                </div>
                                <select id="serviceId" name="serviceId" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                                    <option value="choose..">Select Service</option>
                                    {this.renderServices()}
                                </select>
                                <div className="form-group py-2">
                                        <div className="input-field"><input type="text" defaultValue={"Test Id"+this.props.match.params.testId || ''} disabled placeholder="centreId" required className="" onChange = {e =>this.centreId = e.target.value }/> </div>
                                </div>
                                {/* <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="number" placeholder="Doctor Id "   required className=""onChange = {e =>this.docId = e.target.value }/> </div>
                                </div> */}







                                <div className="d-flex align-items-start">
                                <div className="text-center pt-3 ml-auto">Already Updated? <Link to={'/treatment-history-doctor/'+this.state.userId}> Go Back</Link></div>
                                </div> <button className="btn btn-block text-center my-3">Update</button>
                                <div className="text-center pt-3 text-muted">Already Updated? <Link to={'/treatment-history-doctor/'+this.state.userId}> Go Back</Link></div>
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
