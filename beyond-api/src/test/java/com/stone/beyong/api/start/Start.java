package com.stone.beyong.api.start;
public class Start {

	public static void main( String[] args ) throws Exception {
		TomcatBootstrap.start( 8081, Profiles.LOCAL);
	}

}	