-- boards data --
insert into boards(title,content,writer,category)
 values('제목1', '내용1','홍길동',1);
insert into boards(title,content,writer,category)
 values('제목2', '내용2','임꺽정',1);
insert into boards(title,content,writer,category)
 values('제목3', '내용3','유관순',1);
insert into boards(title,content,writer,category)
 values('제목4', '내용4','안중근',1);
insert into boards(title,content,writer,category)
 values('제목5', '내용5','윤봉길',1);

 -- board_files data --
 insert into board_files(file_no, file_path, board_no) values
  (1,'a1.gif', 1), (2,'a2.gif', 1), (3,'a3.gif', 1),
  (4,'b1.gif', 2), (5,'b2.gif', 2),
  (6,'c1.gif', 4), (7,'c2.gif', 4), (8,'c3.gif', 4),(9,'c4.gif', 4),
  (10,'d1.gif', 5);

 -- assignments data --
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

  -- members data --
insert into members(email,name,password)
 values('dhkfkr1@naver.com','kim',sha2('1111',256));
insert into members(email,name,password)
 values('dhkfkr2@naver.com','kimju',sha2('111',256));
insert into members(email,name,password)
 values('dhkfkr3@naver.com','kimjung',sha2('11',256));
insert into members(email,name,password)
 values('dhkfkr4@naver.com','kimjungwon',sha2('1',256));
insert into members(email,name,password)
 values('dhk5@naver.com','won',sha2('1112',256));