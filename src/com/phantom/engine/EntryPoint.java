package com.phantom.engine;

import com.phantom.engine.log.Logger;

public class EntryPoint {

	public static void main(String[] args) {
		Logger core = Logger.init("core");
		core.addPrintStream(System.out);
		core.setBufferedPrinting(true);
		core.setFileOutput(true);
		
		for (int i = 0; i < 10; i++) {
			core.trace(core.getLine());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		core.print();
		core.close();
	}
	
}
