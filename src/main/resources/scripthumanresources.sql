CREATE DATABASE humanresources
    WITH
    OWNER = postgres
    ENCODING = 'UTF8';

COMMENT ON DATABASE humanresources
    IS 'database to keep a record of employees.';
	
/*Elimina tabla empleados*/
drop table employee;

/*El id de la tabla es autoincremental*/
CREATE TABLE employee
(
    id serial NOT NULL PRIMARY KEY,
    name text NOT NULL,
    email text NOT NULL,
    city text NOT NULL,
    zipcode text NOT NULL,
    salary numeric(15, 2) NOT NULL,
    registration_date timestamp NOT NULL
);

/*Actualizamos la tabla agregando el campo fecha de aumento salarial la cual se dara cada 6 meses.*/
ALTER TABLE employee
ADD COLUMN salary_increase_date timestamp;

/*Creamos procedure para guardar fecha de alta en el sistema de un empleado*/
CREATE OR REPLACE PROCEDURE public.INSERT_PROC(v_name_proc text, v_email_proc text, v_city_proc text, v_zipcode_proc text, v_salary numeric)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
	INSERT INTO employee(name, email, city, zipcode ,salary, registration_date, salary_increase_date)
	VALUES(v_name_proc, v_email_proc, v_city_proc, v_zipcode_proc, v_salary, now(), now() + interval '6 month');
END
$BODY$;

DROP PROCEDURE public.INSERT_PROC;

call public.INSERT_PROC('testName', 'testEmail', 'testCity', 'testZipcode', 100000.50);

select * from employee;
delete from employee;

/* funcion para sumar o restar fechas */		
select now() - interval'5 days';
select now() - interval '5 days 3 hours';		   
select now() - interval '5 days 3 hours 15 minutes';
select now() + interval '6 month';
select now() + interval '1 year';