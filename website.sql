create table website
(
    id       int auto_increment
        primary key,
    name     varchar(30)  null,
    url      varchar(200) null,
    tagId    int          null,
    `order`  int          null,
    dateTime datetime     not null
)
    comment '网站';

INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (1, 'github', 'https://github.com/', 1, 1, '2020-08-31 07:39:04');
INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (2, 'bootcdn', 'https://www.bootcdn.cn/', 1, 4, '2020-08-31 07:39:07');
INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (3, 'gitlab', 'http://www.gitlab.com/', 1, 3, '2020-08-31 07:39:09');
INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (4, '坚果云', 'https://www.jianguoyun.com/#/', 1, 2, '2020-08-31 07:39:18');
INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (5, 'gmail', 'https://mail.google.com/mail/u/0/?pli=1#inbox', 1, 5, '2020-08-31 07:39:20');
INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (6, 'ProcessOn', 'https://www.processon.com/diagrams', 2, 6, '2020-08-31 07:39:22');
INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (7, '阿里云控制台', 'https://account.aliyun.com/login/', 2, 7, '2020-08-31 18:59:04');
INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (8, '宝塔运维', 'http://47.93.223.61:8888/fsrbt/', 2, 8, '2020-08-31 18:59:44');
INSERT INTO website (id, name, url, tagId, `order`, dateTime) VALUES (9, 'Vultr', 'https://my.vultr.com/', 2, 9, '2020-08-31 19:02:53');