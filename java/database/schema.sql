BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, animal, availability,volunteer,adopter,questionnaire,donation;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE volunteer (
    volunteer_id int,
    first_name varchar (50) not null,
    last_name varchar (50) not null,
    address varchar(50) not null,
    phone_number varchar(11) not null,
	is_active boolean not null,
	status varchar (10) not null,


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
   photo varchar (200),
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
	phone_number varchar (50) not null,
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

 CREATE TABLE donation (

 donation_id serial,
 donator_id int,
 donation_date DATE not null,
 first_name varchar(50) not null,
 last_name varchar(50) not null,
 description varchar(2000) not null,

 CONSTRAINT pk_donation PRIMARY KEY(donation_id),
 CONSTRAINT fk_donation_user FOREIGN KEY(donator_id) references users(user_id)


 );

COMMIT TRANSACTION;

INSERT INTO users (username,password_hash,role)
VALUES('testuser','123456789','user');

INSERT INTO volunteer ( volunteer_id,first_name, last_name,address,phone_number,is_active)
VALUES ((SELECT user_id FROM users WHERE user_id = 1 ),'test','test','address','412412412',true);


INSERT INTO availability (volunteer_id,available_date,available_time)
VALUES ((SELECT volunteer_id FROM volunteer WHERE volunteer_id =1),'2022-12-12','afternoon');

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,photo,is_adopted)
VALUES ('dog','Golden-Retriever-Mixed',5,'Noisy','Medium','Indie',false,'https://i.imgur.com/L1b5K2P.png',true);

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,photo,is_adopted)
VALUES ('cat','tabby',10,'Noisy','Small','Oliver',false,'https://styles.redditmedia.com/t5_2r5i1/styles/communityIcon_x4lqmqzu1hi81.jpg',true);

INSERT INTO adopter ( adopter_id,approved_to_adopt,animal_id)
VALUES ((SELECT user_id FROM users WHERE user_id=1),'Approved',1);

INSERT INTO questionnaire (first_name,last_name,number_children,housing_type,fenced_yard,walker,years_of_pet_experience,renting_or_owning,vet,disabled,animal_id,adopter_id,reference_one,reference_one_contact,reference_two,reference_two_contact)
VALUES ('Lucas','Rover',0,'House',false,'Lucas',20,'own','vet',false,1,1,'referenceOne','contactOne','referenceTwo','contactTwo');

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,photo,is_adopted)
VALUES ('Cat','Tabby',4,'Sly','Medium','Elon',false,'https://i.imgur.com/AD3MbBi.jpeg',true);

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,photo,is_adopted)
VALUES ('Cat','American Tabby',5,'Delightful','large','Felix',false,'https://i.imgur.com/wYTCtRu.jpeg',true);

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,photo,is_adopted)
VALUES ('bunny','American Bunny',12,'Nuts','Medium','Sprinkles',false,'https://i.imgur.com/2Qg5o0N.jpeg',true);

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,photo,is_adopted)
VALUES ('ferret','unknown',7,'Curious','Small','Winston',false,'https://i.imgur.com/vqtP2Jm.jpeg',true);

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,photo,is_adopted)
VALUES ('bunny','unknown',2,'Anxious','Small','Roger',false,'https://i.imgur.com/jydvLf6.jpeg',true);

INSERT INTO animal (type,breed,age,temperament,size, name,special_needs,photo,is_adopted)
VALUES ('dog','mixed',4,'Friendly','Medium','Daisy',false,'https://i.imgur.com/gkcz5Ep.jpg',true);

insert into donation (donation_id,donation_date, first_name,last_name,description)
values(default,'01-01-2022','Bibek','siwakoti','i would like to donate');
