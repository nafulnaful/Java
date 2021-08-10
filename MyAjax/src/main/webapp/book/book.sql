CREATE TABLE 
  book
  (
    isbn VARCHAR2(30),
    title VARCHAR2(100),
    publish VARCHAR2(100),
    price NUMBER(8),
    published DATE,
    bimage VARCHAR2(50) DEFAULT 'noimage.jpg',
    PRIMARY KEY (isbn)
  )
;
INSERT INTO book  VALUES 
('8972807303','���� 2021 ���������ϱ�',
'�������� �븲',17800,'2015/6/23','a.jpg');

INSERT INTO book  VALUES 
('8972807494','����Ŭ 10g + PL/SQL �Թ�',
'���Ľ�',20000,'2021/7/25','b.jpg');

INSERT INTO book  VALUES ('8972807257','HTML �Թ� + ��������',
'�븲','18000 ','2021/3/27','c.jpg');

INSERT INTO book  VALUES ('8972807133','������ ���� XML',
'�븲 ���ǻ�','20000','2015/5/30','d.jpg');
INSERT INTO book  VALUES ('8972807087','C ���  �Թ�',
'�븲1','20000','2015/3/25','e.jpg');
INSERT INTO book  VALUES ('8972807346','C++�Թ�',
'�������� �븲','18000','2021/6/30','f.jpg');
INSERT INTO book  VALUES ('8972807605',
'�÷��� �׼ǽ�ũ��Ʈ ����','�������� ���Ľ�','35000',
'2021/12/30','g.jpg');
INSERT INTO book  VALUES ('8972807621',
'DSLR ī�޶�  ���� ���� ���伥 ',
'�������� ���Ľ�','16000','2021/12/18','h.jpg');
commit;




