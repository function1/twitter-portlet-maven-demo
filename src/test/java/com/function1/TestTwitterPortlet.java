package com.function1;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class TestTwitterPortlet extends TestCase {
	protected void setUp() {
	}

	protected void tearDown() {

	}

	@Test
	public void testSimple() {
		assertTrue(true);
	}

	@Test
	public void testJavaProperties() {
		TwitterPortlet twitterPortlet = new TwitterPortlet();
		assertNotNull(twitterPortlet.getTwitterLogin());
		assertTrue(twitterPortlet.getTwitterLogin().trim().length()>0);
	}
	
	@Test
	public void testGetFriendsMostRecentTweet(){
		TwitterPortlet twitterPortlet = new TwitterPortlet();
		List<String> messages = twitterPortlet.getFriendsMostRecentTweet();
		assertNotNull(messages);
		assertTrue(messages.size()>0);
	}
}
