
    create table Blog3 (
        id bigint not null auto_increment,
        name varchar(60),
        primary key (id)
    );

    create table BlogItem3 (
        id bigint not null auto_increment,
        title varchar(100),
        text text,
        dateTime datetime,
        bolgId bigint not null,
        primary key (id)
    );

    create table Child3 (
        id varchar(16) not null,
        parentId varchar(16) not null,
        primary key (id)
    );

    create table Parent3 (
        id varchar(16) not null,
        primary key (id)
    );

    alter table BlogItem3 
        add index fk_blogitem_1 (bolgId), 
        add constraint fk_blogitem_1 
        foreign key (bolgId) 
        references Blog3 (id);

    alter table Child3 
        add index fk_child_1 (parentId), 
        add constraint fk_child_1 
        foreign key (parentId) 
        references Parent3 (id);
