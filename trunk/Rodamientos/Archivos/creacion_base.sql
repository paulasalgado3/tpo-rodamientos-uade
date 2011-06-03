CREATE DATABASE RODAMIENTOS

USE RODAMIENTOS


create login usr_rodamientos with
	password = '123456',
	check_policy = off,
	default_database = RODAMIENTOS	

exec sp_changedbowner usr_rodamientos
