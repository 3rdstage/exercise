
    alter table Corporation 
        drop 
        foreign key FK149947E8B62DDA1C;

    alter table Individual 
        drop 
        foreign key FK740F7EB9B62DDA1C;

    drop table if exists Corporation;

    drop table if exists Individual;

    drop table if exists Person;

    drop table if exists Right;

    create table Corporation (
        id varchar(255) not null,
        name varchar(255),
        reg_no varchar(255),
        primary key (id)
    );

    create table Individual (
        id varchar(255) not null,
        first_name varchar(50),
        last_name varchar(50),
        primary key (id)
    );

    create table Person (
        id varchar(255) not null,
        primary key (id)
    );

    create table Right (
        id varchar(16) not null,
        discriminator varchar(5) not null,
        start_date date,
        duration integer,
        primary key (id)
    );

    alter table Corporation 
        add index FK149947E8B62DDA1C (id), 
        add constraint FK149947E8B62DDA1C 
        foreign key (id) 
        references Person (id);

    alter table Individual 
        add index FK740F7EB9B62DDA1C (id), 
        add constraint FK740F7EB9B62DDA1C 
        foreign key (id) 
        references Person (id);
