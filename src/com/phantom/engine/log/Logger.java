package com.phantom.engine.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logger {
	
	private static Map<String, Logger> loggers = new HashMap<String, Logger>();
	private String name;
	private boolean fileOutput = false;
	private boolean bufferedPrinting = true;
	private File output;
	private FileWriter writer;
	private StringBuilder buffer;
	private List<PrintStream> streams = new ArrayList<PrintStream>();
	
	private Logger(String name) {
		this.name = name;
		buffer = new StringBuilder();
		output = new File("logs/output.log");
		try {
			writer = new FileWriter(output.getAbsolutePath());
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
			for (PrintStream p : streams) {
				p.print(buffer.toString());
			}
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
			for (PrintStream p : streams) {
				p.print(buffer.toString());
			}
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
			for (PrintStream p : streams) {
				p.print(buffer.toString());
			}
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
			for (PrintStream p : streams) {
				p.print(buffer.toString());
			}
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
			for (PrintStream p : streams) {
				p.print(buffer.toString());
			}
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
			for (PrintStream p : streams) {
				p.print(buffer.toString());
			}
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
		for (PrintStream p : streams) {
			p.print(buffer.toString());
		}
		try {
			if (fileOutput) {
				writer.append(buffer.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isBufferEmpty() {
		return buffer.isEmpty();
	}

	public boolean doFileOutput() {
		return fileOutput;
	}

	public void setFileOutput(boolean fileOutput) {
		this.fileOutput = fileOutput;
	}

	public boolean doBufferedPrinting() {
		return bufferedPrinting;
	}

	public void setBufferedPrinting(boolean bufferedPrinting) {
		this.bufferedPrinting = bufferedPrinting;
	}
	
	public void addPrintStream(PrintStream stream) {
		streams.add(stream);
	}
	
	public void removePrintStream(PrintStream stream) {
		streams.remove(stream);
	}
	
}
