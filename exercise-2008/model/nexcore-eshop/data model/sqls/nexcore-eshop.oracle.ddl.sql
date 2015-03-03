/*
0. # of Table : 19, # of Sequence : 1, # of Function : 1

1. Use Oracle SQL Developer or commercial tools.
 Don't use free eclipse plug-ins such as DBViewer, jOra or free stand-alone tools 
such as SQuirreL SQL Client for intensive DDL script. Some of them can't recognize 
comments syntax or process multiple statements in correct way. Moreover such tools 
can't parse or execute 'create function' statements correctly.

2. After execute this script, compile stored procedures/functions.

3. About the additional period and slash after 'create function' statement, 
refer 'http://download.oracle.com/docs/cd/B10501_01/server.920/a90842/ch5.htm#1006009'
*/


-- Deletes schema object in reverse order.
drop table ps_employee_education;
drop table ps_employee_work_career;
drop table ps_employee_family_member;
drop table ps_employee;
drop table ps_lineitem;
drop table ps_item;
drop table ps_product;
drop table ps_category;
drop table ps_supplier;
drop table ps_qna_file;
drop table ps_qna;
drop sequence ps_qna_seq;
drop table ps_role_menu_map;
drop table ps_menu;
drop table ps_order;
drop table ps_account;
drop table ps_user;
drop table ps_role;
drop table ps_file;
drop function gen_num_for_table;
drop table ps_number;
purge recyclebin;

create table ps_number (
                table_name varchar2(20) not null,
                next_no number(20) not null,
                constraint pk_number primary key (table_name)
);

create or replace function gen_num_for_table(table_name_in in varchar2)
	return number
	is next_no_out number;
	begin
		select next_no into next_no_out 
			from ps_number 
			where table_name = table_name_in 
			for update wait 3;
		update ps_number set next_no = next_no + 1 
			where table_name = table_name_in;
		return (next_no_out);
	end;
/

create table ps_file (
                id number(20) not null,
                name varchar2(200) not null,
                path varchar2(1000) not null,
                constraint pk_file primary key (id)
);

create table ps_role (
                id varchar2(10) not null,
                name varchar2(80) not null,
                constraint pk_role primary key (id)
);

create table ps_user (
                login_id varchar2(10) not null,
                passwd varchar2(16) not null,
                role_id varchar2(10),
                registered_date varchar2(8),
                last_login_datetime varchar2(14),
                constraint pk_user primary key (login_id)
);

-- Oracle 10g XE(express edition) doen't support bitmap index.
-- create bitmap index idx_user_1 on ps_user ( role_id );
create index idx_user_1 on ps_user ( role_id );

create table ps_account (
                id varchar2(16) not null,
                login_id varchar2(10),
                name varchar2(80) not null,
                phone varchar2(20),
                email varchar2(50),
                country varchar2(50),
                zip varchar2(20),
                state varchar2(50),
                city varchar2(50),
                address varchar2(200),
                bonus_point number(10,0) default 0,
                constraint ps_account_pk primary key (id)
);
create index idx_account_1 on ps_account ( login_id );

create table ps_order (
                id number(10) not null,
                account_id varchar2(16) not null,
                ordered_date varchar2(8) not null,
                ordered_time varchar2(6),
                total_price number(10,2),
                constraint ps_order_pk primary key (id)
);
create index idx_order_1 on ps_order ( account_id );

create table ps_menu (
                id varchar2(10) not null,
                name varchar2(80) not null,
                parent_menu_id varchar2(10),
                display_order number(5),
                descn varchar2(1000),
                constraint pk_menu primary key (id)
);
create index idx_menu_1 on ps_menu ( parent_menu_id );

create table ps_role_menu_map (
                role_id varchar2(10) not null,
                menu_id varchar2(10) not null,
                constraint pk_role_menu_map primary key (role_id, menu_id)
);

create sequence ps_qna_seq;

create table ps_qna (
                id number(20) not null,
                parent_qna_id number(20),
                title varchar2(200) not null,
                body varchar2(4000),
                writer_id varchar2(10),
                registered_datetime varchar2(14),
                constraint pk_qna primary key (id)
);
create index idx_qna_1 on ps_qna ( parent_qna_id );
create index idx_qna_2 on ps_qna ( title );
create index idx_qna_3 on ps_qna ( writer_id );

create table ps_qna_file (
                qna_id number(20) not null,
                file_id number(20) not null,
                display_order number(5),
                constraint pk_qna_file primary key (qna_id, file_id)
);

create table ps_supplier (
                id varchar2(10) not null,
                name varchar2(80) not null,
                phone varchar2(20),
                constraint pk_supplier primary key (id)
);

create table ps_category (
                id varchar2(10) not null,
                name varchar2(80) not null,
                descn varchar2(1000),
                constraint pk_category primary key (id)
);

create table ps_product (
                id varchar2(10) not null,
                category_id varchar2(10) not null,
                name varchar2(80) not null,
                short_descn varchar2(1000),
                full_descn clob,
                constraint pk_product primary key (id)
);

create table ps_item (
                id varchar2(10) not null,
                product_id varchar2(10) not null,
                supplier_id varchar2(10),
                unit_cost number(10,2),
                list_price number(10,2),
                qty number(10),
                constraint pk_item primary key (id)
);
create index idx_item_1 on ps_item ( product_id );

create table ps_lineitem (
                order_id number(10) not null,
                item_no number(5) not null,
                item_id varchar2(10) not null,
                unit_price number(10,2),
                qty number(5),
                constraint pk_lineitem primary key (order_id, item_no)
);
create index idx_lineitem_1 on ps_lineitem ( item_id );

create table ps_employee (
                id varchar2(16) not null,
                name varchar2(80) not null,
                phone varchar2(20),
                email varchar2(50),
                job_code varchar2(10),
                position_code varchar2(10),
                status_code varchar2(10),
                entrance_date char(8),
                resignation_date char(8),
                constraint pk_employee primary key (id)
);

create table ps_employee_family_member (
                employee_id varchar2(16) not null,
                member_no number(10) not null,
                name varchar2(80) not null,
                member_relation_code varchar2(10),
                birthday char(8),
                phone varchar2(20),
                constraint pk_employee_family_member primary key (employee_id, member_no)
);

create table ps_employee_work_career (
                employee_id varchar2(16) not null,
                work_career_no number(10) not null,
                company_name varchar2(80) not null,
                department_name varchar2(160),
                job varchar2(2000),
                end_month char(6),
                start_month varchar2(6) not null,
                constraint pk_employee_work_career primary key (employee_id, work_career_no)
);

create table ps_employee_education (
                employee_id varchar2(16) not null,
                education_no number(10) not null,
                name varchar2(80) not null,
                education_class_code varchar2(10),
                institution_name varchar2(80),
                start_date char(8),
                end_date char(8),
                duration_hour number(5),
                constraint pk_employee_education primary key (employee_id, education_no)
);


-- Adds foreign-keys.
alter table ps_qna_file add constraint fk_qna_file_2
foreign key (file_id)
references ps_file (id)
not deferrable;

alter table ps_user add constraint fk_user_1
foreign key (role_id)
references ps_role (id)
not deferrable;

alter table ps_role_menu_map add constraint fk_role_menu_map_1
foreign key (role_id)
references ps_role (id)
not deferrable;

alter table ps_qna add constraint fk_qna_2
foreign key (writer_id)
references ps_user (login_id)
not deferrable;

alter table ps_account add constraint fk_account_1
foreign key (login_id)
references ps_user (login_id)
not deferrable;

alter table ps_order add constraint fk_order_1
foreign key (account_id)
references ps_account (id)
not deferrable;

alter table ps_lineitem add constraint fk_lineitem_1
foreign key (order_id)
references ps_order (id)
not deferrable;

alter table ps_menu add constraint fk_menu_1
foreign key (parent_menu_id)
references ps_menu (id)
not deferrable;

alter table ps_role_menu_map add constraint fk_role_menu_map_2
foreign key (menu_id)
references ps_menu (id)
not deferrable;

alter table ps_qna add constraint fk_qna_1
foreign key (parent_qna_id)
references ps_qna (id)
not deferrable;

alter table ps_qna_file add constraint fk_qna_file_1
foreign key (qna_id)
references ps_qna (id)
not deferrable;

alter table ps_item add constraint fk_item_2
foreign key (supplier_id)
references ps_supplier (id)
not deferrable;

alter table ps_product add constraint fk_product_1
foreign key (category_id)
references ps_category (id)
not deferrable;

alter table ps_item add constraint fk_item_1
foreign key (product_id)
references ps_product (id)
not deferrable;

alter table ps_lineitem add constraint fk_lineitem_2
foreign key (item_id)
references ps_item (id)
not deferrable;

alter table ps_employee_family_member add constraint fk_employee_family_member_1
foreign key (employee_id)
references ps_employee (id)
not deferrable;

alter table ps_employee_work_career add constraint fk_employee_work_career_1
foreign key (employee_id)
references ps_employee (id)
not deferrable;

alter table ps_employee_education add constraint fk_employee_education_1
foreign key (employee_id)
references ps_employee (id)
not deferrable;


-- Adds audit columns
alter table ps_number add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_file add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_role add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_user add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_account add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_order add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_menu add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_role_menu_map add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_qna add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_qna_file add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_supplier add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_category add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_product add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_item add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_lineitem add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_employee add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_employee_family_member add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_employee_work_career add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));
alter table ps_employee_education add
	(create_user varchar2(10), create_dt char(14), last_modify_user varchar2(10), last_modify_dt char(14));


-- Adds comments for tables and columns.
comment on table ps_account is '��';
comment on column ps_account.id is '��id';
comment on column ps_account.phone is '��ȭ��ȣ';
comment on column ps_account.email is 'e-mail �ּ�';
comment on column ps_account.country is '����';
comment on column ps_account.zip is '�����ȣ';
comment on column ps_account.state is '��, Ư����/������/��';
comment on column ps_account.city is '��/��/��';
comment on column ps_account.address is '���ּ�';
comment on column ps_account.login_id is '�����id';
comment on column ps_account.name is '����';
comment on column ps_account.bonus_point is '���ʽ�����Ʈ';

comment on table ps_category is '��ǰ�з�';
comment on column ps_category.id is '��ǰ�з�id';
comment on column ps_category.name is '��ǰ�з���';
comment on column ps_category.descn is '����';

comment on table ps_file is '����';
comment on column ps_file.id is '����id';
comment on column ps_file.name is '���ϸ�';
comment on column ps_file.path is '������';

comment on table ps_item is '�ǸŻ�ǰ';
comment on column ps_item.id is '�ǸŻ�ǰid';
comment on column ps_item.product_id is '��ǰid';
comment on column ps_item.supplier_id is '������id';
comment on column ps_item.unit_cost is '���޴ܰ�';
comment on column ps_item.list_price is '�ǸŴܰ�';
comment on column ps_item.qty is '������';
comment on column ps_item.create_user is '������id';
comment on column ps_item.create_dt is '�����Ͻ�';
comment on column ps_item.last_modify_user is '�ֱټ�����id';
comment on column ps_item.last_modify_dt is '�ֱټ����Ͻ�';

comment on table ps_lineitem is '�ֹ��׸�';
comment on column ps_lineitem.order_id is '�ֹ�id';
comment on column ps_lineitem.item_no is '�׸��ȣ';
comment on column ps_lineitem.item_id is '�ǸŻ�ǰid';
comment on column ps_lineitem.unit_price is '�ֹ��ܰ�';
comment on column ps_lineitem.qty is '�ֹ�����';
comment on column ps_lineitem.create_user is '������id';
comment on column ps_lineitem.create_dt is '�����Ͻ�';
comment on column ps_lineitem.last_modify_user is '�ֱټ�����id';
comment on column ps_lineitem.last_modify_dt is '�ֱټ����Ͻ�';

comment on table ps_menu is '�޴�';
comment on column ps_menu.id is '�޴�id';
comment on column ps_menu.name is '�޴���';
comment on column ps_menu.parent_menu_id is '�����޴���';
comment on column ps_menu.display_order is 'ǥ�ü���';
comment on column ps_menu.descn is '����';

comment on table ps_number is '��ȣ';
comment on column ps_number.table_name is '���̺��';
comment on column ps_number.next_no is '������ȣ';

comment on table ps_order is '�ֹ�';
comment on column ps_order.id is '�ֹ�id';
comment on column ps_order.account_id is '�ֹ���id';
comment on column ps_order.ordered_date is '�ֹ�����';
comment on column ps_order.ordered_time is '�ֹ��ð�';
comment on column ps_order.total_price is '�ֹ��Ѿ�';
comment on column ps_order.create_user is '������id';
comment on column ps_order.create_dt is '�����Ͻ�';
comment on column ps_order.last_modify_user is '�ֱټ�����id';
comment on column ps_order.last_modify_dt is '�ֱټ����Ͻ�';

comment on table ps_product is '��ǰ';
comment on column ps_product.id is '��ǰid';
comment on column ps_product.category_id is '��ǰ�з�id';
comment on column ps_product.name is '��ǰ��';
comment on column ps_product.short_descn is '��༳��';
comment on column ps_product.full_descn is '��ü����';
comment on column ps_product.create_user is '������id';
comment on column ps_product.create_dt is '�����Ͻ�';
comment on column ps_product.last_modify_user is '�ֱټ�����id';
comment on column ps_product.last_modify_dt is '�ֱټ����Ͻ�';

comment on table ps_qna is 'QnA';
comment on column ps_qna.id is 'QnA id';
comment on column ps_qna.parent_qna_id is '���� QnA id';
comment on column ps_qna.title is '����';
comment on column ps_qna.body is '����';
comment on column ps_qna.writer_id is '�ۼ���id';
comment on column ps_qna.registered_datetime is '����Ͻ�';

comment on table ps_qna_file is 'QnA ����';
comment on column ps_qna_file.qna_id is 'QnA id';
comment on column ps_qna_file.file_id is '����id';
comment on column ps_qna_file.display_order is 'ǥ�ü���';

comment on table ps_role is '����';
comment on column ps_role.id is '����id';
comment on column ps_role.name is '���Ҹ�';

comment on table ps_role_menu_map is '���Һ��޴�';
comment on column ps_role_menu_map.role_id is '����id';
comment on column ps_role_menu_map.menu_id is '�޴�id';

comment on table ps_supplier is '������';
comment on column ps_supplier.id is '������id';
comment on column ps_supplier.name is '�����ڸ�';
comment on column ps_supplier.phone is '��ȭ��ȣ';

comment on table ps_user is '�����';
comment on column ps_user.login_id is '�α���id';
comment on column ps_user.passwd is '��й�ȣ';
comment on column ps_user.role_id is '����id';
comment on column ps_user.registered_date is '�����';
comment on column ps_user.last_login_datetime is '�ֱٷα����Ͻ�';

comment on table ps_employee is '����';
comment on column ps_employee.id is '����id';
comment on column ps_employee.name is '�����̸�';
comment on column ps_employee.phone is '��ȭ��ȣ';
comment on column ps_employee.email is 'e-mail �ּ�';
comment on column ps_employee.job_code is '�����ڵ�';
comment on column ps_employee.position_code is '�����ڵ�';
comment on column ps_employee.status_code is '�����ڵ�(����,����,����)';
comment on column ps_employee.entrance_date is '�Ի���(yyyymmdd)';
comment on column ps_employee.resignation_date is '�����(yyyymmdd)';
comment on column ps_employee.create_user is '������id';
comment on column ps_employee.create_dt is '�����Ͻ�';
comment on column ps_employee.last_modify_user is '�ֱټ�����id';
comment on column ps_employee.last_modify_dt is '�ֱټ����Ͻ�';

comment on table ps_employee_family_member is '��������';
comment on column ps_employee_family_member.employee_id is '����id';
comment on column ps_employee_family_member.member_no is '������ȣ';
comment on column ps_employee_family_member.name is '�����̸�';
comment on column ps_employee_family_member.member_relation_code is '��������';
comment on column ps_employee_family_member.birthday is '�������';
comment on column ps_employee_family_member.phone is '��ȭ��ȣ';
comment on column ps_employee_family_member.create_user is '������id';
comment on column ps_employee_family_member.create_dt is '�����Ͻ�';
comment on column ps_employee_family_member.last_modify_user is '�ֱټ�����id';
comment on column ps_employee_family_member.last_modify_dt is '�ֱټ����Ͻ�';

comment on table ps_employee_education is '���������̷�';
comment on column ps_employee_education.employee_id is '����id';
comment on column ps_employee_education.education_no is '���������̷¹�ȣ';
comment on column ps_employee_education.name is '������';
comment on column ps_employee_education.education_class_code is '��������(����, ����, �ܱ���, it,...) �ڵ�';
comment on column ps_employee_education.institution_name is '���������';
comment on column ps_employee_education.start_date is '������(yyyymmdd)';
comment on column ps_employee_education.end_date is '������(yyyymmdd)';
comment on column ps_employee_education.duration_hour is '�����Ⱓ(�ð�)';
comment on column ps_employee_education.create_user is '������id';
comment on column ps_employee_education.create_dt is '�����Ͻ�';
comment on column ps_employee_education.last_modify_user is '�ֱټ�����id';
comment on column ps_employee_education.last_modify_dt is '�ֱټ����Ͻ�';

comment on table ps_employee_work_career is '�����ٹ��̷�';
comment on column ps_employee_work_career.employee_id is '����id';
comment on column ps_employee_work_career.work_career_no is '�ٹ��̷¹�ȣ';
comment on column ps_employee_work_career.company_name is 'ȸ���';
comment on column ps_employee_work_career.department_name is '�μ���';
comment on column ps_employee_work_career.job is '����';
comment on column ps_employee_work_career.end_month is '�����(yyyymm)';
comment on column ps_employee_work_career.start_month is '���ۿ�(yyyymm)';
comment on column ps_employee_work_career.create_user is '������id';
comment on column ps_employee_work_career.create_dt is '�����Ͻ�';
comment on column ps_employee_work_career.last_modify_user is '�ֱټ�����id';
comment on column ps_employee_work_career.last_modify_dt is '�ֱټ����Ͻ�';


-- Added at 2010-04-01 by Sang-moon Oh

CREATE TABLE ps_delivery_status_code (
                CODE CHAR(3) NOT NULL,
                NAME VARCHAR2(80) NOT NULL,
                DESCN VARCHAR2(1000),
                CONSTRAINT PK_DELIVERY_STATUS_CODE PRIMARY KEY (CODE)
);
COMMENT ON TABLE ps_delivery_status_code IS '��ۻ��� Code';
COMMENT ON COLUMN ps_delivery_status_code.CODE IS '�ڵ�';
COMMENT ON COLUMN ps_delivery_status_code.NAME IS '�ڵ��';
COMMENT ON COLUMN ps_delivery_status_code.DESCN IS '�ڵ� ����';


CREATE TABLE PS_DELIVERY (
                id NUMBER NOT NULL,
                ORDER_ID NUMBER NOT NULL,
                STATUS_CODE CHAR(3),
                EXPECTED_DELIVERY_DATE CHAR(8),
                DELIVERY_DATE CHAR(8),
                FEE NUMBER,
                RECEIVED_BY VARCHAR2(80),
                CONSTRAINT PK_DELIVERY PRIMARY KEY (id)
);
COMMENT ON TABLE PS_DELIVERY IS '���';
COMMENT ON COLUMN PS_DELIVERY.id IS '���ID';
COMMENT ON COLUMN PS_DELIVERY.ORDER_ID IS '�ֹ�ID';
COMMENT ON COLUMN PS_DELIVERY.STATUS_CODE IS '��ۻ��� Code';
COMMENT ON COLUMN PS_DELIVERY.EXPECTED_DELIVERY_DATE IS '��������';
COMMENT ON COLUMN PS_DELIVERY.DELIVERY_DATE IS '�����';
COMMENT ON COLUMN PS_DELIVERY.FEE IS '������';
COMMENT ON COLUMN PS_DELIVERY.RECEIVED_BY IS '������';

CREATE INDEX idx_delivery_1 ON PS_DELIVERY ( order_id );
-- CREATE BITMAP INDEX idx_delivery_2 ON PS_DELIVERY ( status_code );

ALTER TABLE PS_DELIVERY ADD CONSTRAINT FK_DELIVERY_1
FOREIGN KEY (ORDER_ID)
REFERENCES PS_ORDER (ID)
NOT DEFERRABLE;

ALTER TABLE PS_DELIVERY ADD CONSTRAINT FK_DELIVERY_2
FOREIGN KEY (STATUS_CODE)
REFERENCES ps_delivery_status_code (CODE)
NOT DEFERRABLE;

