# Day-3 CRUD with React and fetch

Before this exercise, you should have completed the exercise [**Patterns
to handle CRUD via
fetch**](https://docs.google.com/document/d/1b9_S7mbnWYfPXdF_fkvWQ1yyST6s-pSFzYKgrkrRHJ8/edit?usp=sharing)
(which you have if you attended the class)

This exercise will use
[*json-server*](https://github.com/typicode/json-server) to provide a
quick test-backend we can use for or REST-calls. This exercise focuses
on React, so this allows us to abstract away database and REST problems.

**Clone** this project, as the start code for this exercise:
[*https://github.com/Cphdat3sem2017f/startCodeReactDay4CRUD.git*](https://github.com/Cphdat3sem2017f/startCodeReactDay4CRUD.git)

Navigate into the project folder, and type: **npm install**

It's a *create-react-app* project, set up with start code for this
exercise, and a json-document ***data.json*** that holds our data. This
is ACTUALLY the database. When you start to add persons via the code,
they will go in here.

#### Start the json-server

Open a terminal (meant only for the backend) in the root of the project

type: **npm run dataserver**

This will start the server on the port it tells you. Verify by opening a
browser with this URL:
[*http://localhost:3456/api*](http://localhost:3456/api)

*Leave this terminal open for the rest of the exercise. If you close it,
you close the server*.

#### Use postman to verify that you can:

**POST** using this url:

[*http://localhost:3456/api*](http://localhost:3456/api) (provide it
with a json structure similar to what you got above, but without an id)

**PUT** using this url:

[*http://localhost:3456/api*](http://localhost:3456/api)/{id} (json
structure from the original, but with your changes)

**DELETE** using this url:

[*http://localhost:3456/api/{id}*](http://localhost:3456/api/%7bid%7d)
Use the id, for the person you want to delete

### 

### Before we start for real

<span id="_gjdgxs" class="anchor"></span>You should spend a few minutes
on the provided code to learn what it does. It provides a dataFactory
which serves as the façade up against the server.

Inside this factory, it provides an observer- based way to listen for
changes (refer to the exercise mentioned in the start). This works so
whenever getPersons(..) is called, a possible *observer* will be
notified with the new List. If called with an argument like:
getPersons(true), it will return the cached list, otherwise an updated
list from the server.

#### \

#### Select a strategy for how to handle data.

You must select, and be aware of the pros & cons with the solution you
select, one of the two strategies given below:

1.  You maintain a local list (\_persons), which you *update*, *delete*
    > and *change locally* on the client, whenever the user does those
    > parts of **C**R**UD**. While doing this, *you also update the
    > server*. The problem with this solution is that you need to handle
    > data operations in two different places (client and server), and
    > when does your data actually get synchronized with changes from
    > the server with this solution?

2.  The second option is: whenever you do a Create, Update or Delete,
    > you do it on the server (only), and after that you update the
    > local list with a call to the server. The advantage is, that we
    > have a strategy for when to update data (which is when user are
    > manipulating data), and we still have a local copy we can use for
    > sorting, filtering and all the other thing we like to do on the
    > client, without involving the server. The disadvantage is; more
    > server calls. This however *is the solution I will recommend*,
    > also because it's simpler.

**a)**

In App.js, locate the AllPersons component. This is already set up as an
observer for data changes (make sure you understand all parts involved).

Add a table that must render all persons, and all their properties.

With the provided code, you have what it takes, to update this list,
whenever you receive a change from the server.

Test and verify that your data gets rendered (make sure the data server
is running as explained in "start the server"

To prepare for the coming questions, you could add an edit and delete
link to each row as sketched below:

![](media/image2.png){width="6.692913385826771in"
height="1.0416666666666667in"}

If you provide the &lt;a&gt; tag with an id, which is the id for the
person in this row, you can hook up an event handler and grab the id
using the event argument (let id = event.target.id)

Create the link like this (person is value passed to the map-callback):

&lt;a href="" onClick={this.onEdit} id={person.id}&gt;edit&lt;/a&gt;

Since we are using the link as a button (it does not take up as much
space), we must disable its default behaviour.

Do that in the onEdit handler using the event argument:
event.preventDefault()

**b) Creating new Persons**

Add a method addPerson(..) to the dataFacade.

No matter which strategy you decided for above, you must always *post to
the server*.

If you decided to maintain the list locally, trigger an update to
observers via façade.getPersons(true) which will provide the local
cached version. Otherwise just call façade.getPersons(), which will
update observers with a "fresh" list from the backend.

Hint: Small
[*article*](https://stackoverflow.com/questions/39565706/post-request-with-fetch-api)
related to post of json, with fetch

**b**) Add a Form, inspired of the exercises we did day-3, using the
Controlled Component pattern. Ths must allow us to add and submit a new
Person.

Submit the new person via the façade method added in the previous step.

**c)** Verify that you can create new persons, and that the table is
updated accordingly.

**d) (yellow) Deleting Persons**

Add a method on the façade that will allow us to delete a person, given
the id. Update the server always, and handle data locally, according to
your selected strategy.

**e**) Implement the required code to delete a person via the UI
(**edit**, delete links, suggested earlier)

**f) (yellow/red) Update Persons**

Add a method on the façade that will allow us to update a person, given
the id and a changed person object. Update the server always, and handle
data locally, according to your selected strategy.

e\) Implement the required code to edit a person via the UI

**Hints:**

Implement a method in the facade which can return a person (from the
local cache), given the id.

Use the React Pattern “lifting state up”, and provide an event handler
in App.js, which are passed down via props to the AllPerson component,
and fired from this with the *id*. Now use the *id* to fetch the person
via the facade method implemented above, and pass the person to be
edited into the AddEditPerson component (as visualized below).

![](media/image1.png){width="5.850885826771654in"
height="3.6761395450568677in"}
