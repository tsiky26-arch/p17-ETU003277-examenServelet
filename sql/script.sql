
USE db_s2_ETU003277;

create table ligneDeCredit(
    id integer primary key auto_increment,
    libelle varchar(50),
    montant decimal(10,2)
);

create table ligneDeDepense(
    id integer primary key auto_increment,
    idCredit int,
    depense decimal(10,2)
);

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);