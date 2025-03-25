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
  CONSTRAINT fk_avdelings_id FOREIGN KEY (avdelings_id) REFERENCES Avdeling(avdelings_id) DEFERRABLE INITIALLY DEFERRED
  
);

-- Nå kan vi oppdatere Avdeling for å legge til sjef-referansen
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
	('dkro','daniel','kronheim','2024-02-01','Personlig Trener',60000,2);
	
INSERT INTO Avdeling (navn, ansatt_sjef)
VALUES ('IT-avdelingen', 1);
VALUES ('PT-avdelingen',2);


INSERT INTO Prosjekt (navn, beskrivelse)
VALUES
    ('Webutvikling', 'Utvikling av ny webapplikasjon for intern kommunikasjon.');


INSERT INTO Ansatt_Prosjekt(ansatt_id, prosjekt_id, rolle, antall_jobbtimer)
VALUES
	(1,1,'Prosjektleder',120);

SELECT * FROM Ansatt;