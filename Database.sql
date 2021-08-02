create database carManagement

create table [User] (
UserID int primary key,
UserName varchar(30) NOT NULL,
[Password] varchar(30) NOT NULL,
Designation varchar(20) NOT NULL,
)
go

create table Inventory(
ItemCode int primary key,
ItemName varchar(30) NOT NULL,
Manufacturer varchar(30) NOT NULL,
ItemType varchar(20) NOT NULL,
ItemPrice int NOT NULL DEFAULT 0,
ItemQty int NOT NULL DEFAULT 0,
)
go

create table [Service](
ServiceCode int primary key,
ServiceName varchar(30) NOT NULL,
ServiceType varchar(20) NOT NULL,
ServiceCost int NOT NULL DEFAULT 0,
)
go

insert into [User]
VALUES
(1,'M. Ansar Butt','123','Manager'),
(2,'Muhammad Haris Saeed','123','Manager'),
(3,'Fatima Nauman','123','Manager')
GO

insert into Inventory
VALUES
(1,'Air Filter TX-560','Suzuki','Air Filter',300,100),
(2,'Gear Filter X-560','Suzuki','Gear Filter',700,96),
(3,'Clutch Oil GX-50 3L','Kixx','Clutch Oil',3000,67),
(4,'Break Oil NX-89 2L','Kixx','Break Oil',1000,89),
(5,'Air Filter GC-890','Toyota','Air Filter',400,10),
(6,'Rim 15.6','General','Rim',10000,15),
(7,'Break Shoe 1.8','Norton','Break Shoe',1900,90)
GO

insert into [Service]
VALUES
(1,'Car Wash','Automatic',3000),
(2,'Wheel Allignment','Manual',2000),
(3,'Tuning','Manual',500)
GO