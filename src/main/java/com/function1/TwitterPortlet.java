package com.function1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.PagableResponseList;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

import com.plumtree.remote.portlet.IPortletContext;
import com.plumtree.remote.portlet.IPortletRequest;
import com.plumtree.remote.portlet.PortletContextFactory;

public class TwitterPortlet extends HttpServlet {

	private static final long serialVersionUID = -3418976082322119469L;
	private Properties twitterProps;

	public TwitterPortlet() {
		twitterProps = loadProps();
	}

	protected Properties loadProps() {
		InputStream is = TwitterPortlet.class
				.getResourceAsStream("twitter.properties");
		Properties p = new Properties();
		try {
			p.load(is);
		} catch (IOException e) {
			System.out.println("Unable to find twitter.properties file");
			return null;
		}
		return p;
	}

	public String getPortalUserName(HttpServletRequest request,
			HttpServletResponse response) {
		IPortletContext portletContext = PortletContextFactory
				.createPortletContext(request, response);
		IPortletRequest portletRequest = portletContext.getRequest();
		return portletContext.getUser().getUserName();
	}	
	
	public List<String> getFriendsMostRecentTweet() {
		List<String> tweets = new ArrayList<String>();
		String senderID = getTwitterLogin();
		String senderPassword = getTwitterPassword(); 

		Twitter twitter = new TwitterFactory().getInstance(senderID,
				senderPassword);
		PagableResponseList<User> statuses;
		try {
			statuses = twitter.getFriendsStatuses();
			for (User nextTwitterUser : statuses) {
				String tweet = nextTwitterUser.getStatusText();
				if(tweet==null || tweet.trim().length()<=0 || tweet.trim().toUpperCase().equals("NULL")){
					// don't add to list
				} else {
					tweets.add(nextTwitterUser.getName() + ": "
						+ nextTwitterUser.getStatusText());
				}
			}
		} catch (TwitterException e) {
			System.out.println("Unable to retrieve tweets");
			return null;
		}
		return tweets;
	}
	
	public String getTwitterLogin(){
		return twitterProps.getProperty("twitter.login");
	}
	
	public String getTwitterPassword(){
		return twitterProps.getProperty("twitter.password");
	}
}
