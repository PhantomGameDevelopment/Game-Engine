package com.phantom.engine;

import com.phantom.engine.log.Logger;

public class EntryPoint {

	public static void main(String[] args) {
		Logger core = Logger.init("core");
		core.setBufferedPrinting(true);
		core.setFileOutput(true);
		
		core.trace("Hello World!");
		core.print();
	}
	
}
