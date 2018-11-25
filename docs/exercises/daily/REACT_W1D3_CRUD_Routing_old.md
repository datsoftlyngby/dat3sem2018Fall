---
title: '<span id="_sg98ygdguoy4" class="anchor"></span>Exercise day 4: backend'
...

In this exercise we will continoue working with the datastore. We will
use the jsonserver as backend for convenience. We want to focus on the
frontend and how to implement the 4 CRUD operations with javascript.

  ------------------------------------------------------------------------------------------------------------
  Level   Task
  ------- ----------------------------------------------------------------------------------------------------
          1\. Add a file to the src folder: DataStore.js and inside create a class
          and export the class.

          2\. Give the class a constructor method that sets a property: ‘\_books’
          as an empty array;

          3\. Make a method: loadBooks() that using the javascript fetch() method
          can load all the books from the server into this.\_books variable.
          
          Remember to bind this:
          
          this.loadBooks = this.loadBooks.bind(this);

          4\. Make a method: getAllBooks() that returns the full collection.

          5\. Now test your java class by making a Books component and place it
          inside the render() method of App.js

          6\. Make a method that can retrieve one book based on Id. Test it!

          7\. Make a method that can insert a new book into the collection and on
          to the server. Test it using form fields.

          8\. Make a method that can alter an existing book on the server based on
          id

          9\. Make a method that can delete a book based on the id.

          10\. Change the name of the data store to BookStore and create 2 new
          files called: CustomerStore and OrderStore
          
          Create CRUD operations to enable a system to register orders made by costumers on 1 or more books.

          11\. Create a small web app that can show a list of books and let a
          customer select books (use checkboxes) and create an order. All should
          be stored in the 3 data store objects

          12\. Create the backend using JAX-RS with tomcat
  ------------------------------------------------------------------------------------------------------------
