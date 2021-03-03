import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class BookAppointments extends React.Component{
    state={
        doc:[]
    }
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            date: this.date,
            time : this.time,
            remark : this.remark,
            patientId:this.state.userId, //needs to get from local storage
            docId : this.docId,
            dob: this.dob,
            dgserviceId:this.serviceId,
            
        };
        
        axios.post("patient/booking", data).then(
            res =>{
                console.log(res);
                
                toast.success("Booking Successful, wait fro approval",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    booked: true
                });
            }
        ).catch(
            err => {
                toast.error("Something went wrong....Booking Failed ,Please Try Again",{autoClose:4000,position:toast.POSITION.TOP_CENTER});
                console.log(err);
            }
        )
        console.log(data);
    }
    componentWillMount(){
        
        axios.get('doctor/all-doctors').then(
            response =>{
                    
                    const doc=response.data.docId
                    this.setState({doc})
                    console.log(doc);
    
            }
        )
    }
    // bindDropDowns() {
    //     var clientName = document.getElementById('clientName').value
 
    //     for(var i=0; i < this.state.doc.length; i++) {
    //      var clientName = this.state.doc[i].clientName;
    //      console.log("Some"+clientName)
    //     }
    // }
    
	render(){
        if(this.state.booked){
            return <Redirect to={'/patientHome'} />;
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
                                    <div className="input-field"><input type="text" placeholder="Issues/ Problems" required className="" onChange = {e =>this.remark = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="date" placeholder="Date of Appointment" required className="" onChange = {e =>this.date = e.target.value }/> </div>
                                </div>
                                
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="time" placeholder="Time of Appointment" required className="" onChange = {e =>this.time = e.target.value }/> </div>
                                </div>
                                

                                {/* <div>
                                    <select className="custom-select" id="clientName" onSelect="bindDropDowns()">
                                    
                                        {this.state.doc.map((obj) => 
                                        <option key={obj.clientName}>{obj.clientName}</option>
                                        )};
                                    </select>
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



                                {/* <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="date"  required className="" name="dob"onChange = {e =>this.dob = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="number" placeholder="Enter contact Number "   required className="" name="contactNumber"onChange = {e =>this.contactNumber = e.target.value }/> </div>
                                </div>

                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Qualification" required className="" onChange = {e =>this.qualification = e.target.value }/> </div>
                                </div>
                                <div className="form-group py-2">
                                    <div className="input-field"><input type="text" placeholder="Speciality" required className="" onChange = {e =>this.speciality = e.target.value }/> </div>
                                </div>    
                                <div className="form-group py-1 pb-2">
                                    <div className="input-field"><input type="text" placeholder="Enter your Address "   required className="" name="address"onChange = {e =>this.address = e.target.value }/> </div>
                                </div> */}







                                <div className="d-flex align-items-start">
                                    
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

export default BookAppointments;