--BEGIN TRANSACTION;

--Create table MAKERS
CREATE TABLE MAKERS
(MNO    NUMBER(2),
 MAK    VARCHAR2(30),
 COD    VARCHAR2(3),
 PRIMARY KEY (MNO));

INSERT INTO MAKERS VALUES ('01', 'AMERICAN MOTORS OR AMC', 'AMC')
INSERT INTO MAKERS VALUES ('02', 'AUDI', 'AUD')
INSERT INTO MAKERS VALUES ('03', 'BMW', 'BMW')
INSERT INTO MAKERS VALUES ('04', 'BUICK', 'BUK')
INSERT INTO MAKERS VALUES ('05', 'CADILLAC', 'CAD')
INSERT INTO MAKERS VALUES ('06', 'CHEVROLET', 'CHE')
INSERT INTO MAKERS VALUES ('07', 'CHRYSLER', 'CRY')
INSERT INTO MAKERS VALUES ('08', 'DODGE', 'DOD')
INSERT INTO MAKERS VALUES ('09', 'DODGE/PLYMOUTH LITE TRK & VAN', 'DOT')
INSERT INTO MAKERS VALUES ('10', 'FORD LIGHT TRUCK AND VAN', 'FDT')
INSERT INTO MAKERS VALUES ('11', 'FORD MEDIUM AND HEAVY TRUCK', 'FDM')
INSERT INTO MAKERS VALUES ('12', 'FIAT', 'FIA')
INSERT INTO MAKERS VALUES ('13', 'FORD', 'FOR')
INSERT INTO MAKERS VALUES ('14', 'CHEVROLET & GMC TRUCK & VAN', 'GMC')
INSERT INTO MAKERS VALUES ('15', 'HONDA', 'HON')
INSERT INTO MAKERS VALUES ('16', 'INTERNATIONAL TRUCK (I.H.C.)', 'INT')
INSERT INTO MAKERS VALUES ('17', 'ISUZU', 'ISU')
INSERT INTO MAKERS VALUES ('18', 'LINCOLN', 'LIN')
INSERT INTO MAKERS VALUES ('19', 'MERCEDES', 'MCS')
INSERT INTO MAKERS VALUES ('20', 'MITSUBISHI', 'MIT')
INSERT INTO MAKERS VALUES ('21', 'MERCURY', 'MRY')
INSERT INTO MAKERS VALUES ('22', 'MAZDA', 'MZD')
INSERT INTO MAKERS VALUES ('23', 'NISSAN / DATSUN', 'NIS')
INSERT INTO MAKERS VALUES ('24', 'OLDSMOBILE', 'OLD')
INSERT INTO MAKERS VALUES ('25', 'PLYMOUTH', 'PLY')
INSERT INTO MAKERS VALUES ('26', 'PORSCHE', 'POR')
INSERT INTO MAKERS VALUES ('27', 'PONTIAC', 'PON')
INSERT INTO MAKERS VALUES ('28', 'RENAULT', 'REN')
INSERT INTO MAKERS VALUES ('29', 'SAAB', 'SAB')
INSERT INTO MAKERS VALUES ('30', 'SUBARU', 'SUB')
INSERT INTO MAKERS VALUES ('31', 'TOYOTA', 'TOY')
INSERT INTO MAKERS VALUES ('32', 'UPS', 'UPS')
INSERT INTO MAKERS VALUES ('33', 'VOLKSWAGEN', 'VOL')
INSERT INTO MAKERS VALUES ('34', 'HYUNDAI', 'HUN')
INSERT INTO MAKERS VALUES ('35', 'YUGO', 'YUG')
INSERT INTO MAKERS VALUES ('36', 'GMC TRUCK AND VAN', 'GMM')
