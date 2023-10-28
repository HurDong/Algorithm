-- 코드를 입력하세요
SELECT car_id,
max(case
    when end_date >= '2022-10-16' and start_date <= '2022-10-16' then '대여중'
    else '대여 가능'
end) as avaliability
from car_rental_company_rental_history group by car_id order by car_id desc;