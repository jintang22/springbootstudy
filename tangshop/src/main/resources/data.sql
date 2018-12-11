insert into member (id, name, email, password, regdate) values (1, 'kim', 'abc@gamil.com', '{bcrypt}$2a$10$iZInwMMpG3bQ4mw24WeHteeDLhV8GkQWLk3PAuhE.ej3KBjT.mFji', now());
insert into member (id, name, email, password, regdate) values (2, 'kang', 'a2bc@gamil.com', '{bcrypt}$2a$10$iZInwMMpG3bQ4mw24WeHteeDLhV8GkQWLk3PAuhE.ej3KBjT.mFji', now());

insert into role (id, name) values (1, 'USER');
insert into role (id, name) values (2, 'ADMIN');

insert into member_role(member_id, role_id) values (1, 1);
insert into member_role(member_id, role_id) values (1, 2);
insert into member_role(member_id, role_id) values (2, 1);

insert into goods (id, name, price, regdate) values ( 1, 'testgoods', '100', now());
insert into goods_detail(id, content, goods_id) values ( 1, 'goods detail content', 1 );

insert into goods (id, name, price, regdate) values ( 2, 'testgoods', '200', now());
insert into goods_detail(id, content, goods_id) values ( 2, 'goods detail content', 2 );

insert into cart( id, regdate, status, goods_id, member_id, count ) values (1, now(), 'ADDED', 1, 2, 1);
insert into cart( id, regdate, status, goods_id, member_id, count ) values (2, now(), 'ADDED', 2, 2, 1 );

insert into purchase (id, regdate, status, total_order_amount, member_id) values ( 1, now(), 'PURCHASED', 100, 2);
insert into purchase_goods (id, count, order_amount, regdate , cart_id, goods_id, purchase_id)
values ( 1, 1, 100, now(), null, 1, 1);
