create database dmcdb;
use dmcdb;

#admin table
insert into admin_table (adminId, firstName, lastName, password, role) values (1, 'Broderick', 'Schwerin', 'Z9amFj1r', 1);
insert into admin_table (adminId, firstName, lastName, password, role) values (2, 'Pearce', 'Milroy', 'EIXLYY', 2);
insert into admin_table (adminId, firstName, lastName, password, role) values (3, 'Connie', 'Buttner', '9Nq6Qg53nNY', 3);
insert into admin_table (adminId, firstName, lastName, password, role) values (4, 'Obediah', 'Whitehurst', 'edMZ5rpQj', 4);

#agent table
insert into agent_table (agentPk, agentId, fristName, lastName, dob, gender, contactNumber, password, email, bankAccNo, bankName, ifsc, role) values (1, 1, 'Joel', 'Grewer', '2013-12-16', 'Male', '9803072838', 'yAU1Co0', 'agrewer0@sphinn.com', '1107476364', 'Archie', 'EJ6ZQa0Xb', 1);
insert into agent_table (agentPk, agentId, fristName, lastName, dob, gender, contactNumber, password, email, bankAccNo, bankName, ifsc, role) values (2, 2, 'Beck', 'Shelp', '2013-08-26', 'Female', '1140391038', 'MFytSiszSWs', 'gshelp1@princeton.edu', '1317536908', 'Gael', 'AgBoLWEb', 2);
insert into agent_table (agentPk, agentId, fristName, lastName, dob, gender, contactNumber, password, email, bankAccNo, bankName, ifsc, role) values (3, 3, 'Alley', 'Cubitt', '2003-07-29', 'Male', '6906087533', 'ZiEv4qnQ', 'ncubitt2@discovery.com', '5104076687', 'Natasha', 'eXqneihnc1F2', 3);
insert into agent_table (agentPk, agentId, fristName, lastName, dob, gender, contactNumber, password, email, bankAccNo, bankName, ifsc, role) values (4, 4, 'Othelia', 'Prawle', '2004-11-14', 'Female', '7849094298', 'O8pKTZq', 'nprawle3@techcrunch.com', '8833210774', 'Noby', 'QRfLIl9o', 4);

#Book apppointment
insert into request_table  (requestId, date, time, remark, status, patientId, doctorId, diagnosticService, agentId) values (1, '2020-06-20', '23:58', 'Vestibulum sed magna at nunc commodo placerat.', false, 1, 1, 1, 1);
insert into request_table  (requestId, date, time, remark, status, patientId, doctorId, diagnosticService, agentId) values (2, '2020-07-03', '10:36', 'Curabitur convallis.', false, 2, 2, 2, 2);
insert into request_table  (requestId, date, time, remark, status, patientId, doctorId, diagnosticService, agentId) values (3, '2020-07-02', '21:26', 'Aliquam non mauris.', false, 3, 3, 3, 3);
insert into request_table  (requestId, date, time, remark, status, patientId, doctorId, diagnosticService, agentId) values (4, '2021-02-02', '4:30', 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', true, 4, 4, 4, 4);

#centre_table
insert into centre_table  (centreId, brief, address, city, state, email, website, contactno, zip, serviceId) values (1, 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', '5 Leroy Trail', 'Washington', 'District of Columbia', 'isamms0@spotify.com', 'xinhuanet.com', '9533735562', '20430', 1);
insert into centre_table  (centreId, brief, address, city, state, email, website, contactno, zip, serviceId) values (2, 'Nulla tempus.', '92368 Annamark Lane', 'Buffalo', 'New York', 'bruddock1@goodreads.com', 'shinystat.com', '6249484523', '14269', 2);
insert into centre_table  (centreId, brief, address, city, state, email, website, contactno, zip, serviceId) values (3, 'Etiam pretium iaculis justo.', '8399 Kenwood Drive', 'Jersey City', 'New Jersey', 'smcnirlin2@dailymail.co.uk', 'ezinearticles.com', '2541986696', '07305', 3);
insert into centre_table  (centreId, brief, address, city, state, email, website, contactno, zip, serviceId) values (4, 'Etiam pretium iaculis justo.', '99328 Mandrake Trail', 'San Jose', 'California', 'jokroy3@rakuten.co.jp', 'xing.com', '2870891199', '95155', 4);

#service_table
insert into service_table (serviceId, serviceName, cost, time, isntruction, diagnosticCentre) values (1, 'Clinical diagnosis', '1438.23', '6:35', 'Family hx-stroke', 1);
insert into service_table (serviceId, serviceName, cost, time, isntruction, diagnosticCentre) values (2, 'Radiology', '4285.09', '21:55', 'Ac/subac endocardit NOS', 2);
insert into service_table (serviceId, serviceName, cost, time, isntruction, diagnosticCentre) values (3, 'Laboratory diagnosis', '418.75', '4:43', 'Sprain of thyroid region', 3);
insert into service_table (serviceId, serviceName, cost, time, isntruction, diagnosticCentre) values (4, 'Principal  diagnosis', '668.42', '13:21', 'Hypercalcemia', 4);

#doctor_table
insert into doctor_table (docId, firstName, lastName, dob, gender, contactNumber, password, address, qualification, speciality, roleId) values (1, 'Boris', 'MacGillacolm', '2020-05-15', 'Genderfluid', '560 729 0203', 'SBuVYowwx8', '44 Orin Place', 'bmacgillacolm0', 'Ethambutol', 1);
insert into doctor_table (docId, firstName, lastName, dob, gender, contactNumber, password, address, qualification, speciality, roleId) values (2, 'Ermanno', 'Arnson', '2020-09-17', 'Non-binary', '571 750 8216', '15CUGygVkmG', '8 Pond Park', 'earnson1', 'GABAPENTIN', 2);
insert into doctor_table (docId, firstName, lastName, dob, gender, contactNumber, password, address, qualification, speciality, roleId) values (3, 'Mannie', 'Loiterton', '2020-08-19', 'Bigender', '769 203 8862', 'B8j2QHtGVvS4', '64 Fallview Parkway', 'mloiterton2', 'Spice Anti-bacterial foaming Hand Wash', 3);
insert into doctor_table (docId, firstName, lastName, dob, gender, contactNumber, password, address, qualification, speciality, roleId) values (4, 'Emlen', 'Willcock', '2020-10-27', 'Genderqueer', '223 158 6852', 'x5rFtHNT', '89 Thierer Plaza', 'ewillcock3', 'False Ragweed', 4);

#patient_table
insert into patient_table (patientId, firstName, lastName, dob, gender, contactNumber, password, address, roleId) values (1, 'Michal', 'Carslaw', '2020-10-28', 'Male', '357 991 8589', 'CMwBGCv6V', '9 Sundown Drive', 1);
insert into patient_table (patientId, firstName, lastName, dob, gender, contactNumber, password, address, roleId) values (2, 'William', 'Sicily', '2020-05-02', 'Bigender', '697 594 6355', 'WtqPsXs5', '98 Maple Parkway', 2);
insert into patient_table (patientId, firstName, lastName, dob, gender, contactNumber, password, address, roleId) values (3, 'Fabio', 'Caroline', '2020-06-26', 'Female', '168 348 3844', 'Eh4MLqzcimK', '0 Helena Street', 3);
insert into patient_table (patientId, firstName, lastName, dob, gender, contactNumber, password, address, roleId) values (4, 'Wolfgang', 'Eicke', '2020-04-30', 'Bigender', '755 673 1355', 'YWJPX6x9onJ', '7 Rockefeller Hill', 4);

#role_table
INSERT INTO role_table (roleId, roleName)
VALUES
(1, "Doctor"),
(2, "Admin"),
(3, "Patient"),
(4, "Agent");

#TestResult_table
insert into testresult_table (testId, testName, testresult, patientId, diagnosticServiceId) values (1, 'foakenfall0', 'HoRIg5Q', 1, 1);
insert into testresult_table (testId, testName, testresult, patientId, diagnosticServiceId) values (2, 'dmarden1', '50kYRgowsNH', 2, 2);
insert into testresult_table (testId, testName, testresult, patientId, diagnosticServiceId) values (3, 'jkennea2', 'WWZWiNK', 3, 3);
insert into testresult_table (testId, testName, testresult, patientId, diagnosticServiceId) values (4, 'cleland3', '4g89fT8', 4, 4);

#update commission table
insert into commission_table (commissionId, baselineValue, diagnosticServiceId) values (1, 286, 1);
insert into commission_table (commissionId, baselineValue, diagnosticServiceId) values (2, 986, 2);
insert into commission_table (commissionId, baselineValue, diagnosticServiceId) values (3, 842, 3);
insert into commission_table (commissionId, baselineValue, diagnosticServiceId) values (4, 255, 4);

#updateTreatment
insert into updatetreatment_table (treatmentId, patientId, doctorId, diagnosticServiceId, testresultId, symptoms, diagnosis, recommendation, diet, prescription) values (1, 1, 1, 1, 1, 'Oil & Gas Production', 'Center', 'Terrace', 'Browning', 'Savings Institutions');
insert into updatetreatment_table (treatmentId, patientId, doctorId, diagnosticServiceId, testresultId, symptoms, diagnosis, recommendation, diet, prescription) values (2, 2, 2, 2, 2, 'Major Banks', 'Way', 'Place', 'Welch', 'n/a');
insert into updatetreatment_table (treatmentId, patientId, doctorId, diagnosticServiceId, testresultId, symptoms, diagnosis, recommendation, diet, prescription) values (3, 3, 3, 3, 3, 'Radio And Television Broadcasting And Communications Equipment', 'Hill', 'Place', 'New Castle', 'Steel/Iron Ore');
insert into updatetreatment_table (treatmentId, patientId, doctorId, diagnosticServiceId, testresultId, symptoms, diagnosis, recommendation, diet, prescription) values (4, 4, 4, 4, 4, 'Packaged Foods', 'Parkway', 'Street', 'Sherman', 'Diversified Commercial Services');
