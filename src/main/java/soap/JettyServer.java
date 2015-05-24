package soap;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 
 * @author chamerling
 * 
 */
public class JettyServer {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String webappDirLocation = "src/main/webapp/";

		// The port that we should run on can be set into an environment
		// variable
		// Look for that variable and default to 8080 if it isn't there.
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "9191";
		}

		Server server = new Server(Integer.valueOf(webPort));
		
		
		System.err.println ("Starting jetty "+server.getClass().getPackage().getImplementationVersion()+" ...");
		
		WebAppContext root = new WebAppContext();

		root.setContextPath("/");
		root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
		root.setResourceBase(webappDirLocation);

		// Parent loader priority is a class loader setting that Jetty accepts.
		// By default Jetty will behave like most web containers in that it will
		// allow your application to replace non-server libraries that are part
		// of the
		// container. Setting parent loader priority to true changes this
		// behavior.
		// Read more here:
		// http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
		root.setParentLoaderPriority(true);

		server.setHandler(root);
		
		
		
		
		
		
		
		
		
		
		
		ServletHandler handler = new ServletHandler();
 
	FilterHolder filter = new FilterHolder();
	filter.setInitParameter("allowedOrigins", "*");
	filter.setInitParameter("allowedMethods", "POST,GET,OPTIONS,PUT,DELETE,HEAD");
	filter.setInitParameter("allowedHeaders", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
	filter.setInitParameter("preflightMaxAge", "728000");
	filter.setInitParameter("allowCredentials", "true");
	CrossOriginFilter corsFilter = new CrossOriginFilter();
	filter.setFilter(corsFilter);
 
	FilterMapping filterMapping = createFilterMapping("/*", filter);
	handler.addFilter(filter, filterMapping);
 
	server.setHandler(handler);
	handler.addServletWithMapping(JsonServlet.class, "/*");
		
		
		
		
		
		
		
		
		
		
		

		server.start();
		server.join();
	}

}
