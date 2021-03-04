import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class BookAppointmentAgent extends React.Component{
    state={
        docList:[],
        serviceList:[]
    }
    handleSubmit =(event) =>{

        event.preventDefault();
        const data ={
            requestId:8,
            date: this.date,
            time : this.time,
            remark : this.remark,
            patientId : {patientId:this.patientId}, 
            
            doctorId :{ docId:this.state.docId},
            
            diagnosticService : {serviceId:this.state.dgserviceId},
            agentId:{agentPk:this.state.userId}//getting from local storage
            
            
        };
        
        axios.post("agent/booking", data).then(
            res =>{
                console.log(res);
                
                toast.success("Booking Successful, wait for approval",{autoClose:7000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    booked: true
                });
            }
        ).catch(
            err => {
                toast.error("Something went wrong....Booking Failed ,Please Try Again",{autoClose:7000,position:toast.POSITION.TOP_CENTER});
                console.log(err);
            }
        )
        console.log(data);
    }

    handleChanged = (event) => {
        const { name, value } = event.target;

        switch(name) {
            case "docId":
                this.setState({
                    docId: value
                });
                break;
            case "dgserviceId":
                this.setState({
                    dgserviceId: value
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


        
        axios.get('doctor/all-doctors').then(
            response =>{
                    
                    const docList=response.data
                    this.setState({
                        docList: docList
                    });
                    console.log(docList);
    
            }
        )

        
    }
    
    

    renderOptions = () => {
        return (
            this.state.docList.map((company) => {
                return (
                    <option key={company.docId} value={company.docId}>{company.firstName +' '+ company.lastName}</option>
                );
            })
        );
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
        if(this.state.booked){
            return <Redirect to={'/appointment-status-agent/'+this.state.userId} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Book Appointment</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                             <div className="form-group py-2">
                                    <div className="input-field"><input type="number" placeholder="Patient Id" required className="" onChange = {e =>this.patientId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Issues/ Problems" required className="" onChange = {e =>this.remark = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="date" placeholder="Date of Appointment" required className="" onChange = {e =>this.date = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="time" step="1" placeholder="Time of Appointment" required className="" onChange = {e =>this.time = e.target.value }/> </div>
                                </div>
                                

                                
                                <select id="docId" name="docId" className="form-control input-field" defaultValue="Select Doctor" onChange={(event) => this.handleChanged(event)}>
                                    <option value="choose..">Select Doctor</option>
                                    {this.renderOptions()}
                                </select>
                                <br></br>
                                <select id="dgserviceId" name="dgserviceId" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                                    <option value="choose..">Select Service</option>
                                    {this.renderServices()}
                                </select>
                              

                                <div className="d-flex align-items-start">
                                <div className="text-center pt-3 ml-auto">Feeling well? <Link to={"/agentHome"}> Go Back</Link></div>
                                </div> <button className="btn btn-block text-center my-3">Book</button>
                                
                            </form> 
                            
                        </div>
                    </div>
                </div>
            </div>
		</div>

			
		);
		
	}
}


class RowCreator extends React.Component{
    render(){
        var obj = this.props.item;
        return(
            <option key={obj.clientName}>{obj.clientName}</option>
        )
   }
}

export default BookAppointmentAgent;