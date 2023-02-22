create database malldb;

use malldb;

create table userTbl( 
userID 		char(8)	 	NOT NULL 	primary key,
name  		varchar(10) NOT NULL 	unique,
birthYear 	int 		NOT NULL,
address 	char(2) 	NOT NULL,
mobile1 	char(3) 	NOT NULL, 
mobile2 	char(8) 	NOT NULL,
height 		smallint,
mDate		 date ); 

insert into userTbl  values('LSG', '이승기', 1967, '서울', '011', '11111111', 182, '2008-8-8');
insert into userTbl  values('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4');
insert into userTbl  values('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7');
insert into userTbl  values('JYP', '조용필', 1950, '경기', '011', '44444444', 166, '2009-4-4');
insert into userTbl  values('SSK', '성시경', 1979, '서울', '010', '12345678', 186, '2013-12-12');
insert into userTbl  values('LJB', '임재범', 1963, '서울', '016', '66666666', 182, '2009-9-9');
insert into userTbl  values('YJS', '윤종신', 1969, '경남', '010', '09283746', 170, '2005-5-5');
insert into userTbl  values('EJW', '은지원', 1972, '경북', '011', '88888888', 174, '2014-3-3');
insert into userTbl  values('JKW', '조관우', 1965, '경기', '018', '99999999', 172, '2010-10-10');
insert into userTbl  values('BBK', '비비킴', 1973, '서울', '010', '00000000', 176, '2013-5-5');

commit;

select * from userTbl;
select userID, name from userTbl;
select count(*) from userTbl;

drop table buyTbl;
commit;

create table buyTbl(
num		  int 		auto_increment	not null	primary key,
userID	  char(8)	not null,
prodName  char(6)	not null,
groubName char(4),
price 	  int 		not null,
amout 	  smallint 	not null,
foreign key(userID) references userTbl(userID) );

insert into buyTbl  values(NULL, 'KBS', '운동화', NULL, 30, 2);
insert into buyTbl  values(NULL, 'KBS', '노트북', '전자', 1000, 1);
insert into buyTbl  values(NULL, 'JYP', '모니터', '전자', 200, 1);
insert into buyTbl  values(NULL, 'BBK', '모니터', '전자', 200, 5);
insert into buyTbl  values(NULL, 'KBS', '청바지', '의류', 50, 3);
insert into buyTbl  values(NULL, 'BBK', '메모리', '전자', 80, 10);
insert into buyTbl  values(NULL, 'SSK', '책', '서적', 15, 5);
insert into buyTbl  values(NULL, 'EJW', '책', '서적', 15, 2);
insert into buyTbl  values(NULL, 'EJW', '청바지', '의류', 50, 1);
insert into buyTbl  values(NULL, 'BBK', '운동화', NULL, 30, 2);
insert into buyTbl  values(NULL, 'EJW', '책', '서적', 15, 1);
insert into buyTbl  values(NULL, 'BBK', '운동화', NULL, 30, 2);

commit;

select * from buyTbl;
select count(*) from buyTbl;




