insert into member (id, name, password, email, regdate) values(1, '김진탱', '{bcrypt}$2a$10$ZEulp8wVXy7eTuQiMqeyn.XqXSpV2xq/587PUSpu0lIghw7rsMvK2', 'jintang22@gmail.com', now());
insert into member (id, name, password, email, regdate) values(2, '김진태', '{bcrypt}$2a$10$ZEulp8wVXy7eTuQiMqeyn.XqXSpV2xq/587PUSpu0lIghw7rsMvK2', 'jintkim@ebay.com', now());
insert into member (id, name, password, email, regdate) values(3, '김진탱이', '{bcrypt}$2a$10$V72uvnzcHMNBOyc6NlyH5OjwRzWYGiFAClF1MYu8JVcZcevTqfRSS', 'a', now());

insert into role (id,  name) values (1, 'MEMBER');
insert into role (id,  name) values (2, 'ADMIN');

insert into member_role(member_id, role_id) values( 1, 1);
insert into member_role(member_id, role_id) values( 1, 2);
insert into member_role(member_id, role_id) values( 2, 1);


insert into item(id, name, price, regdate, content ) values ( 1, '테스트상품1', 100, now(), 'this is content a');
insert into item(id, name, price, regdate, content ) values ( 2, '테스트상품2', 200, now(), 'this is content b');
insert into item(id, name, price, regdate, content ) values ( 3, '테스트상품3', 300, now(), 'this is content c');
insert into item(id, name, price, regdate, content ) values ( 4, '테스트상품4', 400, now(), 'this is content d');
insert into item(id, name, price, regdate, content ) values ( 5, '테스트상품5', 500, now(), 'this is content e');