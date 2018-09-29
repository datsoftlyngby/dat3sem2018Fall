Dom Manipulation and Events

**1) Simple DOM manipulation and Event handling**

Add three divs to an HTML page, each with a unique id

**a)** When the page initially is loaded all divs should be given a
color of your choice

Hints: use document.getElementsByTagName() and
element.style.backgroundColor

**b)** Add a button, and assign a click handler to the button. When the
button is clicked each div should be given a unique color.

Hints: use document.getElementById(..) to get the individual div’s

**2) Event Bubbling and event arguments**

In a new HTML page add two div’s, each with a unique id

Style both id’s with this class:

.mydiv {width: 25px; height: 25px;background-color:yellow; margin:1px;}

**a)**

Add a click handler to each id and write code, so when clicked, each div
will write to the console "Hi from idOfTheDiv".

**b)** Now, using cut and paste, add 10 more divs (still each with a
unique id).

*Adding an eventhandler to each div, would be cumbersome and
non-efficient (what it you had been asked to add 100 or thousands of new
id’s).*

We will use JavaScript's event bubbling mechanism to solve this with
only a single event handler.

Add a new div (without the myDiv class) with the id="outher" around all
our div’s and assign a single event handler (with the event argument) to
this div.

Implement code to write to the console:

-   The value of id pointed to by ***this***

-   The value of id pointed to by the target property (which you get
    > from the event argument)

-   Make SURE you understand what happened here

**3)**

Add an empty paragraph tag, with an id, to your HTML and change the code
for both exercises above, so that output is not written to the console,
but into this paragraph.

Hint: Use the innerText property of an Element

**4)**

**a)** Yesterday you used the arrays map and join methods to create an
UL with a number of names (ex- 4).

Use this function+DOM man. to insert the UL somewhere in an HTML
page.![](media/image12.png){width="2.1259437882764654in"
height="1.029303368328959in"}

**b)** Create a *FORM* with an *input* field + a *submit* button as
sketched here.

Write the necessary code to add the new name to the array of names, and
regenerated the &lt;ul&gt; with the updated list.

**Hint:** You will probably see, very shortly that the name is added,
the screen flickers and it's gone again.

The problem is, that submit submits to the server, so the full page is
reloaded. To prevent this you can call .preventDefault() on the event
argument which will prevent the default behavior (submit) and it should
work.

You can, also use preventDefault() to prevent a link from actually
forwarding to the link-address.

**c)** Add two more buttons to the form with the text: “remove first”
and “remove last”. Implement the behaviour inspired of how solved
part-b.

**5)**

Yesterday you created a number of filter functions using the array given
below

> var cars = \[
>
> { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
>
> { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
>
> { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
>
> { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price:
> 4799 },
>
> { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
>
> \];

![](media/image11.png){width="3.7776826334208224in"
height="1.796875546806649in"}

**a) **

Write a function that, given this array, will return an html string with
the array formatted as a Table as sketched in this figure (styled with
the Bootstrap class table):

**b) **

![](media/image3.png){width="3.637333770778653in"
height="1.8020833333333333in"}

Add an input field and a button, each with an id as sketched here.

Write the necessary code so when the button is clicked, and the input
field contain a number:

-   A new filtered array is created having only prices &lt; than the
    > value provided

-   This array is passed to the function implemented in a), and the DOM
    > is updated with this new array.

**6)** **Implement a calculator with functionality as given below.**

> a\. When a button is clicked the value should be appended to the display
> div (middle figure)
>
> b\. When the equal sign is clicked the result of the calculation should
> be displayed. (last figure)
>
> c\. Use the HTML and Style given below to get started

  ![](media/image8.png){width="1.6657239720034995in" height="1.9830041557305338in"}   ![](media/image9.png){width="1.6656069553805775in" height="1.973630796150481in"}   ![](media/image10.png){width="1.6709317585301837in" height="1.998772965879265in"}
  ----------------------------------------------------------------------------------- ---------------------------------------------------------------------------------- -----------------------------------------------------------------------------------

  ------------------------------------------------------------------------------------
  &lt;div id="container"&gt;                             &lt;style&gt;
                                                         
  &lt;div id="display" class="t4"&gt;&lt;/div&gt;        \#container{
                                                         
  &lt;div id="buttons"&gt;                               width: 226px;
                                                         
  &lt;div class="t1"&gt;7&lt;/div&gt;                    height: 274px;
                                                         
  &lt;div class="t1"&gt;8&lt;/div&gt;                    border: 3px solid darkblue;
                                                         
  &lt;div class="t1"&gt;9&lt;/div&gt;                    margin: auto
                                                         
  &lt;div class="t1"&gt;/&lt;/div&gt;                    }
                                                         
  &lt;div class="t1"&gt;4&lt;/div&gt;                    .t1, .t4{
                                                         
  &lt;div class="t1"&gt;5&lt;/div&gt;                    border: 1px solid black;
                                                         
  &lt;div class="t1"&gt;6&lt;/div&gt;                    height: 48px;
                                                         
  &lt;div class="t1"&gt;\*&lt;/div&gt;                   margin-left: 3px;
                                                         
  &lt;div class="t1"&gt;1&lt;/div&gt;                    margin-top: 3px;
                                                         
  &lt;div class="t1"&gt;2&lt;/div&gt;                    display: inline-block;
                                                         
  &lt;div class="t1"&gt;3&lt;/div&gt;                    text-align: center;
                                                         
  &lt;div class="t1"&gt;-&lt;/div&gt;                    line-height: 48px;
                                                         
  &lt;div class="t1"&gt;0&lt;/div&gt;                    }
                                                         
  &lt;div class="t1"&gt;.&lt;/div&gt;                    .t1{
                                                         
  &lt;div class="t1"&gt;+&lt;/div&gt;                    width: 48px;
                                                         
  &lt;div id="calculate"class="t1"&gt;=&lt;/div&gt;      }
                                                         
  &lt;/div&gt;                                           .t4{
                                                         
  &lt;/div&gt;                                           width: 219px;
                                                         
                                                         }
                                                         
                                                         &lt;/style&gt;
  --------------------------------------------------- -- -----------------------------
  ------------------------------------------------------------------------------------

**Hints (and this is just hints, there are many ways to solve this
problem)**

-   Assign a *single* click eventhandler to the div with the *buttons*
    > id to handle anything but the “=” button.

-   Use your knowledge about event bubbling and the events target
    > property to get the text in the div that was clicked (via the
    > innerText property).

-   Assign a new event handler to the div with the “*calculate*” id. Use
    > the event arguments .stopPropagation() method, to prevent this
    > event from bubbling up to your “outer” event handler.

-   Use the indexOff(..) method to test whether a string contains \*,
    > /, + or -.

-   Use split(..) (with one of the four operators) to get the two
    > numeric values and use Number(..) to convert a numeric string into
    > a number before you do the calculation.
