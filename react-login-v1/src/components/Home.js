import React,{Component} from 'react';
import axios from 'axios';


class Home extends Component{



	
    
	render(){
		if(this.props.userInfo != null){
			return(
				<div>
				<h3> Home Page ,and  {this.props.userInfo.uid} and {this.props.userInfo.role} </h3>
				</div>
			);
		}else{
			return(
				<div>Unauthorised</div>
			)
		}
		
		
	}
}

export default Home;