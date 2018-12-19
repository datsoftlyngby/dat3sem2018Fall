Exercise - File upload Service, with a Web/App Client
-----------------------------------------------------

This exercise is meant to give you inspiration/examples for some of the
things you are expected to do in the Semester Project and in CA-3.

The exercise will guide you through the following steps:

-   How to create a JAX-RS endpoint to upload files (images)

-   How to use ngrok.com to set up a tunnel so you, while developing,
    > can access your localhost services from anywhere on the planet
    > (here, just from your phone ;-)

-   Create a simple React Native Client, used to provide access to the
    > phone’s photo library, where you can select an image and upload it
    > to your server, using the endpoint create in step-1

### 1) Image Upload Service

**1a)** Create a new NetBeans Maven Web Project – fileUpload

[]{#_4im246owpp63 .anchor}**1b)** Add the following dependencies to the
pom-file:

[]{#_gjdgxs .anchor}

&lt;dependency&gt;

&lt;groupId&gt;org.glassfish.jersey.media&lt;/groupId&gt;

&lt;artifactId&gt;jersey-media-multipart&lt;/artifactId&gt;

&lt;version&gt;2.26&lt;/version&gt;

&lt;/dependency&gt;

&lt;dependency&gt;

&lt;groupId&gt;org.glassfish.jersey.bundles&lt;/groupId&gt;

&lt;artifactId&gt;jaxrs-ri&lt;/artifactId&gt;

&lt;version&gt;2.26&lt;/version&gt;

&lt;type&gt;zip&lt;/type&gt;

&lt;/dependency&gt;

**1c)** Use the Wizard to create a new Jax-RS service” the usual way”.
Use the following values:

-   **path** "upload"

-   **Class Name:** UploadResource

-   Set the start part (for all end-points) to "api" in
    > ApplicationConfig.java

**1d)** Remove the generated endpoints from the generated class, and
paste in the following code:

//IMPORTANT: Replace with a unix path when uploading to Droplet and set
permissions on the folder

public static final String **FILE\_LOCATION = "C://img/";**

@Path("/file")

@POST

@Consumes(MediaType.MULTIPART\_FORM\_DATA)

public Response uploadFile(@DefaultValue("") @FormDataParam("user")
String user,

@FormDataParam("file") InputStream file,

@FormDataParam("file") FormDataContentDisposition fileDisposition)
throws IOException {

System.out.println("Just to show how to send additonal data: "+ user);

String fileName = fileDisposition.getFileName();

saveFile(file, fileName);

String status = "{\\"status\\":\\"uploaded\\"}";

return Response.ok(status).build();

}

private void saveFile(InputStream is, String fileLocation) throws
IOException {

String location = FILE\_LOCATION + fileLocation;

try (OutputStream os = new FileOutputStream(new File(location))) {

byte\[\] buffer = new byte\[256\];

int bytes = 0;

while ((bytes = is.read(buffer)) != -1) {

os.write(buffer, 0, bytes);

}

}

}

**1e)** Open the file: ApplicationConfig and enter this line in the
getClasses method (around line 23):

resources.add(MultiPartFeature.class);

**1f)** Create the folder given in **FILE\_LOCATION** (or replace the
suggested folder with your own)

**1g)** Replace the content of index.html with the code below:

&lt;!DOCTYPE html&gt;

&lt;html&gt;

&lt;head&gt;

&lt;title&gt;Upload File&lt;/title&gt;

&lt;meta http-equiv="Content-Type" content="text/html;
charset=UTF-8"&gt;

&lt;/head&gt;

&lt;body&gt;

&lt;h2&gt;Upload file&lt;/h2&gt;

&lt;form action="api/upload/file" enctype="multipart/form-data"
method="post"&gt;

&lt;label&gt;Select File&lt;/label&gt;&lt;input type= "file" name="file"
/&gt; &lt;br/&gt;&lt;br/&gt;

&lt;button id="btn"&gt;Upload&lt;/button&gt;

&lt;/form&gt;

&lt;script&gt;

document.getElementById("btn").onclick = save;

function save(e) {

var input = document.querySelector('input\[type="file"\]');

var data = new FormData();

data.append('file', input.files\[0\]);

data.append("user", 'WEB User');

fetch('api/upload/file', {

method: 'POST',

body: data

});

e.preventDefault();

}

&lt;/script&gt;

&lt;/body&gt;

&lt;/html&gt;

**1h)** Execute the project, test and verify that you can upload files
via the endpoint "api/upload/file"

### 2) Open your localhost server to the "whole world"

Before we can use this service from a phone, it must either be deployed
(which is cumbersome while we are developing), or we have to find a way
to "open" your currently running localhost service to the outside world.

**2a) Using ngrok**

[*ngrok*](https://ngrok.com/) is probably the coolest service that exist
for app+backend developers. It will allow you to open your currently
running download service with a simple command like this: **ngrok http
8084** (assuming you are using 8084).

Download and install it as explained
[*here*](https://ngrok.com/#download). Unless you plan to set the path
permanently, I suggest to install in a folder close to the root.

2b) Verify that you can access your index.html file via one the two
forward addresses (http or https) given after you run this command:
**ngrok http 8084**

Before you complain that this does not work, make sure to copy/paste the
url.

If you do this in the class, verify that you can access servers running
other laptops (using their public address)

How cool is this ;-)

### 3) React Native Client to upload images via your new Upload Service

Since you now have "public" access to the service running on your
laptop, you are ready to test the upload service again, this time from a
mobile device. This exercise will implement a simple client which will
let you select and upload an image from the photo library on your phone.

**3a)** Create a new project with either the Expo XDE tool, or
create-react-native-app

**3b)** Use your browser to navigate to Expo's image picker example:
[*https://docs.expo.io/versions/latest/sdk/imagepicker.html*](https://docs.expo.io/versions/latest/sdk/imagepicker.html)

Copy all content from the example into the clipboard, and replace ALL
content in App.js in you newly created project.

Execute the example on your phone, and verify that you select, and show,
an image from your photo library.

**3c)** The string returned from the \_pickImage method is all we need
to upload this image to your new service, since the JavaScript version
provided by React Native also ships with the FormData object.

**3d)** Copy/paste the following method into App.js (in a real app you
would probably make a façade class):

\_uploadImage = (uri) =&gt; {

this.setState({uploading : true});

//Replace me with your ngrok forward url (each time you restart ngrok)

**let apiUrl = "http://ea681b42.ngrok.io";**

const apiURL = apiUrl + "/fileUpload/api/upload/file";

let uriParts = uri.split('.');

let fileType = uriParts\[uriParts.length - 1\];

let fileName = uri.split('/').pop();

let formData = new FormData();

formData.append('file', {

uri: uri,

name: \`photo.\${fileName}\`,

type: \`image/\${fileType}\`,

});

formData.append("user","Mobile User (just to show it can be done)");

let options = {

method: 'POST',

body: formData,

headers: {

Accept: 'application/json',

'Content-Type': 'multipart/form-data',

},

};

return fetch(apiURL, options).

then((res) =&gt; {

let status = res.ok ? "Image uploaded successfully" : "Failed to upload
image";

this.setState({ status,uploading:false })

}).catch((err)=&gt;{

this.setState({status:"Failed to upload image",uploading:false })

});

}

**IMPORTANT**: Replace **apiURL** above, with your ngrok forward
address.

**3e)** Add a new upload button to the render() method, and call the
method above with image url provide when you selected an image.

**3f)** Verify that you can upload an image

**3g)**

The upload example given above provides two state variables, which you
can use to make your UI more user friendly.

React Native provide a component ActivityIndicator (shows a spinner)
which you can activate while uploading. Use this, and provide a Text
field with status info about the upload-
