insert into user_tb(username, password, email, created_at)
values ('ssar', '$2a$10$i1bXiG7ILY47VVrXQwy0h.ckyNN7/GS9r3AgKJFwTKOd3xxGxD0Wu', 'ssar@nate.com', now());
insert into user_tb(username, password, email, created_at)
values ('cos', '$2a$10$i1bXiG7ILY47VVrXQwy0h.ckyNN7/GS9r3AgKJFwTKOd3xxGxD0Wu', 'cos@nate.com', now());
insert into user_tb(username, password, email, created_at)
values ('love', '$2a$10$i1bXiG7ILY47VVrXQwy0h.ckyNN7/GS9r3AgKJFwTKOd3xxGxD0Wu', 'love@nate.com', now());

insert into board_tb(title, content, user_id, is_public, created_at)
values ('제목1', '내용1', 1, true, now());
insert into board_tb(title, content, user_id, is_public, created_at)
values ('제목2', '내용2', 1, true, now());
insert into board_tb(title, content, user_id, is_public, created_at)
values ('제목3', '내용3', 2, true, now());
insert into board_tb(title, content, user_id, is_public, created_at)
values ('제목4', '내용4', 3, true, now());
insert into board_tb(title, content, user_id, is_public, created_at)
values ('제목5', '내용5', 1, false, now());
