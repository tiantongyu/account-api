--liquibase formatted sql
--changeset tom.yu:insertTestData splitStatements:true endDelimiter:;

INSERT INTO account (id, name, type, currency, balance)
VALUES
    ('00001','testaccount1','SAVINGS','AUD', 29870),
    ('00002','testaccount2','SAVINGS','AUD', 150000),
    ('00003','testaccount3','CURRENT','AUD', 3000),
    ('00004','testaccount4','SAVINGS','SGD', 500000),
    ('00005','testaccount5','CURRENT','SGD', 12000),
    ('00006','testaccount6','CURRENT','AUD', 1100);

INSERT INTO transactions (id, account_id, currency, amount, date)
VALUES
    ('90001','00001','AUD',1000,'2020-08-28'),
    ('90002','00001','AUD',-5000,'2020-09-05'),
    ('90003','00001','AUD',1000,'2020-09-10'),
    ('90004','00001','AUD',1300,'2020-09-27'),
    ('90005','00005','SGD',-400,'2020-08-20'),
    ('90006','00005','SGD',900,'2020-09-01');