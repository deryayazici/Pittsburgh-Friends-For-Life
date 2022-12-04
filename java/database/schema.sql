BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, animal, availability,volunteer,adopter,questionnaire;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE volunteer (
    volunteer_id int,
    address varchar(50) not null,
    phone_number varchar(11) not null,
	is_active boolean not null,


    CONSTRAINT pk_volunteer PRIMARY KEY (volunteer_id),
    CONSTRAINT fk_volunteer_users FOREIGN KEY (volunteer_id) references users (user_id)

);

CREATE TABLE availability (
   availability_id serial,
   volunteer_id int not null,
   available_date DATE not null,
   available_time varchar(15) not null,

   CONSTRAINT pk_availability PRIMARY KEY (availability_id),
   CONSTRAINT fk_volunteer_availability FOREIGN KEY (volunteer_id) references volunteer (volunteer_id)
);


CREATE TABLE animal(
   animal_id serial,
   type varchar(10) not null,
   breed varchar(50),
   age int,
   size varchar(10),
   temperament varchar(50),
   name varchar(20),
   special_needs boolean,
   photo varchar (20),
   is_adopted boolean,

   CONSTRAINT pk_animal PRIMARY KEY (animal_id)

);

CREATE TABLE adopter (

      adopter_id int,
      approved_to_adopt varchar(10) not null,
      animal_id int not null,

      CONSTRAINT pk_adopter PRIMARY KEY (adopter_id),
      CONSTRAINT fk_adopter_users FOREIGN KEY (adopter_id) references users (user_id),
      CONSTRAINT fk_adopter_animal FOREIGN KEY (animal_id) references animal (animal_id)

);

CREATE TABLE questionnaire (

	questionnaire_id serial,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	number_children int not null,
    housing_type varchar(20) not null,
	fenced_yard boolean not null,
	walker varchar(50) not null,
	years_of_pet_experience int not null,
	renting_or_owning varchar (20) not null,
	vet varchar (50) not null,
	disabled boolean not null,
	animal_id int not null,
	adopter_id int not null,
	reference_one varchar(50) not null,
	reference_one_contact varchar(50) not null,
	reference_two varchar(50) not null,
	reference_two_contact varchar(50) not null,


	CONSTRAINT pk_questionnaire PRIMARY KEY (questionnaire_id),
	CONSTRAINT fk_questionnaire_animal FOREIGN KEY (animal_id) references animal (animal_id),
	CONSTRAINT fk_questionnaire_adopter FOREIGN KEY (adopter_id) references adopter (adopter_id)
);

COMMIT TRANSACTION;
--ROLLBACK;

--SELECT * FROM availability;

--SELECT * FROM animal;

INSERT INTO users (username,password_hash,role)
VALUES('testuser','123456789','user');

INSERT INTO volunteer ( volunteer_id,address,phone_number,is_active)
VALUES ((SELECT user_id FROM users WHERE user_id = 1 ),'address','412412412',true);

INSERT INTO availability (volunteer_id,available_date,available_time)
VALUES ((SELECT volunteer_id FROM volunteer WHERE volunteer_id =1),'2022-12-12','afternoon');

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,is_adopted)
VALUES ('dog','Golden-Retriever-Mixed',5,'Noisy','Medium','Indie',false,true);

INSERT INTO adopter ( adopter_id,approved_to_adopt,animal_id)
VALUES ((SELECT user_id FROM users WHERE user_id=1),'Approved',1);

INSERT INTO questionnaire (first_name,last_name,number_children,housing_type,fenced_yard,walker,years_of_pet_experience,renting_or_owning,vet,disabled,animal_id,adopter_id,reference_one,reference_one_contact,reference_two,reference_two_contact)
VALUES ('Lucas','Rover',0,'House',false,'Lucas',20,'own','vet',false,1,1,'referenceOne','contactOne','referenceTwo','contactTwo');


