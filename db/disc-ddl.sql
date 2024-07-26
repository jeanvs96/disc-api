--CREATE schema disc;

CREATE SEQUENCE seq_users
	INCREMENT 1
	START 1;

CREATE TABLE users (
	user_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_users'),
	username text NOT NULL unique,
	email text not null unique,
	password text NOT NULL,
	status bool not null);

CREATE SEQUENCE seq_roles
    INCREMENT 1
	START 1;

CREATE TABLE roles (
	role_id bigint NOT null PRIMARY KEY default nextval('disc.seq_roles'),
	role_name text NOT null);

CREATE SEQUENCE seq_users_roles
    INCREMENT 1
	START 1;

CREATE TABLE users_roles (
	id_user_role bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_users_roles'),
	user_id bigint NOT NULL,
	role_id bigint NOT NULL,
			CONSTRAINT fk_users_roles_id_user
				FOREIGN KEY (user_id)
				REFERENCES users(user_id),
			CONSTRAINT fk_users_roles_id_roles
				FOREIGN KEY (role_id)
				REFERENCES roles(role_id)
);

CREATE SEQUENCE seq_state
    INCREMENT 1
	START 1;


CREATE TABLE state (
	state_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_state'),
	name text NOT NULL unique
);

CREATE SEQUENCE seq_city
    INCREMENT 1
	START 1;

CREATE TABLE city (
	city_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_city'),
	name text not NULL, 
	state_id bigint NOT NULL,
			CONSTRAINT fk_city_state
				FOREIGN KEY (state_id)
				REFERENCES state(state_id)
);

alter table users 
	add column city_id bigint, 
		add constraint fk_user_city
			foreign key (city_id)
			references city(city_id)
;

alter table users 
	add column birth_date date;

CREATE SEQUENCE seq_education_level
    INCREMENT 1
	START 1;

create table education_level (
	education_level_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_education_level'),
	education_level text not null
);

alter table users 
	add column education_level_id bigint,
		add constraint fk_user_education_level
			foreign key (education_level_id)
			references education_level(education_level_id)
;
			

CREATE SEQUENCE seq_field_of_interest
    INCREMENT 1
	START 1;

create table field_of_interest (
	field_of_interest_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_field_of_interest'),
	field text not null
);

alter table users 
	add column field_of_interest_id bigint,
		add constraint fk_user_field_of_interest
			foreign key (field_of_interest_id)
			references field_of_interest(field_of_interest_id)
;

CREATE SEQUENCE seq_tests
    INCREMENT 1
	START 1;

create table tests (
	test_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_tests'),
	name text not null
);

CREATE SEQUENCE seq_test_results
    INCREMENT 1
	START 1;

create table test_results (
	test_result_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_test_results'),
	d_factor bigint not null,
	i_factor bigint not null,
	s_factor bigint not null,
	c_factor bigint not null,
	test_date date not null,
	test_id bigint not null,
	user_id bigint not null,
			CONSTRAINT fk_result_test
				FOREIGN KEY (test_id)
				REFERENCES tests(test_id),
			CONSTRAINT fk_result_user
				FOREIGN KEY (user_id)
				REFERENCES users(user_id)
);

CREATE SEQUENCE seq_questions
    INCREMENT 1
	START 1;

create table questions (
	question_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_questions'),
	question text not null,
	test_id bigint not null,
			CONSTRAINT fk_question_test
				FOREIGN KEY (test_id)
				REFERENCES tests(test_id)
);

CREATE SEQUENCE seq_answers
    INCREMENT 1
	START 1;

create table answers (
	answer_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_answers'),
	answer text not null,
	factor text not null,
	question_id bigint not null,
			CONSTRAINT fk_answers_questions
				FOREIGN KEY (question_id)
				REFERENCES questions(question_id)
);

CREATE SEQUENCE seq_ongoing_test
    INCREMENT 1
	START 1;

create table ongoing_test (
	ongoing_test_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_ongoing_test'),
	test_id bigint not null,
	user_id bigint not null,
	current_question bigint not null,
			CONSTRAINT fk_ongoing_test_test
				FOREIGN KEY (test_id)
				REFERENCES tests(test_id),
			CONSTRAINT fk_ongoing_test_user
				FOREIGN KEY (user_id)
				REFERENCES users(user_id)
);

CREATE SEQUENCE seq_ongoing_test_answers
    INCREMENT 1
	START 1;

create table ongoing_test_answers (
	ongoing_test_answers_id bigint NOT null PRIMARY KEY DEFAULT nextval('disc.seq_ongoing_test_answers'),
	question_id bigint not null,
	ongoing_test_id bigint not null,
	d_factor bigint not null,
	i_factor bigint not null,
	s_factor bigint not null,
	c_factor bigint not null,
			CONSTRAINT fk_ongoing_test_answers_question
				FOREIGN KEY (question_id)
				REFERENCES questions(question_id),
			CONSTRAINT fk_ongoing_test_answers_ongoing_test
				FOREIGN KEY (ongoing_test_id)
				REFERENCES ongoing_test(ongoing_test_id)
);

alter table test_results  
	add column test_date date not null
;

create sequence seq_authentication_code
	increment 1
	start 1;
	
create table authentication_code (
	authentication_code_id bigint not null primary key default nextval('disc.seq_authentication_code'),
	user_id bigint not null,
	code text unique not null,
	date_time timestamp not null,
		constraint fk_password_recovery_code_user
			foreign key (user_id)
				references users(user_id)
);

create sequence seq_factor_combination_description
	increment 1
	start 1;

create table factor_combination_description (
	factor_combination_id bigint not null primary key default nextval('disc.seq_factor_combination_description'),
	factor_combination text unique not null,
	title text not null,
	description text not null
);

create sequence seq_test_results_factor_combination
	increment 1
	start 1;

create table test_results_factor_combination (
	test_results_factor_combination_id bigint not null primary key default nextval('disc.seq_test_results_factor_combination'),
	test_result_id bigint not null,
	factor_combination_id bigint not null,
	constraint fk_test_result_factor_combination
			foreign key (test_result_id)
				references test_results(test_result_id),
	constraint fk_factor_combination_test_result
		foreign key (factor_combination_id)
			references factor_combination_description(factor_combination_id)
);

create sequence seq_main_factor_description
	increment 1
	start 1;

CREATE TABLE disc.main_factor_description (
	main_factor_description_id int8 NOT NULL DEFAULT nextval('disc.seq_main_factor_description'::regclass),
	factor text NOT NULL,
	title text NOT NULL,
	description text NOT NULL,
	positive_points text NOT NULL,
	improvement_points text NOT NULL,
	keywords text NOT NULL,
	CONSTRAINT main_factor_description_pkey PRIMARY KEY (main_factor_description_id)
);