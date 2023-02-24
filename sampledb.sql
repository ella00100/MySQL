use sampledb;

select * from student;

insert into student value( '둥둥이', '냠냠사료과', '12451248');
update student set name = '몰랑이' where id = '12123261';
update student set name = '보리차' where id = '12202261';

insert into student value ('홍길동', '도난학과', '1111111');
delete from student where id = '1111111';

commit;


