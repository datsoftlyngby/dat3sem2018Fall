# React Native with Expo
### Getting started

Install the required Expo tools as explained
[*here*](https://docs.expo.io/versions/latest/introduction/installation.html)
(you don’t need to install an emulator, if you have an up-to-date
phone). Please note that you have to install tools both on your computer
and on your phone.

### First project 
**1a)** Initial commands:  

- `sudo npm install -g expo-cli` Installing the expo tools globally - Just do this once.
- `cd to/desired/project/location`
- `expo init` Create a new react native app -> use the **blank** template and provide a name.
- `cd react_native_demo/` enter the newly created project
- `expo start` Start the project and scan the QR code with the Expo app on your phone.
 
- Follow the steps given in this "[*Up and Running*](https://docs.expo.io/versions/latest/guides/up-and-running.html)"
guide and verify that you can create the project, install and execute it
on your device (via the Expo-app), and change the project code in your
IDE/editor.

- Scan the provided QR-code with the Expo app on your phone, and verify that "it works".

**2a)** Debugging

Skim these links:
- Expo [*Development Mode*](https://docs.expo.io/versions/latest/guides/development-mode.html)
- Expo [*Debugging*](https://docs.expo.io/versions/latest/guides/debugging.html) (skip simulators, unless you're on a Mac)
- Facebook [*debugging*](https://facebook.github.io/react-native/docs/debugging.html)

**2b)** Publishing 

[*This*](https://docs.expo.io/versions/latest/guides/publishing.html) is
how you are expected to hand-in "deployed" react native assignments.
(You dont have to but If you want to put it on app store: Just read the two
first sections, *Publishing* and *How to Publish*)

**3)** Learn the Basics
The main exercise for today is this [*Facebook tutorial*](https://facebook.github.io/react-native/docs/getting-started.html).

You should really do your best to complete all of it before the
end of today, it will also serve as a perfect recap on most of the
general React terms introduced last week.

### Part 2 - navigation
Create a new react native app with `expo init`
**1)** Open the project in your editor, open App.js and replace ALL code in this file with this code:  [*App.js*](https://raw.githubusercontent.com/Dat3SemStartCode/scripts_unrelated/master/JS/App.js)

**Important:** in the root of your project, install react-navigation with either npm or yarn
like: `npm install react-navigation` **or**  `yarn add react-navigation`

**2)** Type `npm start` and load the app into the Expo-client on your phone
**3)** Spend a few minutes before you start with this App, and make sure you understand the provided code (most of it, is Todo’s which you should delete when the
corresponding step is completed)

**Hints:** The sample code provided above, use the StackNavigator from the React Navigation package. There are many Router/navigation-frameworks out there for React Native. This one seems to “be the one” backed up by most of the community, including [*facebook*](https://facebook.github.io/react-native/docs/navigation.html)
and [*Expo*](https://docs.expo.io/versions/v28.0.0/guides/routing-and-navigation#__next).
The example gives you “all” that is required related to routing and react-native for this semester, but if you want to dig deeper, take a look at the tutorial on the [*React
Navigation*](https://reactnavigation.org/docs/en/getting-started.html)
website.

#### **How to demo this exercise**

When you hand-in your agenda this Friday, for the Monday review, you should include these urls:
1. One for the github repository that host your code
2. One for the deployed version of the code (like in this [*demo*](https://expo.io/@lars/blank)
3. Apps with a Backend - Many apps do not really “shine” unless they have a supporting backend. Create a quick JAX-RS backend which can show a list of uploaded data. You decide which data to use, but it must eventually come from your phone. We suggest location data.
For this exercise, you can do without a database on the backend, and just use an in-memory list to store data.

**2a)** Implement a simple react application which can load data from the server via a Rest-API and render the data in a **ul**, **table** or whatever you prefer.

**2b)** Implement a simple POST REST endpoint, which should allow a client to upload new data.

**2c)** Implement a simple app which should read some information from the phone (location data) and upload the data to the server (when the user presses a touchable, or constantly, using JavaScripts setTimeOut)

**Hint:** Use [*ngrok*](https://ngrok.com/) to host your backend, while you are developing

Put this file into your project [*TutorialStart.js*](https://raw.githubusercontent.com/Dat3SemStartCode/scripts_unrelated/master/JS/TutorialStart.js).Go to Expos “SDK API Reference” and play around with the examples, given here.

The docs provide bunches of amazing, almost ready to just paste into a new app, examples of how to use the hardware features on your phone.

Try to (but don’t limit yourself to only this) use the following components:
- Camera
- Barcode scanner
- Accelerometer
- ImagePicker
- Location
- Video
- And much more

This should hopefully convince you about how much we can do with Expo/React Native, even after only two days.

#### How to hand in/demo this exercise
If you want de demo and receive feedback on this exercise next Monday, include a link to the code on github + a link to the app on Expo, so anyone can install the
app. 
