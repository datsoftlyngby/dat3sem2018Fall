# Rapportskrivning
Det er meningen at du efter denne uge skal kunne skrive en rapport om dit program.
Formålet med rapporten er at sætte en anden software udvikler til hurtigt og præcist at sætte sig ind i dit program sådan at vedkommende kan fejlrette, udvide og ændre med størst mulig sikkerhed.

### Læringsmål
Efter denne uge forventes du at:

* kunne beskrive navigationen mellem web-siderne i dit system ved hjælp af et ***state-diagram***.
* kunne beskrive dit system ved hjælp af et ***aktivitetsdiagram*** med swim-lanes som viser hvordan bruger og system arbejder sammen/interagerer.
* kunne beskrive hvilke dele af programmet der bliver kaldt når en bruger laver input på en specifik side ved hjælp af et ***sekvensdiagram***
* kan redegøre for hvilke dele af systemet der er *implementeret* i modsætning til dem der er *planlagt*.
* kan redegøre for hvordan ikke implementerede elementer skal laves (hvilke klasser, metoder, database tabeller, jsp sider og servlets mangler)
* kunne beskrive hvilken brugerinputs validering der foretages (eller burde være)
* kan bruge javadoc på klasser og metoder

### Erhvervskompetencer
Når man arbejder professionelt kommer man til at skifte projekt. Man kommer derfor til at overtage andres kode, og man kommer til at videregive sin kode til andre. Det er derfor vigtigt at du kan dokumentere din kode internt vha javadoc, at beskrive nuværende implementationsstatus, og at du kender til de standarder der er for dokumentation af software (diagrammer).

## Prøveeksamen
### [For at øve eksamensituationen skal I aflevere på moodle](https://cphbusiness.mrooms.net/mod/assign/view.php?id=44792):

* Have jeres kildetekst på github, så I kan give et link til jeres kode, så det er nemt at klone.
* Have jeres løsning deployed på digital ocean sådan at i kan give et link til jeres program så man kan prøvekøre det.
* Uploade en rapport over jeres program (rapporten skal ligge på github som pdf, men link til github skal afleveres på moodle)

Efter efterårsferien vil vi holde prøve eksamen. Det bliver gruppevis, og vi har 45 min per gruppe. Det forventes at I som gruppe fremlægger i godt 10 min (inkl. kort demo), og så er der gruppe eksamen hvor vi snakker om kode og rapport. Der vil blive givet en vejl. karakter.

## Ugeplan

Dag | Emne
---|---
Mandag | Klasseundervisning
Tirsdag | Vejledning med tutorer
Onsdag | Selvstændigt arbejde og review at navigationsdiagram, aktivitetsdiagram samt sekvensdiagram.
Torsdag | Vejledning med tutorer
Fredag | Selvstændigt arbejde og review javadoc samt status.
Søndag | Afleveringsfrist kl. 23:59 for prøveeksamen.


### Materiale til ugen
* [UML at Tutorialspoint](https://www.tutorialspoint.com/uml/). Der er både en oversigts beskrivelse af formålet med UML, og en kort forklaring på hver type af diagram.
* [Diagrammer med PlantUML](Diagrammer.md)
* [Javadoc](javadoc.md), and [Javadoc in Netbeans](javadocNetbeans.md)
* [Skabelon for en rapport](RapportSkabelon.md)
* [Slides](Slides.pptx)

### Review til onsdag
Til onsdags review skal I have færdiggjort følgende diagrammer over jeres løsning til cup-cake:

* ER diagram over hvilke tabeller der er i databasen. Det centrale er hvilke tabeller der er, og hvilke relationer der er mellem disse tabeller samt hvordan de er lavet med fremmednøgler.
* Et navigationsdiagram over hvilke sider I har lavet (eller planlagde at lave), og hvordan man som bruger kommer fra den ene side til den næste
* Et sekvensdiagram der starter med at en bruger har valgt en cup-cake, og nu vil købe den.

Desuden skal der vises en skabelon for rapporten der er bygget over standard-skabelonen.

### Review til fredag

### Grøn, Gul & Rød
Der vil være forskel på hvor langt i er nået med koden afhængigt af om man er en grøn, gul, eller rød gruppe. Det betyder at der jo den vej vil være forskel i hvor store dele af systemet der er beskrevet som "ikke implementeret men planlagt".

Mht. rapporten, så er forventningerne som:

Niveau | Beskrivelse
---|---
Grøn | Det forventes at der afleveres en rapport der beskriver systemet, og at der er forklaret diagram af hver slags. Det forventes at det er beskrevet hvilke dele der er implementeret.
Gul | Det forventes at der er lavet javadoc for alle klasserne der er brugt i et af de afleverede sekvens diagrammer.
Rød | Det forventes at javadoc er lagt på github.


