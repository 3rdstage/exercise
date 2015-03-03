
-- drop table employees_min;

create table employees_min(
	id number(10, 0) not null,
	name varchar2(60) not null,
	manager_id number(10, 0),
	constraint pk_employees_min primary key (id),
	constraint fk_employees_min_1 foreign key (manager_id) references employees_min(id)
);


insert into employees_min values (1, '홍길동', null);
insert into employees_min values (2, 'John', null);
insert into employees_min values (3, '태권  V', 1);
