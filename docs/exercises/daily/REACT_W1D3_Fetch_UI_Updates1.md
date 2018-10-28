Patterns to handle CRUD via fetch and React
===========================================

The “exercise” focuses on these problems:

-   Where do we store data (locally) in a React Application

-   How do we fetch data, using fetch(..), and how do we trigger a
    > re-render when data has been fetched (asynchronously)

-   How do we update or local data to reflect changes that might have
    > happened (by other clients) in the backend

It will ( we will do this together in the class) provide a number of
strategies you can use for all projects with problems as those outlined
above. You should notice that some of the hints slightly breaks
guidelines given by Facebook - but *not* guidelines used generally by
the large React Open Source community.

The guidelines suggested in the following, are heavily inspired by the
popular library MobX, and our major strategy will be to provide
*DataStores, Factories* etc. which using different strategies can notify
(GUI) components about changes and trigger a re-render.

Whether you want to have a single store for all your data (like in
Redux, a very popular library) or several stores for individual items is
something we leave up to you to decide. There are pros & cons with both
solutions.

Even though we use data stores, the major strategy is still the react
way of, "lifting state up", and pass data down.

### Fetching remote data and updating the UI

This exercise will only focus on fetching data. Updating data is
"trivial", once you have *learned to use fetch*.

The real day four exercise will include all CRUD operations

**a)**

We will use this remote API for all request made in the following (I
apologize for some of the very bad jokes you will see soon ;-):

[*http://api.icndb.com/jokes/random*](http://api.icndb.com/jokes/random)

Test in your browser a few times (remember I warned you ;-)

You should observe that, if we convert the provided json into a
JavaScript object we could get a "joke" like:

response.value.joke

b\) Create a new react project like this: create-react-app fetchtemplate

Clean up the generated project as usually, and start the development
server with **npm start**

Align your IDE and browser window next to each other, to take advantage
the great live reload feature offered by the seed.

Replace the App class with the content given below:

class App extends Component {

constructor(props){

super();

this.state = {joke: "aa"}

}

componentDidMount(){

const facade = this.props.facade;

}

render() {

return (

&lt;div className="App"&gt;

{this.state.joke}

&lt;/div&gt;

);

}

}

**c)** Create a new JavaScript file *jokeFacade.js* and paste in the
code below:

const URL = "http://api.icndb.com/jokes/random";

class JokesFacade {

}

export default new JokesFacade();

d\) Navigate into *index.js*, import the façade, and pass it in via props
to the App component as sketched below:

import jokeFacade from "./jokesFacade";

ReactDOM.render(&lt;App facade={jokeFacade} /&gt;, .....

#### Now we are ready to start.

Remember from period-1, that fetch returns a promise (*similar to a
future in Java*) so we need to call fetch like this, when we are dealing
with JSON. The major problem will be to handle the asynchronous response
in our façade.

fetch(url)

.then((resp) =&gt; resp.json()) // Transform the data into json

.then(function(data) {

// do something with (but we don't know when this will be called

})

})

Strategy-1 Using a callback
---------------------------

One way to solve this problem is via a method that takes a callback, we
can call from within the factory when data is ready as sketched below.

a\) Add the this code to the jokeFacade

getJokeViaCallback = (cb) =&gt; {

fetch(URL)

.then(function (res) {

return res.json();

}).then(function(data){

let joke = data.value.joke

if (cb) {

cb(data.value.joke);

}

});

}

**b)** Now let's update the UI with a new cool joke from this method.

First implement the callback, needed as input to the new method in the
façade. Add this method into the **App** class (*observe it's using the
arrow notation, if you prefer traditional methods you must do the "bind
thing" in the constructor*):

jokeUpdater = (data) =&gt;{

this.setState({joke: data});

}

**c)** Finally let's call the new method in the façade. A perfect place
to do that is in componentDidMount(), so call it here, after the façade
is initialized, as sketched below

facade.getJokeViaCallback(this.jokeUpdater);

**d)** Verify that the code can fetch a "joke" and asynchronously update
the UI via the callback.

Make sure you understand why the callback updates a *state variable*,
and what this actually "triggers"

Strategy-2 Using an Observer based design
-----------------------------------------

The strategy used above works perfectly well, if you can update the data
in the same Component as where you call the getJoke…. method.

But if you want to trigger the update in one Component and use it in
another (without having to do state lifting) you can use this strategy
(it can easily be extended to handle more than one observer)

**a)** Add this code to the jokeFacade:

getJokeAndNotify = () =&gt; {

fetch(URL)

.then(function (res) {

return res.json();

}).then((data) =&gt; {

let joke = data.value.joke

if (this.handler) {

this.handler(joke);

};

});

}

setObserver(handler) {

this.handler = handler;

}

**b)** Now let's use the new method.

Comment out the previous strategy in componentDidMount (this exercise is
about trying different strategies) and paste in this code.

//facade.getJokeViaCallback(this.jokeUpdater);

facade.setObserver(this.jokeUpdater);

facade.getJokeAndNotify()

Observe how we are following the *observer pattern* by first registering
a method as the observer (we use the same method as in the previous
example) and then call getJokeAndNotify which will trigger the method we
just registered.

**c)** Verify that the code can fetch a "joke" and asynchronously update
the UI via this Observer inspired design.

Strategy for getting updates from the server
--------------------------------------------

A common problem with Single Page Applications is how to keep data on
the client, in sync with data on the server. There is no trivial way to
do that (without the help of utility libraries, and websockets), so the
following is just a simple suggestion, you can use for some of the
exercises Friday.

In this strategy we will use *polling*, that is, we will constantly at a
given time-interval request the server for updates (not a very efficient
way of doing this, and not meant for larger real-life applications).

For this exercise we will use this to constantly update our browser with
new un-cool jokes ;-)

This is simple, since our façade already have most of what is required.

**a)** Add the following code to the jokesFacade.

getJokeContiniuesly =(time) =&gt;{

this.timerId = setInterval(this.getJokeAndNotify,time);

}

stopIntervalFetching =()=&gt;{

if(this.timerId){

clearInterval(this.timerId);

}

}

The first method will start a timer, and (using the interval passed in)
continuously fetch new jokes. It uses the getJokeAndNotify method, so
the observer must be set before this call.

The second method stops the data fetching.

**b**) Now let's test the new functionality

Comment out the previous strategy in componentDidMount and paste in this
code

facade.setObserver(this.jokeUpdater);

//facade.getJokeAndNotify();

facade.getJokeContiniuesly(2000)

c\) Override componentWillUnmount (why) as given below

componentWillUnmount() {

this.props.facade.facade.stopIntervalFetching();

}

d\) Test and verify that you, never ever in your life have seen so many
bad jokes in such a short time ;-)

### Strategy-3 (yellow/red) Convert asynchronous behaviour into synchronously

*Marked as yellow/red, but this is actually the simplest way to solve
the problem ;-) *

If you want to try the *newest and coolest way* of solving the
asynchronous behaviour using the ***async**,* ***await*** keywords, this
will give you a peek into the new great ES7 world (thanks to Babel).

I will not explain what goes on here, only how to use it. If you plan to
use this strategy, use Google

**a)** Paste this code into **jokesFacade**. Observe that this method
*returns a joke*, *not a promise*.

async fetchAsync() {

const response = await fetch(URL);

const res = await response.json();

return res.value.joke;

}

**b)** When calling a method marked with async, it can only be called
from a method which itself is async.

So comment out the existing componentDidMount method, and paste this
version in instead.

Observe: no callbacks, no observers, no (visible) promises, we "just"
call the method, get ajoke and use it ;-)

async componentDidMount(){

const facade = this.props.facade;

const joke = await facade.fetchAsync();

this.setState({joke});

}

**c)** Verify that this fetches a joke, and updates your UI.

*Save this project were you can easily find it again. *

*Use it as reference for future problems related to fetch and UI update
problems.*
