
    create table ContactInfo2 (
        id bigint not null auto_increment,
        address varchar(200),
        phoneNumber varchar(50),
        primary key (id)
    );

    create table Group2 (
        id bigint not null auto_increment,
        name varchar(50) not null,
        description varchar(200),
        primary key (id)
    );

    create table Role2 (
        id bigint not null auto_increment,
        name varchar(50) not null unique,
        description varchar(200),
        primary key (id)
    );

    create table User2 (
        id bigint not null auto_increment,
        passwd varchar(20) not null,
        name varchar(50) not null,
        email varchar(80),
        contactInfoId bigint,
        groupId bigint,
        primary key (id)
    );

    create table UserRole2 (
        userId bigint not null,
        roleId bigint not null,
        primary key (userId, roleId)
    );

    alter table User2 
        add index fk_user2_2 (contactInfoId), 
        add constraint fk_user2_2 
        foreign key (contactInfoId) 
        references ContactInfo2 (id);

    alter table User2 
        add index fk_user2_1 (groupId), 
        add constraint fk_user2_1 
        foreign key (groupId) 
        references Group2 (id);

    alter table UserRole2 
        add index fk_userrole2_2 (roleId), 
        add constraint fk_userrole2_2 
        foreign key (roleId) 
        references Role2 (id);

    alter table UserRole2 
        add index fk_userrole2_1 (userId), 
        add constraint fk_userrole2_1 
        foreign key (userId) 
        references User2 (id);
