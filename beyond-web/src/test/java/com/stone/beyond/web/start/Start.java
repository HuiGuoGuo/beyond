package com.stone.beyond.web.start;
public class Start {

	public static void main( String[] args ) throws Exception {
		TomcatBootstrap.start( 8080, Profiles.LOCAL);
	}

}