package com.phantom.engine;

import com.phantom.engine.log.Logger;

public class EntryPoint {

	public static void main(String[] args) {
		Logger core = Logger.init("core");
		core.addPrintStream(System.out);
		core.setBufferedPrinting(false);
		core.setFileOutput(true);
		
		core.trace("Hello World!");
		if (!core.isBufferEmpty()) {
			core.print();
		}
		core.close();
	}
	
}
