-- 버전 문제로 in 절 안에 limit불가여서 join절에 붙이기
# select id, length from fish_info where id in (select id from fish_info order by length limit 10) order by id asc;
select f.id, f.length from fish_info f join (select id from fish_info order by length desc limit 10) j on f.id = j.id order by f.length desc, f.id asc;

