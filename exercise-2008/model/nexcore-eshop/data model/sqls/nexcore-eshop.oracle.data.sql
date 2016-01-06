
insert into ps_category (id, name) values ('BIRDS', 'Birds');
insert into ps_category (id, name) values ('CATS', 'Cats');
insert into ps_category (id, name) values ('DOGS', 'Dogs');
insert into ps_category (id, name) values ('FISH', 'Fish');
insert into ps_category (id, name) values ('REPTILES', 'Reptiles');

insert into ps_product (id, category_id, name) values ('FI-SW-01', 'FISH', 'Angelfish');
insert into ps_product (id, category_id, name) values ('FI-SW-02', 'FISH', 'Tiger Shark');
insert into ps_product (id, category_id, name) values ('FI-FW-01', 'FISH', 'Koi');
insert into ps_product (id, category_id, name) values ('FI-FW-02', 'FISH', 'Goldfish');
insert into ps_product (id, category_id, name) values ('K9-BD-01', 'DOGS', 'Bulldog');
insert into ps_product (id, category_id, name) values ('K9-PO-02', 'DOGS', 'Poodle');
insert into ps_product (id, category_id, name) values ('K9-DL-01', 'DOGS', 'Dalmation');
insert into ps_product (id, category_id, name) values ('K9-RT-01', 'DOGS', 'Golden Retriever');
insert into ps_product (id, category_id, name) values ('K9-RT-02', 'DOGS', 'Labrador Retriever');
insert into ps_product (id, category_id, name) values ('K9-CW-01', 'DOGS', 'Chihuahua');
insert into ps_product (id, category_id, name) values ('RP-SN-01', 'REPTILES', 'Rattlesnake');
insert into ps_product (id, category_id, name) values ('RP-LI-02', 'REPTILES', 'Iguana');
insert into ps_product (id, category_id, name) values ('FL-DSH-01', 'CATS', 'Manx');
insert into ps_product (id, category_id, name) values ('FL-DLH-02', 'CATS', 'Persian');
insert into ps_product (id, category_id, name) values ('AV-CB-01', 'BIRDS', 'Amazon Parrot');
insert into ps_product (id, category_id, name) values ('AV-SB-02', 'BIRDS', 'Finch');

-- commit 1


insert into ps_supplier (id, name, phone) values ('SPL-1', '¾Æ·ÕÀÌ Pets', '212-947-0797');
insert into ps_supplier (id, name, phone) values ('SPL-2', 'ABC Pets', '415-947-0797');

insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-1', 'FI-SW-01', 'SPL-1', 10.00, 16.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-2', 'FI-SW-01', 'SPL-1', 10.00, 16.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-3', 'FI-SW-02', 'SPL-1', 12.00, 18.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-4', 'FI-FW-01', 'SPL-1', 12.00, 18.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-5', 'FI-FW-01', 'SPL-1', 12.00, 18.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-6', 'K9-BD-01', 'SPL-1', 12.00, 18.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-7', 'K9-BD-01', 'SPL-1', 12.00, 18.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-8', 'K9-PO-02', 'SPL-1', 12.00, 18.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-9', 'K9-DL-01', 'SPL-1', 12.00, 18.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-10', 'K9-DL-01', 'SPL-1', 12.00, 18.50, 20000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-11', 'RP-SN-01', 'SPL-1', 12.00, 18.50, 20000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-12', 'RP-SN-01', 'SPL-1', 12.00, 18.50, 20000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-13', 'RP-LI-02', 'SPL-1', 12.00, 18.50, 20000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-14', 'FL-DSH-01', 'SPL-1', 12.00, 58.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-15', 'FL-DSH-01', 'SPL-1', 12.00, 23.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-16', 'FL-DLH-02', 'SPL-1', 12.00, 93.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-17', 'FL-DLH-02', 'SPL-1', 12.00, 93.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-18', 'AV-CB-01', 'SPL-1', 92.00, 193.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-19', 'AV-SB-02', 'SPL-1', 2.00, 15.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-20', 'FI-FW-02', 'SPL-1', 2.00, 5.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-21', 'FI-FW-02', 'SPL-1', 1.00, 5.29, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-22', 'K9-RT-02', 'SPL-1', 100.00, 135.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-23', 'K9-RT-02', 'SPL-1', 100.00, 145.49, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-24', 'K9-RT-02', 'SPL-1', 92.00, 255.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-25', 'K9-RT-02', 'SPL-1', 90.00, 325.29, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-26', 'K9-CW-01', 'SPL-1', 92.00, 125.50, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-27', 'K9-CW-01', 'SPL-1', 90.00, 155.29, 10000);
insert into ps_item (id, product_id, supplier_id, unit_cost, list_price, qty) 
	values ('EST-28', 'K9-RT-01', 'SPL-1', 90.00, 155.29, 10000);


-- commit 2

insert into ps_number (table_name, next_no) values ('order', 1001);
insert into ps_number (table_name, next_no) values ('file', 10005);
insert into ps_number (table_name, next_no) values ('item', 200);
insert into ps_number (table_name, next_no) values ('delivery', 2001);


insert into ps_role (id, name) values ('R-1', 'Admin');
insert into ps_role (id, name) values ('R-2', 'Staff');
insert into ps_role (id, name) values ('R-3', 'Customer');
insert into ps_role (id, name) values ('R-4', 'Supplier');

insert into ps_user (login_id, passwd, role_id, registered_date, last_login_datetime)
	values ('admin', 'psadminadmin', 'R-1', '20050101', '20081201111111');
insert into ps_user (login_id, passwd, role_id, registered_date, last_login_datetime)
	values ('fishmd', 'fishfish', 'R-2', '20050101', '20081201182631');
insert into ps_user (login_id, passwd, role_id, registered_date, last_login_datetime)
	values ('dogsmd', 'dogdog', 'R-2', '20070804', '20081201134725');
insert into ps_user (login_id, passwd, role_id, registered_date, last_login_datetime)
	values ('chskim', 'rlacjdtn', 'R-3', '20060813', '20081025082341');
insert into ps_user (login_id, passwd, role_id, registered_date, last_login_datetime)
	values ('yhlee', 'dldudgml', 'R-3', '20070222', '20080904152134');
insert into ps_user (login_id, passwd, role_id, registered_date, last_login_datetime)
	values ('gdhong', 'ghdrlfehd', 'R-3', '20080712', '20080927172341');

insert into ps_account (id, name, login_id, phone, email, country, zip, state, city, address)
	values ('200001', '±èÃ¶¼ö', 'chskim', '011-212-8425', 'chskim@skcc.com', '´ëÇÑ¹Î±¹', '200200', '°æ±âµµ', 'ºÐ´ç', null);
insert into ps_account (id, name, login_id, phone, email, country, zip, state, city, address)
	values ('200002', 'ÀÌ¿µÈñ', 'yhlee', '010-725-1004', 'yhlee@chollian.net', '´ëÇÑ¹Î±¹', '201321', '°æ±âµµ', '¾È¾ç', null);
insert into ps_account (id, name, login_id, phone, email, country, zip, state, city, address)
	values ('200003', 'È«±æµ¿', 'gdhong', '016-724-2701', 'gdhong@google.com', '´ëÇÑ¹Î±¹', '100300', '¼­¿ï', '¼­¿ï', null);
		
insert into ps_order (id, account_id, ordered_date, ordered_time, total_price)
	values (1000, '200001', '20080902', '201521', 247.00);

insert into ps_lineitem(order_id, item_no, item_id, unit_price, qty)
	values (1000, 1, 'EST-1', 16.50, 1);
insert into ps_lineitem(order_id, item_no, item_id, unit_price, qty)
	values (1000, 2, 'EST-8', 18.50, 2);
insert into ps_lineitem(order_id, item_no, item_id, unit_price, qty)
	values (1000, 3, 'EST-18', 193.50, 1);








	
