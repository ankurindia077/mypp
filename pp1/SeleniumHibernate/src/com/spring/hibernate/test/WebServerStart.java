package com.spring.hibernate.test;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.MovedContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.StdErrLog;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class WebServerStart {
	
	
	 
	public static void main(String[] args) throws Exception {
		 Server webServer;
		 
		// Launch Protractor's own test app on http://localhost:8080
        ((StdErrLog) Log.getRootLogger()).setLevel(StdErrLog.LEVEL_OFF);
        webServer = new Server(new QueuedThreadPool(6));
        ServerConnector connector = new ServerConnector(webServer, new HttpConnectionFactory());
        connector.setPort(8080);
        webServer.addConnector(connector);
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{"index.html"});
        resource_handler.setResourceBase("src/com/spring/hibernate/test/webapp");
        HandlerList handlers = new HandlerList();
        MovedContextHandler effective_symlink = new MovedContextHandler(webServer, "/lib/angular", "/lib/angular_v1.2.9");
        handlers.setHandlers(new Handler[] { effective_symlink, resource_handler, new DefaultHandler() });
        webServer.setHandler(handlers);
        webServer.start();

	}

}
