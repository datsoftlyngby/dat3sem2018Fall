# Executors, Callables and Futures.

### Initial setup
Copy the start code from file on [*github*](https://github.com/Cphdat3sem2018f/week1-threads/blob/master/code/SequentialPinger):

Create a new plain Java Maven Project, and add the SequentalPinger class to the project.

The program include a list of URL's, and performs a HTTP request up
against each URL to check whether the site is up or not.

The code, as given, has no multi threaded part, so all checks are
executed sequentially. This is a problem (how big, is up to you to
figure out) when it comes to performance (time) when the list of
websites grows.

Your task is to wrap the functionality into an ExecutorService, making all checks work in parallel.

### Tasks
- Run the program, as provided, a few times. Time it and write down the result(s).
```java
long startTime = System.nanoTime();
methodToTime(.........);
long endTime = System.nanoTime();
long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
```
- Create a new version of the program that uses an ExecutorService, Callables and Futures in order to handle the problem in “parallel”.
- Print the status of all tasks. Make sure to print both the url + status
- Time the program again. Reflect on difference in performance (time) for the two strategies (sequential vs parallel).

Remember to shutdown the ExecutorService when done, otherwise your
program will not terminate.

##### Hints
- Use something like [*example*](https://www.journaldev.com/1090/java-callable-future-example) as template for your solution.
- Move all content from the getStatus() method into the call() method of your `Callable<String>` class.

##### Yellow
If you notice that some of the sites take too long time to make their
response you could set a timeout value, since this will slow down your whole application.
You can set a timeout value on the connection object (preferably) via its `setConnectTimeout()` method, or you can use the get method on a Future that takes a timeout value.

If you implement this option, make sure to add an extra status value
"TIMEOUT" which must be reported in these cases (together with the
URL)

### Exercise 2 (do this only if you have the time)

We have seen in the exercise above, that using Callables and Futures, we can get results in the order the task where started.

**a)** Rewrite **exercise 2, day 2** to use this strategy, instead of the original "Producer Consumer" design.

**b)** Time the two solutions, which one is fastest?

**c)** Just because (if) one is faster than the other, does this always mean it's better?
