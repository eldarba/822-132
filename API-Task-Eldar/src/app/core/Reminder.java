package app.core;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reminder implements Comparable<Reminder> {

	// fields
	private LocalDateTime expiration;
	private String text;
	private boolean important;
	private boolean popped;

	// CTORs
	public Reminder() {
	}

	public Reminder(LocalDateTime expiration, String text, boolean important) {
		super();
		this.expiration = expiration;
		this.text = text;
		this.important = important;
	}

	// getters and setters
	public LocalDateTime getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDateTime expiration) {
		this.expiration = expiration;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isPopped() {
		return popped;
	}

	public void setPopped(boolean popped) {
		this.popped = popped;
	}

	@Override
	public int compareTo(Reminder other) {
		return this.expiration.compareTo(other.expiration);
	}

	@Override
	public int hashCode() {
		return Objects.hash(expiration, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Reminder)) {
			return false;
		}
		Reminder other = (Reminder) obj;
		return Objects.equals(expiration, other.expiration) && Objects.equals(text, other.text);
	}

	@Override
	public String toString() {
		return "Reminder [expiration=" + expiration + ", text=" + text + ", important=" + important + ", popped="
				+ popped + "]";
	}

	public boolean isExpired() {
		LocalDateTime now = LocalDateTime.now();
		if (this.expiration.isBefore(now)) {
			return true;
		} else {
			return false;
		}
	}

}
