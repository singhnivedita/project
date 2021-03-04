import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class AddService extends React.Component{
    state={ 
        serviceList:[],
        centreList:[]
    }
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            centreId: this.state.centreId,
            serviceId : this.state.serviceId,
            
            
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
        axios.get('admin/diagnostic-centre').then(
            response =>{
                    
                    const centreList=response.data
                    this.setState({
                        centreList: centreList
                    });
                    console.log(centreList);
    
            }
        )
        
   
    }
    handleChanged = (event) => {
        const { name, value } = event.target;

        switch(name) {
            
            case "serviceId":
                this.setState({
                    serviceId: value
                });
                break;
                case "centreId":
                this.setState({
                    centreId: value
                });
                break;
        }
    }

    renderCentres = () => {
        return (
            this.state.centreList.map((company) => {
                return (
                    <option key={company.centreId} value={company.centreId}>{company.centreId}</option>
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
        if(this.state.added){
            return <Redirect to={'/adminHome'} />;
        }
		return(
		<div>
			<div className="container-fluid">
                <div className="row">
                    <div className="col" id="bg1"></div>
                    <div className="col" id="b2">
                        <div className="wrapper bg-white">
                            
                            <div className="h4 text-muted text-center pt-2">Add Services to Centre</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                               



                                

                                {/* <div className="form-group py-2">
                                    <div className="input-field"><input type="number" placeholder="Centre Id " required className="" onChange = {e =>this.centreId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="number" placeholder="Service Id" required className="" onChange = {e =>this.serviceId = e.target.value }/> </div>
                                </div>     */}
                                

                                <select id="centreId" name="centreId" className="form-control input-field" defaultValue="Select Centre" onChange={(event) => this.handleChanged(event)}>
                                    <option value="choose..">Select Centre</option>
                                    {this.renderCentres()}
                                </select>
                                <br></br>
                                <select id="serviceId" name="serviceId" className="form-control input-field" defaultValue="Select Service" onChange={(event) => this.handleChanged(event)}>
                                    <option value="choose..">Select Service</option>
                                    {this.renderServices()}
                                </select>





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