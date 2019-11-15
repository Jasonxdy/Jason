

/*
SELECT ���� �ؼ� ���� (����Ŭ �ϸ鼭 �׻� �����ؾ� �ϴ� ��)

5 : SELECT �÷��� AS ��Ī, ����, �Լ���, .... -- SELECT ��
1 : FROM ������ ���̺�� -- FROM ��
2 : WHERE �÷��� | �Լ���  �񱳿�����  �񱳰� -- WHERE ��
3 : GROUP BY �׷����� ���� �÷��� -- GROUP BY ��
4 : HAVING  �׷��Լ���  �񱳿�����  �񱳰� -- HAVING ��
6 : ORDER BY �÷��� | ��Ī | �÷�����   ���Ĺ��  [NULLS FIRST/LAST]; -- ORDER BY �� (�׻� ���� ������)

(SELECT ���� �̰� ����) -> FROM���� ������� �ؼ��ϴٰ�, SELECT -> ORDER BY ������ �����Ѵٰ� ����
*/

-- EMPLOYEE ���̺��� �μ� �ڵ尡 D5�̸� �ѹ���, D6�̸� ��ȹ��, D9�̸� �����η� ó���Ͻÿ�
-- ��, �μ��ڵ尡 D5, D6, D9�� ������ ������ ��ȸ
-- => CASE ���� ���
-- �μ��ڵ� ������������ ����

SELECT DEPT_CODE,
CASE 
WHEN DEPT_CODE = 'D5' THEN '�ѹ���'
WHEN DEPT_CODE = 'D6' THEN '��ȹ��'
WHEN DEPT_CODE = 'D9' THEN '������'
END AS �μ�
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D6','D9')
ORDER BY DEPT_CODE;






