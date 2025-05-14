-- 코드를 입력하세요
-- 상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛
-- 총주문량이 큰 순서대로 조회

WITH T1 AS(
    SELECT *
    FROM FIRST_HALF 
    WHERE TOTAL_ORDER>= 3000
)


SELECT A.FLAVOR
FROM T1 A
JOIN ICECREAM_INFO B ON A.FLAVOR = B.FLAVOR
WHERE B.INGREDIENT_TYPE = 'fruit_based'
ORDER BY A.TOTAL_ORDER DESC;