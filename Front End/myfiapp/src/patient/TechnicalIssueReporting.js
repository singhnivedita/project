import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class TechnicalIssueReportingPatient  extends React.Component{
   state={
       serviceList:[]
   }
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            issueId: 5,
            yourId:this.state.userId,
            issues:this.issues,
            description:this.description,
            role:this.state.diagnosticServiceId
            
            
        };

        axios.post("agent/report-issue", data).then(
            res =>{
                console.log(res);
                
                toast.success("Issues Reported, We will get back to you shortly ",{autoClose:7000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    reported: true
                });
            }
        ).catch(
            err => {
                toast.error("Something went wrong....,Please Try Again",{autoClose:7000,position:toast.POSITION.TOP_CENTER});
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

        const userId = localStorage.getItem('userId');
        this.setState({userId})

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
                    <option key={company.roleId} value={company.roleName}>{company.roleName}</option>
                );
            })
        );
    }
	render(){
        if(this.state.reported){
            return <Redirect to={'/patientHome'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Report Technical Issue</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                             <div className="form-group ">
                                    <div className="form-control input-field"><input placeholder="Your Id " defaultValue={"Your id is "+this.state.userId || ''} required className="" onChange = {e =>this.description = e.target.value }/> </div>
                                </div>
                             <select id="diagnosticServiceId" name="diagnosticServiceId" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                             <option value="select....">Select your Role(Required)</option>
                                    {this.renderServices()}
                             </select>
                             <br></br>
                                <div className="form-group ">
                                    <div className="form-control input-field"><input placeholder="Write Technical Issue" required className="" onChange = {e =>this.issues = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group ">
                                    <div className="form-control input-field"><input className="form-control input-field"placeholder="Describe the issue" required className="" onChange = {e =>this.description = e.target.value }/> </div>
                                </div>
                                
                                <div className="d-flex align-items-start">
                                <div className="text-center pt-3 ml-auto">Issue Solved? <Link to={"/patientHome"}> Go Back</Link></div>
                                </div> <button className="btn btn-block text-center my-3">Add</button>
                                <div className="text-center pt-3 text-muted">Issue Solved? <Link to={"/patientHome"}> Go Back</Link></div>
                            </form> 
                            
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}

export default TechnicalIssueReportingPatient;