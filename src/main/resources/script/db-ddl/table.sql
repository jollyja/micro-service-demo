drop table demo_tran_log;

CREATE TABLE demo_tran_log (
    tran_seq varchar(40) not null,
    tran_date varchar(8) not null, -- YYYYMMDD
    tran_time timestamp(3) not null, 
    tran_cost decimal(19) not null default 0,
    tran_amount decimal(19, 2) not null default 0,
    tran_code varchar(10) not null,
    tran_name varchar(20) not null,
    tran_desc varchar(200) null,
	PRIMARY KEY (tran_seq),
    KEY demo_tran_log_idx1 (tran_time) USING BTREE,
    KEY demo_tran_log_idx2 (tran_amount) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


