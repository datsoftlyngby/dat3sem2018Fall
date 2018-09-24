# Database design.


### Oversigt over ugen:  

#### Mandag
Laver vi en “code-along” hvor vi I fællesskab designer og koder en lille database.
I løbet af weekenden vil der komme et link til den ”tutorial” vi vil følge.

#### Resourcer
- [Slides fra dagens gennemgang](resources/slides.pptm)
- [DDL - script til selve databasen](resources/ddl.sql)
- [DML - script til data i databasen](resources/dml.sql)
- [Java project m prepared statements og transaction](resources/TestDB.zip)


[Resourcer](https://drive.google.com/drive/folders/1YM6ZdDmQkitjEDoRnVKcSuNgoSl_H8-j?usp=sharing)

#### Opgaver til onsdag
Vejledning med tutorer: Lav [Øvelse 1](exercises/SQLex1.md) og [Øvelse 2](exercises/DDLexercise2.md)

#### Opgaver til fredag
Vejledning med tutorer: Lav [Øvelse 3](exercises/NormaliseringEx3.md) og [Øvelse 4](exercises/DatabaseExercise4.md)



### Oversigt over resourcer:  

| Emne                             | Ressourcer                               |
| -------------------------------- | ---------------------------------------- |
| 1: Relationelle databaser og SQL | [Lynda.com video kursus om MySql](https://www.lynda.com/MySQL-tutorials/SELECT-statement/139986/173303-4.html?org=cphbusiness.dk): Se kapitel 2-6 + 8, [Workbench](https://dev.mysql.com/doc/workbench/en/): Reference materiale til opslag. |
| 2: DML                           | Data Manipulation Language: CRUD operationer - [MySQL Tutorial](http://www.mysqltutorial.org/basic-mysql-tutorial.aspx): Grundig online MySql bog som i kan læse i når der er tid. |
| 3: Complex SELECT statements:    | [Inner](http://www.mysqltutorial.org/mysql-inner-join.aspx), [Left/Right join](http://www.mysqltutorial.org/mysql-left-join.aspx) - Aggregate functions:    [AVG](http://www.mysqltutorial.org/mysql-avg/), [COUNT](http://www.mysqltutorial.org/mysql-row-count/), [MIN](http://www.mysqltutorial.org/mysql-min/) , [MAX](http://www.mysqltutorial.org/mysql-max-function/), [SUM](http://www.mysqltutorial.org/mysql-sum/) - [Sub queries](http://www.mysqltutorial.org/mysql-subquery/) - Operators: AND, OR, NOT, =, <>, >=, BETWEEN, IN, LIKE with [WILDCARDS](http://www.mysqltutorial.org/mysql-like/) and [ALIAS](http://www.mysqltutorial.org/mysql-alias/) - ANY vs. ALL - [UNION](http://www.mysqltutorial.org/sql-union-mysql.aspx) |
| 4: Modelering                    | [Domain model](http://stg-tud.github.io/eise/WS11-EiSE-07-Domain_Modeling.pdf) udledt fra kravsspecifikationen [(Conceptual model)->(Logical model)-> (Physical Database model)](https://www.visual-paradigm.com/support/documents/vpuserguide/3563/3564/85378_conceptual,l.html). [Data modeling](https://dev.mysql.com/doc/workbench/en/wb-data-modeling.html) in workbench, [Reverse engineering](https://dev.mysql.com/doc/workbench/en/wb-reverse-engineer-live.html) in workbench. |
| 5: DDL                           | DDL: Data Definition Language - CREATE, DROP, ALTER: Database, Table, View, [SQL-constraints](https://www.tutorialspoint.com/sql/sql-constraints.htm): Primary key, [Foreign key]() and [MySQL Cascade](http://www.mysqltutorial.org/mysql-on-delete-cascade/), NOT NULL, Unique, [MYSQL Data types](https://www.tutorialspoint.com/mysql/mysql-data-types.htm),  auto_increment |
| 6: Indexing                      | [Indexing](http://www.tutorialspoint.com/mysql/mysql-indexes.htm) |
| 7: NF                            | [3 Normalformer](http://www.studytonight.com/dbms/database-normalization.php): 1NF, 2NF, 3NF |
| 8: JDBC                          | [JDBC](https://www.tutorialspoint.com//jdbc/jdbc-quick-guide.htm): Connection, Statement, PreparedStatement og [SQL Injection](https://www.javacodegeeks.com/2012/11/sql-injection-in-java-application.html), [ResultSet](http://tutorials.jenkov.com/jdbc/resultset.html), [Transactions](https://www.tutorialspoint.com/mysql/mysql-transactions.htm) i Mysql og [Transactions i java med JDBC](https://www.tutorialspoint.com/jdbc/jdbc-transactions.htm). |
| 9: SQL Exceptions                | [SQL Exceptions](https://www.tutorialspoint.com/jdbc/jdbc-exceptions.htm) og hvordan man opsætter og læser error [logs](http://www.pontikis.net/blog/how-and-when-to-enable-mysql-logs) (Configurationsfilen ligger på: /etc/mysql/mysql.conf.d/mysqld.cnf og logfilen på `sudo tail /var/log/mysql/mysql.log`) |
| 10: Backup                       | [Backup og Restore database.](https://www.backuphowto.info/how-backup-mysql-database-automatically-linux-users) |





### Resultatet

Efter denne uge har i været igennem følgende:

1. I har lært hvordan man designer en database med tabeller og relationer, samt datatyper på kolonnerne og "constraints" der hjælper med at sikre data integriteten.
2. I har lært hvordan man laver CRUD (Create, Read, Update og Delete) operationer på databasen for at manipulere data.
3. I vil kende til forskellen på DDL: Data Definition Language og DML: Data Manipulation Language.
4. I vil vide hvordan man man laver et E/R diagram og hvordan omsætter dette til en fysisk data model og til et sql script
5. I vil have lært en række SQL commandoer til at kunne lave komplekse udtræk af data fra en database med flere sammenkædede tabeller.

#### Læringsmål

Efter denne uge er det meningen at du kan:

- Oprette en database med tabeller og indbyrdes relationer udfra en forståelse af kravsspecifikationer
- Lave primary key og foreign key constraints på tabellerne
- Forstå og tale om de 3 Normal Former og omsætte dem til praktisk database design
- Bruge JDBC fra et java program til at udføre CRUD operationer på databasen.

#### Erhvervskompetencer

Når ugen er omme har du opnået følgende kompetencer:

- Du kan redegøre for database design og implementation.
- Du kan oprette og manipulere en MySql database.
- Du kan bruge databaser i dine java programmer.



## Onsdag - Review   

[Se tiderne for gruppe review her](https://docs.google.com/spreadsheets/d/1dimfKx2nP6wmzixonlXTLQn6IiLEhVQv8dgcOZC3V3k/edit#gid=711878783)

Onsdag taler vi om de øvelser i har lavet. Vi vil gerne høre jer fortælle om de 3 normalformer, hvad forskellen er på inner join og left join, hvordan man laver en sub query og mange flere ting.

| Niveau | Demo                                     |
| ------ | ---------------------------------------- |
| Grøn   | Vi forventer at i har lavet **Øvelse 1**: opgave 1-13, 18, 23, 26-28, 31-34, 36 **Øvelse 2**: 1-3, 6 |
| Gul    | Vi forventer desuden at i har lavet **Øvelse 1**: 14, 19, 24, 29, 35 **Øvelse 2**: 4-5, 8-11 |
| Rød    | Vi forventer at i yderligere laver **Øvelse 1**: 15-17, 20-22, 25, 30, 37 **Øvelse 2**: 7, 12-13 |



## Fredag - Review   

Når vi mødes fredag vil vi gerne have en demo af jeres arbejde med opgaverne.

Forventninger til fredag (Gul bygger videre på grøn og rød bygger videre på gul):  

| Niveau | Demo                                     |
| ------ | ---------------------------------------- |
| Grøn   | Vi forventer at i har lavet **Øvelse 3** samt delopgaverne i **Øvelse 4** part 1-2 og part 4 opgave 1-6 |
| Gul    | Vi forventer desuden at du har lavet **Øvelse 4:** part 3 og part 4 opgave: 7-11 |
| Rød    | Her forventer vi desuden at du yderligere har lavet **Øvelse 4:** part 5-6 og part 4 opgave 12-15 |



