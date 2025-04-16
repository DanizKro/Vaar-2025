SET search_path  to oblig4;
SELECT*FROM kunde
SELECT*FROM ansatt

-- a)
CREATE TABLE KUNDE_NY(
	knr INTEGER PRIMARY KEY,
	kunde_xml XML

);

-- c)
-- Migrerer data fra KUNDE tabellen til KUNDE_NY tabellen.
INSERT INTO KUNDE_NY(knr,kunde_xml)
SELECT
  knr,xmlelement(
	NAME kunde,
	xmlforest(
		fornavn AS fornavn,
		etternavn AS etternavn,
		adresse AS adresse,
		postnr AS postnr
	)
  ) AS kunde_xml
  FROM KUNDE;

-- d)
-- Sjekker om det nå finnes en kunde_ny tabell som ble opprettet over
SELECT * FROM kunde_ny;

-- e)
-- Skriv en spørring som benytter XPATH funksjonen (og eventuelt andre funksjoner), og som
-- henter ut data om alle kunder fra KUNDE_NY
SET search_path TO oblig4;
SELECT 
	knr, --Velger hvilke kolonne vi skal hente ut fra
	(xpath('//fornavn/text()', kunde_xml))[1]::text AS fornavn,
	(xpath('//etternavn/text()', kunde_xml))[1]::text AS etternavn,
	(xpath('//adresse/text()',kunde_xml))[1]::text AS adresse,
	(xpath('//postnr/text()',kunde_xml))[1]::text AS postnr
FROM KUNDE_NY; -- fra hvilke tabell

SET search_path = oblig4;

-- f)
-- Skriv en spørring som henter ut kunder med etternavn som starter på «A» fra KUNDE_NY 
SELECT 
	knr,
	(xpath('//etternavn/text()', kunde_xml))[1]::text AS navn,
	(xpath('//adresse/text()',kunde_xml))[1]::text AS adresse,
	(xpath('//postnr/text()',kunde_xml))[1]::text AS postnr
FROM KUNDE_NY
WHERE (xpath('//etternavn/text()', kunde_xml))[1]::text like 'A%' -- A% betyr A + resten spiller ingen rolle
ORDER BY (xpath('//etternavn/text()', kunde_xml))[1]::text; -- Får de i rekkefølge

-- g)
SET search_path TO oblig4;
DROP TABLE IF EXISTS ORDRE_NY;
CREATE TABLE ORDRE_NY(
ordrenr INTEGER PRIMARY KEY,
kundenr INTEGER,
ordre_xml xml,
CONSTRAINT knr_fk FOREIGN KEY (kundenr) REFERENCES kunde_ny(knr)
);

-- h) TEST om den finnes
SELECT*FROM ORDRE_NY;

-- i)
-- Skriv en INSERT spørring som migrerer data fra ORDRE tabellen til ORDRE_NY tabellen.
SET search_path TO oblig4;
INSERT INTO ORDRE_NY (ordrenr, kundenr, ordre_xml) -- Kolonner i ORDRE_NY tabellen
SELECT ordrenr, knr, xmlelement(					-- Migrerer 'Ordrenr' og 'kundenr' fra ORDRE_NY-tabellen med 'ordrenr' og 'knr' fra Ordre-tabellen
NAME ordre, xmlforest(								-- deretter alle XML-elementene i tillegg med alle atributter
ordrenr AS ordrenr,
ordredato AS ordredato,
sendtdato AS sendtdato,
betaltdato AS betaltdato,
knr AS knr
)
) AS ordre_xml FROM ordre;

-- j) TEST
SELECT*FROM ORDRE_NY; 

-- k)
SET search_path TO oblig4;
INSERT INTO ordre_ny(ordrenr, kundenr, ordre_xml)
SELECT o.ordrenr, o.knr, xmlelement(NAME orde, xmlforest( -- o = ordre
o.ordredato AS ordredato,
o.sendtdato AS sendtdato,
o.betaltdato AS betaltdato
), 
XMLAGG(xmlelement(NAME ordrelinje, xmlforest(
ol.ordrenr AS ordrenr,	-- ol = ordrelinje
ol.vnr AS vnr,
ol.prisprenhet AS prisprenhet,
ol.antall AS antall)
)
)
)AS ordre_xml
FROM ORDRE o LEFT JOIN ORDRELINJE ol ON o.ORDRENR = ol.ORDRENR
GROUP BY o.ordrenr,o.knr, o.ordredato, o.sendtdato, o.betaltdato;

-- l)
DELETE FROM ORDRE_NY; 
-- Siden ingen kolonner er valgt etter FROM (Normalt sett inkluderer navn på kolonne som skal slettes)
-- slettes derfor ALL dataen i ALL kolonner. Må gjøre dette fordi vi får dobbel PK fra oppgave i.

-- Kjør koden fra oppgave k) igjen
-- TESTER om ordre_ny inneholder ny data:
SELECT * FROM ordre_ny
ORDER BY ordrenr ASC;

-- m)

--Skriv en spørring som henter ut data fra ORDRE_NY tabellen. Spørringen skal hente alle ordre for
--kunde nummer (knr) 5643 som ble sendt («sendtdato») i august 2019 («2019-08»). Spørringen
--skal hente ut «ordrenr», «knr», «prisprenhet» og «antall» som vist under:

SET search_path TO oblig4;
SELECT ordrenr, kundenr,
(xpath('//prisprenhet/text()',ordre_xml))[1]::text AS prisprenhet,
(xpath('//antall/text()', ordre_xml))[1]::text AS antall,
(xpath('//sendtdato/text()',ordre_xml))[1]::text AS sendtdato
FROM ordre_ny WHERE kundenr = '5643' 
AND (xpath('//sendtdato/text()', ordre_xml))[1]::text LIKE '2019-08%';

-- (xpath('//antall/text()', HVOR LIGGER DATAEN))[1]::DATATYPEN as antall,







