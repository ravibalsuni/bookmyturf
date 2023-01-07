create table turf(
	id varchar(50) not null,
	name varchar(100) not null,
	pin varchar(50) not null,
	address varchar(max),
	owner_Id varchar(50),
	turf_Status varchar(50),
	primary key(id)
);

create table turfBooking(
	id varchar(50) not null,
	turf_Id varchar(50) not null,
	createdDateTime Date not null,
	bookingDateTime Date not null,
	createdBy varchar(50),
	booking_Status varchar(50),
	primary key(id)
);

USE [bookmyturfDB]
GO
CREATE SEQUENCE [dbo].[hibernate_sequence] 
 AS [bigint]
 START WITH 10000000
 INCREMENT BY 1
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO