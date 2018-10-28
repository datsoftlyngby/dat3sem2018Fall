# React Exercise Week 1 - Day 1:

### ES6 - Create a Data Store

For these exercises we will not use React but pure ES6. In order to
transpile and bundle it easily with babel and webpack we will use
create-react-app. Setup a project with create-react-app in some folder
of your choice: [*Like this*](https://github.com/facebookincubator/create-react-app)

1\. After the folder structure is created - go to the src folder and delete all files except: index.js. Now add a file: Cars.js and inside create a class and export the class.

2\. Give the class a constructor method that sets a property: ‘\_cars’ as an array full of Car objects (a car has id, make, model and year) - (Get car objects
[*here*](https://github.com/Cphdat3sem2017f/React/blob/master/DAT/exercises/Ex1/cars.json)).

3\. Make a method: getAllCars() that returns the full collection.
Remember to bind this:
`this.getAllCars = this.getAllCars.bind(this);`
4\. Now test your java class by importing the class in index.js file.
Make a new instance of the DataStore class and call its getAllCars()
method.

Try to get the cars to show in you html page.

Hint: **const** app = **document**.getElementById(**"root"**);

5\. Make a method that can retreive one car based on id. Test it!

6\. Make a method that can insert a new car into the collection. Test it
using form fields in the index.html page.

7\. Make a method that can alter an existing car based on id

8\. Make a method that can delete a car based on the id.

9\. Remove the export line and add this to your file:

const cars = new Cars();

cars.getAllCars().forEach(function(c) {

console.log(\`\${c.id}, \${c.make}\`); //Observe the use of template literals (\`)

});

9\. Test your methods with node in the terminal/bash:

(in the root of your project) type: node ./src/carStore.js

### Try out some ES6 features
Create a new js page: ES6features.js and paste this into it:
```js
export const text1 = "Hello";
export const text2 = "Hello World";
export const text3 = "Hello Wonderful World";
export default function(str){
return str.toUpperCase();
}
```

Observe how we export "many" *named* values using the export keyword, and a single value using export default. What you export as *default* (only one value pr. File) must be imported like this: import upper from "./dataStore1";

What you export as *named* (non-default) exports will be exported as one single object (containing the three properties text1, text2, text3) and must be included with the Object Destructuring syntax:
`import {text1,text2, text3} from "./dataStore1";`
In one line:
`import upper, {text1,text2, text3} from "./dataStore1";`

Now use upper to print text3 to the console.  
a\) In the src-folder, create a new JavaScript-file *dataStore2.js*, and export an object
```js
export default {
firstName: "Grethe",
lastName: "Hansen",
gender : "Femail",
email: "grethe@hansen.dk",
phone: "12345"}
```
b\) In App.js import this into a const called person

c\) Implement a one-liner (using Object destructuring) to initialize (only) two variables, firstName and email.

d\) import into index.js and print firstname and email to console.

### Test some ES6 features

Play around with arrow functions, let and const, spread operator,
default arguments etc. Get inspiration from
[*here*](https://webapplog.com/es6/)
Arrow function:
Rewrite this to an arrow function:
```js
[‘peter’,’hanne’,’penang’,’hakim’].map(function(e){return `${e} er en person`});
```

### React - Create a gallery

1\. Look at the example in
[*basic.html.*](https://github.com/Cphdat3sem2017f/React/blob/master/DAT/exercises/Ex1/basic.html)

2\. Copy that file and call it: "gallery.html"

3\. Change the props text so that it can describe the type of gallery you
are making (e.g: speedboats or horses or...)

4\. change one of the methods (changeGreen and ChangeRed) so that they
can change the writing to a random text from an array of quotes.

5\. Add 1 more button so that you have 3 buttons in total

6\. change the methods so that you can show a different picture,
depending on which button is clicked. Hint: use require to make static
import of images: &lt;img src={ require('./img/image1.jpg') } /&gt;

7\. Try and see if you can make your app work with just one button (when
clicked it should show the next image allways).

8\. Now move your application into a create-react-app. Do it in a way that your gallery becomes a component, that is loaded into App.js

