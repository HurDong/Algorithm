-- 코드를 입력하세요
SELECT date_format(o.sales_date,"%Y") as year,
date_format(o.sales_date,"%m") as month,
count(distinct u.user_id) as puchased_users,
round((count(distinct u.user_id) / (select count(*) from user_info where year(joined) = 2021)),1) as puchased_ratio
from user_info u join online_sale o on u.user_id = o.user_id
where u.joined like concat("2021","%")
group by year,month
order by year,month;