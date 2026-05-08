-- 코드를 작성해주세요
select id, (select count(*) from ecoli_data where parent_id = a.id) as child_count from ecoli_data a order by id asc;