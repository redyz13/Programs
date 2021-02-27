//CREATE DATABASE autoTest

CREATE TABLE Modello (
    nomeModello VARCHAR(20) NOT NULL,

    PRIMARY KEY(nomeModello)
)

CREATE TABLE auto (
    targa VARCHAR(8) NOT NULL,
    cilindrata INT NOT NULL,
    prezzo FLOAT NOT NULL,
    modello VARCHAR(20) NOT NULL,
    colore VARCHAR(20) NOT NULL,
    alimentazione VARCHAR(10) NOT NULL,

    PRIMARY KEY(targa),
    FOREIGN KEY(modello) REFERENCES Modello(nomeModello)
)

CREATE UNIQUE INDEX IndMod
ON auto(modello)

CREATE UNIQUE INDEX IndMC
ON auto(modello, colore)