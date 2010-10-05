<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.function1.TwitterPortlet, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Twitter Portlet</title>
</head>
<body>
<div>
<% TwitterPortlet twitterPortlet = new TwitterPortlet(); %>
<p>Get the Currently Logged in Portal User using the IDK:</p>
<p>Hello, <%= twitterPortlet.getPortalUserName(request, response) %></p>
</div>
<div>
<p>Now, get the most recent tweets from all your twitter friends
(remember to set up your twitter login and password in pom.xml):</p>
<ol>
	<%
			List<String> tweets = twitterPortlet.getFriendsMostRecentTweet();
			for(String nextTweet : tweets){
		%>
	<li><%= nextTweet %></li>
	<% }%>
</ol>
</div>


</body>
</html>