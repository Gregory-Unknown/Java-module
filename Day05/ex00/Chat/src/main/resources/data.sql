insert into chat.users (login, passwd) VALUES ('German', '123456');
insert into chat.users (login, passwd) VALUES ('Petr', '45345');
insert into chat.users (login, passwd) VALUES ('Tommy', '343');
insert into chat.users (login, passwd) VALUES ('Vasil', '44');
insert into chat.users (login, passwd) VALUES ('Jingle', '123456453');
insert into chat.users (login, passwd) VALUES ('Bells', 'login');

insert into chat.room (chat_owner, chat_name) VALUES (1, 'chat1');
insert into chat.room (chat_owner, chat_name) VALUES (2, 'chat2');
insert into chat.room (chat_owner, chat_name) VALUES (3, 'chat3');
insert into chat.room (chat_owner, chat_name) VALUES (4, 'chat4');
insert into chat.room (chat_owner, chat_name) VALUES (5, 'chat5');

set time zone "Europe/Moscow";

insert into chat.msgs (room_id, sender, message, time) VALUES (1, 2, 'hello friends', to_timestamp(extract(epoch from now())));
insert into chat.msgs (room_id, sender, message, time) VALUES (3, 2, 'hello friends', to_timestamp(extract(epoch from now())));
insert into chat.msgs (room_id, sender, message, time) VALUES (4, 2, 'hello friends', to_timestamp(extract(epoch from now())));
insert into chat.msgs (room_id, sender, message, time) VALUES (1, 2, 'hello friends', to_timestamp(extract(epoch from now())));
insert into chat.msgs (room_id, sender, message, time) VALUES (1, 3, 'hello friends', to_timestamp(extract(epoch from now())));
insert into chat.msgs (room_id, sender, message, time) VALUES (2, 3, 'hello friends', to_timestamp(extract(epoch from now())));
