# Diagrammer på 2. semester
Der er mange værktøj til at tegne diagrammer. Denne note vil kort beskrive et af disse - et som egner sig godt til brug på git og github.

Dog er det sådan at der i MySQLWorkbench er et udemærket værktøj til at tegne ER diagrammer, så det vil jeg anbefale at man bruger.

## PlantUML

Git kan godt lide tekstfiler, og plantuml er en tekst syntaks til at beskrive UML diagrammer. Det har et automatiseret layout som gør at man ikke skal bruge tid på layout af diagrammer (og bare må acceptere når der laves dårlig layout).

PlantUML kan bruges til at lave:

* Domæne modeller (klasse diagrammer)
* Aktivitetsdiagrammer 
* Sekvens diagrammer
* State charts (vi bruger dem til at beskrive navigation med)

Der er to resourcer der nyttige til disse værktøj:

* [PlantUMLs hjemmeside](http://plantuml.com). Denne er noget rodet, men der er eksempler på alle UML diagrammer og hvordan man laver dem.
* [Planttext](https://www.planttext.com) som er en simpel side hvor man kan skrive sine diagrammer i browseren så man kan se hvordan diagrammet kommer til at se ud.

## Statecharts / navigations diagrammer
Vi skal kunne vise diagrammer der viser hvordan man kommer fra den ene side til den næste. Et eksempel kunne være dette:

![](img/NavigateLogin.png)

Dette diagram viser at brugeren starter på Login.jsp siden. Den fyldte sorte klat er der hvor man starter. Den knap så fyldte klat på diagrammet under "LoggedIn" betyder at diagrammet er slut her.

Så måden dette diagram skal læses er at brugeren starter på Login.jsp. Der kan man indtaste brugernavn og password (det står ikke i diagrammet - diagrammer skal ikke vise det hele). Hvis brugernavn og password ikke passer skal man prøve igen, ellers "kommer man videre i systemet".

Diagrammet er lavet i [planttekst](https://www.planttext.com) med denne tekst

```plantuml
@startuml

Title Logging in
State Login.jsp
State "Error Login.jsp" as error
State LoggedIn

note right of LoggedIn
Username and role
stored in session
end note

[*] -> Login.jsp
Login.jsp --> LoggedIn : user and pw OK
error --> Login.jsp : try-again
Login.jsp --> error : user or pw not OK
LoggedIn --> [*]

@enduml
```

Der er mange andre muligheder i forbindelse med Statecharts. De fleste vil man ikke have brug for til at lave navigationsdiagrammer. Mulighederne er vist på [plantuml siden for state charts](http://plantuml.com/state-diagram).

## Sequence diagrams
Ideen i et sekvens diagram er at man kan følge hvordan et bruger-input forplanter sig ned igennem systemet. Et eksempel kan være at vi prøver at lave et sekvens diagram for login. Det kan se sådan ud:

![](img/SequenceLogin.png)

Til højre har vi en bruger der skriver bruger navn og password ind på JSP siden Login. Disse sendes så i en http post til LoginServlet der spørger UserTableManager som igen spørger databasen om brugernavn og password passer sammen.

Databasen returnerer et resultset, som så checkes. Vi antager det gik godt, hvilket returneres til servlet som forwarder til CustomerHomePage der vises til brugeren.

Den tekst der tegner diagrammet er dette:

```
@startuml

title "Login - Sequence Diagram"

actor User
boundary Login.jsp
boundary CustHomePage.jsp
participant LoginServlet
participant UserTableManager
database ShopDatabase

User -> Login.jsp : username & password
Login.jsp -> LoginServlet: http POST login
LoginServlet -> UserTableManager: validate()
UserTableManager -> ShopDatabase: executeQuery()
ShopDatabase -> UserTableManager: resultset
UserTableManager -> UserTableManager: validate resultset
UserTableManager -> LoginServlet: OK
LoginServlet -> CustHomePage.jsp: forward
CustHomePage.jsp -> User: Welcome

@enduml
```

# PlantUML i Netbeans
Hvis man virkelig vil kaste sig over at bruge PlantUML så kan man bruge et plugin i Netbeans. Det skal ses som alternativ til at bruge [planttext](https://www.planttext.com).

1. In the `Tools` menu, select `Plugins` (at the end of the menu).
2. You are presented with a dialog box with several tabs. Select `Available Plugins` and locate `PlantUML`.
3. Follow the instructions from there. Netbeans will need to restart.

Nu bør du så være istand til at arbejde med plant UML is netbeans direkte.

