CREATE TABLE customer
(
    dni            varchar(20) NOT NULL,
    full_name       varchar(50) NOT NULL,
    credit_card    varchar(20) NOT NULL,
    total_flights  int NOT NULL,
    total_lodgings int NOT NULL,
    total_tours    int NOT NULL,
    phone_number  varchar(20) NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY ( dni )
);

CREATE TABLE fly
(
    "id"           bigserial NOT NULL,
    origin_lat   decimal NOT NULL,
    origin_lng   decimal NOT NULL,
    destiny_lng  decimal NOT NULL,
    destiny_lat  decimal NOT NULL,
    origin_name  varchar(20) NOT NULL,
    destiny_name varchar(20) NOT NULL,
    aero_line varchar(20) NOT NULL,
    price double precision NOT NULL,
    CONSTRAINT pk_fly PRIMARY KEY ( "id" )
);


CREATE TABLE hotel
(
    "id"      bigserial NOT NULL,
    name    varchar(50) NOT NULL,
    address varchar(50) NOT NULL,
    rating int NOT NULL,
    price    double precision NOT NULL,
    CONSTRAINT pk_hotel PRIMARY KEY ( "id" )
);

CREATE TABLE tour
(
    "id"             bigserial NOT NULL,
    id_customer       varchar(20) NOT NULL,
    CONSTRAINT pk_tour PRIMARY KEY ( "id" ),
    CONSTRAINT fk_customer FOREIGN KEY ( id_customer ) REFERENCES customer ( dni ) ON DELETE NO ACTION
);

CREATE TABLE reservation
(
    "id"             uuid NOT NULL,
    date_reservation timestamp NOT NULL,
    date_start       date NOT NULL,
    date_end         date NULL,
    total_days       int NOT NULL,
    price            double precision not null,
    tour_id          bigint NULL,
    hotel_id         bigint NULL,
    customer_id      varchar(20) NOT NULL,
    CONSTRAINT pk_reservation PRIMARY KEY ( "id" ),
    CONSTRAINT fk_customer_r FOREIGN KEY ( customer_id ) REFERENCES customer ( dni ) ON DELETE NO ACTION ,
    CONSTRAINT fk_hotel_r FOREIGN KEY ( hotel_id ) REFERENCES hotel ( "id" ) ON DELETE NO ACTION ,
    CONSTRAINT fk_tour_r FOREIGN KEY ( tour_id ) REFERENCES tour ( "id" ) ON DELETE CASCADE
);

CREATE TABLE ticket
(
    "id"           uuid NOT NULL,
    price          double precision NOT NULL,
    fly_id         bigint NOT NULL,
    customer_id    varchar(20) NOT NULL,
    departure_date timestamp NOT NULL,
    arrival_date   timestamp NOT NULL,
    purchase_date  timestamp NOT NULL,
    tour_id   bigint,
    CONSTRAINT pk_ticket PRIMARY KEY ( "id" ),
    CONSTRAINT fk_customer_t FOREIGN KEY ( customer_id ) REFERENCES customer ( dni )ON DELETE NO ACTION,
    CONSTRAINT fk_fly_t FOREIGN KEY ( fly_id ) REFERENCES fly ( "id" ) ON DELETE NO ACTION,
    CONSTRAINT fk_tour_t FOREIGN KEY ( tour_id ) REFERENCES tour ( "id" ) ON DELETE CASCADE
);