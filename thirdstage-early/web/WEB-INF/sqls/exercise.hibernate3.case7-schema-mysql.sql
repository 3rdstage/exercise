
    drop table if exists test.Customer7;

    create table test.Customer7 (
        id bigint not null auto_increment,
        residentsno vachar unique,
        telno vachar,
        address vachar,
        entrydate date,
        primary key (id)
    );

    create index idx_customer7_1 on test.Customer7 (residentsno);
