
    create table test2.Building (
        id bigint not null auto_increment,
        name varchar(60) not null,
        companyId bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table test2.Company (
        id bigint not null auto_increment,
        name varchar(60) not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table test2.Factory (
        id bigint not null auto_increment,
        name varchar(60) not null,
        companyId bigint not null,
        primary key (id)
    ) ENGINE=InnoDB;

    create table test2.industry (
        id bigint not null auto_increment,
        name varchar(50) not null,
        descn varchar(1000),
        parentId bigint,
        primary key (id),
        check (parentId != id)
    ) ENGINE=InnoDB;

    alter table test2.Building 
        add index fk_company_1 (companyId), 
        add constraint fk_company_1 
        foreign key (companyId) 
        references test2.Company (id);

    alter table test2.Factory 
        add index fk_company_2 (companyId), 
        add constraint fk_company_2 
        foreign key (companyId) 
        references test2.Company (id);

    alter table test2.industry 
        add index fk_industry_1 (parentId), 
        add constraint fk_industry_1 
        foreign key (parentId) 
        references test2.industry (id);
