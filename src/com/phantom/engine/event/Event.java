package com.phantom.engine.event;

public	 class Event {

	public enum EventType {
		MOUSE_PRESSED, MOUSE_RELEASED, MOUSE_MOVED
	}
	
	private EventType type;
	
	protected Event(EventType type) {
		this.type = type;
	}
	
	public EventType getType() {
		return type;
	}
	
}
