**React Routing, with React Router V4**
=======================================

**Getting started (we will do this part in the class together)**
---------------------------------------------------------

**a)** Setup the "Quick Start" example as explained
[*here*](https://reacttraining.com/react-router/web/guides/quick-start)

Verify that you can execute the example.

**b)** Replace the content of index.css with the CSS found [here](https://raw.githubusercontent.com/Dat3SemStartCode/scripts_unrelated/master/React/react_routing.css)

Add this CSS-class to the ul-tag that holds your top level links:
`className="header"`

Observe how it's common to restyle a `<ul>` into something that looks like a menu.

**Using NavLink**

**c)** Observe that when you navigate in the menu, it does not give any
visual indication of *what is selected right now*

Import NavLink in the top of your file, and replace the Link components
with NavLink (only) in the BasicExample component.

Verify the new behavior.

**d)** The example demonstrates "how easy" it is to implement nested
routes. Replace the Link tags in the Topics component with NavLink and
observe the result.

The default style used for the *active* item does not work well here
(background is much too dark). By default NavLink uses a class called
active, if present (checks the style-file). You can change this behavior
via the activeClassName property, as sketched below:

`<NavLink activeClassName="activeV2" to={……`  
Add this class to all NavLinks in the Topics component, and verify that
the new style is used.

**Using HashRouter**

**e)** Replace BrowserRouter in the import statement with HashRouter
and test the application. Observe how the urls has changed when you
navigate in the application.

You will probably prefer the first version *if you could*. There is
however, a deployment issue with the BrowserRouter which you can't see
when you use the webpack dev-server (npm start).

Unless you belong to the red students, we suggest that you are using the HashRouter, but please read the [*docs*](https://reacttraining.com/react-router/web/api/HashRouter)
related to HashRouter.

The guidelines you will get for deployment *will require that you use
this browser*. Obviously you can deploy in a way that will handle the
problem, but that’s for the reds, to figure out [Starting here](https://github.com/ReactTraining/react-router/blob/v3/docs/guides/Histories.md#configuring-your-server).

**Understanding the match object**

**f)** Press Home and then Topics and observe the url used for this
route. Locate the place(s) in the code that forces this path to be
used.

**g)** Now press some of the Topics-links, and observe the url used for
these (nested) routes.

Locate the place (s) in the code that forces these paths to be used.

**h)** Now locate the five places (in Topics and Topic) that uses the match object: 
- `({match})`
- `{${match.url}`
- `{${match.path}`
- `{${match.params.<some param>}`
Especially notice in Topics - this statement: `<Route path={`${match.path}/:id\} component={Topic} /> and how it corresponds with a statement in Topic: `<h3>Requested Param: {match.params.id}</h3>`.  
This is how we can forward parameters with Routes.  



**The match part shows you two things.**

1.  How you can create dynamic routes

2.  This is suggested as the normal pattern for building nested routes (as in this example).

In the next step you will see that match provides us with some very
useful additional information. Read
[*here*](https://reacttraining.com/react-router/web/api/match) before
you continue.

**Handling URL-parameters**

**i)** locate the Topic component, and add this class to the outer div:
className="topic"

This was only done, to ensure you know where this part of the code is
rendered

**j)** In Topics locate this part of the code, and make sure you
understand the purpose of the highlighted part:

```
<Route path={`${match.url}/:topicId`} component={Topic}/>
```

**k)** Locate the Topic class and make sure you understand the
highlighted parts (use the
[*docs*](https://reacttraining.com/react-router/web/api/match))

```jsx
const Topic = ({ match }) => (
    <div>
        <h3>{match.params.topicId}</h3>
    </div>
)
```

#### Make sure you understand the idea with the individual pieces.

**2)** Complete this
[*guide/tutorial*](https://www.sitepoint.com/react-router-v4-complete-guide/)

