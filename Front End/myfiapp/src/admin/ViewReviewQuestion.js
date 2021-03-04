import React from 'react';



import axios from 'axios';
import { Link, Redirect } from 'react-router-dom';
import AdminHome from './AdminHome';


class ViewReviewQuestion extends React.Component{
    state = {
        services:[]
    }
    componentWillMount(){
        axios.get('/admin/all-questions').then(res=> {
            const services = res.data;
            this.setState({services})

        })
    } 
	render(){
       
        
			return(
                <div>
                    <AdminHome/>
                     <div id="tableDiv">
                        <h2 align='center'> Review Questions</h2>
                        <span className="float-right"><Link to={'/add-review-question'}>Create New Question</Link></span>
                        <table id="tableWrap" className="table " >
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Question</th>
                                
                                
                            </tr>
                            </thead>
                            <tbody>
                                {this.state.services.map(service => <RowCreator item={service}/>)}
                            </tbody>
                            
                        </table>
                        </div>
                
                        </div>
        
                    
                );
		

		
		
	}
}

class RowCreator extends React.Component{
    render(){
         var service = this.props.item;
         return(
             <tr>
                 <td>{service.question_id}</td>
                 <td>{service.question}</td>
                 
                 
             </tr>
         )
    }
}

export default ViewReviewQuestion;