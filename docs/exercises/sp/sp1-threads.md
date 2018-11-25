# SP 1: Threads
 
**Before you start**
 
- Make sure you are in a group.
- Make sure, before Friday 16.00, that you have decided a strategy for who presents which learning objectives at the review on monday, and remember to add this info to the review-plan.

## Part 1

Make sure you have completed all exercises (relative to your
colour-ambition) from day 1-3  
[Day 1](../daily/THREADS-1_basics.md)  
[Day 2](../daily/THREADS-2_prod_cons.md)  
[Day 3](../daily/THREADS-3_callables.md)  

## Part 2

[Exam preparation 1: Threads and sockets](../exam_prep/exprep_threads_socket.md)  
[Exam preparation 2: Producer Consumer pattern](../exam_prep/exprep_threads_prod_cons.md)  

These are what we call an “exam preparation exercise”. It is meant to represent the “level” and “form” of what you can get for the real exam.

## Part 3 (race condition) 
*Red Only*

Execute the main code in either [BankApp.java](BankApp.java) or [BankAppExecutor.java](BankAppExecutor.java)

The program includes a method `executeTransactions()` which executes a series of transactions on a shared account object and prints true/false depending on the expected outcome.

- Identify places in the code where it "goes wrong".
- What should the closing balance be?
- Experiment: Increase the number of calls of executeTransactions () or
the number of threads and observe the effect.
- Observe that there are two versions of the main() method, one that creates threads in a traditional way, and one using an ExecutorService (the recommended way).

Solve the problem in the Bank program:
1) Using the traditional synchronization
2) Using a java.util.concurrent.locks.ReentrantLock
