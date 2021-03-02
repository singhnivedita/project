import React, { Component } from 'react'
import { NavLink, Link } from "react-router-dom";
import axios from 'axios';


class Navbar extends Component {
  state ={}

  
    componentDidMount() {

		const config ={
			headers:{
				Authorization:'Bearer '+ localStorage.getItem('token')
			}
		};
        axios.get("validate", config).then(
            res =>{
                this.setState({
                    userInfo :res.data
                });
            },
        ).catch(
            err => {
                console.log(err);
            }
        )
       
        console.log(localStorage.getItem('token'));

        // if(localStorage.getItem('token') != null){
        //     this.setState({ loggedIn: false })
        // }else
        //     this.setState({loggedIn :true})
    }

  render() {
    return (
        <div>
          <nav className="navbar navbar-expand-sm ">
            <div className='container'>
            <span className="navbar-brand"><Link to={"/"}> <i className = "fa fa-heartbeat"></i>   Diagnostic Medical Center </Link></span>
            <button className="navbar-toggler custom-toggler" type="button" data-toggle="collapse" data-target="#navI" aria-controls="navI" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
  
              <div className="collapse navbar-collapse" id="navI">
                {/* <ul className="navbar-nav mr-auto">
                  <li className="nav-item ">
                    <NavLink className="nav-link" exact to="/">Home</NavLink>
                  </li>
                  <li className="nav-item">
                    <NavLink className="nav-link" to="/">About</NavLink>
                  </li>
                </ul> */}
                <ul className="navbar-nav ml-auto">
  
                  {(this.state.userInfo != null) ?
                    <React.Fragment>
                      <NavLink className="nav-item" to={"/"}>name-{this.state.userInfo.uid}</NavLink>&nbsp;&nbsp;&nbsp;&nbsp;
                      <NavLink className='nav-item' to={'/'} onClick ={() => localStorage.clear() }>Log out</NavLink>
                    </React.Fragment>
                    :
                    <React.Fragment>
                      <NavLink className='nav-item ' to={"/doctorLogin"}><i className = "fa fa-user-md"></i> Doctor</NavLink>&nbsp;&nbsp;&nbsp;&nbsp;
                      <NavLink className='nav-item' to={"/adminLogin"}><i className=" fa fa-lock"></i> Admin</NavLink>
                    </React.Fragment>
                  }
                </ul>
              </div>
            </div>
          </nav>
        </div>
      )
  }
}

export default Navbar