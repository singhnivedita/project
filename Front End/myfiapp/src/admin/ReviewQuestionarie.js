import axios from 'axios';
import React from 'react';
import { Link ,Redirect} from 'react-router-dom';
import {toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

toast.configure();

class AddReviewQuestions  extends React.Component{
   state={}
    handleSubmit =(event) =>{
        event.preventDefault();
        const data ={
            question_id: 4,
            question:this.question
            
            
        };

        axios.post("admin/create-review-question", data).then(
            res =>{
                console.log(res);
                
                toast.success("Questions Added ",{autoClose:7000,position:toast.POSITION.TOP_CENTER});
                this.setState({
                    updated: true
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
                            
                            <div className="h4 text-muted text-center pt-2">Add Review Question</div>
                             <form className="pt-3" onSubmit={this.handleSubmit} >
                                <div className="form-group ">
                                    <div ><textarea className="form-control"placeholder="Review Question" required className="" onChange = {e =>this.question = e.target.value }/> </div>
                                </div>
                               
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

export default AddReviewQuestions;