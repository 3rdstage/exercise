delete from sm_category;

-- top level category
insert into sm_category(id, name, parent_id, seq) values ('1000001', '여성의류', null, 100);
insert into sm_category(id, name, parent_id, seq) values ('1000002', '남성의류', null, 200);
insert into sm_category(id, name, parent_id, seq) values ('1000003', '패션잡화', null, 300);
insert into sm_category(id, name, parent_id, seq) values ('1000004', '스포츠패션', null, 400);
insert into sm_category(id, name, parent_id, seq) values ('1000005', '보석', null, 500);
insert into sm_category(id, name, parent_id, seq) values ('1000006', '주방', null, 600);
insert into sm_category(id, name, parent_id, seq) values ('1000007', '가구', null, 700);
insert into sm_category(id, name, parent_id, seq) values ('1000008', '침구', null, 800);
insert into sm_category(id, name, parent_id, seq) values ('1000009', '건강', null, 900);
insert into sm_category(id, name, parent_id, seq) values ('1000010', '식품', null, 1000);
insert into sm_category(id, name, parent_id, seq) values ('1000011', '가전', null, 1100);
insert into sm_category(id, name, parent_id, seq) values ('1000012', '카메라', null, 1200);
insert into sm_category(id, name, parent_id, seq) values ('1000014', '컴퓨터', null, 1400);
insert into sm_category(id, name, parent_id, seq) values ('1000015', '상품권', null, 1500);
insert into sm_category(id, name, parent_id, seq) values ('1000016', '보험', null, 1600);
insert into sm_category(id, name, parent_id, seq) values ('1000017', '여행', null, 1700);



-- subcategory under 여성의류
insert into sm_category(id, name, parent_id, seq) values ('1000022', '셔츠', '1000001', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000023', '블라우스', '1000001', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000024', '티셔츠', '1000001', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000025', '니트', '1000001', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000026', '가디건', '1000001', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000027', '자켓', '1000001', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000028', '팬츠', '1000001', 700);
insert into sm_category(id, name, parent_id, seq) values ('1000029', '스커트', '1000001', 800);
insert into sm_category(id, name, parent_id, seq) values ('1000030', '점퍼', '1000001', 900);
insert into sm_category(id, name, parent_id, seq) values ('1000031', '코트', '1000001', 1000);

insert into sm_category(id, name, parent_id, seq) values ('1000032', '솔리드 셔츠', '1000022', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000033', '체크 셔츠', '1000022', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000034', '스트라이프 셔츠', '1000022', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000035', '프린트 셔츠', '1000022', 400);

insert into sm_category(id, name, parent_id, seq) values ('1000036', '레이스 블라우스', '1000023', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000037', '쉬폰 블라우스', '1000023', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000038', '체크 블라우스', '1000023', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000039', '프린트 블라우스', '1000023', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000040', '민소매 블라우스', '1000023', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000041', '프릴 블라우스', '1000023', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000042', '리본 블라우스', '1000023', 700);
insert into sm_category(id, name, parent_id, seq) values ('1000043', '새틴 블라우스', '1000023', 800);
insert into sm_category(id, name, parent_id, seq) values ('1000044', '실크 블라우스', '1000023', 900);
insert into sm_category(id, name, parent_id, seq) values ('1000045', '차이나카라 블라우스', '1000023', 1000);
insert into sm_category(id, name, parent_id, seq) values ('1000046', '롱 블라우스', '1000023', 1100);

insert into sm_category(id, name, parent_id, seq) values ('1000047', '민소매 티셔츠', '1000024', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000048', '롱 티셔츠', '1000024', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000049', '라운드넥 티셔츠', '1000024', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000050', '브이넥 티셔츠', '1000024', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000051', '박스/루즈핏 티셔츠', '1000024', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000052', '레이스 티셔츠', '1000024', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000053', '빈티지 티셔츠', '1000024', 700);
insert into sm_category(id, name, parent_id, seq) values ('1000054', '카라 티셔츠', '1000024', 800);
insert into sm_category(id, name, parent_id, seq) values ('1000055', '폴라 티셔츠', '1000024', 900);



-- subcategory under 남성의류
insert into sm_category(id, name, parent_id, seq) values ('1000056', '티셔츠', '1000002', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000057', '캐주얼 셔츠', '1000002', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000058', '드레스 셔츠', '1000002', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000060', '스웨터', '1000002', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000061', '자켓', '1000002', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000062', '팬츠', '1000002', 700);

insert into sm_category(id, name, parent_id, seq) values ('1000063', '라운드넥 티셔츠', '1000056', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000064', '브이넥 티셔츠', '1000056', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000065', '폴라 티셔츠', '1000056', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000066', '후드 티셔츠', '1000056', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000067', '집업 티셔츠', '1000056', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000068', '민소매 티셔츠', '1000056', 600);
insert into sm_category(id, name, parent_id, seq) values ('1000069', '스트라이프 티셔츠', '1000056', 700);
insert into sm_category(id, name, parent_id, seq) values ('1000070', '프린트 티셔츠', '1000056', 800);

insert into sm_category(id, name, parent_id, seq) values ('1000071', '솔리드 셔츠', '1000057', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000072', '스트라이프 셔츠', '1000057', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000073', '체크 셔츠', '1000057', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000074', '도트 셔츠', '1000057', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000075', '프린트 셔츠', '1000057', 500);

insert into sm_category(id, name, parent_id, seq) values ('1000076', '솔리드 셔츠', '1000058', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000077', '스트라이프 셔츠', '1000058', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000078', '체크 셔츠', '1000058', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000079', '도트 셔츠', '1000058', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000080', '패턴 셔츠', '1000058', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000081', '프린트 셔츠', '1000058', 600);

insert into sm_category(id, name, parent_id, seq) values ('1000082', '라운드넥 스웨터', '1000060', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000083', '브이넥 스웨터', '1000060', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000084', '폴라 스웨터', '1000060', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000085', '후드 스웨터', '1000060', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000086', '집업 스웨터', '1000060', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000087', '가디건', '1000060', 600);

insert into sm_category(id, name, parent_id, seq) values ('1000088', '캐주얼 바지', '1000062', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000089', '정장 바지', '1000062', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000090', '청바지', '1000062', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000091', '트레이닝 바지', '1000062', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000092', '카고 팬츠', '1000062', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000093', '반바지', '1000062', 600);



-- subcategory under 가전
insert into sm_category(id, name, parent_id, seq) values ('1000094', '영상 가전', '1000011', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000095', '음향 가전', '1000011', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000096', '계절 가전', '1000011', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000097', '생활 가전', '1000011', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000098', '주방 가전', '1000011', 500);

insert into sm_category(id, name, parent_id, seq) values ('1000099', 'TV', '1000094', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000100', 'VTR', '1000094', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000101', 'DVD', '1000094', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000102', '프로젝터', '1000094', 400);

insert into sm_category(id, name, parent_id, seq) values ('1000103', '홈시어터', '1000095', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000104', '오디오', '1000095', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000105', '카세트 플레이어', '1000095', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000106', '미니 카세트 플레이어', '1000095', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000107', '앰프', '1000095', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000108', '스피커', '1000095', 600);

insert into sm_category(id, name, parent_id, seq) values ('1000109', '에어컨', '1000096', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000110', '선풍기', '1000096', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000111', '냉풍기', '1000096', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000112', '가습기', '1000096', 400);
insert into sm_category(id, name, parent_id, seq) values ('1000113', '공기청정기', '1000096', 500);
insert into sm_category(id, name, parent_id, seq) values ('1000114', '난방기', '1000096', 600);

insert into sm_category(id, name, parent_id, seq) values ('1000115', '세탁기', '1000097', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000116', '청소기', '1000097', 200);

insert into sm_category(id, name, parent_id, seq) values ('1000117', '냉장고', '1000098', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000118', '밥솥', '1000098', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000119', '레인지', '1000098', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000120', '식기세척기', '1000098', 400);

insert into sm_category(id, name, parent_id, seq) values ('1000121', '브라운관 TV', '1000099', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000122', 'LCD TV', '1000099', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000123', 'PDP TV', '1000099', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000124', '슬림 브라운관 TV', '1000099', 400);

insert into sm_category(id, name, parent_id, seq) values ('1000125', '벽걸이 에어컨', '1000109', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000126', '스탠드 에어컨', '1000109', 200);

insert into sm_category(id, name, parent_id, seq) values ('1000127', '일반 세탁기', '1000115', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000128', '드럼 세탁기', '1000115', 200);

insert into sm_category(id, name, parent_id, seq) values ('1000129', '진공 청소기', '1000116', 100);
insert into sm_category(id, name, parent_id, seq) values ('1000130', '핸디 청소기', '1000116', 200);
insert into sm_category(id, name, parent_id, seq) values ('1000131', '스팀 청소기', '1000116', 300);
insert into sm_category(id, name, parent_id, seq) values ('1000132', '로봇 청소기', '1000116', 400);




