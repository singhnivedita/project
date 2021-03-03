import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class UpdateServiceCentre extends React.Component{
    state={
        serviceList:[]
    }
    
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            centreId: this.props.match.params.centreId,
            brief : this.brief,
            address : this.address,
            city:this.city,
            state : this.state,
            email: this.email,
            website: this.website,
            serviceId: this.serviceId,
            contactno: this.contactno,
            zip:this.zip,
            serviceId:this.state.serviceId

            
        };

        axios.put("admin/modify-centre", data).then(
            res =>{
                console.log(res);
                
                toast.success("Centre Details Updated ",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
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
                        
                            <div className="h4 text-muted text-center pt-2">Update Centre Details</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" defaultValue={this.props.match.params.centreId || ''} disabled placeholder="centreId" required className="" onChange = {e =>this.centreId = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="brief" required className="" onChange = {e =>this.brief = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="address" required className="" onChange = {e =>this.address = e.target.value }/> </div>
                                </div>
                                

                                
                                



                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text"  required className="" placeholder="city"onChange = {e =>this.city = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="state "   required className="" onChange = {e =>this.state = e.target.value }/> </div>
                                </div>

                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Email" required className="" onChange = {e =>this.email = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Website" required className="" onChange = {e =>this.website = e.target.value }/> </div>
                                </div>    
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="number" placeholder="contactno "   required className="" onChange = {e =>this.contactno = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="number" placeholder="zip "   required className=""onChange = {e =>this.zip = e.target.value }/> </div>
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

export default UpdateServiceCentre;