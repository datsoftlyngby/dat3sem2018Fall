Exercise Day 2: Create-React-App

### Learning:

1.  Basic react app
2.  Class, state, props, render, JSX, binding ‘this’

## Use this tutorial:[here](https://github.com/facebookincubator/create-react-app#getting-started)[*Create-React-App on github*](https://github.com/facebookincubator/create-react-app#getting-started)
or if you want video go [here](https://egghead.io/lessons/react-react-fundamentals-development-environment-setup)
[*egghead.io on react*](https://egghead.io/lessons/react-react-fundamentals-development-environment-setup)

#### 1: Create a photo gallery with 'create-react-app' project
1\. Create a new project based on create-react-app
2\. Check content of the created folder structure. Especially look inside the public, scripts and src folders
3\. Create a new .js file and inside create a class that extends React.Component &lt;/br&gt; Hint: Remember to import React (import React from 'react';) Hint: Remember to export the class
4\. Put some content in the render() method and see if you can get the application to load your component and show the content
5\. Now create an image folder in the 'public' folder and put some images inside
6\. In your new class component add an array of references to the images &lt;/br&gt; Hint: \['image/img1', 'image/img2', ...\]
7\. Let your component loop through the array and show all the image in its render() method
8\. Style your component to give each image a visible border and a padding of 2px.
9\. Change the Component so that it can display only one random image from the collection.
10\. Create a button so that clicking it will change to a new random image on display
11\. Create an ImageHolder component as a functional stateless component, that can have both an image and some text about the image. &lt;/br&gt; hint: use props to send information about the image source and the text to the sub component.
12\. Use this ImageHolder inside the image gallery component from last exercise to show the image plus the text of each image in the gallery
