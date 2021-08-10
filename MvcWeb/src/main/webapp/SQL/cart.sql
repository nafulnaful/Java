ALTER TABLE CART
   DROP
      CONSTRAINT FK_Product_TO_CART
      CASCADE;

ALTER TABLE CART
   DROP
      CONSTRAINT FK_member_TO_CART
      CASCADE;

ALTER TABLE CART
   DROP
      PRIMARY KEY
      CASCADE
      KEEP INDEX;

DROP INDEX PK_CART;

/* ��ٱ��� */
DROP TABLE CART 
   CASCADE CONSTRAINTS;

/* ��ٱ��� */
CREATE TABLE CART (
   cartNum NUMBER(8) NOT NULL, /* ��ٱ��Ϲ�ȣ */
   oqty NUMBER(8), /* ���� */
   indate DATE, /* ����� */
   pnum NUMBER(8), /* ��ǰ��ȣ */
   idx NUMBER(8) /* ȸ����ȣ */
);

COMMENT ON TABLE CART IS '��ٱ���';

COMMENT ON COLUMN CART.cartNum IS '��ٱ��Ϲ�ȣ';

COMMENT ON COLUMN CART.oqty IS '����';

COMMENT ON COLUMN CART.indate IS '�����';

COMMENT ON COLUMN CART.pnum IS '��ǰ��ȣ';

COMMENT ON COLUMN CART.idx IS 'ȸ����ȣ';

CREATE UNIQUE INDEX PK_CART
   ON CART (
      cartNum ASC
   );

ALTER TABLE CART
   ADD
      CONSTRAINT PK_CART
      PRIMARY KEY (
         cartNum
      );

ALTER TABLE CART
   ADD
      CONSTRAINT FK_Product_TO_CART
      FOREIGN KEY (
         pnum
      )
      REFERENCES Product (
         pnum
      );

ALTER TABLE CART
   ADD
      CONSTRAINT FK_member_TO_CART
      FOREIGN KEY (
         idx
      )
      REFERENCES member (
         idx
      );