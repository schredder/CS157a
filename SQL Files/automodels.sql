--WORK IN PROGRESS!
--BEGIN TRANSACTION;

--Create table MAKERS
CREATE TABLE MODELS
(MNO    NUMBER(2),
 NAME   VARCHAR2(30),
 ENGI
 MCOD   VARCHAR2(3) REFERENCES MAKERS.COD)