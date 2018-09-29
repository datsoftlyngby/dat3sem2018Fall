REST with JAX RS - PersonDTO
============================

Building on the exercise from yesterday, use the same project and add a
new entity: Address.

**a)** First, implement a unidirectional relationship, so that each
Person has a collection of addresses, but not vice-versa.

You can now observe that your endpoints from Exercise 2 still works, but
the Person resource now has an additional field (the addresses field).

**b)** Now, you must make the relationship bidirectional (a person has a
collection of addresses, and an address has a collection of persons).
This will break your rest endpoints, as the gson library try to make an
endless chain of Persons with Addresses with Persons with Addresses
with…

Why this is an issue when using JSON, but not a problem in java, or in
javascript?

**c)** Without changing the relationship between Person and Address,
solve the serialization problem by implementing Data-transfer objects.
That is; you must create new class(es) that will not cause trouble when
serialized to JSON, and the code for the endpoints should then transform
Person objects to a PersonDTO (or similar) before serializing, and
likewise transform PersonDTO objects to Person before using the
facade/database.

d\) In your facade class create a method that uses the JPQL select with
the “new” operator to automatically change collection of Person objekter
to collection of PersonDTO objekter when selected [*Se how here: under
headline: *](https://www.thoughts-on-java.org/jpql/)[*Constructor
references*](https://www.thoughts-on-java.org/jpql/).

e\) Lav en metode i rest servicen som kan sende personobjekter
serialiseret som json til klienten ved at bruge den metode du lige har
oprettet.
