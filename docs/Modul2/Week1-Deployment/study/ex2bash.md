# Bash scripting exercise
These exercises are based on Ryans bash tutorial <http://ryanstutorials.net/bash-scripting-tutorial/>.

## Task 1 
Write a simple hello world bash script. 
Change it so that it instead of writing "Hello world" writes "Hello <user>" (where user is the name of the current user - which can be found as a variable in bash)
​	
## Task 2
Try to explain to the person next to you what exactly this piece of bash does:

![](../img/bash01.jpg)

## Task 3
Create a script which will print a random word. There is a file containing a list of words on your system (usually /usr/share/dict/words or /usr/dict/words). Hint: Piping will be useful here. 
This exercise is taken from the bottom of this page <http://ryanstutorials.net/bash-scripting-tutorial/bash-variables.php>.

## Task 4
Create a script which will take data from STDIN and print the 3rd line only.
This exercise is taken from the bottom of this page <http://ryanstutorials.net/bash-scripting-tutorial/bash-input.php>.

## Task 5
Exercises from the bottom of <http://ryanstutorials.net/bash-scripting-tutorial/bash-if-statements.php>
Now let's make some decisions.

* Create a Bash script which will take 2 numbers as command line arguments. It will print to the screen the larger of the two numbers.
* Create a Bash script which will accept a file as a command line argument and analyse it in certain ways. eg. you could check if the file is executable or writable. You should print a certain message if true and another if false.
* Create a Bash script which will print a message based upon which day of the week it is (eg. 'Happy hump day' for Wedensday, 'TGIF' for Friday etc).

## Task 6
Create a bash script which will automate setting up the users in your group, installing their ssh keys, and adding them to the sudo group. This will make it easier to delete a droplet and start from fresh.