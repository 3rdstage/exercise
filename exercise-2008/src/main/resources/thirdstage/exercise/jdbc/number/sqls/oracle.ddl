create table tb_line1(
	id number(10,0) not null,
	x number not null,
	y number not null,
	primary key (id)
);

create table tb_line2(
	id number(10,0) not null,
	x varchar2(100) not null,
	y varchar2(100) not null,
	primary key (id)
);

insert into tb_line1 (id, x, y) values (100, 1.10, 2.00);
insert into tb_line2 (id, x, y) values (100, '1.10', '2.00');