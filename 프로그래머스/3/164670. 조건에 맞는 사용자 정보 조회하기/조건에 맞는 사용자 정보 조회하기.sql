-- 코드를 입력하세요
SELECT u.user_id, u.nickname, concat(u.city,' ',u.street_address1,' ',u.street_address2) as 전체주소,
concat(substring(u.tlno,1,3),'-',substring(u.tlno,4,4),'-',substring(u.tlno,8,4)) as 전화번호
from used_goods_user u join used_goods_board b on u.user_id = b.writer_id group by u.user_id having count(*) >= 3 order by u.user_id desc;