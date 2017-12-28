package com.laioffer.ood.in_memory_file_system;

public abstract class Entry {
	private Directory parent;
	private String name;
	private long create;
	private long lastUpdated;
	private long lastAccessed;

	public Entry(String name, Directory parent) {
		this.parent = parent;
		this.name = name;
		create = System.currentTimeMillis();
	}

	public boolean delete() {
		return parent != null && parent.deleteEntry(this);
	}

	public abstract int size();

	public String getFullPath() {
		if (parent == null) {
			return name;
		}
		return parent.getFullPath() + "/" + name;
	}

	public long getCreationTime() {
		return create;
	}

	public long getLastUpdatedTime() {
		return lastUpdated;
	}

	public long getLastAccessedTime() {
		return lastAccessed;
	}

	public String getName() {
		return name;
	}
}
