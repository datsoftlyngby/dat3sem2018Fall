---
title: '<span id="_3njf2xsd6vkw" class="anchor"></span>Threads day 3 exercise'
...

The example code can be found on github:

[*https://github.com/Cphdat3sem2017f/Threads-3-exercise-code*](https://github.com/Cphdat3sem2017f/Threads-3-exercise-code)

Look at the file SequentialPinger.java in package ex20.

This program takes a list of URL's and makes a HTTP request to the given
URL in order to see if the site is up or not.

But the program has no multi threaded part, and is therefore running all
the checks sequentially. This is a huge bottleneck when the list of
websites grows.

Your job is to wrap the functionality into a ExecutorService, thereby
making the checks work in parallel.

Tasks:

-   Run the program as provided a few times. Time it (either in the java
    > code, or with your phone’s stopwatch).

<!-- -->

-   <span id="_30j0zll" class="anchor"></span>Create an ExcecutorService
    > to handle the tasks.

-   Make a task that takes a URL, and returns a response just like
    > the getStatus() method

-   Print out the status afterwards

-   Time the program again. Consider the performance gain, versus the
    > effort of using an executor service.

Remember to shut down your ExcecutorService after use, otherwise your
program will not terminate.

Hints are provided on the next page:

#### \
***Hints***

This is a step-by-step guide on how to solve the problem. Try **NOT** to
use this all the way. If you get stuck, look at the hints, but continue
on your own afterwards.

-   You need to make a ExecutorService in order for you to run
    > the tasks. Take the FixedThreadPool() variant, with 10 threads
    > (you can always change that afterwards).

-   You need a list of futures of type String to store the futures
    > returned by the executors submit(..) method. These futures will
    > give us the results from our Callables

-   Write a loop; for every URL, extract the URL in a final String
    > object

-   Make a Callable&lt;String&gt; anonymous inner class

    -   In the call() method, copy all the code from getStatus method,
        > and change the url variable with your final String variable
        > created earlier.

-   Submit the task to the executor, and add the returned future to the
    > list of futures.

-   Loop through the list of futures and print out the status of
    > each site. Remember that the response should include the URL, and
    > not only the status.
