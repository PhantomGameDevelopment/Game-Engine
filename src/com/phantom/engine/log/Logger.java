package com.phantom.engine.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Logger {
	
	private static Map<String, Logger> loggers = new HashMap<String, Logger>();
	private String name;
	private boolean fileOutput = false;
	private boolean bufferedPrinting = true;
	private File output;
	private FileWriter writer;
	private StringBuilder buffer;
	
	private Logger(String name) {
		this.name = name;
		buffer = new StringBuilder();
		output = new File("output.log");
		try {
			writer = new FileWriter(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		loggers.put(name, this);
	}
	
	@Override
	public void finalize() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Logger init(String name) {
		return new Logger(name);
	}
	
	public static Logger getLogger(String name) {
		return loggers.get(name);
	}
	
	public void trace(Object message) {
		String msg = "[" + name.toUpperCase() + "] [TRACE] " + message + "\n";
		if (bufferedPrinting) {
			buffer.append(msg);
		} else {
			System.out.println(msg);
			try {
				if (fileOutput) {
					writer.append(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void debug(Object message) {
		String msg = "[" + name.toUpperCase() + "] [DEBUG] " + message + "\n";
		if (bufferedPrinting) {
			buffer.append(msg);
		} else {
			System.out.println(msg);
			try {
				if (fileOutput) {
					writer.append(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void info(Object message) {
		String msg = "[" + name.toUpperCase() + "] [INFO] " + message + "\n";
		if (bufferedPrinting) {
			buffer.append(msg);
		} else {
			System.out.println(msg);
			try {
				writer.append(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void warn(Object message) {
		String msg = "[" + name.toUpperCase() + "] [WARNING] " + message + "\n";
		if (bufferedPrinting) {
			buffer.append(msg);
		} else {
			System.out.println(msg);
			try {
				if (fileOutput) {
					writer.append(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void error(Object message) {
		String msg = "[" + name.toUpperCase() + "] [ERROR] " + message + "\n";
		if (bufferedPrinting) {
			buffer.append(msg);
		} else {
			System.out.println(msg);
			try {
				if (fileOutput) {
					writer.append(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fatal(Object message) {
		String msg = "[" + name.toUpperCase() + "] [FATAL] " + message + "\n";
		if (bufferedPrinting) {
			buffer.append(msg);
		} else {
			System.out.println(msg);
			try {
				if (fileOutput) {
					writer.append(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void print() {
		System.out.print(buffer.toString());
		try {
			if (fileOutput) {
				writer.append(buffer.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isFileOutput() {
		return fileOutput;
	}

	public void setFileOutput(boolean fileOutput) {
		this.fileOutput = fileOutput;
	}

	public boolean isBufferedPrinting() {
		return bufferedPrinting;
	}

	public void setBufferedPrinting(boolean bufferedPrinting) {
		this.bufferedPrinting = bufferedPrinting;
	}
	
}
