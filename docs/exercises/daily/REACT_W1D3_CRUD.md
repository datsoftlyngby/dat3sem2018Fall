Asynchronous API Interaction using fetch
========================================

This exercise uses
[*json-server*](https://github.com/typicode/json-server) to provide a
quick test-backend for our REST-calls. The exercise focuses on React, so
this allows us to abstract away database and REST problems.

**Clone** this project, as the start code for this exercise:[
](https://github.com/Cphdat3sem2017f/startCodeReactDay4CRUD.git)*https://github.com/Cphdat3sem2017f/startCodeReactDay4CRUD.git*

Navigate into the project folder, and type: **npm install**

It's a *create-react-app* project, changed to provide start code for
this exercise. It also includes a json-document ***data.json*** with the
start data. This is ACTUALLY the database. When you start to add persons
via the code, they will go in here.

Start the json-server
---------------------

Open a *separate terminal* in the root of the project and type: **npm
run dataserver**

Verify that the server is started from a browser with this URL:[
](http://localhost:3456/api)*http://localhost:3456/api*

Keep this terminal open for the rest of the exercise.

**Use postman to verify that you can:**

**POST:** [*http://localhost:3456/api*](http://localhost:3456/api)
(provide it with a json structure similar to what you got above, without
an id)

**PUT**: [*http://localhost:3456/api*](http://localhost:3456/api)/{id}
(json structure from the original, but with your changes)

**DELETE**:
[*http://localhost:3456/api/{id}*](http://localhost:3456/api/%7bid%7d)
Use the id, for the person you want to delete

Before we start for real
------------------------

Spend a few minutes with the provided code. It provides, among several
things, a file dataFactory.js which should abstract away API-calls

#### Select a strategy for how to handle data.

There are *a minimum* of two overall strategies you can use to handle
API-calls to remote data.

1.  You can maintain a local list (copy of the remote data[^1]), which
    > you *update*, *delete* and *change* locally on the client,
    > whenever the user does those parts of **C**R**UD**. While doing
    > this, you also update the server. The problem with this solution
    > is, that you need to handle and synchronize data operations in two
    > different places (client and server). The advantage with this
    > solution is less server-interaction (network traffic). Part two of
    > this exercise will introduce this strategy (yellow/red)

2.  The second option is: whenever you do a *Create*, *Update* or
    > *Delete*, you do it on the server (only), and after that, you make
    > a request to get a “fresh” list of the total data[^2]. The
    > advantage is, that whenever we make the request for a “fresh”
    > list, we get an updated (with changes others users might
    > have made) list of data, and we still have a local copy we can use
    > for sorting, filtering and all the other thing we like to do on
    > the client only. The disadvantage is more server calls. This,
    > however, is the solution we will recommend for green/yellow
    > students since it’s also is simpler. Part one of this exercise
    > uses this strategy (you should all do this part).

Part-1 - Only hold data on the server, no local caching involved
----------------------------------------------------------------

**a) Show all persons **

In App.js, locate the AllPersons component.

Add a table that should render all persons, and all their properties.

Hints: For all the tasks given below, follow the React Patterns
“Unidirectional data flow” and “Lifting state up”. This means that
neither the AddEditPerson, nor the AllPersons component should have
access to the facade, but only the data they need + events to “lift the
state up” (observe that the provided AllPersons component is provided as
a functional component)

Test, and verify that your data is rendered (make sure the data server
is running as explained in "start the server"

To prepare for the following questions, you should add an edit and
delete link to each row as sketched
below:![](media/image2.png){width="6.5in" height="1.0138888888888888in"}

If you provide the &lt;a&gt; tag with an id, which is the id for the
person in this row, you can hook up an event handler and grab the id
using the event argument (let id = event.target.id)

Create the link like this (person is value passed to the map-callback):

&lt;a href="" onClick={this.onEdit} id={person.id}&gt;edit&lt;/a&gt;

Since we are using the link as a button (it does not take up as much
space), you must disable its default behaviour. Do that in the onEdit
handler using the event argument: event.preventDefault()

**b) Create a new Person**

Add a method addPerson(..) to the dataFacade.

Hint: Read about [*making
Post’s*](https://docs.google.com/document/d/1hF9P65v_AJKCjol_gFkm3oZ1eVTuOKc15V6pcb3iFa8/edit?usp=sharing)
with fetch

Change the provided Form to use the Controlled Component pattern. This
should allow you to add and submit a new Person.

Submit the new person via the façade method added in the previous step.

**Hint:** Pass a method addPerson(..) from App.js down to AddEditPerson
to “lift state up”. In this method, running in the App-component, you
should also take the necessary actions to update the AllPersons
component

**c)** Verify that you can create new persons, and that the table is
updated accordingly.

**d) Deleting Persons**

Add a method on the façade that will allow you to delete a person, given
the id.

**e**) Implement the required code to delete a person via the UI
(**edit**, **delete** links suggested earlier) and make sure the table
is updated whenever a person is deleted

**f) Update Persons**

Add a method on the façade that will allow you to update a person, given
the id and a changed person object.

Hint: If you check whether a person object has a id, you can reuse your
existing method to add a user. If a person has an id, it must be an
existing user (edit= PUT), otherwise it must be a new user (add = POST).

Implement the required code to edit a person via the UI, and make sure
the table is updated.

**Hints:**

Use the React Pattern “lifting state up”, and provide an event handler
in App.js, which are passed down via props to the AllPersons component,
and fired from this with the *person* to be edited. Now when this
eventhandler is fired with the person to edit, pass the person into the
AddEditPerson component (as visualized below).

![](media/image1.png){width="6.5in" height="4.083333333333333in"}

Part-2 Cache data on the client to minimize server traffic 
-----------------------------------------------------------

Important: Before you continue you should make a copy of part-1, or
better, make a new branch for part-2. Part1 is an acceptable solution
you can use as a future template/example, and in some cases even a
better solution, compared to what follows here.

In part two, we re-fetched the list of data, each time we made a change
(add, edit or delete). This helps to keep the client in sync with the
backend and changes from other users, but involves a lot of redundant
network traffic. In this version we will cache data on the client, to
minimize the required traffic.

**2a)** Add this declaration to the beginning of the *dataFacade.js*
file:

const CACHE\_TIME = 1000\*60;//1min

**2b)** Add this constructor to the DataFacade:

constructor(){\
this.\_persons = \[\];\
this.\_lastWrite = 0; //To know when to the cache last was written to\
}

**2c)** Add this method below the constructor:

setPersons = (p) =&gt; {\
this.\_lastWrite = new Date().getTime();\
this.\_persons = p;\
}

**2d)** Change the getPersons() method into this (observe the use of
async/await):

async getPersons() {\
if(this.\_persons.length!==0 && this.\_lastWrite + CACHE\_TIME - new
Date().getTime() &gt; 0 ) {\
return this.\_persons;\
}\
var promise = fetch(URL).then(handleHttpErrors)\
var data = await promise;\
this.setPersons(data);\
return this.\_persons;\
}

**Important:** Do not continue before you have answered the following
questions (ask for help if you can’t answer):

-   If we monitor (*make sure to do it*) the network requests following
    > a PUT, POST or DELETE, what would you expect to see as the
    > difference, compared to version-1

-   What is the purpose of this.\_lastWrite?

-   What is the purpose of CACHE\_TIME

-   What benefits do we get from using the async/await keywords

**2e)** Change your facade methods that handles POST, PUT and DELETE
requests to update the local cache (this.\_person). Do this *ONLY after
you have received the response from the request* so you know whether
data actually was updated on the server.

Hint: This will be simpler to implement with the async/await keywords
(see 2d)

[^1]: Only for small amounts of data. When data grows, we need other
    strategies (which we will cover tomorrow)

[^2]: Again, only a valid solution for small amounts of data
