/*
    SYNONYM
    - �ٸ� DB (�����)�� ���� ��ü�� ���� ���� Ȥ�� ���Ӹ� // �� ģ���� ��ü
    - �ٸ� ������� ��ü�� �����ϴ� ��� '����ڸ�.��ü��'���� �����ؾ� ������
    SYNONYM (���Ǿ�)�� ����ϸ� ������ �̸����� ���� ����.
*/


-- SYNONYM ���� ���
/*
    [ǥ����]
    
    CREATE SYNONYM ���� (���Ӹ�)
    FOR ����ڸ�.��ü��;
*/

-- ���Ǿ� ����
-- ����� / ���� ���Ǿ�

-- 1. ����� ���Ǿ�
-- ��ü�� ���� ���� ������ �ο����� ����ڰ� ������ ���Ǿ�� �ش� ����ڸ� ��� ����

-- SAMPLE ������ �̿��Ͽ� KH ������ EMLOYEE ���̺� ���� ��
-- ���Ǿ �����Ͽ� EMP�� �����ϱ�

-- 1) (������ ����)
-- SAMPLE ������ KH ������ EMPLOYEE ���̺� ��ȸ ���� �ο�
GRANT SELECT ON KH.EMPLOYEE TO SAMPLE;

-- 2) (SAMPLE ����)
-- KH.EMPLOYEE ���̺� ��ȸ Ȯ��
SELECT * FROM KH.EMPLOYEE;

-- 3) (SAMPLE ����)
-- KH.EMPLOYEE ���̺��� ������ EMP�� ����
CREATE SYNONYM EMP
FOR KH.EMPLOYEE;

-- 4) (������ ����)
-- SAMPLE ������ SYNONYM ���� ���� �ο�
GRANT CREATE SYNONYM TO SAMPLE;

-- 5) (SAMPLE ����)
-- CMD���� �ٽ� SYNONYM ����
CREATE SYNONYM EMP FOR KH.EMPLOYEE;

-- 6) (SAMPLE ����)
-- SYNONYM ��ȸ
SELECT * FROM EMP;




-- 2. ���� ���Ǿ�
-- ��� ������ �ο��� �� �ִ� ���� (DBA)�� ������ ���Ǿ�
-- ��� ����ڰ� ����� �� �ִ� ���Ǿ ������ �� ����.
-- (PUBLIC)
-- EX) DUMMY TABLE -> DUAL (����Ŭ ������ ������ �ڵ����� �ٿ���)

-- KH ������ DEPARTMENT ���̺��� DEPT��� ���� ���Ǿ� ����

-- 1) (������ ����)
-- ���� ���Ǿ� ����
CREATE PUBLIC SYNONYM DEPT
FOR KH.DEPARTMENT;

SELECT * FROM KH.DEPARTMENT;
SELECT * FROM DEPT;

-- 2) �ٸ� ���� (SAMPLE)�� ���� ���Ǿ� (DEPT) ��� �������� Ȯ��
--> SAMPLE ������ KH ������ DEPARTMENT ���̺� SELECT ���� �ο�
GRANT SELECT ON KH.DEPARTMENT TO SAMPLE;
-- �ƹ��� ���� ���Ǿ�� �ش� ���̺� ���� ���� ������ ���� ��� ��ȸ �Ұ�

-- 3) (SAMPLE ����)
-- DEPT (���� ���Ǿ�) ��� �������� Ȯ��
SELECT * FROM DEPT;




-- 3. ���Ǿ� ����

-- SAMPLE ������ EMP ���Ǿ� ����
DROP SYNONYM EMP;











