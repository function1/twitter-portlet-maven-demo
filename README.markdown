# Use Maven to create a WCI Portlet

This is an example of how Maven can be used to help manage jar
dependencies to develop a WIC Portlet. This portlet displays a
few of your most recent tweets from Twitter. Please see the the
[Everything Maven Part 2 - Twitter Portlet](http://www.function1.com/2010/03/everything-maven-part-2-twitter-portlet/)
article for more detail.

# Prerequisites
In order to compile and build this code, you'll need the following: 

* [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk6-jsp-136632.html) (version 1.6 or above)
* [Maven](http://maven.apache.org/download.html#Installation)

# Installation

1) Open 'pom.xml', find the xml snippet below, and update with your
twitter login and password

    <properties>
    <!-- Credentials used by the portlet to connect to twitter-->		 
    <twitter.login>Your Twitter Login</twitter.login>
    <twitter.password>Your Twitter Password</twitter.password>
    ...
    </properties>

2) The following command will test to make sure the code can connect
to twitter and retrieve some tweets using the credentials you entered
in the pom. If tests pass, it will build a war under a directory named
'target'.

    mvn install
    
3) Deploy the war file to your portlet server. For example, you can drop the war into TOMCAT_HOME/webapps

4) Import the pte file to create appropriate portal objects (Remote
Server, Web Service, and Portlet) (comming soon)
