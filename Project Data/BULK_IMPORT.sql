-- drop all the tables first
SET TERMOUT OFF;

DROP TABLE RDIMDAN;
DROP TABLE RDIMMOD;
DROP TABLE RDIMARS;
DROP TABLE APLOLD;
DROP TABLE APLGMC;
DROP TABLE APLFOR;
DROP TABLE APLTOY;
DROP TABLE APLSAB;
DROP TABLE APLSUB;
DROP TABLE APLVOL;
DROP TABLE APLBUK;
DROP TABLE APLMZD;
DROP TABLE APLCAD;
DROP TABLE APLUPS;
DROP TABLE APLCRY;
DROP TABLE APLINT;
DROP TABLE APLISU;
DROP TABLE APLLIN;
DROP TABLE APLREN;
DROP TABLE APLFDT;
DROP TABLE APLPOR;
DROP TABLE RDIMBEH;
DROP TABLE APLCHE;
DROP TABLE RADCRX;

SET TERMOUT ON;
PROMPT All tables dropped.;

-- now do the bulk import, roll back any transactions on error
SET FEEDBACK OFF;

WHENEVER SQLERROR CONTINUE ROLLBACK;

SET DEFINE OFF;
PROMPT Importing data now... (may be awhile).

PROMPT Importing from "RADCRX.sql";
@"RADCRX.sql";
PROMPT Importing from "RDIMDAN.sql";
@"RDIMDAN.sql";
PROMPT Importing from "RDIMMOD.sql";
@"RDIMMOD.sql";
PROMPT Importing from "RDIMARS.sql";
@"RDIMARS.sql";
PROMPT Importing from "APLOLD.sql";
@"APLOLD.sql";
PROMPT Importing from "APLGMC.sql";
@"APLGMC.sql";
PROMPT Importing from "APLFOR.sql";
@"APLFOR.sql";
PROMPT Importing from "APLTOY.sql";
@"APLTOY.sql";
PROMPT Importing from "APLSAB.sql";
@"APLSAB.sql";
PROMPT Importing from "APLSUB.sql";
@"APLSUB.sql";
PROMPT Importing from "APLVOL.sql";
@"APLVOL.sql";
PROMPT Importing from "APLBUK.sql";
@"APLBUK.sql";
PROMPT Importing from "APLMZD.sql";
@"APLMZD.sql";
PROMPT Importing from "APLCAD.sql";
@"APLCAD.sql";
PROMPT Importing from "APLUPS.sql";
@"APLUPS.sql";
PROMPT Importing from "APLCRY.sql";
@"APLCRY.sql";
PROMPT Importing from "APLINT.sql";
@"APLINT.sql";
PROMPT Importing from "APLISU.sql";
@"APLISU.sql";
PROMPT Importing from "APLLIN.sql";
@"APLLIN.sql";
PROMPT Importing from "APLREN.sql";
@"APLREN.sql";
PROMPT Importing from "APLFDT.sql";
@"APLFDT.sql";
PROMPT Importing from "APLPOR.sql";
@"APLPOR.sql";
PROMPT Importing from "RDIMBEH.sql";
@"RDIMBEH.sql";
PROMPT Importing from "APLCHE.sql";
@"APLCHE.sql";


SET DEFINE ON;

PROMPT Finished;
