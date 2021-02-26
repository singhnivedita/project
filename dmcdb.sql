use dmcdb;


show tables;
select * from testresult_table;

select * from updatetreatment_table;
select * from Request_table;
select * from patient_table;
select * from service_table;
Insert into Request_table Values
("3","2021-09-01", "cough","Yes","1330","1","1","2");

Insert into service_table Values
("1","2008", "Not any","Radiology","19:30:10");

Insert into doctor_table Values
('1', 'Indore, India', '6663854425', '1984-01-01', 'Dr. MP', 'Male', 'Singh', 'doctorpwd', 'MBBBS, MD', 'General Physician', '1');
desc Request_table;
desc service_table;
desc doctor_table;
Select patientId FROM Request_table  WHERE docId="1";



select* from Request_table Inner Join patient_table on patient_table.pId = Request_table.patientId AND Request_table.status ="Yes"