package com.stone.beyong.api.start;
public class PortalServer {

	public static void main( String[] args ) throws Exception {
		TomcatBootstrap.start( 8081, Profiles.TEST);
	}

}	