# Standard skabelon for rapport (cupcake)
Dokumentation af software kan tage mange former og varierer fra den ene udvikler virksomhed til den anden.

Denne skabelon er lavet for at vise hvordan en sådan rapport *kan* se ud.

<hr>
## Forside
Det er almindeligt at der på forsiden er følgende informationer

* En titel  *Ofte er det navnet på omgaven - cupcake. Student projekter har ofte en skør titel som "Kagekaj slår til igen". En af jeres opgaver i løbet af studiet er at lære at lade jeres pjat ligge hjemme og opføre jer professionelt*
* Deltagere *Navn og cph-email på alle deltagere*
* Tidspunkt *Hvornår blev projektet og rapporten lavet - husk årstal*

## Indledning
Kort intro til hvad dette projekt omhandler. Formålet med indledning er at sætte en fagfælle i stand til at forstå resten af rapporten. For jer som studerende er en "fagfælle" en anden datamatiker studerende på 2. semester der er på samme niveau, men som ikke kender cup-cake opgaven. 

### Baggrund
Det typiske der skal med for at forklare projektet er:

* En kort beskrivelse af den virksomhed som skal bruge systemet
* Hvilke krav kunden har til systemet forklaret i brede termer, f.eks. "*kunden skal kunne bestille en cupcake hvor man kan vælge både bund og top.*" i modsætning til "*der skal være en drop down menu med scrollbar i højre side med en liste over hvilke bunde der er og hvad de koster*". 

### Teknologi valg
En kort beskrivelse af hvilke teknologier der er brugt (jdbc, mysql, ...). Her er det *ikke* meningen at I skal beskrive disse teknologier, men man skal sige hvilke der er brugt sådan at den der skal overtage projektet ved hvilken software der skal bruges. Der skal versions numre på (Netbeans 8.2, ikke blot "Netbeans").

## Krav
Dette afsnit vender vi tilbage til senere i semesteret. Der er to dele i dette afsnit:

* hvad er firmaets håb med dette system (hvad er deres vision for systemet eller hvilken værdi er det jeres system skal tilføre deres virksomhed).
* scrum userstories (product backlog). Dette vender vi tilbage til efter efterårferien.


## Domæne model og ER diagram
Det interesante ved denne domæne og database er at den langt hen af vejen er grundlaget for resten at systemet. Tabeller og relationer siger noget om *hvad* systemet arbejder med, ikke *hvordan*. Så det er godt sted at starte.

Som led i beskrivelsen af Domæne eller ER diagram skal man have følgende med:

* Diagram over hele modellen.  Det er vigtigt at få plads til alle tabeller og alle relationer. *Det kan så betyde at man ikke kan få plads til alle attributter på de enkelte tabeller. Dem kan man slå op i databasen, så det er ikke så vigtigt*
* Hvis nogle af tabellerne ikke er på 3. normal form vil det være almindeligt at nævne det, og forklare hvorfor det er gjort (tidspres eller anden overvejelse).
* Hvis der anvendes 1-1 relationer kan man beskrive hvorfor man ikke blot har en tabel.
* Hvis nogle tabeller implementerer en mange-mange relation vil det være normalt at beskrive det.
* Hvis der er flere veje at nå fra et sted til et andet vil det nemt gøre det svært at holde databasen konsistent. Hvis I har gjort det alligevel så skal I forklare hvorfor.
* Hvis der er tabeller hvor man benytter andet end et automatisk generetet ID som nøgle skal man forklare det.

Der er interessant at beskrive hvilke overvejelser der ligger til grund for de konkrete valg der er i ER modellen (fremmednøgler, constraints, triggers, osv)

## Navigationsdiagram
Det som brugeren oplever er en række websider hvor man kan indtaste oplysninger gå videre til andre sider. I større systemer kan det være svært at bevare overblikket over hvilke sider der er, og hvordan man kommer fra den ene til den anden. Navigationsdiagrammet er beregnet på at vise dette på en mere overskuelig måde. Som led i beskrivelsen af navigationsdiagrammet skal følgende med:

* Oversigts diagrammet. Hvis det bliver for stort må man dele det op. Men det er vigtigt at der er et overordnet diagram.
* Hvis man har benyttet sig af en "fælles navigations bar" i toppen af alle sider skal man forklare det.
* Hvis nogle sider kun kan nåes af nogle brugere (dem der har konto, dem der er logget ind, dem der arbejder i butikken,...), så skal det fremgå.
* Navne på jsp sider skal fremgå, og hvilke servlet der bringer en fra den ene side til den næste.

## Sekvens diagrammer
De fleste programmører kan læse de enkelte metoder i et program, mens det kan være svært at skabe sig et overblik over hvordan programmet virker på overordnet plan. Et sekvens diagram bruges til at vise hvordan et typisk forløb foregår, eller til at vise et særligt svært særtilfælde. *Man kan aldrig dokumentere hele programmet med sekvensdiagrammer, man vælger altid nogle interessante eksempler*.

Et eksempel på et typisk forløb kunne være at brugeren præsenteres for indkøbssiden. Her skal der vises følgende:

* Selve diagrammet, startende med jsp-siden eller servlet.
* Brug de rigtige klassenavne og metode navne
* Undlad argumenter til metoderne

I forklaringen til diagrammet skal du særligt lægge vægt at beskrive hvilke grene af if-sætninger der er brugt i de enkelte metoder. 

## Særlige forhold
Dette afsnit bruges til at beskrive særlige forhold der benyttes i programmet. Det kan f.eks. være:

* Hvilke informationer gemmes i session
* Hvordan håndterer man exceptions. Det kommer vi tilbage til senere i semesteret.
* Hvordan man på har valgt at lave brugerindput validering
* Hvordan man har valgt at lave sikkerhed i forbindelse med login
* Hvilke brugertyper der er valgt i databasen, og hvodan de er brugt i jdbc
* ... andre elementer

Husk: det er bedre med 2 linjers dokumentation end ingen.

## Status på implementation
Dette afsnit skal liste hvor langt man er nået med implementationen. Typiske ting man kan have sprunget over er:

* Man har ikke nået at lave alle de jsp sider man har med i navigationsdiagrammet.
* Man har ikke nået at lave alle CRUD metoderne til alle tabellerne
* Man har ikke fået stylet sine sider
* Man har fundet en fejl "i sidste øjeblik", men har ikke haft tid til at rette det. - F.eks. at man har brugt session forkert sådan at man på en af siderne kan komme ind uden at være logget in.
* tests der fejler på afleveringstidspunkt
* ... andre mangler

## Test
Der skal være lavet test. Vi har ikke i dette projekt haft fokus på at teste, så det skal ikke med. Du skal dokumentere tests ved at beskrive i tabel form:

* Hvilke klasser er testet
* Hvilke metoder der er testet
* Dækningsgrad af dine tests for de falgte metoder og klasser
