package com.phantom.engine.event.events.input;

import com.phantom.engine.event.Event;

public class MouseMovedEvent extends Event {
	
	private int x, y;
	private boolean dragged;
	
	protected MouseMovedEvent(int x, int y, boolean dragged) {
		super(EventType.MOUSE_MOVED);
		this.x = x;
		this.y = y;
		this.dragged = dragged;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public boolean isDragged() {
		return dragged;
	}

}
