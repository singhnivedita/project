import React from 'react';
import logo from './logo.svg';
import './App.css';
import './Stylesheet/style.css';

import Doctor from './doctor/DoctorLogin';
import Footer from './home/Footer';
import Nav from './home/Nav';

import Admin from './admin/AdminLogin'
import Patient from './patient/PatientLogin';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Registration from './patient/Registration';
import Home from './home/Home';
import Navbar from './home/Navbar';
import axios from 'axios';
import PatientHome from './patient/PatientHome';
import AgentHome from './agent/AgentHome';
import Agent from './agent/AgentLogin';
import AdminHome from './admin/AdminHome';
import DoctorHome from './doctor/DoctorHome';
import DiagnosticService from './patient/DiagnosticService';
import DiagnosticServiceAgent from './agent/DiagnosticServiceAgent';
import AppointmentStatus from './patient/AppointmentStatus';
import TreatmentHistory from './patient/TreatmentHistory';
import TestResult from './patient/TestResult';
import AppointmentRequests from './doctor/AppointmentRequests';
import DoctorRegistration from './doctor/DoctorRegistration';
import CreateAgent from './admin/CreateAgent';

class App extends React.Component {
  state ={};
  

    
  render(){
  return (


    <BrowserRouter>
    <div className="App">
        <Nav />
        <Switch>
          <Route exact path="/home" component={ () => <Home  />}/>
          <Route exact path="/" component={ Patient}/>
          <Route exact path="/doctorLogin" component={  Doctor} />
          <Route exact path="/adminLogin"  component={  Admin}  />
          <Route exact path="/agentLogin"  component={  Agent}  />
          <Route exact path="/agentHome" component={ AgentHome } />
          <Route exact path="/registration" component={Registration} />
          <Route exact path="/doctor-registration" component ={DoctorRegistration} />
          <Route exact path="/create-agent" component ={CreateAgent} />
          <Route exact path="/patientHome" component={ PatientHome} />
          <Route exact path="/doctorHome" component={ DoctorHome} />
          <Route exact path="/adminHome" component={AdminHome  } />
          <Route exact path="/diagnosticService" component={ DiagnosticService  } />
          <Route exact path="/diagnosticServiceAgent" component={ DiagnosticServiceAgent } />
          <Route exact path="/appointment-status/:patientId" component={ AppointmentStatus  } />
          <Route exact path="/treatment-history/:patientId" component={TreatmentHistory  } />
          <Route exact path="/test-result/:patientId" component={ TestResult  } />
          <Route exact path="/appointment-request/:doctorId" component={ AppointmentRequests  } />
        </Switch>
        
        <Footer />

    </div>
    </BrowserRouter>
  );
  }
}

export default App;
