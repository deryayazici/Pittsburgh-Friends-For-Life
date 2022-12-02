BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, animal, availability,volunteer;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE availability (
   availability_id serial,
   morning boolean,
   afternoon boolean,
   evening boolean,
   Monday boolean,
   Tuesday boolean,
   Wednesday boolean,
   Thursday boolean,
   Friday boolean,
   Saturday boolean,
   Sunday boolean,

   CONSTRAINT pk_availability PRIMARY KEY (availability_id)
);

CREATE TABLE volunteer (
    volunteer_id int,
    address varchar(50) not null,
    phone_number varchar(11) not null,
    availability_id int,

    CONSTRAINT pk_volunteer PRIMARY KEY (volunteer_id),
    CONSTRAINT fk_volunteer_availability FOREIGN KEY (availability_id) references availability (availability_id),
    CONSTRAINT fk_volunteer_users FOREIGN KEY (volunteer_id) references users (user_id)

);


CREATE TABLE animal(
   animal_id serial,
   type varchar(10) not null,
   breed varchar(20),
   age int,
   size varchar,
   temperament varchar,
   name varchar(20),
   specialNeeds boolean,
   photo varchar (20),
   isAdopted boolean,

   CONSTRAINT pk_animal PRIMARY KEY (animal_id)

);

CREATE TABLE adopters (

      adopter_id int,
      approvedToAdopt varchar(10) not null,
      animal_id int not null,
      questionnaire_id int not null,

      CONSTRAINT pk_adopters PRIMARY KEY (adopter_id),
      CONSTRAINT fk_adopters_users FOREIGN KEY (adopter_id) references users (user_id),
      CONSTRAINT fk_adopters_animal FOREIGN KEY (animal_id) references animal (animal_id)

);

COMMIT TRANSACTION;


