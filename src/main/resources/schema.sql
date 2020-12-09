CREATE TABLE CUSTOMER (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  DOCUMENT_ID VARCHAR(250) NOT NULL,
  NAME VARCHAR(250) NOT NULL,
  AGE VARCHAR(250),
  REGISTRATION_DATE VARCHAR(250) NOT NULL,
  LAST_UPDATE VARCHAR(250) NOT NULL
);

ALTER TABLE CUSTOMER ADD CONSTRAINT UQ_DOCUMENT_ID UNIQUE(DOCUMENT_ID);

CREATE TABLE ADDRESS (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  ZIP_CODE VARCHAR(250) NOT NULL,
  NUMBER VARCHAR(250)
);

CREATE TABLE CUSTOMER_ADDRESS (
  ID_CUSTOMER INT NOT NULL,
  ID_ADDRESS INT NOT NULL
);