drop table Menu;

create table Menu(
  id varchar(10),
  name varchar(50) not null constraint df_Menu_name default '',
  descn varchar(1000),
  parentId varchar(10),
  seq numeric(5,0) not null constraint df_Menu_seq default 1,
 	constraint pk_Menu primary key (id),
 	constraint fk_Menu_1 foreign key (parentId) references Menu(id),
 	constraint ck_Menu_1 check ( parentId <> id)
 );

create index ix_Menu_1 on Menu(parentId);