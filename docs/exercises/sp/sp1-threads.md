---
title: '[]{#_dm6h62ksxhp .anchor}SP-1 Threads - Day 4+5'
---

Before you start
----------------

-   Make sure you are in a group.

-   Make sure, before Friday 16.00, that you have decided a strategy for
    > who presents what, next monday, and remember to add this info to
    > the review-plan.

Part-1
------

Make sure you have completed all exercises (relative to your
colour-ambition) from day 1-3, before you start with the the following.

Exercise 1 (race condition)
---------------------------

![](media/image4.png){width="5.021367016622922in"
height="1.4520745844269467in"}

Use the code in the package day1.turnstiles as start code for this
exercise. This program simulates a large football stadium with many
turnstiles that each updates a shared counter, for each spectator that
passes a turnstile.

Initially, the code is setup to simulate 40 turnstiles, each (running in
a separate thread) simulates that 1000 spectators pases.

Execute the code and observe the result of the shared counter.

Questions/tasks:

**a)** Do you get the right result?

**b)** What is the problem in the code? (It’s there whether you get the
right result or not)

**c)** Solve the problem using synchronization techniques.

Exercise 2 ![](media/image3.png){width="2.425in" height="0.5215277777777778in"}
-------------------------------------------------------------------------------

[*Is
here*](https://docs.google.com/document/d/13f18buNu2WgTocikJ2Quj6TaetkujWouRCaibq2VCu8/edit?usp=sharing)

This is what we call an “exam preparation exercise”. It is meant to
represent the “level” and “form” of what you can get for the real exam.

Exercise 3 (race condition) Red Only

Execute the main code in either day1.bank.BankApp.java or
day1.bank.BankAppExecutor.java

The program includes a method executeTransactions () which executes a
series of transactions on a shared account object and prints true /
false depending on the expected outcome.

Identify places in the code where it "goes wrong".

What should the closing balance be?

Experiment: Increase the number of calls of executeTransactions () or
the number of threads

and observe the effect.

Observe that there are two versions of the main() method, one that
creates threads in a traditional way, and one using an ExecutorService
(the recommended way).

Solve the problem in the Bank program:

1)  Using the traditional synchronization

2)  Using a java.util.concurrent.locks.ReentrantLock
