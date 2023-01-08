create table turf(
	id varchar(50) not null,
	name varchar(100) not null,
	pin varchar(50) not null,
	address varchar(max),
	owner_id varchar(50),
	turf_status varchar(50),
	approval_status varchar(50),
	primary key(id)
);

create table turf_Booking(
	id varchar(50) not null,
	turf_id varchar(50) not null,
	created_datetime varchar(50) not null,
	booking_datetime varchar(50) not null,
	booking_date varchar(50) not null,
	booking_timeslot varchar(50) not null,
	created_by varchar(50),
	booking_status varchar(50),
	availability_status varchar(50),
	duration varchar(50)
	primary key(id)
);

create table turf_Availability(
	id varchar(50) not null,
	turf_id varchar(50) not null,
	available_date varchar(50) not null,
	available_time varchar(50) not null,
	availability_status varchar(50)
);


GO
CREATE SEQUENCE [dbo].[hibernate_sequence] 
 AS [bigint]
 START WITH 10000000
 INCREMENT BY 1
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO