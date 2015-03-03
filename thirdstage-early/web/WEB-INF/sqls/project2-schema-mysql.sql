
    alter table project2.Process2 
        drop 
        foreign key fk_process_1;

    drop table if exists project2.Process2;

    drop table if exists project2.Requirement2;

    create table project2.Process2 (
        no bigint not null auto_increment,
        id varchar(50) not null unique,
        name varchar(200) not null,
        description text,
        createdDate datetime,
        parentProcessId bigint,
        primary key (no)
    );

    create table project2.Requirement2 (
        no bigint not null auto_increment,
        id varchar(32) not null unique,
        title varchar(100) not null,
        request text,
        response text,
        requestedDate datetime,
        primary key (no)
    );

    create index idx_process_1 on project2.Process2 (id);

    create index idx_process_2 on project2.Process2 (name);

    alter table project2.Process2 
        add index fk_process_1 (parentProcessId), 
        add constraint fk_process_1 
        foreign key (parentProcessId) 
        references project2.Process2 (no);

    create index idx_requirement_1 on project2.Requirement2 (id);
