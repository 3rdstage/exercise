delete from sm_category;

-- top level category
insert into sm_category(id, name, parent_id, seq) values ('1000001', '�����Ƿ�', null, 100);
insert into sm_category(id, name, parent_id, seq) values ('1000002', '�����Ƿ�', null, 200);
insert into sm_category(id, name, parent_id, seq) values ('1000003', '�м���ȭ', null, 300);
insert into sm_category(id, name, parent_id, seq) values ('1000004', '�������м�', null, 400);
insert into sm_category(id, name, parent_id, seq) values ('1000005', '����', null, 500);
insert into sm_category(id, name, parent_id, seq) values ('1000006', '�ֹ�', null, 600);
insert into sm_category(id, name, parent_id, seq) values ('1000007', '����', null, 700);
insert into sm_category(id, name, parent_id, seq) values ('1000008', 'ħ��', null, 800);
insert into sm_category(id, name, parent_id, seq) values ('1000009', '�ǰ�', null, 900);
insert into sm_category(id, name, parent_id, seq) values ('1000010', '��ǰ', null, 1000);
insert into sm_category(id, name, parent_id, seq) values ('1000011', '����', null, 1100);
insert into sm_category(id, name, parent_id, seq) values ('1000012', 'ī�޶�', null, 1200);
insert into sm_category(id, name, parent_id, seq) values ('1000014', '��ǻ��', null, 1400);
insert into sm_category(id, name, parent_id, seq) values ('1000015', '��ǰ��', null, 1500);
insert into sm_category(id, name, parent_id, seq) values ('1000016', '����', null, 1600);
insert into sm_category(id, name, parent_id, seq) values ('1000017', '����', null, 1700);



-- subcategory under �����Ƿ�
insert into sm_category(id, name, parent_id, seq) values ('1000022', '����', '1000001', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000023', '���콺', '1000001', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000024', 'Ƽ����', '1000001', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000025', '��Ʈ', '1000001', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000026', '�����', '1000001', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000027', '����', '1000001', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000028', '����', '1000001', 700);
insert into sm_category(id, name, parent_id, seq) values ('1000029', '��ĿƮ', '1000001', 800);
insert into sm_category(id, name, parent_id, seq) values ('1000030', '����', '1000001', 900);
insert into sm_category(id, name, parent_id, seq) values ('1000031', '��Ʈ', '1000001', 1000);

insert into sm_category(id, name, parent_id, seq) values ('1000032', '�ָ��� ����', '1000022', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000033', 'üũ ����', '1000022', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000034', '��Ʈ������ ����', '1000022', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000035', '����Ʈ ����', '1000022', 400);

insert into sm_category(id, name, parent_id, seq) values ('1000036', '���̽� ���콺', '1000023', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000037', '���� ���콺', '1000023', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000038', 'üũ ���콺', '1000023', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000039', '����Ʈ ���콺', '1000023', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000040', '�μҸ� ���콺', '1000023', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000041', '���� ���콺', '1000023', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000042', '���� ���콺', '1000023', 700);
insert into sm_category(id, name, parent_id, seq) values ('1000043', '��ƾ ���콺', '1000023', 800);
insert into sm_category(id, name, parent_id, seq) values ('1000044', '��ũ ���콺', '1000023', 900);
insert into sm_category(id, name, parent_id, seq) values ('1000045', '���̳�ī�� ���콺', '1000023', 1000);
insert into sm_category(id, name, parent_id, seq) values ('1000046', '�� ���콺', '1000023', 1100);

insert into sm_category(id, name, parent_id, seq) values ('1000047', '�μҸ� Ƽ����', '1000024', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000048', '�� Ƽ����', '1000024', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000049', '����� Ƽ����', '1000024', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000050', '���̳� Ƽ����', '1000024', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000051', '�ڽ�/������ Ƽ����', '1000024', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000052', '���̽� Ƽ����', '1000024', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000053', '��Ƽ�� Ƽ����', '1000024', 700);
insert into sm_category(id, name, parent_id, seq) values ('1000054', 'ī�� Ƽ����', '1000024', 800);
insert into sm_category(id, name, parent_id, seq) values ('1000055', '���� Ƽ����', '1000024', 900);



-- subcategory under �����Ƿ�
insert into sm_category(id, name, parent_id, seq) values ('1000056', 'Ƽ����', '1000002', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000057', 'ĳ�־� ����', '1000002', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000058', '�巹�� ����', '1000002', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000060', '������', '1000002', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000061', '����', '1000002', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000062', '����', '1000002', 700);

insert into sm_category(id, name, parent_id, seq) values ('1000063', '����� Ƽ����', '1000056', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000064', '���̳� Ƽ����', '1000056', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000065', '���� Ƽ����', '1000056', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000066', '�ĵ� Ƽ����', '1000056', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000067', '���� Ƽ����', '1000056', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000068', '�μҸ� Ƽ����', '1000056', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000069', '��Ʈ������ Ƽ����', '1000056', 700);
insert into sm_category(id, name, parent_id, seq) values ('1000070', '����Ʈ Ƽ����', '1000056', 800);

insert into sm_category(id, name, parent_id, seq) values ('1000071', '�ָ��� ����', '1000057', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000072', '��Ʈ������ ����', '1000057', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000073', 'üũ ����', '1000057', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000074', '��Ʈ ����', '1000057', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000075', '����Ʈ ����', '1000057', 500);

insert into sm_category(id, name, parent_id, seq) values ('1000076', '�ָ��� ����', '1000058', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000077', '��Ʈ������ ����', '1000058', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000078', 'üũ ����', '1000058', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000079', '��Ʈ ����', '1000058', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000080', '���� ����', '1000058', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000081', '����Ʈ ����', '1000058', 600);

insert into sm_category(id, name, parent_id, seq) values ('1000082', '����� ������', '1000060', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000083', '���̳� ������', '1000060', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000084', '���� ������', '1000060', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000085', '�ĵ� ������', '1000060', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000086', '���� ������', '1000060', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000087', '�����', '1000060', 600);

insert into sm_category(id, name, parent_id, seq) values ('1000088', 'ĳ�־� ����', '1000062', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000089', '���� ����', '1000062', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000090', 'û����', '1000062', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000091', 'Ʈ���̴� ����', '1000062', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000092', 'ī�� ����', '1000062', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000093', '�ݹ���', '1000062', 600);



-- subcategory under ����
insert into sm_category(id, name, parent_id, seq) values ('1000094', '���� ����', '1000011', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000095', '���� ����', '1000011', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000096', '���� ����', '1000011', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000097', '��Ȱ ����', '1000011', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000098', '�ֹ� ����', '1000011', 500);

insert into sm_category(id, name, parent_id, seq) values ('1000099', 'TV', '1000094', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000100', 'VTR', '1000094', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000101', 'DVD', '1000094', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000102', '��������', '1000094', 400);

insert into sm_category(id, name, parent_id, seq) values ('1000103', 'Ȩ�þ���', '1000095', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000104', '�����', '1000095', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000105', 'ī��Ʈ �÷��̾�', '1000095', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000106', '�̴� ī��Ʈ �÷��̾�', '1000095', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000107', '����', '1000095', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000108', '����Ŀ', '1000095', 600);

insert into sm_category(id, name, parent_id, seq) values ('1000109', '������', '1000096', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000110', '��ǳ��', '1000096', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000111', '��ǳ��', '1000096', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000112', '������', '1000096', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000113', '����û����', '1000096', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000114', '�����', '1000096', 600);

insert into sm_category(id, name, parent_id, seq) values ('1000115', '��Ź��', '1000097', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000116', 'û�ұ�', '1000097', 200);

insert into sm_category(id, name, parent_id, seq) values ('1000117', '�����', '1000098', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000118', '���', '1000098', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000119', '������', '1000098', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000120', '�ı⼼ô��', '1000098', 400);

insert into sm_category(id, name, parent_id, seq) values ('1000121', '����� TV', '1000099', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000122', 'LCD TV', '1000099', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000123', 'PDP TV', '1000099', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000124', '���� ����� TV', '1000099', 400);

insert into sm_category(id, name, parent_id, seq) values ('1000125', '������ ������', '1000109', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000126', '���ĵ� ������', '1000109', 200);

insert into sm_category(id, name, parent_id, seq) values ('1000127', '�Ϲ� ��Ź��', '1000115', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000128', '�巳 ��Ź��', '1000115', 200);

insert into sm_category(id, name, parent_id, seq) values ('1000129', '���� û�ұ�', '1000116', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000130', '�ڵ� û�ұ�', '1000116', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000131', '���� û�ұ�', '1000116', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000132', '�κ� û�ұ�', '1000116', 400);




