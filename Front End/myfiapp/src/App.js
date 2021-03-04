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
import BookAppointments from './patient/BookAppointments';
import PatientRecord from './doctor/PatientRecord';
import TestResultDoctor from './doctor/TestResult-doctor';
import UpdateTreatment from './doctor/UpdateTreatment';
import TreatmentHistoryDoctor from './doctor/TreatmentHistory-Doctor';
import UpdateTestResult from './doctor/UpdateTestResult';
import AddService from './admin/AddService';
import DiagnosticCentre from './admin/Centre';
import UpdateServiceCentre from './admin/UpdateServiceCentre';
import AllTestResult from './admin/AllTestResult';
import UpdateTestResultAdmin from './admin/UpdateTestResultAdmin';
import ApproveRequest from './doctor/ApproveRequest';
import BookAppointmentAgent from './agent/BookAppointmentAgent';
import AppointmentStatusAgent from './agent/AppointmentStatus-Agent';
import AddReviewQuestions from './admin/ReviewQuestionarie';
import ViewAllServiceCommission from './admin/ViewAllServiceCommission';
import UpdateCommissionBaseline from './admin/UpdateCommission';
import ViewCommissionAgent from './agent/ViewCommissionAgent';
import ViewAgent from './admin/ViewAllAgent';
import ViewReviewQuestion from './admin/ViewReviewQuestion';
import TechnicalIssueReportingPatient from './patient/TechnicalIssueReporting';
import ViewTechnicalIssues from './admin/ViewTechnicalIssues';
import TechnicalIssueReportingDoctor from './doctor/TechnicalIssueReporting';
import TechnicalIssueReportingAgent from './agent/TechnicalIssueReporting';

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
          <Route exact path="/diagnostic-service-agent" component={ DiagnosticServiceAgent } />
          <Route exact path="/appointment-status/:patientId" component={ AppointmentStatus  } />
          <Route exact path="/appointment-status-agent/:agentId" component={ AppointmentStatusAgent  } />
          <Route exact path="/treatment-history/:patientId" component={TreatmentHistory  } />
          <Route exact path="/test-result/:patientId" component={ TestResult  } />
          <Route exact path="/appointment-request/:doctorId" component={ AppointmentRequests  } />
          <Route exact path="/appointment-request-approve/:requestId" component={ ApproveRequest  } />
          <Route exact path="/booking-agent" component={ BookAppointmentAgent  } />
          <Route exact path="/appointment-status-agent/:agentId" component={ AppointmentStatusAgent  } />
          <Route exact path="/add-review-question" component={ AddReviewQuestions  } />
          <Route exact path="/view-all-commission-admin" component={ ViewAllServiceCommission  } />
          <Route exact path="/update-service-baseline/:serviceId" component={ UpdateCommissionBaseline  } />
          <Route exact path="/view-commission-agent/:agentId" component={ ViewCommissionAgent  } />
          <Route exact path="/view-agent" component={ ViewAgent  } />
          <Route exact path="/view-review-question" component={ ViewReviewQuestion  } />
          <Route exact path="/report-issue-patient" component={ TechnicalIssueReportingPatient  } />
          <Route exact path="/view-technical-issue-admin" component={ ViewTechnicalIssues  } />
          <Route exact path="/issue-reporting-doctor" component={ TechnicalIssueReportingDoctor  } />
          <Route exact path="/issue-reporting-patient" component={ TechnicalIssueReportingPatient  } />
          <Route exact path="/issue-reporting-agent" component={ TechnicalIssueReportingAgent  } />

          

          <Route exact path="/appointment-booking/" component={ BookAppointments  } />
          <Route exact path="/patient-record/:doctorId" component={ PatientRecord  } />
          <Route exact path="/test-result-doctor/:doctorId" component={ TestResultDoctor  } />
          <Route exact path="/update-treatment-doctor/:testId" component={ UpdateTreatment  } />
          <Route exact path="/update-testresult-doctor/:testId" component={ UpdateTestResult  } />
          <Route exact path="/add-services" component={ AddService  } />
          <Route exact path="/view-centre" component={ DiagnosticCentre } />
          <Route exact path="/update-centre/:centreId" component={ UpdateServiceCentre } />
          <Route exact path="/update-test-result-admin/:testId" component={ UpdateTestResultAdmin } />
          <Route exact path="/view-test-admin" component={ AllTestResult } />
          <Route exact path="/add-service" component={ AddService } />
          
          
          <Route exact path="/treatment-history-doctor/:doctorId" component={ TreatmentHistoryDoctor  } />


        </Switch>
        
        <Footer />

    </div>
    </BrowserRouter>
  );
  }
}

export default App;
