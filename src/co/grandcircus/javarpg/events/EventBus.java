package co.grandcircus.javarpg.events;

import java.util.HashSet;
import java.util.Set;

public class EventBus implements EventListener {

	private Set<EventListener> eventListeners = new HashSet<>();

	@Override
	public void handleEvent(Event event) {
		eventListeners.forEach(l -> l.handleEvent(event));
	}
	
	public void register(EventListener listener) {
		eventListeners.add(listener);
	}
	
	public void unregister(EventListener listener) {
		eventListeners.remove(listener);
	}
}
