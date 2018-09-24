# CSS Cascading Style Sheet
## CSS purpose:
Presentation of the content of a markup document to the user
- Create look and feel
- Manipulate
    - color
    - fonts
    - layout
    - etc...
- Seperate content from presentation
- 3 ways
    1. inline css
    2. internal styles
    3. external style sheet
- Selectors
    1. id is made with a `#` tag     
      e.g. `#customer` in css and `<div id="customer">` in html  
    2. class is made with a `.`  
      e.g. `.customers` in css  
      `<div class="customers">` in html
    3. html tag names like this
      `div img{ ... }` selects all img that is inside a div element.

#### Inline CSS
```html
<h1><font color="red"> Chapter 1. </font></h1>
```
#### Internal CSS
```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <style>
        div { border: solid 1px blue; }
        .red { background-color: red; }
    </style>
  </head>
  <body>
    <p id="xyz" style="color: green;"> To demonstrate specificity </p>
  </body>
</html>
```
#### External CSS
In a separate document called e.g.: style.css
```css
 div { border: solid 1px blue; }
.red { background-color: red; }
```
In html document we link to the CSS document in the head section of the html
```html
<html>
  <head>
    <meta charset="utf-8">
   <link href="path/to/file.css" rel="stylesheet" type="text/css">
  </head>

```
## Usefull styles

```css
/* reset to counter different browsers default settings */
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed,
figure, figcaption, footer, header, hgroup,
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
  margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* set border of div or anything else */
div { border: solid 1px blue; }
/* use class as . to hit different html elements */
.redborder {
    border: solid 3px red;
}
/* use id as # to hit specific element*/
#container{
    
}
```