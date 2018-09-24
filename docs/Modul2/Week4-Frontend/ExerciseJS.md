## Javascript functionality
| Emne                                     | Ressourcer                               |
| ---------------------------------------- | ---------------------------------------- |
| 4. Javascript                            | [Javascript tutorial](https://www.w3schools.com/Js/js_intro.asp), [Html events](https://www.w3schools.com/Js/js_events.asp), [arrays](https://www.w3schools.com/Js/js_arrays.asp), [array sort](https://www.w3schools.com/Js/js_array_sort.asp), [Objects](https://www.w3schools.com/Js/js_objects.asp), [Video kursus på Lynda.com: 1-6](https://www.lynda.com/JavaScript-tutorials/JavaScript-Essential-Training-2011/81266-2.html?org=cphbusiness.dk), [Regular Expression for validation](https://www.w3schools.com/jsref/jsref_obj_regexp.asp) |
| 5. Document Object Model (DOM) + Form value validation | [DOM tutorial](https://www.w3schools.com/Js/js_htmldom.asp), [Få data fra jsp session/request trukket ud i javascript](https://gist.github.com/Thomas-Hartmann/6e3670165d6528f3ff98a984ce4f4f80#file-jsp2js-jsp) |
| 6. Events og event handling              | [DOM events](https://www.w3schools.com/Js/js_htmldom_events.asp), [Event handler](https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onclick_dom) |
| 7. JS function and callback              | [Callback introduction](http://javascriptissexy.com/understand-javascript-callback-functions-and-use-them/) |
| 8. Lambda i java og Arrow notation i ES6 | [Eksempelkode](https://github.com/HartmannDemoCode/Sem2/tree/master/CallbackInJava) |
| 9. Array.map() og Array.filter i JS.     | [Tutorial om map, filter (og reduce)](https://code.tutsplus.com/tutorials/how-to-use-map-filter-reduce-in-javascript--cms-26209) |
| 10. Functional programming               | [Introduction to functional programming with js](https://medium.com/javascript-scene/master-the-javascript-interview-what-is-functional-programming-7f218c68b3a0) |


In this exercise we use the index.jsp file and the scripts/script.js file to make our solution. 

when you develop with javascript allways have your **browser console** window open to detect any **errors**!!

1. Look at the script.js file: see how the submit event handler is implemented. 
2. Extend it to also validate input from the other input fields (Use the regular expressions to check if the character pattern for the input is right.)
3. Implement the eventhandlers for the 8 of the 10 buttons in the right view pane
   1. consoleLog: Implement the eventhandler so you can write to the browser console: The time is `current time` (Hint get the time like this: ` Date();`
   2. When this button is clicked its color should change. (Hint use 'this' keyword to reference the element behind the event: `this.style.backgroundColor = 'red';`)
   3. Change color in TH: The exercise here is to target all the `<th>` tags by using `document.getElementByTagName`. This will return an array of all elements of type table header. In order to set `.style.color = 'pink'` on each of them. the collection must be looped over. (hint: use a normal for loop).
   4. Make an eventhandler to this button that can hide the logo if it is shown and show it if it is hidden. (Hint: select the surrounding div with id=logo. save the information about its innerHTML (in a variable outside the eventhandler function (only if the variable is empty)). Then if the innerHTML is empty give it the content of the variable - else give it an empty string)
   5. Remove the first row of buttons. Hint: use the surrounding div and set its innerHTML to an empty string;
   6. Look at the implementation of the 'sort by firstname' click event handler. Based on the code in this eventhandler now implement the eventhandler code for the 'sort by lastname' button
   7. In the same way now look at the implementation of 'filter on female' and implement the filter on male button.
   8. Finally implement the 'Sum account' event handler so that we get the sum of all the listed accounts.