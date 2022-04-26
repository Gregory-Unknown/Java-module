insert into chat.users (login, password) VALUES ('German', '123456');
insert into chat.users (login, password) VALUES ('Petr', '45345');
insert into chat.users (login, password) VALUES ('Tommy', '343');
insert into chat.users (login, password) VALUES ('Vasil', '44');
insert into chat.users (login, password) VALUES ('Jingle', '123456453');
insert into chat.users (login, password) VALUES ('Bells', 'login');

insert into chat.room (chat_owner, chat_name) VALUES (1, 'chat1');
insert into chat.room (chat_owner, chat_name) VALUES (2, 'chat2');
insert into chat.room (chat_owner, chat_name) VALUES (3, 'chat3');
insert into chat.room (chat_owner, chat_name) VALUES (4, 'chat4');
insert into chat.room (chat_owner, chat_name) VALUES (5, 'chat5');

set time zone "Europe/Moscow";

insert into chat.message (room_id, sender, message, time) VALUES (1, 1, 'hello friends', to_timestamp(extract(epoch from now())));
insert into chat.message (room_id, sender, message, time) VALUES (3, 2, 'bonjour friends', to_timestamp(extract(epoch from now())));
insert into chat.message (room_id, sender, message, time) VALUES (4, 2, 'salut friends', to_timestamp(extract(epoch from now())));
insert into chat.message (room_id, sender, message, time) VALUES (1, 2, 'hi friends', to_timestamp(extract(epoch from now())));
insert into chat.message (room_id, sender, message, time) VALUES (1, 3, 'zdorovo friends', to_timestamp(extract(epoch from now())));
insert into chat.message (room_id, sender, message, time) VALUES (2, 3, 'ciao friends', to_timestamp(extract(epoch from now())));
