import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';


import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();


class ApproveRequest extends React.Component{
    
    state = {
        
        
    }

    
    componentWillMount(){
        //console.log(this.props ) //getting undefined ,how to get this value
        const userId = localStorage.getItem('userId');
        this.setState({userId})
        axios.get('/doctor/approve/'+this.props.match.params.requestId).then(res=> {
            
            toast.success("Appointment Approved",{autoClose:7000,position:toast.POSITION.TOP_CENTER});
            this.setState({
                approved: true
            });
        }
    ).catch(
        err => {
            toast.error("Something went wrong....Booking Failed ,Please Try Again",{autoClose:7000,position:toast.POSITION.TOP_CENTER});
            console.log(err);
        }
    )
    
}
    

	render(){
       
        if(this.state.approved){
            return <Redirect to={'/appointment-request/'+this.state.userId} />;
        }
        return(
            <div>
                Request Approved
            
                    </div>
    
                
            );
		

		
		
	}
}







export default ApproveRequest;