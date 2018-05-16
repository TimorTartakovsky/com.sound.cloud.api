# com.sound.cloud.api

# Configuration of Environment

1) Download and install JDK 9 and make sure HOME_JAVA pointed on the same Java version
2) Download and install Maven version 3.5.0 or higher (tested on v3.5.3)
3) Clone the project in your directory in your PC.
4) Install IDE to work with a project (Intellij and Eclipse are preferable)
5) Download all dependencies using maven.
6) Check if your Apache Tomcat installed on your machine (suggesting Tomcat v.9)

To Run this project open console (terminal) and run several commands.

java -version = should show current version (have to be v9)
javac -version = should show current version (have to be v9)
mvn -version = should show current version (have to be not less then v.3.5.0, the latest is preferable)

Start the program with command: mvnw spring-boot:run

Wait until message that program running successfully on port 8080 or any other following the configuration of a web server 

Program contains two parts one for viewing of the persisted items on web page:

#View part of a program

Open browser and type to search bar of you Chrome ))) or any other browser next url: http://localhost:post/index 

1)http://localhost:post/index 
2)http://localhost:post/
3)http://localhost:post

have to present you only one page for now (Tracks page) where all the retrieved tracks from Sound Cloud API shown.
Links will redirect on the page of Sound Cloud tracker for now.

#API part

Currently supports only: POST, GET, and DELETE http methods. 
All the requests to API should start with /api/and some directory

POST: /api/addTrack
body: {
    "title": "some track title",
    "permalinkUrl": "http://some url"
}

Post request create a new track.

GET: /api/getAllTracks

GET request returns back all the tracks sorted by TITLE.

DELETE: /api/deleteTrack/id/{id} - delete by ID
DELETE: /api/deleteTrack/permalink/{permalink} - delete by permalink


This sound cloud API wrapper created in test by Teymur Tartakovsky  
