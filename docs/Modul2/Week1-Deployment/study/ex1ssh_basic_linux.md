# Configure Linux server
You have to do these exercises individually!!

## Task 1 
In order to communicate with the linux machine, you need some software on your own machine. 
For windows you need install git to get access to git-bash. Mac has the necessary programs build in as the mac is in essence a unix machine. 

## Task 2 
Create an ubuntu droplet at digitalocean.com. You can make do with the small one at 5$. It is plenty big for our purposes (what is the minimum requirements for a machine to run ubuntu if it is only a server?) You will be emailed a root password and an IP address to use. You will also be recommended to make a ssh key - for today you will not need it and we will look into that on day 2.

## Task 3 
Use ssh to log into your new linux machine. 
Create a user account for each member in your group, give each user an initial password - changing your password is task 4.
(Follow the first three steps of this guide [Initial server setup](https://www.digitalocean.com/community/tutorials/initial-server-setup-with-ubuntu-14-04)).

## Task 4 
Each group member uses ssh to log into the linux machine from their own computer. Change your password on the linux machine. Log out, and log in again. One of the group members will “forget” their password, and the root user should help recover the account.

## Task 5 
There are many commands which can be learned in unix, and many conventions to learn. We will only touch upon the very basics.  

Each user creates a text file in their home directory using the nano editor. The file should contain at least 5 lines of text. Each user should make a copy of the file, giving it a new name. Each user should make a new folder, and move the copy to this folder. Each user should change the permissions on the folder so that other users on the same machine can see the files within it.

## Task 6 
Using scp copy the file from the Linux machine down to your own machine. Copying files to and from the linux machine is best done from your own machine. Change the file (including the name) on your machine, and put the changed file up on the linux machine in the folder you created.

## Task 7 
Using the command “cat”, combine the files from each group member into one file, and store it in your folder.

## Task 8 
Complete 7 of the 15 exercises in <http://www.thegeekstuff.com/2009/03/15-practical-unix-grep-command-examples/>
- grep is a classic linux command. In particular, try to combine the various options to look for a given pattern in all the user folders.

## Task 9 
All commands in Linux are documented using the command “man” (for manual). Try man on the commands mv, cp, ls. In particular, what option should you give to ls to also show “hidden” files, and what option should be given to see the permissions of each file?

## Task 10

Use scp to move a file from your local mashine to the linux server

(Hint: you can use scp this way: `scp -r /path/to/local/file <username>@<ip address>:/path/on/remote/file`)

