import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class UpdateCommissionBaseline extends React.Component{
    state={
        serviceList:[]
    }
    
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            
            
            diagnosticServiceId:{serviceId:this.props.match.params.serviceId},
            baselineValue : this.baseLine
            
            
           
            
        };

        axios.put("admin/update-commission/"+this.props.match.params.serviceId, data).then(
            res =>{
                console.log(res);
                
                toast.success("Commission Baseline Updated ",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
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
            
            case "diagnosticServiceId":
                this.setState({
                    diagnosticServiceId: value
                });
                break;
        }
    }

    
    componentWillMount(){

        axios.get('/admin/diagnostik-service/'+this.props.match.params.serviceId).then(
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
                    <option key={company.diagnosticServiceId} value={company.diagnosticServiceId}>{company.serviceName}</option>
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
                        
                            <div className="h4 text-muted text-center pt-2">Update TCommission</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                                
                             <select id="diagnosticServiceId" name="diagnosticServiceId" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                                    
                                    {this.renderServices()}
                                </select>
                                <br></br>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="number" placeholder="BaseLine Value" required className="" onChange = {e =>this.baseLine = e.target.value }/> </div>
                                </div>
                               
                                

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

export default UpdateCommissionBaseline;