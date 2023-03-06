create database hw;

use hw;
drop table 응모자;
create table 응모자(
번호 int not null primary key,
이름 varchar(10) not null,
주소 varchar(100),
연락처 varchar(11),
지역 varchar(10),
응모분야 varchar(10),
당첨여부 varchar(1),
foreign key (지역) references 지역(지역코드)
);

create table 지역(
지역코드 varchar(10) not null primary key, 
지역명 varchar(20) );

insert into 응모자 value(1,'dung', '인천광역시 연수구', '01077777777', '01', '화장품', 'Y');
insert into 응모자 value(2,'kim', '서울특별시 강남', '01075477157', '02', '물티슈', 'Y');
insert into 응모자 value(3,'nami', '서울특별시 강동', '01058971100', '02', '아이패드', 'N');
insert into 응모자 value(4,'park', '서울특별시 강서', '01077725477', '02', '에어팟', 'Y');
insert into 응모자 value(5,'abraham', '울산광역시', '01071234567', '03', '무드등', 'N');

insert into 지역 value('01', '인천');
insert into 지역 value('02', '서울');
insert into 지역 value('03', '울산');

drop view V_luck;

create view V_luck
as select 이름, 주소, 당첨여부 from 응모자
where 지역 = '02' and 당첨여부 = 'Y';

select * from V_luck;

commit;

