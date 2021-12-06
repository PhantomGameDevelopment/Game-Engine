package com.phantom.engine.event.events.input;

public class MouseReleasedEvent extends MouseButtonEvent {

	public MouseReleasedEvent(int button, int x, int y) {
		super(button, x, y, EventType.MOUSE_RELEASED);
	}
	
}
