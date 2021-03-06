import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class UpdateTestResultAdmin extends React.Component{
    state={
        serviceList:[]
    }
    
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            testId: this.props.match.params.testId,
            testName : this.name,
            testResult : this.result,
            
            diagnosticServiceId:{serviceId:this.state.serviceId},
           // patientId: this.props.match.params.testId ,//how to get this patient value corresponding to tests?
            patientId:{patientId:this.pId}
           
            
        };

        axios.put("admin/update-test-result", data).then(
            res =>{
                console.log(res);
                
                toast.success("Test Result Updated ",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
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
            return <Redirect to={'/adminHome'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                        
                            <div className="h4 text-muted text-center pt-2">Update Test Result</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" defaultValue={"Test Id"+this.props.match.params.testId || ''} disabled placeholder="centreId" required className="" onChange = {e =>this.centreId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="number"   placeholder="Patient Id" required className="" onChange = {e =>this.pId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Test Name" required className="" onChange = {e =>this.name = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Test Result" required className="" onChange = {e =>this.result = e.target.value }/> </div>
                                </div>
                               
                                <select id="serviceId" name="serviceId" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                                    <option value="choose..">Select Service</option>
                                    {this.renderServices()}
                                </select>

                                <div className="d-flex align-items-start">
                                <div className="text-center pt-3 ml-auto">Already Updated? <Link to={"/adminHome"}> Go Back</Link></div>
                                </div> <button className="btn btn-block text-center my-3">Update</button>
                                <div className="text-center pt-3 text-muted">Already Updated? <Link to={"/adminHome"}> Go Back</Link></div>
                            </form> 
                            
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default UpdateTestResultAdmin;