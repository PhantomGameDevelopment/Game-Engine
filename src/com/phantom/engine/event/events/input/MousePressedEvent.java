package com.phantom.engine.event.events.input;

public class MousePressedEvent extends MouseButtonEvent {

	protected MousePressedEvent(int button, int x, int y) {
		super(button, x, y, EventType.MOUSE_PRESSED);
	}
	
}
