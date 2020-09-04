create table tag
(
    tid    int auto_increment
        primary key,
    tname  varchar(20)          null,
    torder int                  null,
    secret tinyint(1) default 0 null
)
    comment '网站标签';

INSERT INTO tag (tid, tname, torder, secret) VALUES (1, '常用', 1, 0);
INSERT INTO tag (tid, tname, torder, secret) VALUES (2, '服务器', 2, 0);
INSERT INTO tag (tid, tname, torder, secret) VALUES (3, '隐私', 3, 1);