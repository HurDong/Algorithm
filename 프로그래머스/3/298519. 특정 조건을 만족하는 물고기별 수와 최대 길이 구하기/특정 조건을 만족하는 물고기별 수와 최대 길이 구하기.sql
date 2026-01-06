-- 코드를 작성해주세요
select count(*) as fish_count, max(ifnull(length,10)) as max_length, fish_type from fish_info group by fish_type having avg(ifnull(length,10)) >= 33 order by fish_type asc;

