
    create table Building (
        id varchar(16) not null,
        name varchar(60),
        companyId varchar(16),
        primary key (id)
    );

    create table Company (
        id varchar(16) not null,
        name varchar(255),
        primary key (id)
    );

    create table Course (
        id varchar(16) not null,
        name varchar(60),
        primary key (id)
    );

    create table Employee (
        id varchar(16) not null,
        bossId varchar(16),
        name varchar(60),
        companyId varchar(16),
        primary key (id)
    );

    create table Factory (
        id varchar(16) not null,
        name varchar(60),
        companyId varchar(16),
        primary key (id)
    );

    create table Person (
        id varchar(16) not null,
        name varchar(30) not null,
        country varchar(50),
        city varchar(50),
        street varchar(50),
        number integer,
        primary key (id)
    );

    create table Student (
        id varchar(16) not null,
        name varchar(60),
        primary key (id)
    );

    create table StudentCourseMap (
        studentId varchar(16) not null,
        courseId varchar(16) not null,
        primary key (studentId, courseId)
    );

    alter table Building 
        add index fk_building_1 (companyId), 
        add constraint fk_building_1 
        foreign key (companyId) 
        references Company (id);

    create index idx_company_1 on Company (name);

    alter table Employee 
        add index fk_employee_1 (bossId), 
        add constraint fk_employee_1 
        foreign key (bossId) 
        references Employee (id);

    alter table Employee 
        add index fk_employee_2 (companyId), 
        add constraint fk_employee_2 
        foreign key (companyId) 
        references Company (id);

    alter table Factory 
        add index fk_factory_1 (companyId), 
        add constraint fk_factory_1 
        foreign key (companyId) 
        references Company (id);

    alter table StudentCourseMap 
        add index fk_studentcoursemap_1 (courseId), 
        add constraint fk_studentcoursemap_1 
        foreign key (courseId) 
        references Course (id);

    alter table StudentCourseMap 
        add index fk_studentcoursemap_2 (studentId), 
        add constraint fk_studentcoursemap_2 
        foreign key (studentId) 
        references Student (id);
