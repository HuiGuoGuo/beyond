package com.stone.beyong.api.start;


import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.scan.StandardJarScanner;

import javax.servlet.ServletException;

/**
 * 创建Tomcat Server的工厂类.
 * 
 * @author 潘瑞峥
 * @date 2014年7月29日
 */
public class TomcatFactory {

	private static final String DEFAULT_WEBAPP_PATH = "/src/main/webapp";

	/**
	 * 创建用于开发运行调试的Tomcat Server, 以src/main/webapp为Web应用目录.
	 */
	public static Tomcat createTomcat( int port, boolean isServlet3 ) throws ServletException {
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir( "target" );
		tomcat.setPort( port );
		Connector connector = new Connector( "HTTP/1.1" );
		connector.setPort( port );
		connector.setURIEncoding( "UTF-8" );
		connector.setUseBodyEncodingForURI( true );
		tomcat.setConnector( connector );
		tomcat.getService().addConnector( connector );

		Context context = tomcat.addWebapp( "", getWebappPath() );
		context.setReloadable( true );
		StandardJarScanner scanner = ( StandardJarScanner ) context.getJarScanner();

		if ( !isServlet3 ) {
			scanner.setScanAllDirectories( false );
			scanner.setScanClassPath( false );
		}
		tomcat.setSilent( true );

		return tomcat;
	}

	/**
	 * 快速重新启动.
	 */
	public static void reloadContext( Tomcat tomcat ) throws Exception {

		tomcat.stop();

		tomcat.start();

		System.out.println( "[INFO] Application reloaded" );
	}

	private static String getWebappPath() {
		return SystemUtils.USER_DIR + DEFAULT_WEBAPP_PATH;
	}

}