-- 코드를 입력하세요
SELECT h.history_id,
floor(c.daily_fee * (datediff(h.end_date,h.start_date)+1) *
      (case
       when datediff(h.end_date,h.start_date)+1 <7 then 1
       when datediff(h.end_date,h.start_date)+1 <30 then 0.95
       when datediff(h.end_date,h.start_date)+1 <90 then 0.92
       else 0.85 end)) as fee
from car_rental_company_car as c join car_rental_company_rental_history as h on c.car_id = h.car_id join car_rental_company_discount_plan as p on c.car_type = p.car_type where c.car_type = '트럭' group by h.history_id order by fee desc, h.history_id desc;       
     
    