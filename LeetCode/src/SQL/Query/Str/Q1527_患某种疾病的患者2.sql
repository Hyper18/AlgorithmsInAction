-- 正则匹配的写法
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions REGEXP '^DIAB1|\\sDIAB1';