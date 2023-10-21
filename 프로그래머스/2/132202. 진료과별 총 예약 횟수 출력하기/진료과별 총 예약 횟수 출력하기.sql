-- 코드를 입력하세요
SELECT mcdp_cd as 진료과코드, count(*) as 5월예약건수 from appointment where apnt_ymd between '2022-05-01' and '2022-05-31' group by mcdp_cd  order by 5월예약건수 asc, 진료과코드 asc;