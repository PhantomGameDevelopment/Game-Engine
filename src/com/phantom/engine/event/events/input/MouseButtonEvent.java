package com.phantom.engine.event.events.input;

import com.phantom.engine.event.Event;

public class MouseButtonEvent extends Event {

	protected int button;
	protected int x, y;
	
	protected MouseButtonEvent(int button, int x, int y, EventType type) {
		super(type);
		this.x = x;
		this.y = y;
		this.button = button;
	}

	public int getButton() {
		return button;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
