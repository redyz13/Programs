-- Crea Database
CREATE DATABASE nome
-- Elimina Database
DROP DATABASE nome

-- Crea tabella
CREATE TABLE nome (
    
)

-- Aggiungi attributo
ALTER TABLE nome(
    add nome
)

-- Rimuovi attributo
ALTER TABLE nome(
    drop nome
)

-- Modifica attributo
ALTER TABLE nome(
    change nome nuovoNome nuovoTipo
)

-- Crea indice
CREATE UNIQUE INDEX nomeIndice
ON nomeTabella(nomecolonna1, nomecolonna2, ecc)

-- Elimina tabella
DROP TABLE nomeTabella

-- Elimina indice
DROP INDEX nomeIndice ON nomeTabella

-- Inserisci record
INSERT INTO nomeTabella
VALUES(valore1, valore2, ecc)

--
INSERT INTO nomeTabella
(nomecampo1, nomecampo2) VALUES (valore1, valore2)

-- Aggiorna valori tabella
UPDATE nomeTabella
SET attributo = espressione
{WHERE condizione}

--
UPDATE Giocatori
SET indirizzo = "Via Milano 20"
WHERE Cognome = "Rossi"

--
UPDATE Giocatori
SET Punti = Punti + 1

--
DELETE
FROM Giocatori
WHERE Cognome = "Rossi"

-- Select
SELECT attributo
FROM nomeTabella
{WHERE condizione}
{GROUP BY [nome-colonna]...}
{HAVING condizione}
{ORDER BY [attributo]...}

--
SELECT Cognome, Indirizzo
FROM Giocatori

--
SELECT *
FROM Giocatori

--
SELECT Cognome, Indirizzo
FROM Giocatori
WHERE Sesso = "M"