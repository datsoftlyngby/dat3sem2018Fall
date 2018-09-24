# Tråde
### Læringsmål
Efter denne uge er det målet at du:

* Kan starte, stoppe og afbryde tråde i Java.
* Kan give konkrete eksempler i Java på problemer der kan opstå når der er flere samtidige tråde.
* Kan dele en opgave op i mindre dele som kan håndteres af "worker threads".
* Kan bruge en worker thread til at håndtere http forespørgsler.

### Erhvervsrelevans
De fleste moderne systemer har behov for at kunne reagere hurtigt på bruger input eller kunne håndtere mange forespørgsler til en server. Cluet i dette er at kunne uddelegere det tunge arbejde til andre processer sådan at den process der tager sig af at modtage input kan være klar hele tiden. Tråde er en central problemstilling i de fleste realistiske programmer.

## Resourcer
* [Note om tråde](NoteOnThreads.md)
* [Link til github](https://github.com/Dat2SemCPH/Modul1Threads)
* [Slides fra mandag (Kommer senere mandag)](Week2Threads.pptx)


## Opgaver til onsdag
Alle opgaverne skal benytte sig af Executors og ikke kodes med tråde direkte.

1. (grøn) Skriv et program hvor Main tråden laver en række tasks til en ExecutorService (du kan f.eks. tage udgangspunkt i `Executor03`). Den første taks skal skrive `AAA`, den næste `BBB`,`CCC` osv. op til `ZZZ` (ialt er der vist 25 tegn). Der skal være 4 worker threads i executor servicen.

2. (grøn) Læs op på begrebet 'synchronized' (f.eks. denne side "http://tutorials.jenkov.com/java-concurrency/synchronized.html"). Ret `Executor05`sådan at linjerne:
	
	```java
int myH = hundred;  
Thread.sleep( sleepTime ); // simulate some external job taking time  
myH += 100;  
hundred = myH;    
```  
bliver sikret mod fejlopdatering.   
Der skal bruges det der kaldes "[Synchronized Blocks in Static Methods](http://tutorials.jenkov.com/java-concurrency/synchronized.html#synchronized-blocks-static-methods)". Til review vil der blive spurgt grundigt ind til forståelsen af jeres løsning.
3. (gul) Eksempel `Executor06` indsætter heltal i en array liste, og hver opgave skriver ud hvor mange elementer der er indsat. Bemærk - nogle gange vil der ikke blive sat 100 elementer ind i listen.
  * til review - forklar hvordan det kan ske
  * foreslå en løsning
  * (rød)foreslå en løsning der ikke benytter sig af `synchronized`.  
4. (gul/rød). De fleste operativ systemer har et program der viser performance af systemet (windows: taskmanager, mac: activity monitor, linux: System Monitor).
Lav en variation af et af Executor programmerne der sætter alle dine cores i sving og vis os det til review.  
5. (rød - meget vanskelig, det er en hæftig opgave om forståelse af Java). Der er en syntaks fejl i `Executor02`. Hvad er den, hvorfor har vi den, og hvad skal der til for at løse den?  
     * Læse denne lille [artikel](http://www.lambdafaq.org/what-are-the-reasons-for-the-restriction-to-effective-immutability/)  
6. (ekstra) Kig på denne liste af spørgsmål for generel viden om tråde. Der er nye områder her, som man kan undersøge på egen hånd hvis man har tid og overskud:-)  
     * [Interview spørgsmål om java tråde](http://www.javainterview.in/p/java-synchronization-interview-questions.html)  


## Opgaver til fredag
Opgaverne til fredag er at få omprogrammeret vores webserver fra sidste uge så den bliver mere responsiv (bliver hurtigere klar til næste request).


1. (grøn) Med udgangspunkt i picoServer05 laver vi små ændringer for at køre hvert server response ud i en ny tråd. Du skal bruge en ExecutorService som du indsætter lige før while loopet (den jeg kalder `workingJack` i eksemplerne). Efter while loopet kommer `Socket socket = server.accept();` som jo er et blokerende kald, der afventer et nyt request fra en klient/browser. 
  
    Herefter tager vi al koden fra try-catch blokken og flytter dette over i en selvstændig metode (HINT: I netbeans markeres al koden -> højreklik -> refactor -> introduce -> method -> giv metoden et navn - nedefor har vi kaldt den `MakeResponse`). Nu har vi kun et enkelt metode kald under linjen der opretter en socket. Denne linje kan nu indsættes i en run metode inde i en anonym implementation af interfacet: Runnable ala dette:

```java
...
Socket socket = server.accept();
workingJack.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        MakeResponse(socket, root);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            });

```

    På denne måde vil alle response der skal laves af serveren blive lagt ud i en anden tråd, så hovedtråden hurtigst muligt bliver klar til igen at vente på et nyt request fra en browser.  

2. (gul) I opgave 1 tog vi udgangspunkt i `picoServer05` der kun sender filer tilbage. I `picoServer06` håndterer vi både filer og `addournumbers`. 
	* Der skal laves en task og executor der returnering af filer - altså lidt i stil med opgave 1. 
	* Der skal være en task der håndterer `addournumbers` (håndter gerne hele else delen - altså inklusiv switchen.).

	Bemærk: I bliver nødt til at flytte det at lukke socket ind i de to tasks, da det er dem der ved hvornår de har svaret på requestet.
	
2. (gul/rød) Når I er færdig med opgave 2, så vil I main tråden stadig have til opgave at lave et HttpRequest objekt. Gentag processen med at lave metoder og tasks sådan at også det at lave HTTPRequestet bliver gjort i en selvstændig task.  Hvis I følger processen med at lave nye metoder og tasks, så vil denne nye task selv lave nye tasks. Det må den gerne - det er god karma.

3. (rød) I koden fra sidste uge er der en klasse der hedder `ClientMain`. Den kan bruges til at kalde en web-server. 

	* Sæt det op sådan at I på den ene computer kører en webserver (f.eks. en `picoserver06` fra sidste uge).
	* Få `ClientMain` til at kalde denne server.
	* Lav `ClientMain` programmet så den vha. executors sender mange requests samtidigt til Serveren.
	* Til review skal I vise en udgave hvor I kan demonstrere at både klient og server kører med flere samtidige tasks.

