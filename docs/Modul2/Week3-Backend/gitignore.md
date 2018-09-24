# Git ignore files
When we are developing java code we are using the netbeans editor. When we are more people working on a project, git and github is useful to allow a group of people to work together on the development.

But both netbeans and Java relies on a number of files which are not intended to be shared between developers. These files need to be ignored when one **add** files to the git repository. I will briefly explain which files that is, and how to ignore them.

## Java files which should be ignored
What we should share is the source code stored in .java files. When we build our Java projects, a number of compiled files are produced. These are:

- .class (at least one for each source file)

Besides, in J2EE applications, modules are packaged as EAR, JAR and WAR based on their functionality. We will only see the first two:

1. JAR: EJB modules which contain enterprise java beans (class files) and EJB deployment descriptor are packed as JAR files with .jar extenstion
2. WAR: Web modules which contain Servlet class files, JSP Files, supporting files, GIF and HTML files are packaged as JAR file with .war (web archive) extension
3. EAR: All above files (.jar and .war) are packaged as JAR file with .ear (enterprise archive) extension and deployed into Application Server.

Thus, for the Java part, we need to include the following lines in the *.gitignore* file:

```
*.class
*.jar
*.war
*.ear
```

## Netbeans files which should be ignored
A netbeans project is organised into a number of folders and a few top-level folders:

- src, test, web: these folders contain your source code, these are what we really want to share
- build.xml: this file contain information about how the program is to be compiled and build. To avoid confusion, it is necessary that all members of a group compile the project the same way, hence this file is shared.
- The compiled versions of the program goes into the folders _build/_, _nbbuild/_, _dist/_ and _nbdist_. These folders should **not be shared**.
- The _nbproject_ folder contains more detailed info on how to build and compile the project, the files in this directory should be shared.
- In the _nbproject/private/_ folder is stored a few elements which relates to your personal setup of netbeans (even though you have not made any personal changes!). The files in this directory should **not be shared**

The gitignore for netbeans should then look like this:

```
nbproject/private/
build/
nbbuild/
dist/
nbdist/
```

### An assumption made on gitignore.io
Many have used gitignore.io to produce a gitignore file. That should work, but those who made the file for netbeans assumed one would always let the netbeans project be the top-level of a git repository. The netbeans part of the .gitignore file should look like this in general:

```
**/nbproject/private/
**/build/
**/nbbuild/
**/dist/
**/nbdist/
```

The _**/_ says to ignore these folders independent of where in the the git project they are located.

## Mac or Windows ignore files
Both of these operating systems have their own set of files which should be ignored. The files gitignore.io produce for these two operating systems are fine and can be used.

### If you make many git projects
Some think that the _.gitignore_ file should contain only those files which are specific to the project, and not those which are specific to the operating system. 

If you think that sound right, you can put the operating system specific ignore parts into **the global ignore file**. See this file for more help: <https://help.github.com/articles/ignoring-files/>



