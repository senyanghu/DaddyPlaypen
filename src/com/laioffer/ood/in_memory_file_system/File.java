package com.laioffer.ood.in_memory_file_system;

public class File extends Entry {
	private byte[] contents;
	private int size;

	public File(String name, Directory parent, int size) {
		super(name, parent);
		this.size = size;

	}

	@Override
	public int size() {
		return size;
	}

	public String getContents() {
		return new String(contents);
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}
}
