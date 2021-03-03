


import React from 'react';



import axios from 'axios';

import AgentHome from './AgentHome';


class ViewCommissionAgent extends React.Component{
    state = {
        services:[],
        
    }
    
    componentWillMount(){
        
        axios.get('/agent/commission/'+this.props.match.params.agentId).then(res=> {
            const services = res.data;
            this.setState({services})
            console.log(services)
        })
    } 
	render(){
       
        
			return(
                <div>
                    <AgentHome/>
                        <div id="tableDiv">
                        <h2 align='center'> Total Commission</h2>
                        <table id="tableWrap" className="table ">
                            <thead>
                            <tr>
                            
                                <th>Agent Id</th>
                                <th>Total Commission</th>
                                
                            </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>{this.props.match.params.agentId}</td>
                                    <td>{this.state.services}</td>
                                </tr>
                                
                            </tbody>
                            
                        </table>
                        </div>
                
                        </div>
        
                    
                );
		

		
		
	}
}



export default ViewCommissionAgent;