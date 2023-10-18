-- 코드를 입력하세요
SELECT to_char(sales_date, 'YYYY-MM-DD') as sales_date, product_id, user_id, sales_amount from online_sale where sales_date >= to_date('2022-03-01','YYYY-MM-DD') and sales_date <= to_date('2022-03-31','YYYY-MM-DD')

union all

SELECT  to_char(sales_date, 'YYYY-MM-DD') as sales_date, product_id, NULL as user_id, sales_amount from offline_sale where sales_date >= to_date('2022-03-01','YYYY-MM-DD') and sales_date <= to_date('2022-03-31','YYYY-MM-DD')

order by sales_date asc, product_id asc, user_id asc;