# Exercise 1:

This exercise is about making a web application, that will allow users to upload their recipes and to see a list of recipes and and see a specific recipe, when a user clicks on an item in the recipe list view. Recipes must contain ingredients and instructions and they can contain images and ratings.

Create a **maven** web application that can register recipes from users. 
HINT: in maven project we handle dependencies via POM.XML file. To get a connection to the database the following needs to be in the POM.XML file:

```xml
<dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-java</artifactId>
     <version>5.1.39</version>
</dependency>
```

For examples and reference code see [Sem2 demo code base](https://github.com/HartmannDemoCode/Sem2). (Especially these projects: DataMapper, ServletDemo, jspdemo).

## 1. Persist in database

1. Create an E/R diagram of the entities and their relationships
2. Create the necessary tables and foreign keys in a database to persist the recipe data.
3. Create the necessary java classes to hold the entities. These entity classes are DTOs that we use to transport data from the data layer to the presentation layer and back.
4. Fill some dummy data in the database.
5. Make a data mapper class, so that database tuples can be retrieved from the database and objects be created. E.g methods like `getIngredientsByRecipe(r_id): List<Ingredient>` , `getAllRecipes(): List<Recipe>` `getRecipeByName(String name): Recipe`  and `createRecipe(String instruct, List<Ingredient> ing): void`.
6. Add structure to the database, so that images of the food can be shown (Hint: Images are put in files and the path to the file is stored in the db table.

## 2. Create the Control (servlet)

1. Make a new servlet that has an instance of the Mapper class. 
2. Let the servlet read the request property: 'origin' (when it is passed in the request from one of the views).
3. Make a switch statement in the control so that based on the origin content we can do different things
4. In case the origin is: 'getrecipes', we should be able to let the mapper get a List of all recipes.
5. Add the recipe list to the session object.
6. Forward the request to a new page called: showallrecipes.jsp.

## 3. Create the showrecipes view (jsp page).

1. Create a jsp page (showrecipes.jsp)  that can show all the recipe names in a formatted user friendly manner.
2. Make all the recipes clickable. Use a get request to tell the server what recipe was clicked. (Hint: use a link element with parameters to show which recipe `<a href="Control?origin=showRecipe&recipe_id=3">chocolate mouse</a>`).
3. Create a jsp page that can show a single recipe (showrecipe.jsp) when it was clicked from the previous page. (How would we get the information about the recipe onto this page? hint: grap it from the session that now has a list of all recipes)
4. Make the functionality in the servlet to forward to the showrecipe.jsp when a user clicks a recipe in the showrecipes.jsp view.
5. **Sort** the recipes by name in the view showrecipes.jsp.  
6. (GUL) Create a collection to html converter class, that can show all recipes in a structured manner. This converter should be used by showrecipes.jsp to show recipes in table style with name, date, rating in 3 columns. (Extend the Recipe class and the database to hold this information).
7. (RØD) Make the converter class in a way, so that it can sort the output by each of the 3 columns based on an input string. If you feel like it try using java stream and lambda to achieve the sorting. (Hint: [Read about it here](https://www.leveluplunch.com/java/tutorials/007-sort-arraylist-stream-of-objects-in-java8/)).
8. (RØD) Edit recipe: Create a button in  the recipe details page that loads the recipe into form elements so data can be edited. And create the necessary code on the servlet and data mapper to support this action.

## 4. Create a recipe registration page.

1. Create an html **form** in a file called: **addrecipe.jsp**. to get ingredients and instructions from the users
   - add an input field for a name for the recipe (to use in lookup)
   - add a text area so the user can write ingredients and amounts (separated by semi colon)
   - Provide another text area to input instructions in the recipe
   - Add a hidden field: name=origin value=addrecipe.
2. Extend the functionality of the servlet so when origin=addrecipe we can grap the data from the request parameters and (by the help of the data mappers `createRecipe()` method) insert them in the database.
   1. (GUL) The information about ingredient comes in a format separated by semi colon, so it needs to be split in order to collect a list of ingredients and how much of it is needed (Hint: make an ingredient class to hold the information)
3. Now test that you can upload a recipe to the server from the web form.
4. (GUL) Add a dropdown box in the addrecipe.jsp so the user can choose how many ingredients are in the recipe. Add a button for the user to commit this information to the servlet. Let the servlet reload the addrecipe.jsp page with the number of input text boxes needed to fill in the ingredients. Now on the servlet change the behaviour to take data from the generated input fields (Hint: when creating the input fields make sure they get different names like ingredient1, ingredient2 etc.)

## 5. (RØD) Images in database

1. Store pictures of the dishes in an img folder.
2. Insert the path to the the images in the database.
3. Add a field to contain a list of images in the Recipe class and change methods in the data mapper to deal with images.
4. Change the showrecipe.jsp to show images with the recipe.
5. (MØRKERØD) Create a picture upload button on each recipe
   - when clicked the user should be able to upload additional images
   - these additional images should be shown too when the recipe is requested.
     hint: see [tutorial here](http://www.tutorialspoint.com/servlets/servlets-file-uploading.htm)) Images in database

1. Store pictures of the dishes in an img folder.
2. Insert the path to the the images in the database.