-- 코드를 입력하세요
SELECT ANIMAL_ID, name, TO_CHAR(DATETIME, 'yyyy-MM-dd')
from animal_ins
order by animal_id;