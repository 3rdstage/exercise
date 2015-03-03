drop table sm_category;

create table sm_category(
	id varchar2(10) not null,
	name varchar2(60) not null,
	parent_id varchar2(10),
	seq number(5, 0),
	descn varchar2(2000),
	constraint pk_category primary key (id),
	constraint fk_cateogry_1 foreign key (parent_id) references sm_category(id) not deferrable
);

create index ix_category_1 on sm_category (parent_id);
create index ix_category_2 on sm_category (name);
