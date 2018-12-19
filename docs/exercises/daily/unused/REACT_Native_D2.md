**React Native, Day-2**![](media/image1.png){width="2.0613681102362205in" height="1.7178073053368328in"}
========================================================================================================

This will be a “have fun” day
-----------------------------

First, if not already done, complete the Facebook tutorial introduced
day-1.

1) All the fun :-)
------------------

Navigate into the Expo
[*docs*](https://github.com/Cphdat3sem2017f/StartcodeExercises/blob/master/ReactNative/TutorialStart.js),
and start to play around with the examples, given under the “SDK API
Reference”.

The docs provides bunches of amazing, almost ready to just paste into an
new app, examples of how to use the hardware features on your phone.

Try to (but don’t limit yourself to only this) use the:

-   Camera

-   BarCodeScanner

-   Accelerometer

-   ImagePicker

-   Location

-   Video

-   And much more ;-)

This should hopefully convince how much we can do with Expo/React Native
even after only two days ;-)

### How to get Studypoints for this part

[]{#_px2igy3lipc1 .anchor}Open a project in your editor, open App.js and
replace ALL code in this file with the this code:

[]{#_6z1vg7ftlswj
.anchor}[*https://github.com/Cphdat3sem2017f/StartcodeExercises/blob/master/ReactNative/TutorialStart.js*](https://github.com/Cphdat3sem2017f/StartcodeExercises/blob/master/ReactNative/TutorialStart.js)

[]{#_h9h1beauu14 .anchor}This is the same code used for the Facebook
tutorial yesterday. Change it so it can hold 4-5 examples, which is what
you have to demo.

2) Apps with a Backend
----------------------

[]{#_z1waoikvpdxr .anchor}Most (many) app’s does not really “shine”
unless they have a supporting backend. Create a quick JAX-RS backend
which can show a list of uploaded data (you decide for the data, but it
must eventually come from the phone. We suggest location data).

[]{#_vr9u02sundb5 .anchor}For this exercise you can do without a
database, and just use an in-memory list to store data.

[]{#_4cbgl7vakqzs .anchor}**2a)** Implement a simple react application
which can load data from the server via a Rest-API and render the data
in a **ul**, **table** or whatever you prefer.

[]{#_p7tgxlw7br04 .anchor}**2b)** Implement a simple POST REST endpoint,
which should allow a client to upload new data.

[]{#_yfk3rr8v8bzk .anchor}**2c)** Implement a simple app which should
read some information from the phone (location data) and upload the data
to the server (when user presses a touchable)
