------------------------------------------------------------
-- PERSON AND SUBCLASSES
------------------------------------------------------------

CREATE TABLE person (
                        id VARCHAR(50) PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        email VARCHAR(100) UNIQUE NOT NULL
);

-- Enterprise extends Person
CREATE TABLE enterprise (
                            id VARCHAR(50) PRIMARY KEY,
                            CONSTRAINT fk_enterprise_person
                                FOREIGN KEY (id) REFERENCES person(id)
                                    ON DELETE CASCADE
);

-- Association extends Person
CREATE TABLE association (
                             id VARCHAR(50) PRIMARY KEY,
                             CONSTRAINT fk_association_person
                                 FOREIGN KEY (id) REFERENCES person(id)
                                     ON DELETE CASCADE
);

------------------------------------------------------------
-- RENTAL AND SUBCLASSES
------------------------------------------------------------

CREATE TABLE rental (
                        id VARCHAR(50) PRIMARY KEY,
                        price DOUBLE PRECISION NOT NULL,
                        renter_id VARCHAR(50),

                        CONSTRAINT fk_renter
                            FOREIGN KEY (renter_id) REFERENCES person(id)
                                ON DELETE SET NULL
);

-- House extends Rental
CREATE TABLE house (
                       id VARCHAR(50) PRIMARY KEY,
                       color VARCHAR(50) NOT NULL,
                       CONSTRAINT fk_house_rental
                           FOREIGN KEY (id) REFERENCES rental(id)
                               ON DELETE CASCADE
);

-- Money extends Rental
CREATE TABLE money (
                       id VARCHAR(50) PRIMARY KEY,
                       device VARCHAR(20) NOT NULL,
                       CONSTRAINT fk_money_rental
                           FOREIGN KEY (id) REFERENCES rental(id)
                               ON DELETE CASCADE
);

-- Pc extends Rental
CREATE TABLE pc (
                    id VARCHAR(50) PRIMARY KEY,
                    model VARCHAR(100) NOT NULL,
                    brand VARCHAR(100) NOT NULL,
                    CONSTRAINT fk_pc_rental
                        FOREIGN KEY (id) REFERENCES rental(id)
                            ON DELETE CASCADE
);

-- Bicycle extends Rental
CREATE TABLE bicycle (
                         id VARCHAR(50) PRIMARY KEY,
                         model VARCHAR(100) NOT NULL,
                         brand VARCHAR(100) NOT NULL,
                         color VARCHAR(50) NOT NULL,
                         CONSTRAINT fk_bicycle_rental
                             FOREIGN KEY (id) REFERENCES rental(id)
                                 ON DELETE CASCADE
);

-- Car extends Rental
CREATE TABLE car (
                     id VARCHAR(50) PRIMARY KEY,
                     model VARCHAR(100) NOT NULL,
                     placeNumber INT NOT NULL,
                     CONSTRAINT fk_car_rental
                         FOREIGN KEY (id) REFERENCES rental(id)
                             ON DELETE CASCADE
);
