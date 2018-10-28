React exercise Day 3:
=====================

Leaning objectives: Be able to use: State and props, Events, List and
Keys, Forms and controlled components

Create a Kilo to Pound converter
--------------------------------

Start a new create-react-app called ConverterApp

  ------------------------------------------------------------------------------
     1\. Create a new react class component with 2 input fields and 2 relevant
     labels: Kilo and Pound.
  -- ---------------------------------------------------------------------------
     2\. Add the component to the app.js class´s render method.

     3\. When we write numbers inside one of these input fields the other will
     update with the converted numbers. This because the 2 components share
     state. Initiate state in the constructor.

     4\. Create a method: convert() that can update the state of the component
     (both for kilo and pound). (Hint: setState({pound: , kilo: }) based on
     the value in the input field.

     5\. Make the value of each input field so that it is updated when state
     changes.

     6\. Add a onChange attribute to the input fields so that the convert()
     method is run whenever a value changes.
  ------------------------------------------------------------------------------

### Make the converter generic

Change the converter component so that it can be used to convert
anything (e.g fahrenheit to celcius, inch to centimeter or what ever you
can think of.

  -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     Use props to pass 2 things to the component:
     
     1.  first is the name (what does it convert)
     
     2.  second is the function (how does it convert). Hint: the convert() method from previous exercise is moved up to the parent component and passed to the converter with props. This means that state is now maintained in the parent component.
     
     
  -- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     Use the prop value to set the title of the component.

     Now change the components behavior so that the passed-in function gets called instead of the internal convert() method. This is called ‘lifting state up’

     Create an app with 2 converters using the same component with different props
     
     1.  First converter is for kilo to pound
     
     2.  Second converter is for ounce to kilograms
     
     

     Place both converters onto the app.js

     Add a functionality to the component so that the last 10 calculations can be remembered and printed.
     
     Hint: When the state changes save the old values in an array.[*See here for inspiration*](https://reactjs.org/tutorial/tutorial.html#storing-a-history)
  -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

If you can make the time please do this tutorial:
-------------------------------------------------

[*Create a
to-do-list*](https://medium.com/codingthesmartway-com-blog/the-2017-react-development-starter-guide-f717e4e13de7)
