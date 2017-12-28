package com.laioffer.ood.in_memory_file_system;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private final Directory root;

    public FileSystem() {
        root = new Directory("/", null);
    }

    /**
     * resolve a path like "/foo/bar", return a list of directories from root to cur parent.
     *
     * @param path target file path
     * @return all entries under given path.
     */
    public List<Entry> resolve(String path) {
        assert path.endsWith("/");
        String[] components = path.substring(1).split("/");
        List<Entry> entries = new ArrayList<>(components.length + 1);
        entries.add(root);
        Entry entry = root;  // record the current entry to be scanned.
        for (String component : components) {
            if (entry == null || !(entry instanceof Directory)) {
                throw new IllegalArgumentException("invalid path: " + path);
            }
            if (!component.isEmpty()) {
                entry = ((Directory) entry).getChild(component);
                entries.add(entry);
            }
        }
        return entries;
    }

    /**
     * make a dictionary under given path.
     * Example: /..../NewDirName
     *
     * @param path target file path.
     */
    public void mkdir(String path) {
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("Dictionary already exists: " + path);
        }
        String[] components = path.split("/");
        final String dirName = components[components.length - 1];
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        Directory newDir = new Directory(dirName, parent);
        parent.addEntry(newDir);
    }

    /**
     * create a file under given path.
     *
     * @param path the target path.
     */
    public void createFile(String path, int fileSize) {
        assert !path.endsWith("/");
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("File already exists: " + path);
        }
        final String fileName = path.substring(path.lastIndexOf("/") + 1);
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        File newFile = new File(fileName, parent, fileSize);
        parent.addEntry(newFile);
    }

    /**
     * delete a file/dictionary under a given path.
     *
     * @param path the target path.
     */
    public void delete(String path) {
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) == null) {
            throw new IllegalArgumentException("The target Entry doesn't exists: " + path);
        }
        Entry targetEntry = entries.get(entries.size() - 1);
        targetEntry.delete();
    }

    /**
     * list all the immediate children of the dictionary specified by a given path.
     *
     * @param path the target path.
     * @return the result list.
     */
    public List<Entry> list(String path) {
        List<Entry> children = new ArrayList<>();
        List<Entry> entries = resolve(path);
        Entry targetEntry = entries.get(entries.size() - 1);
        if (targetEntry instanceof File) {
            throw new IllegalArgumentException("the target Direction doesn't exists: " + path);
        }
        for (Entry e : ((Directory) targetEntry).getContents()) {
            if (e instanceof Directory) {
                children.add(e);
            }
        }
        return children;
    }

    /**
     * return the total number of files/dictionaries in the FileSystem.
     *
     * @return the total number.
     */
    public int count() {
        int count = 1;
        for (Entry e : root.getContents()) {
            if (e instanceof Directory) {
                count += ((Directory) e).numOfFiles() + 1;
            } else {
                count++;
            }
        }
        return count;
    }
}
