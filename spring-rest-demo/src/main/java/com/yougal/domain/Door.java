package com.yougal.domain;

public class Door {
	
	public enum DoorStatus {

	    CLOSED, //
	    OPEN, //
	    SELECTED;
	}

	
	public enum DoorContent {

	    JUERGEN, //
	    SMALL_FURRY_ANIMAL, //
	    UNKNOWN;

	}
    private final Long id;

    private final Object monitor = new Object();

    private volatile DoorContent content;

    private volatile DoorStatus status;

    public Door(Long id, DoorContent content) {
        this.id = id;
        this.content = content;
        this.status = DoorStatus.CLOSED;
    }

    public Long getId() {
        return this.id;
    }

    public DoorContent getContent() {
        synchronized (this.monitor) {
            if (this.status == DoorStatus.OPEN) {
                return this.content;
            }
            return DoorContent.UNKNOWN;
        }
    }

    public DoorStatus getStatus() {
        synchronized (this.monitor) {
            return this.status;
        }
    }

    DoorContent peekContent() {
        return this.content;
    }

    void setStatus(DoorStatus status) {
        synchronized (this.monitor) {
            this.status = status;
        }
    }


}
