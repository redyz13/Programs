// CREATE DATABASE officina

CREATE TABLE Proprietario (

	codiceProprietario SMALLINT NOT NULL,
	nome VARCHAR(20) NOT NULL,
	cognome VARCHAR(20) NOT NULL,
	codiceFiscale CHAR(16) NOT NULL,
	indirizzo VARCHAR(20) NOT NULL,

PRIMARY KEY(codiceProprietario))

CREATE TABLE Veicolo (

	codiceVeicolo SMALLINT NOT NULL,
	numeroTarga VARCHAR(20) NOT NULL,
	nome VARCHAR(20) NOT NULL,
	modello VARCHAR(20) NOT NULL,
	marca VARCHAR(20) NOT NULL,
	cilindrata VARCHAR(20) NOT NULL,
	tipoMotore VARCHAR(20) NOT NULL,
	codiceProprietario SMALLINT NOT NULL,

PRIMARY KEY(codiceVeicolo),
FOREIGN KEY(codiceProprietario) REFERENCES Proprietario(codiceProprietario))

CREATE TABLE Tecnico (

	codiceTecnico SMALLINT NOT NULL,
	nome VARCHAR(20) NOT NULL,
	cognome VARCHAR(20) NOT NULL,
	codiceFiscale CHAR(16) NOT NULL,
	indirizzo VARCHAR(20) NOT NULL,

PRIMARY KEY(codiceTecnico))

CREATE TABLE Ripara (
    codiceTecnico SMALLINT NOT NULL,
    codiceVeicolo SMALLINT NOT NULL,

FOREIGN KEY(codiceTecnico) REFERENCES Tecnico(codiceTecnico),
FOREIGN KEY(codiceVeicolo) REFERENCES Veicolo(codiceVeicolo))

CREATE TABLE Tipologia (

	codiceTipologia SMALLINT NOT NULL,
	nome VARCHAR(20) NOT NULL,
	tariffaOraria SMALLINT NOT NULL,
    codiceVeicolo SMALLINT NOT NULL,

PRIMARY KEY(codiceTipologia),
FOREIGN KEY(codiceVeicolo) REFERENCES Veicolo(codiceVeicolo))

CREATE TABLE Manutenzione (

	codiceManutenzione SMALLINT NOT NULL,
	tipo VARCHAR(20) NOT NULL,

PRIMARY KEY(codiceManutenzione))

CREATE TABLE Effettua (

	codiceTecnico SMALLINT NOT NULL,
	codiceManutenzione SMALLINT NOT NULL,

FOREIGN KEY(codiceTecnico) REFERENCES Tecnico(codiceTecnico),
FOREIGN KEY(codiceManutenzione) REFERENCES Manutenzione(codiceManutenzione))

CREATE TABLE PezzoRicambio (

	codicePezzoRicambio SMALLINT NOT NULL,
	nome VARCHAR(20) NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	quantità SMALLINT NOT NULL,
	descrizione VARCHAR(20) NOT NULL,
	codiceManutenzione SMALLINT NOT NULL,

PRIMARY KEY(codicePezzoRicambio),
FOREIGN KEY(codiceManutenzione) REFERENCES Manutenzione(codiceManutenzione))