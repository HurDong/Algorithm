-- 코드를 입력하세요 구글링.... 너무 어렵습니다 이 문제는 ㅠ_ㅠ
SET @hour := -1;
SELECT (@hour := @hour + 1) as HOUR,
	(SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @hour) as COUNT 
FROM ANIMAL_OUTS WHERE @hour < 23;