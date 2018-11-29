insert into member (id, name, email, password, regdate) values (1, 'kim', 'abc@gamil.com', '{bcrypt}$2a$10$iZInwMMpG3bQ4mw24WeHteeDLhV8GkQWLk3PAuhE.ej3KBjT.mFji', now());

insert into member (id, name, email, password, regdate) values (2, 'kang', 'a2bc@gamil.com', '{bcrypt}$2a$10$iZInwMMpG3bQ4mw24WeHteeDLhV8GkQWLk3PAuhE.ej3KBjT.mFji', now());

insert into role (id, name) values (1, 'USER');
insert into role (id, name) values (2, 'ADMIN');

insert into member_role(member_id, role_id) values (1, 1);
insert into member_role(member_id, role_id) values (1, 2);
insert into member_role(member_id, role_id) values (2, 1);


insert into board(id, create_date, read_count, title, member_id) values (1, now(), 0, 'test_title1', 1);
insert into board(id, create_date, read_count, title, member_id) values (2, now(), 0, 'test_title2', 1);
insert into board(id, create_date, read_count, title, member_id) values (3, now(), 0, 'test_title3', 2);
insert into board(id, create_date, read_count, title, member_id) values (4, now(), 0, 'test_title4', 1);
insert into board(id, create_date, read_count, title, member_id) values (5, now(), 0, 'test_title5', 2);

insert into board_content(id, board_id, content) values (1,1,'contents1');
insert into board_content(id, board_id, content) values (2,2,'contents2');
insert into board_content(id, board_id, content) values (3,3,'contents3');
insert into board_content(id, board_id, content) values (4,4,'contents4');
insert into board_content(id, board_id, content) values (5,5,'contents5');