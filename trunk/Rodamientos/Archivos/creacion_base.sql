CREATE DATABASE RODAMIENTOS;
GO

USE RODAMIENTOS;
GO

create login usr_rodamientos with
	password = '123456',
	check_policy = off,
	default_database = RODAMIENTOS	

exec sp_changedbowner usr_rodamientos

--Script
