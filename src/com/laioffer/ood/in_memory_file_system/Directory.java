package com.laioffer.ood.in_memory_file_system;

import java.util.*;

public class Directory extends Entry {
	private List<Entry> contents;

	public Directory(String name, Directory parent) {
		super(name, parent);
		contents = new ArrayList<>();
	}

	public List<Entry> getContents() {
		return contents;
	}

	@Override
	public int size() {
		int size = 0;
		for (Entry e : contents) {
			size += e.size();
		}
		return size;
	}

	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}

	public void addEntry(Entry entry) {
		contents.add(entry);
	}

	public int numOfFiles() {
		int count = 0;
		for (Entry e : contents) {
			if (e instanceof Directory) {
				count++;
				count += ((Directory) e).numOfFiles();
			} else if (e instanceof File) {
				count++;
			}
		}
		return count;
	}

	public Entry getChild(String entryName) {
		for (Entry e : contents) {
			if (e.getName().equals(entryName)) {
				return e;
			}
		}
		return null;
	}
}
