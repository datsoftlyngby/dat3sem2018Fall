# (Mini) Course Assignment 1

**Basic JavaScript, DOM manipulation and Hosting**

![](../media/ca1_technologies.png)

This mini CA expects you to create a few static HTML pages, including a
number of JavaScript examples running 100% client side, that is without
any interaction with the backend.

***This CA will strengthen your skills and knowledge related to:***
- Basic JavaScript
- JavaScript events
- JavaScript functions and callbacks
- Basic DOM manipulation via plain JavaScript
- How to set up a WEBsite with a personal domain
- How to set up a WEBsite to use HTTPS

## Hand-in & Reviews

The server must be hosted and the URL must be provided to us by putting
it in the review plan documents for your class. URLs:
[*ClassA*](https://docs.google.com/spreadsheets/d/14f_P36DV0rqsvIYIjjzC4Lc7Dl5dIt6Y5P7eHYXVTck/edit?usp=sharing)
Times:
[*ClassA*](https://docs.google.com/spreadsheets/d/1xifpDuGC3VzvdSda7RtUCO5o0l7_jg6AKILHXi1nqH4/edit?usp=sharing)
URLs:
[*ClassB*](https://docs.google.com/spreadsheets/d/1gA2Ku3t56CMy0B2VonyG79hPiphDJZvcOgdc-EPyXnM/edit?usp=sharing)
Times:
[*ClassB*](https://docs.google.com/spreadsheets/d/1m44DXpp-kcUK2TMKmlDDL9N68IFPyxuSx_L6Q7ZfAo4/edit?usp=sharing)

### How to complete this CA in the given time
-----------------------------------------

You should however not commit/push any code before it has been reviewed
by the full group, since eventually (monday) it is considered the work
of all of you.

If you feel your group belong to the “greens” you can skip parts marked
with yellow or red.


**Prerequisites**

Before starting on this CA, you should insist that all members in the
group prepare for the CA-work by working with the exercises given for
JavaScript day 1+2 before the start of the CA. In order to complete some
of tasks given in the following, it is expected that you have spent some
time with this JavaScript tutorial on [*Lynda.com*](https://www.lynda.com/JavaScript-tutorials/Welcome/574716/612017-4.html?srchtrk=index%3a3%0alinktypeid%3a2%0aq%3ajavascript%0apage%3a1%0as%3arelevance%0asa%3atrue%0aproducttypeid%3a2).

## Project Description

There is no business model involved with this CA. Your task will be to
produce a number of static HTML pages with the sole purpose of
“learning”. They all include some JavaScript + DOM manipulation running
on the client *without any* server interaction (AJAX).

When completed your pages must be hosted on a Tomcat Server hosted on
your own domain name and (for yellow and red groups) only accessible via
HTTP**S**.

### Description of the pages

**Main page**

![](../media/ca1_js_watch.png)

This should include a short description of the project and the names + a
picture of each member in the group. Somewhere on the page you must
place a functional analog clock as sketched in this figure (remember the
link to the Lynda.com tutorial).

Finally the page should include links to the following three pages (that
each should include a link back to the main
page).![](../media/ca1_calc.png)

**Page1 - Calculator**

This should include a simple calculator as sketched in this figure. This
part it further explained in the exercises for JavaScript day-2.

**Page2 - Typing Speed Tester**

This page should include a typing speed tester that will allow users to
test their “typing speed”. Check out the Lynda.com video for further details (and lots of hints).  

![](../media/ca1_typing_speed.png)

Important: Here you must prove that you can twist existing code to your
own need. Compared to the Lynda example, your version should pick a
random exercise (test string), among 10 different hard coded text
strings when “Start over” is pressed

This would mean that users sees a “new” exercise each time they press
“Start over”

### \
**Page3 - Dynamic UI manipulation**

![](../media/ca1_dom_manipulation.png)

Use the start code (JS, CSS and HTML) given below to complete the
following task (sketched in the figure above)
- Show all the boys
- Show all the girls
- Show all (don’t create a list for this but use the concat function)
- Add a boy and a girl (should update relevant UI-parts)
- Remove a boy or a girl from the top of the list
- Remove a boy or a girl from either the top or bottom of the list, depending on the selection of the two radio buttons
- Reverse all names in the “all” part.
- Sort all names in the “all” part
- Sort all names correctly independent of spelling (whether first character is capitalized)
- Sort all names ascending when the button is pressed first and then descending when the button is pressed next, and so on, back and forth between ascending and descending

Hint: This exercise expect that you have completed the exercise [*The
JavaScript
Array*](https://docs.google.com/document/d/1-RF3dvvejvxwMzRzyXrVtIEoJHUcY6oMbTsVMg50lTM/edit?usp=sharing).

**javascript**:
```js
var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne","hanne","Sanne"];
```
**css**
```css
h2 {color: steelblue;}
h3 {color: steelblue;
    margin-top: 0px;
    margin-bottom: 1em;}
.container {
    font-family:sans-serif; 
    margin:auto;width:60%;}
.lists {
    border: 1px solid; 
    border-color:
    steelblue;
    border-radius: 3px; 
    float:left; width: 12em;
    margin-right:2px;} 
.lists h4 {
    text-align: center; 
    color: steelblue} 
.lists div {
    padding: 3px;text-align: center;} .inputs {
    margin-bottom:12px;}
```
**html**
```html
<div class="container">
  <h2>DOM manipulation via plain JavaScript</h2>
  <h3>And getting used to the JavaScript Array</h3>
  <div class='inputs'>      
  <input id="newboy" placeholder='Add boy' />
  <button id='addboy'>Add Boy</button>
  <input id="newgirl" placeholder='Add girl' />
  <button id = 'addgirl'>Add Girl</button>
  </div>
  <div class='inputs'>
  <button id='removeboy'>Remove boy</button>
  <button id='removegirl'>Remove girl</button>
  <Input type='radio' name='direction' id='first'/>  Remove first
  <Input type='radio' name='direction' id='last'/> Remove last
  <button id='reverse'>Reverse all</button>
  <button id='sort'>Sort all</button>
  </div>
  <div class="lists">
  <h4>Boys</h4>
  <div id="boys"></div>
  </div>
  <div class="lists">
  <h4 style="text-align: center">Girls</h4>
  <div class="names" id="girls"></div>
  </div>
  <div class="lists">
  <h4>All</h4>
  <div id="all"></div>
```

**Page4:** - Dynamic UI manipulation with data obtained via fetch

Only focus on this exercise if your group is yellow or red

a) Enter this URL in a browser and observe the result:
[*https://jsonplaceholder.typicode.com/users/1*](https://jsonplaceholder.typicode.com/users/1)

What is it, you get
back?

![](../media/ca1_get_back.png)
Change the number at the end of the URL to any number &lt;= 10 and
observe the result.

Implement a page, as sketched in this figure, which should fetch the
requested user, and render his data.

b)

Enter this URL in a browser and observe the result:
[*https://jsonplaceholder.typicode.com/users*](https://jsonplaceholder.typicode.com/users)



Use this URL, and add a new button to the page as sketched in figure.
When pressed, it should fetch all persons and render name + phone in a
table: 
![](../media/ca1_get_all.png)

**Deployment**

You are expected to deploy your pages on a Tomcat Server accessible via
a personal domain name (use one of the domains from the group, or if you
are ambitious and proud of your group, buy a domain name for the group.

If you feel you belong to the yellow or red groups the pages must be accessible *ONLY* via a **HTTPS** connection.

What is expected for the presentation Monday

*Note this review presentation should also include exercises from week-2*

You can each earn up to 16 study points for this mini-CA, depending on
your presentation monday.

***This is what we expect from you.***

1. Each member in the group must demonstrate and explain an equal share of the learning objectives from the past 2 weeks. You will base this on the exercises you have done in this period.

2. In the review plan sheet you must paste a link to a google doc with a plan of who in the group does what in the review presentation (remember that it is your responsibility to create a demonstration of all the learning objectives at the review) also explaining how far you came, problems you might have had, and important, who did what.

3. Also make a list of things that you would like to ask at the reviews (think about things you want to explore further.
