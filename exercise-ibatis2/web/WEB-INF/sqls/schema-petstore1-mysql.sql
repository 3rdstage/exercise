/*
@version 1.2
@author Sang-Moon Oh
@date 2008-06-23
@description
	Change the structure of orderstatus table to represent only order level status
	not lineitem level status.
	Adds drop table statements before create table statements 
@version 1.1
@author Sang-Moon Oh
@date 2008-06-13
@description 
	Improve and clarify relationships among entities
	Fix some column names according to convention, 
	for example column name of favcategory to favcategoryid and table name of orders to order
*/
use petstore1d;


/* added on version 1.2 */
drop table if exists orderstatus;
drop table if exists lineitem;
drop table if exists `order`;
drop table if exists inventory;
drop table if exists `item`;
drop table if exists product;
drop table if exists supplier;
drop table if exists banner;
drop table if exists profile;
drop table if exists signon;
drop table if exists account;
drop table if exists category;
drop table if exists sequence;
/* end of addtion */

create table if not exists supplier (
    supplierId int not null,
    name varchar(80) null,
    status varchar(2) not null,
    addr1 varchar(80) null,
    addr2 varchar(80) null,
    city varchar(80) null,
    state varchar(80) null,
    zip varchar(5) null,
    phone varchar(80) null,
primary key (supplierid))
type=innodb
min_rows=0
max_rows=1000
pack_keys=default
row_format=default;

create table if not exists signon (
    username varchar(25) not null,
    password varchar(25)  not null,
primary key (username))
type=innodb
min_rows=0
max_rows=1000
pack_keys=default
row_format=default;

create table if not exists account (
    userid varchar(80) not null,
    email varchar(80) not null,
    firstname varchar(80) not null,
    lastname varchar(80) not null,
    status varchar(2)  null,
    addr1 varchar(80) not null,
    addr2 varchar(40) null,
    city varchar(80) not  null,
    state varchar(80) not null,
    zip varchar(20) not null,
    country varchar(20) not null,
    phone varchar(80) not null,
primary key (userid) )
type=innodb
min_rows=0
max_rows=1000
pack_keys=default
row_format=default;

create table if not exists profile (
    userid varchar(80) not null,
    langpref varchar(80) not null,
    favcategoryid varchar(30),
    listopt bool,
    banneropt bool,
primary key (userid) )
type=innodb
pack_keys=default
row_format=default;

create table if not exists banner (
    categoryid varchar(80) not null,
    bannername varchar(255)  null,
primary key (categoryid))
type=innodb
pack_keys=default
row_format=default;

create table if not exists `order`(
      orderid int not null,
      userid varchar(80) not null,
      orderdate date not null,
      shipaddr1 varchar(80) not null,
      shipaddr2 varchar(80) null,
      shipcity varchar(80) not null,
      shipstate varchar(80) not null,
      shipzip varchar(20) not null,
      shipcountry varchar(20) not null,
      billaddr1 varchar(80) not null,
      billaddr2 varchar(80)  null,
      billcity varchar(80) not null,
      billstate varchar(80) not null,
      billzip varchar(20) not null,
      billcountry varchar(20) not null,
      courier varchar(80) not null,
      totalprice decimal(10,2) not null,
      billtofirstname varchar(80) not null,
      billtolastname varchar(80) not null,
      shiptofirstname varchar(80) not null,
      shiptolastname varchar(80) not null,
      creditcard varchar(80) not null,
      exprdate varchar(7) not null,
      cardtype varchar(80) not null,
      locale varchar(80) not null,
primary key (orderid) )
type=innodb
pack_keys=default
row_format=default;

create table if not exists orderstatus (
      orderid int not null,
      timestamp date not null,
      status varchar(2) not null,
primary key (orderid) )
type=innodb
pack_keys=default
row_format=default;

create table if not exists lineitem (
      orderid int not null,
      lineno int not null,
      itemid varchar(10) not null,
      quantity int not null,
      unitprice decimal(10,2) not null,
primary key (orderid, lineno) )
type=innodb
pack_keys=default
row_format=default;

create table if not exists category (
	categoryid varchar(10) not null,
	name varchar(80) null,
	descn varchar(255) null,
primary key (categoryid) )
type=innodb
pack_keys=default
row_format=default;

create table if not exists product (
    productid varchar(10) not null,
    categoryid varchar(10) not null,
    name varchar(80) null,
    descn varchar(255) null,
primary key (productid) )
type=innodb
pack_keys=default
row_format=default;

alter table product
	add index productcat(categoryid);

alter table product
	add index productname(name);

alter table category
	add index ixcategoryproduct(categoryid);

alter table product  add foreign key (categoryid)
         references category(categoryid)
         on delete restrict
         on update restrict;


create table if not exists item (
    itemid varchar(10) not null,
    productid varchar(10) not null,
    listprice decimal(10,2) null,
    unitcost decimal(10,2) null,
    supplierid int null,
    status varchar(2) null,
    attr1 varchar(80) null,
    attr2 varchar(80) null,
    attr3 varchar(80) null,
    attr4 varchar(80) null,
    attr5 varchar(80) null,
primary key (itemid) )
type=innodb
pack_keys=default
row_format=default;

alter table item
	add index itemprod(productid);

alter table item add foreign key (productid)
         references product(productid)
         on delete restrict
         on update restrict;

alter table item add foreign key (supplierid)
         references supplier(supplierid)
         on delete restrict
         on update restrict;

create table if not exists inventory (
    itemid varchar(10) not null,
    qty int not null,
primary key (itemid) )
type=innodb
pack_keys=default
row_format=default;

create table if not exists sequence (
    name               varchar(30)  not null,
    nextid             int          not null,
primary key (name) )
type=innodb
pack_keys=default
row_format=default;


/* added on version 1.1 */
alter table signon add foreign key (username)
	references account(userid)
	on delete restrict
	on update restrict;

alter table profile add foreign key (userid)
	references account(userid)
	on delete restrict
	on update restrict;

alter table profile add foreign key (favcategoryid)
	references category(categoryid)
	on delete restrict
	on update restrict;

alter table banner add foreign key (categoryid)
	references category(categoryid)
	on delete restrict
	on update restrict;

alter table inventory add foreign key (itemid)
	references item(itemid)
	on delete restrict
	on update restrict;

alter table `order` add foreign key (userid)
	references account(userid)
	on delete restrict
	on update restrict;

alter table lineitem add foreign key (orderid)
	references `order`(orderid)
	on delete restrict
	on update restrict;

alter table lineitem add foreign key (itemid)
	references item(itemid)
	on delete restrict
	on update restrict;

alter table orderstatus add foreign key (orderid)
	references `order`(orderid)
	on delete restrict
	on update restrict;
/* end of addtion */