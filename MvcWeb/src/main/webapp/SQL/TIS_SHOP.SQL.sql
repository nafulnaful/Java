ALTER TABLE upCategory
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_upCategory;

/* ����ī�װ� */
DROP TABLE upCategory 
	CASCADE CONSTRAINTS;

/* ����ī�װ� */
CREATE TABLE upCategory (
	upcg_code NUMBER(8) NOT NULL, /* ����ī�װ��ڵ� */
	upcg_name VARCHAR2(30) NOT NULL /* ����ī�װ��� */
);

COMMENT ON TABLE upCategory IS '����ī�װ�';

COMMENT ON COLUMN upCategory.upcg_code IS '����ī�װ��ڵ�';

COMMENT ON COLUMN upCategory.upcg_name IS '����ī�װ���';

CREATE UNIQUE INDEX PK_upCategory
	ON upCategory (
		upcg_code ASC
	);

ALTER TABLE upCategory
	ADD
		CONSTRAINT PK_upCategory
		PRIMARY KEY (
			upcg_code
		);
-------------------------------------------------------------
ALTER TABLE downCategory
	DROP
		CONSTRAINT FK_upCategory_TO_downCategory
		CASCADE;

ALTER TABLE downCategory
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_downCategory;

/* ���� ī�װ� */
DROP TABLE downCategory 
	CASCADE CONSTRAINTS;

/* ���� ī�װ� */
CREATE TABLE downCategory (
	downcg_code NUMBER(8) NOT NULL, /* ���� ī�װ� �ڵ� */
	downcg_name VARCHAR2(30) NOT NULL, /* ���� ī�װ��� */
	upcg_code NUMBER(8) NOT NULL /* ����ī�װ��ڵ� */
);

COMMENT ON TABLE downCategory IS '���� ī�װ�';

COMMENT ON COLUMN downCategory.downcg_code IS '���� ī�װ� �ڵ�';

COMMENT ON COLUMN downCategory.downcg_name IS '���� ī�װ���';

COMMENT ON COLUMN downCategory.upcg_code IS '����ī�װ��ڵ�';

CREATE UNIQUE INDEX PK_downCategory
	ON downCategory (
		downcg_code ASC
	);

ALTER TABLE downCategory
	ADD
		CONSTRAINT PK_downCategory
		PRIMARY KEY (
			downcg_code
		);

ALTER TABLE downCategory
	ADD
		CONSTRAINT FK_upCategory_TO_downCategory
		FOREIGN KEY (
			upcg_code
		)
		REFERENCES upCategory (
			upcg_code
		);
------------------------------------------------
ALTER TABLE Product
	DROP
		CONSTRAINT FK_downCategory_TO_Product
		CASCADE;

ALTER TABLE Product
	DROP
		CONSTRAINT FK_upCategory_TO_Product
		CASCADE;

ALTER TABLE Product
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_Product;

/* ��ǰ */
DROP TABLE Product 
	CASCADE CONSTRAINTS;

/* ��ǰ */
CREATE TABLE Product (
	pnum NUMBER(8) NOT NULL, /* ��ǰ��ȣ */
	pname VARCHAR2(100) NOT NULL, /* ��ǰ�� */
	pcompany VARCHAR2(50), /* ������ */
	pimage1 VARCHAR2(100), /* ��ǰ�̹���1 */
	pimage2 VARCHAR2(100), /* ��ǰ�̹���2 */
	pimage3 VARCHAR2(100), /* ��ǰ�̹���3 */
	pqty NUMBER(8), /* �������� */
	price NUMBER(8) NOT NULL, /* ���� */
	saleprice NUMBER(8) NOT NULL, /* �ǸŰ� */
	pspec VARCHAR2(20), /* ��ǰ���� */
	pcontents VARCHAR2(1000), /* �󼼼��� */
	point NUMBER(8), /* ����Ʈ */
	pindate DATE NOT NULL, /* ��ǰ�԰��� */
	downcg_code NUMBER(8), /* ���� ī�װ� �ڵ� */
	upcg_code NUMBER(8) /* ����ī�װ��ڵ� */
);

COMMENT ON TABLE Product IS '��ǰ';

COMMENT ON COLUMN Product.pnum IS '��ǰ��ȣ';

COMMENT ON COLUMN Product.pname IS '��ǰ��';

COMMENT ON COLUMN Product.pcompany IS '������';

COMMENT ON COLUMN Product.pimage1 IS '��ǰ�̹���1';

COMMENT ON COLUMN Product.pimage2 IS '��ǰ�̹���2';

COMMENT ON COLUMN Product.pimage3 IS '��ǰ�̹���3';

COMMENT ON COLUMN Product.pqty IS '��������';

COMMENT ON COLUMN Product.price IS '����';

COMMENT ON COLUMN Product.saleprice IS '�ǸŰ�';

COMMENT ON COLUMN Product.pspec IS '��ǰ����';

COMMENT ON COLUMN Product.pcontents IS '�󼼼���';

COMMENT ON COLUMN Product.point IS '����Ʈ';

COMMENT ON COLUMN Product.pindate IS '��ǰ�԰���';

COMMENT ON COLUMN Product.downcg_code IS '���� ī�װ� �ڵ�';

COMMENT ON COLUMN Product.upcg_code IS '����ī�װ��ڵ�';

CREATE UNIQUE INDEX PK_Product
	ON Product (
		pnum ASC
	);

ALTER TABLE Product
	ADD
		CONSTRAINT PK_Product
		PRIMARY KEY (
			pnum
		);

ALTER TABLE Product
	ADD
		CONSTRAINT FK_downCategory_TO_Product
		FOREIGN KEY (
			downcg_code
		)
		REFERENCES downCategory (
			downcg_code
		);

ALTER TABLE Product
	ADD
		CONSTRAINT FK_upCategory_TO_Product
		FOREIGN KEY (
			upcg_code
		)
		REFERENCES upCategory (
			upcg_code
		);


grant all on memo to tis_shop;

grant all on memo_seq to tis_shop;

select * from memo order by idx desc;
--������ ����------------------------------
CREATE SEQUENCE UPCATEGORY_SEQ
START WITH 1 INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE DOWNCATEGORY_SEQ
START WITH 1 INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE PRODUCT_SEQ NOCACHE;
--------------------------------------------


INSERT INTO UPCATEGORY(UPCG_CODE, UPCG_NAME)
VALUES(UPCATEGORY_SEQ.NEXTVAL,'������ǰ');

INSERT INTO UPCATEGORY(UPCG_CODE, UPCG_NAME)
VALUES(UPCATEGORY_SEQ.NEXTVAL,'��Ȱ��ǰ');
COMMIT;

INSERT INTO DOWNCATEGORY(DOWNCG_CODE, DOWNCG_NAME, UPCG_CODE)
VALUES(DOWNCATEGORY_SEQ.NEXTVAL,'��ǻ��/��Ʈ��', 1);
INSERT INTO DOWNCATEGORY(DOWNCG_CODE, DOWNCG_NAME, UPCG_CODE)
VALUES(DOWNCATEGORY_SEQ.NEXTVAL,'�����', 1);

INSERT INTO DOWNCATEGORY(DOWNCG_CODE, DOWNCG_NAME, UPCG_CODE)
VALUES(DOWNCATEGORY_SEQ.NEXTVAL,'�ֹ漼��', 2);
INSERT INTO DOWNCATEGORY(DOWNCG_CODE, DOWNCG_NAME, UPCG_CODE)
VALUES(DOWNCATEGORY_SEQ.NEXTVAL,'����', 2);
COMMIT;

SELECT * FROM UPCATEGORY;
SELECT * FROM DOWNCATEGORY;








        