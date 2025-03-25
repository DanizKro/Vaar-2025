-- Mange-til-en-til-mange-eksempel forelesning F5

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS bedrift_oblig3;
CREATE SCHEMA bedrift_oblig3;
SET search_path TO bedrift_oblig3;

CREATE TABLE Avdeling
(
	avdelings_id   SERIAL PRIMARY KEY,
	navn	   	   VARCHAR(30) NOT NULL,
	ansatt_sjef	   INT  -- Fjerner midlertidig NOT NULL for å håndtere sirkulær avhengihet
);

CREATE TABLE Ansatt
(
  ansatt_id	 		 SERIAL PRIMARY KEY,
  brukernavn 		 VARCHAR(4) NOT NULL,
  fornavn	 		 VARCHAR(30) NOT NULL,
  etternavn  		 VARCHAR(30) NOT NULL,
  datoForAnsettelse  DATE NOT NULL,
  stilling	 		 VARCHAR(20) NOT NULL,
  maanedslonn 		 DECIMAL NOT NULL,  -- mer nøyaktig enn INT for beregning av lønn
  avdelings_id 		 INTEGER NOT NULL,
  CONSTRAINT fk_avdelings_id FOREIGN KEY (avdelings_id) REFERENCES Avdeling(avdelings_id)
  
);

--Legger til en fiktiv ansatt og avdeling slik at vi deretter kan putte på CONSTRAINTS NOT NULL på ansatt_sjef og koble relasjoner
INSERT INTO Avdeling (navn, ansatt_sjef)
VALUES ('Start-avdeling', null);

INSERT INTO Ansatt (brukernavn, fornavn, etternavn, datoForAnsettelse,stilling, maanedslonn, avdelings_id)
VALUES ('Sjef','ikke registrert','ikke registrert','2024-02-01','ikke registrert',100, 1);
-- Oppdatere avdeling med en ansatt sjef
UPDATE Avdeling SET ansatt_sjef = 1 WHERE Avdelings_id = 1;

-- Nå kan vi oppdatere Avdeling sjef-ID
-- Nå kan vi sette NOT NULL og fremmednøkkel for ansatt_sjef
ALTER TABLE Avdeling
ALTER COLUMN ansatt_sjef SET NOT NULL,
ADD CONSTRAINT fk_ansatt_sjef FOREIGN KEY (ansatt_sjef) REFERENCES Ansatt(ansatt_id)ON DELETE RESTRICT;

CREATE TABLE Prosjekt
(
	prosjekt_id		SERIAL PRIMARY KEY,
	navn			VARCHAR(30) NOT NULL,
	beskrivelse 	TEXT,
	CONSTRAINT unikt_prosjektnavn UNIQUE (navn) -- Må ha unikt prosjekt navn
	
);

CREATE TABLE Ansatt_prosjekt
(
	ansatt_id		INT NOT NULL,
	prosjekt_id  	INT NOT NULL,
	antall_jobbtimer 	INT NOT NULL,
	aktiv			BOOLEAN,
	rolle			VARCHAR(30) NOT NULL,
	PRIMARY KEY (ansatt_id, prosjekt_id), --Kombinert PK
	CONSTRAINT fk_ansatt FOREIGN KEY (ansatt_id) REFERENCES Ansatt(ansatt_id) ON DELETE RESTRICT,
    CONSTRAINT fk_prosjekt FOREIGN KEY (prosjekt_id) REFERENCES Prosjekt(prosjekt_id) ON DELETE RESTRICT
);

-- ####################################################################################
-- TEST DATA
INSERT INTO Ansatt (brukernavn, fornavn, etternavn, datoForAnsettelse,stilling, maanedslonn, avdelings_id)
VALUES
	('cstr','christopher','strandheim','2024-02-01','Utvikler',50000,1),
	('dkro','daniel','kronheim','2024-02-01','Personlig Trener',60000,1);
	
INSERT INTO Avdeling (navn, ansatt_sjef)
VALUES ('IT-avdelingen', 2);
VALUES ('PT-avdelingen',3);


INSERT INTO Prosjekt (navn, beskrivelse)
VALUES
    ('Webutvikling', 'Utvikling av ny webapplikasjon for intern kommunikasjon.');


INSERT INTO Ansatt_Prosjekt(ansatt_id, prosjekt_id, rolle, antall_jobbtimer)
VALUES
	(1,1,'Prosjektleder',120);
	
	
	-- ####################################################################################
	-- Spørringer:
	-- Setter sammen Avdeling og hvem som er sjef der	
	
/*	SELECT 
    a.avdelings_id,
    a.navn AS avdelingsnavn,
    ans.ansatt_id AS sjef_id,
    ans.brukernavn AS sjef_initialer,
    ans.fornavn AS sjef_fornavn,
    ans.etternavn AS sjef_etternavn,
    ans.stilling AS sjef_stilling,
    ans.maanedslonn AS sjef_lønn
FROM 
    Avdeling a
INNER JOIN 
    Ansatt ans ON a.ansatt_sjef = ans.ansatt_id;

SELECT * FROM Ansatt;

	-- Sletter en avdeling:
	DELETE FROM Avdeling WHERE avdelins_id = [avdelings-id];
	
	--Oppdatere en kolonne i en tabell:
	UPDATE ansatt SET stilling = 'ikke registrert' WHERE stilling = 'Utvikler'
	
	--Oppdatere en spesifik ansatt:
	UPDATE ansatt SET fornavn = 'chris' WHERE ansatt_id = 2;
	
	
	






















