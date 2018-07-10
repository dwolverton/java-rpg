package co.grandcircus.javarpg.ui;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import co.grandcircus.javarpg.events.Event;
import co.grandcircus.javarpg.events.EventListener;

public class EventDelayer implements EventListener {
	
	private Timer timer;
	private Queue<Event> eventQueue = new LinkedList<>();
	
	private EventListener delegate;
	private long delay;
	
	public EventDelayer(EventListener delegate, long delay) {
		super();
		this.delegate = delegate;
		this.delay = delay;
	}

	private void tick() {
		Event event = eventQueue.poll();
		if (event != null) {
			delegate.handleEvent(event);
		}
		if (eventQueue.isEmpty() && timer != null) {
			timer.cancel();
			timer = null;
		}
	}
	
	@Override
	public void handleEvent(Event event) {
		eventQueue.offer(event);
		if (timer == null) {
			timer = new Timer("Event Delay Timer", true);
			timer.schedule(new Tick(), 0, delay);
		}
	}
	
	private class Tick extends TimerTask {
		@Override
		public void run() {
			tick();
		}
	}
	
	

	
}
