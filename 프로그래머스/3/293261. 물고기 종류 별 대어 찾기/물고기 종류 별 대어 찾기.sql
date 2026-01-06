-- 코드를 작성해주세요
select f.id, n.fish_name, f.length from fish_info f join fish_name_info n on f.fish_type = n.fish_type where f.length =(
    select max(f2.length) from fish_info f2 where f2.fish_type = f.fish_type
) order by f.id asc;