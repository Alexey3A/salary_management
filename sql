drop table if exists salarySource cascade;
drop table if exists positionLevel cascade;
drop table if exists structuralDivision cascade;
drop table if exists worker cascade;
drop table if exists worker_salarySource;

create table salarySource(
    id bigserial primary key,
    salarySourceName varchar unique not null,
    salarySourceSum numeric
);

create table positionLevel(
    position_id bigserial,
    position_name varchar unique,
    basic_salary numeric,
    primary key (position_id)
);

create table structuralDivision(
    division_id bigserial primary key,
    structuralDivision varchar
);

create table worker(
    worker_id bigserial primary key,
    surname varchar(50) not null,
    worker_name varchar(50) not null,
    patronymic varchar(50),
	structuralDivision bigserial references structuralDivision(division_id),
	position_level bigserial references positionLevel(position_id),
    minimal_salary numeric,
	totalSalary numeric
);

create table worker_salarySource(
    worker_id bigserial references worker(worker_id),
    salarySource_id bigserial references salarySource(id),
	primary key (worker_id, salarySource_id)
);