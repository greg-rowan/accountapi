--CREATE USER docker;
--CREATE DATABASE docker;
--GRANT ALL PRIVILEGES ON DATABASE docker to docker;

-- DDL ---
CREATE TABLE account (
user_id serial PRIMARY KEY,
username VARCHAR (50) UNIQUE NOT NULL,
password VARCHAR (50) NOT NULL,
email VARCHAR (355) UNIQUE NOT NULL,
created_on TIMESTAMP NOT NULL,
last_login TIMESTAMP
);

CREATE TABLE role (
role_id serial PRIMARY KEY,
role_name VARCHAR (255) UNIQUE NOT NULL
);


CREATE TABLE account_role
(
  user_id integer NOT NULL,
  role_id integer NOT NULL,
  grant_date timestamp without time zone,
  PRIMARY KEY (user_id, role_id),
  CONSTRAINT account_role_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES role (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT account_role_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- DML --
insert into account
values
  (100, 'BILL SMITH', 'P@SSW@RD','bill.smith@gmail.com', current_timestamp, current_timestamp )
, (101, 'SAM DARNOLD', 'P@SSW@RD','sd@gmail.com', current_timestamp, current_timestamp )
, (102, 'JILL JACKSOLN', 'P@SSW@RD','jillj@gmail.com', current_timestamp, current_timestamp )
, (103, 'BARRY MANILOW', 'P@SSW@RD','barry_m@gmail.com', current_timestamp, current_timestamp )
, (104, 'JOE THOMAS', 'P@SSW@RD','joe.t@gmail.com', current_timestamp, current_timestamp );

insert into role
values(1, 'ADMIN'),(2,'MANAGER'),(3, 'EMPLOYEE');

insert into account_role
values
  (100, 1, current_timestamp)
, (101, 2, current_timestamp)
, (102, 2, current_timestamp)
, (103, 3, current_timestamp)
, (104, 3, current_timestamp);


-- Version Check --
select version();

