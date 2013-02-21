CREATE TABLE CODE_GROUP (
                id VARCHAR2(20) NOT NULL,
                name VARCHAR2(50) NOT NULL,
                descn VARCHAR2(1000),
                PRIMARY KEY (id)
);

CREATE TABLE CODE (
                code_group_id VARCHAR2(20) NOT NULL,
                code VARCHAR2(20) NOT NULL,
                name VARCHAR2(50) NOT NULL,
                seq NUMBER(5, 0) DEFAULT 1 NOT NULL,
                short_descn VARCHAR2(1000),
                full_descn CLOB,
                PRIMARY KEY (code_group_id, code)
);

ALTER TABLE CODE ADD CONSTRAINT fk_code_1
FOREIGN KEY (code_group_id)
REFERENCES CODE_GROUP (id);


