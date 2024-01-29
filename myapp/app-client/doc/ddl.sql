-- DDL(Data Definition Language)

create table boards(
  board_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  created_date datetime null default now()
);

insert into boards(title,content,writer)
 values('제목1', '내용1','홍길동');
insert into boards(title,content,writer)
 values('제목2', '내용2','임꺽정');
insert into boards(title,content,writer)
 values('제목3', '내용3','유관순');
insert into boards(title,content,writer)
 values('제목4', '내용4','안중근');
insert into boards(title,content,writer)
 values('제목5', '내용5','윤봉길');

select *
from boards;

select *
from boards
where board_no=3;

update boards set
 title='okok',
 content='nono',
 writer='haha'
where board_no = 3;

delete from boards where board_no=3;

drop table assignment;

create table assignments(
assignment_no int primary key auto_increment,
title varchar(255) not null,
content text not null,
deadline date not null
);

insert into assignments(title,content,deadline)
 values('제목1', '내용1','2023-12-12');
insert into assignments(title,content,deadline)
 values('제목2', '내용2','2024-01-01');
insert into assignments(title,content,deadline)
 values('제목3', '내용3','2024-01-28');
insert into assignments(title,content,deadline)
 values('제목4', '내용4','2023-11-11');
insert into assignments(title,content,deadline)
 values('제목5', '내용5','2023-09-09');

create table members(
member_no int primary key auto_increment,
email varchar(255) not null,
name varchar(255) not null,
password varchar(100) not null,
created_date datetime null default now()
);

insert into members(email,name,password)
 values('dhkfkr134@naver.com','kim',sha2('1111',256));
insert into members(email,name,password)
 values('dhkfkr13@naver.com','kimju',sha2('111',256));
insert into members(email,name,password)
 values('dhkfkr4@naver.com','kimjung',sha2('11',256));
insert into members(email,name,password)
 values('dhkfkr@naver.com','kimjungwon',sha2('1',256));
insert into members(email,name,password)
 values('dhk@naver.com','won',sha2('1112',256));

alter table boards
 add column category int not null;

update boards set category=1;