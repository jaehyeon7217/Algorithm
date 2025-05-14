-- 코드를 입력하세요
--  평균 대여 기간이 7일 이상인 자동차들
-- 자동차 ID와 평균 대여 기간(컬럼명: AVERAGE_DURATION) 리스트
-- 평균 대여 기간은 소수점 두번째 자리에서 반올림하고
--  결과는 평균 대여 기간을 기준으로 내림차순 정렬해주시고, 평균 대여 기간이 같으면 자동차 ID를 기준으로 내림차순 정렬
SELECT CAR_ID, TO_CHAR(ROUND(AVG(END_DATE-START_DATE+1), 1), 'FM9999990.0') AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
HAVING AVG(END_DATE-START_DATE+1) >=7
ORDER BY TO_NUMBER(AVERAGE_DURATION) DESC, CAR_ID DESC;