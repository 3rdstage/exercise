CREATE TABLE GLOSSARY (
                id NUMBER(10, 0) NOT NULL,
                lang_code CHAR(2),
                name VARCHAR2(50) NOT NULL,
                descn VARCHAR2(500),
                PRIMARY KEY (id)
);

CREATE TABLE WORD (
                id NUMBER(10, 0) NOT NULL,
                glossary_id NUMBER(10, 0) NOT NULL,
                name VARCHAR2(50) NOT NULL,
                short_descn VARCHAR2(300),
                full_descn VARCHAR2(2000),
                PRIMARY KEY (id)
);

ALTER TABLE WORD ADD CONSTRAINT fk_word_1
FOREIGN KEY (glossary_id)
REFERENCES GLOSSARY (id)
;