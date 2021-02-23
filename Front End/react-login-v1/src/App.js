import React from 'react';
import logo from './logo.svg';
import './App.css';
import './Stylesheet/style.css';
import './Stylesheet/dashStyle.css';
import Doctor from './components/DoctorLogin';
import Footer from './components/Footer';
import Nav from './components/Nav';
import Admin from './components/AdminLogin';
import Patient from './components/PatientLogin';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Registration from './components/Registration';
import Home from './components/Home';
import Navbar from './components/Navbar';
import axios from 'axios';
import PatientHome from './components/PatientHome';
import AdminHome from './components/AdminHome';
import DoctorHome from './components/DoctorHome';

class App extends React.Component {
  state ={};
  componentDidMount =() =>{
		const config ={
			headers:{
				Authorization:'Bearer '+ localStorage.getItem('token')
			}
		};
        
        axios.get("http://localhost:8081/authapp/validate", config).then(
            res =>{

              this.setUser(res.data);
                // this.setState({
                //    userInfo :res.data
                    
                // });
               // userInfo:res.data
            },
        ).catch(
            err => {
                console.log(err);
            }
        )
        console.log(config);
    }

    setUser = (userInfo) =>{
      this.setState({
        userInfo:userInfo
      })
    }
  render(){
  return (


    <BrowserRouter>
    <div classNameName="App">
        <Nav userInfo={this.state.userInfo} setUser={this.setUser} />
        <Switch>
          <Route exact path="/home" component={ () => <Home userInfo={this.state.userInfo} />}/>
          <Route exact path="/" component={() => <Patient setUser={this.setUser} />}/>
          <Route exact path="/doctorLogin" component={ () => <Doctor setUser={this.setUser} />} />
          <Route exact path="/adminLogin"  component={ () => <Admin setUser={this.setUser} />}  />
          <Route exact path="/registration" component={Registration} />
          <Route exact path="/patientHome" component={()=> <PatientHome userInfo={this.state.userInfo} />} />
          <Route exact path="/doctorHome" component={()=> <DoctorHome userInfo={this.state.userInfo} />} />
          <Route exact path="/adminHome" component={()=> <AdminHome userInfo={this.state.userInfo} />} />
        </Switch>
        
        <Footer />

    </div>
    </BrowserRouter>
  );
  }
}

export default App;
