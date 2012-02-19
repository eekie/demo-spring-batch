CREATE TABLE SCRAPE_DATA
(
	ID BIGINT NOT NULL,
	CUSTOMER_ID INT,
	COMPANY_NAME VARCHAR(200),
	ADDRESS VARCHAR(200),
	TELEPHONE VARCHAR(200),
	OPENING_HOURS VARCHAR(2000),
	CATEGORIES VARCHAR(2000),
	URL VARCHAR(2000),
	CITY VARCHAR(200),
	POSTAL_CODE VARCHAR(20),
	STREET VARCHAR(200),
	HOUSE_NUMBER VARCHAR(10),
	PRIMARY KEY (ID),
);

CREATE TABLE SCRAPE_DATA_SEQ (
	ID BIGINT IDENTITY
);
INSERT INTO SCRAPE_DATA_SEQ (ID) values (0);
