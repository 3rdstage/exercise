CREATE TABLE GLOSSARY (
                id INT(10) AUTO_INCREMENT NOT NULL,
                lang_code CHAR(2),
                name VARCHAR(50) NOT NULL,
                descn VARCHAR(500),
                PRIMARY KEY (id)
);

CREATE TABLE WORD (
                id INT(10) AUTO_INCREMENT NOT NULL,
                glossary_id INT(10) NOT NULL,
                name VARCHAR(50) NOT NULL,
                short_descn VARCHAR(300),
                full_descn VARCHAR(2000),
                PRIMARY KEY (id)
);

ALTER TABLE WORD ADD CONSTRAINT fk_word_1
FOREIGN KEY (glossary_id)
REFERENCES GLOSSARY (id)
;