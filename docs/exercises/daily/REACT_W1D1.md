Day-2 React Continued
=====================

The exercises in this document continues with the strategy introduced
day1, in that it uses examples from the docs found at
[*https://reactjs.org*](https://reactjs.org)

Create a new Create-react-app project, and set it up similar to day1 for
the following exercises.

1 Lists and Keys
----------------

Skim the first part of [*this
article*](https://reactjs.org/docs/lists-and-keys.html) for a quick
review of the map-method, if needed.

**a)** Create a new JavaScript file ListDemo.js and create a simple
Class-component ListDemo, that initially just should render a div with
some dummy text. Export ListDemo as the default export.

Change index.js to use this file, and verify that you see the dummy text
from the ListDemo’s render method.

**b)** Copy/paste the NumberList component from
[*here*](https://reactjs.org/docs/lists-and-keys.html#basic-list-component)
into the file (before the ListDemo class)

**c)** Change your render() method in ListDemo to use the NumberList
component like this:
`<NumberList numbers={[1,2,3,4,5]}>`

Verify that your browser prints an unordered list of numbers

**d)** A hard-coded list of numbers like this is rare. Usually, data
exists, either as props or state, or in a data store.

Provide the ListDemo class with a constructor, and initialize the state
object with an array property number, initialized with a few numbers for
your test.

Change the render method to initialize the number props for the
NumberList using the number property in the state object.

Verify that the numbers get printed.

Hint: If you have forgotten about state, just use the section [**State
and Lifecycle**](https://reactjs.org/docs/state-and-lifecycle.html#adding-local-state-to-a-class)
from the docs.

**d)** **Keys**

If not already done, open the developer tools Console Window and observe
the warning given for our code.

Read about [*keys*](https://reactjs.org/docs/lists-and-keys.html#keys)
here, and fix the problem (make the warning disappear)

**e)** Decompose NumberList into several components.

Locate the code in your map(..) method (in the NumberList Component)
which probably looks something like this (if you solved the problem in
d)

&lt;li key={index}&gt;{number}&lt;/li&gt;

This is a candidate for code that can be refactored into a separate
control (will make more sense for the next exercise). Use the ListItem
component from this
[*example*](https://reactjs.org/docs/lists-and-keys.html#extracting-components-with-keys)
to replace the code above, with a sub-component.

Verify that the output is as before and that the warning has not come
back

**f)** Implement a new Component NumberTable (just below the NumberList
control from above).

This control, should accept a number array, similar to NumberList in its
props, and create a table with a row for each number.

2) List and Keys continued
--------------------------

a\) Add a new file *ListDemo2.js*, and create a class component
ClassDemo2, similar to the previous exercise and a functional component
Members, which should render a table with members passed in via props.

b\) Add a constructor to ClassDemo2, and initialize state like this

c\) this.state = { members : \[ {name : "Peter", age: 18},

> {name : "Jan", age: 35},
>
> {name : "Janne", age: 25},
>
> {name : "Martin", age: 22}
>
> \] };

d\) In ClassDemo2’s render method use the Member component like this:

&lt;Members members = {this.state.names}/&gt;

e\) Implement the code in Members, required to render a table with all
the names passed in. Make sure to add the required key, to remove the
warning from the console window.

***Answer the following questions, before you continue (questions we
will ask during the examination)***

-   *What is the purpose of the key value, which must be given to
    > individual rows in a react-list*

-   *It's recommended to use a unique value from your data if available
    > (like an ID). How do you get a unique value in a map callback, for
    > data without a unique id?*

-   *What is the difference(s) between state and props?*

-   *For which scenarios would you use props, and for which would you
    > use state?*

-   *Where is the only place you can set state directly as in:
    > this.state = {name: "Peter"};*

-   *How must you set state all other places?*

3 Forms and Controlled Components
---------------------------------

*Handling form inputs are essential for almost all web applications.
Reacts recommended strategy to do this, is via Controlled Components,
which you can read about*
[**here**](https://reactjs.org/docs/forms.html) *(make sure to read the
article before you start).*

**a)** In the same project as before, add a new file FormDemo.js, and
add the functional component sketched below

import React from "react";

export default function Forms() {

return (

&lt;div&gt;

&lt;NameForm /&gt;

&lt;/div&gt;

)

}

**b)** Paste the NameForm control found
[*here*](https://reactjs.org/docs/forms.html) in below the Forms-control
(this will be the one used by Forms)

Place a div around the form, and add an h2-tag above the form, with the
text “Name Form Demo”

**b)** By now you should know what else to do to make it work (render it
in index.js). Do that, and test it

**c) **

To illustrate that with this strategy React state (here the value
property) is truly *the single source of truth* add these changes to the
code.

Provide the value property with a default value in the constructor (to
see how we control the input field)

Add a &lt;p&gt; tag *below* the form, and show the value of the state
property value like this:

&lt;p&gt;{this.state.value.toUpperCase()}&lt;/p&gt;

Verify that React State (the value) property is the "Single Source of
truth"

*The next two questions are plain cut and paste. But do it, and read the
code so you know what to do/were to look, next time you need these
controls. Many of the more complex problems you will encounter this
semester, will be simplified a lot if you can just go back to look at
this example*![](media/image1.png){width="2.1150207786526685in"
height="2.1553062117235346in"}

**d)** Paste the EssayForm component found
[*here*](https://reactjs.org/docs/forms.html#the-textarea-tag), into
FormDemo.js, just below the NameForm class.

Add a div around the form, and an h2-tag above the form with the message
“Essay Form Demo”

Use the EssayForm by “calling” it below the NameForm in your
Forms-control.

**e)** Paste the FlavorForm.js component found
[*here*](https://reactjs.org/docs/forms.html#the-select-tag) in below
the EssayForm class and repeat the steps you did for the EssayForm.

***When this is done, you should have a pretty good example (the figure
above), illustrating the basics of React form-handling***

***Important**: The previous two questions were mostly cut and paste. So
is this (for the start). But you should use this example as **your
future template for how to create complex React Forms**.*

4 Handling multiple inputs
--------------------------

In the src folder, add a new file MultipleInput.js, and paste in the
component found Reservation Class found
[*here*](https://reactjs.org/docs/forms.html#handling-multiple-inputs)
(Rename the class to MultipleInput). Export the component, and test it.

Make sure you understand the strategy with a *name property* on each
input element, and how you use it in the *single* handleInputChange
method

Place a div around the form and add this code below the form (to observe
the controlled behaviour)

&lt;p&gt;{JSON.stringify(this.state)}&lt;/p&gt;

**a** Add a submit button, with a matching handler (that does not
actually submit to the server, make sure you know the BIG difference
when you use preventDefault)

Add an Alert box, as in the first example, to present the results as
sketched in this
figure.![](media/image2.png){width="4.611805555555556in"
height="0.9555555555555556in"}

Print the values of state like this (you will see why in the next
question): alert(JSON.stringify(this.state));

**b)** Now, let's see the real beauty of the pattern introduced in this
example :-)

In the form, add a text field with the label "Name of first guest".
Provide it with a name property (guest1). **Don't touch anything else in
the code**

Enter a name and observe how the name is handled automatically by this
pattern :-)

**c)** Add a few more input fields (guest2, guest3 …); similar to what
you did above. Do this to convince yourself about the beauty of this
pattern - *don't stop until you are convinced* ;-)

**Answer the following questions, before you continue (questions we will
ask during the examination)**

-   In a Controlled Component React state is made the "Single source of
    > truth", so how:

    -   Do we ensure that input controls like text, textarea or select
        > always presents the value found in the components state?

    -   Do we ensure that a controls state, always matches the value
        > found in an input control?

-   What is the purpose of doing event.preventDefault() in an event
    > handler?

-   What would be the effect of NOT doing event.preventDefault in a
    > submit handler

-   Why don't we want to submit the traditional way, in a single page
    > application?

-   What are the two different ways we can use to make this works as
    > expected for our event handlers?

-   Explain in words what it takes to implement the "Controlled
    > Component" pattern for a form

> <span id="_gjdgxs" class="anchor"></span>

\
-

5 Lifting State Up
------------------

Create a new Create-react-app project, and remove all unnecessary code.

**a)** In the src-folder, create a new JavaScript file *jokeStore.js*
and paste in the following code:

class JokeStore {\
constructor(jokes) { this.\_jokes = jokes; }\
addJoke(joke) { this.\_jokes.push(joke); }\
getRandomJoke() { return this.\_jokes\[Math.floor(Math.random() \*
this.\_jokes.length)\]; }

// ES6 getter.You access it like jokeStore.jokes, not
jokeStore.jokes**()**\
get jokes() { return this.\_jokes; }\
}\
let startJokes = \[\
"I totally understand how batteries feel because I’m rarely ever
included in things either",\
"I used to think the brain was the most important organ. Then I thought,
what’s telling me that",\
"You kill vegetarian vampires with a steak to the heart",\
\]\
export default new JokeStore(startJokes);

**b)** Add two components AllJokes and AddJoke, and use these components
in App.js. Create an solution similar to this (almost identical)
[*example*](http://sem3slides.mydemos.dk/react2/react2.html#19)

6 Lifting State Up 2
--------------------

Create a new Create-react-app project, and remove all unnecessary code.
This exercise example starts as almost a copy of exercise 5, but quickly
evolves into much more.

**a)** In the src folder, add a PersonStore class, inspired by exercise
5, and add a few hard-code
persons.![](media/image3.png){width="3.1988604549431323in"
height="1.8893853893263342in"}

**b)** Add the necessary components to render a web-site as sketched in
this figure..

When a new name is typed in and the user presses “save”, the name should
be added to a list (handled by the parent) and the AllPerson control
must be updated with the new Name

**c)** When this works (similar to ex-5) change the PersonStore class to
handle persons as sketched below:

{ firstName: "Kurt", lastName: "Wonnegut", email:
"[*kw@gmail.com*](mailto:kw@gmail.com)"}

Make sure to set up some sample users, and change the method that add
users.

**e)** Change the unordered list into a table with a column for each
property

**f)** Change the example, so you can edit and/or delete persons

**Answer the following questions, before you continue (questions we will
ask during the examination)**

-   What is meant by the react term “Lifting State Up”?

-   Where do you lift it up to?

-   Which way does React recommend data to flow: From sibling to
    > sibling, from bottom to top or from top to bottom?

-   Lifting state up, involves a great deal of boilerplate code, what’s
    > the benefit we get from this?

### 7 Conditional Rendering

*Only if you have time.*

Before you start, read/skim this
[*article*](https://reactjs.org/docs/conditional-rendering.html)

**a)** Create a new JavaScript file LoginControl.js and paste in the
corresponding control found in the article above into this file
(remember: only paste in the class, export the class, and import React).

This component relies on a number of supplementing Components (remember,
Components is like playing with Lego) as sketched below. Copy/paste all
this controls into the LoginControl.js file (above the LoginClass).

-   UserGreeting

-   GuestGreeting

-   Greeting

-   LoginButton

-   LogoutButton

**b)** Change index.js (similar to what we have done the other days) to
render this new Control.

**c)**

In this example, the authors have gone too far when they split up
components into smaller components. This is perfectly OK, since
Component composition is an important thing to learn with React. This
time however, let's learn by doing it "the other way around".

Locate the two Button-Components and observe that they are almost
identical. Refactor this into only a single LoginLogoutButton which
receive both the text and the click event via props.

Refactor the code that used the original components, to use this new
Control.

**d)**

Locate the two lines in the LoginControl constructor that binds *this*
to the event handler.

Comment out these two lines and verify that, without it does not work
(press the button)

Change the two event handlers to use arrow function notation, and verify
that everything is fine again
