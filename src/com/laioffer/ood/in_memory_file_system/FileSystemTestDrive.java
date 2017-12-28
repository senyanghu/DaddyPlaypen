package com.laioffer.ood.in_memory_file_system;

import java.util.Arrays;
import java.util.List;

public class FileSystemTestDrive {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.mkdir("/Desktop");
        fs.mkdir("/Desktop/foo");
        fs.createFile("/Desktop/foo/file1", 2);
        List<Entry> allPathEntry = fs.resolve("/Desktop/foo/file1");

        System.out.println(fs.count());
        
        Entry root = allPathEntry.get(0);
        Entry dir1 = allPathEntry.get(1);
        Entry dir2 = allPathEntry.get(2);
        Entry file1 = allPathEntry.get(3);

//        System.out.println(file1.getFullPath());
//        System.out.println(file1.getCreationTime());
        byte[] array = {'I', (char)(39), 'm', ' ', 'a', ' ', 'f', 'i', 'l', 'e', '.'};
        ((File)file1).setContents(array);
        System.out.println(((File) file1).getContents());
        System.out.println(file1.getName());
        System.out.println(file1.size());
//        System.out.println(((Directory) root).numOfFiles());
//        System.out.println(((Directory) dir1).numOfFiles());
//        System.out.println(((Directory) dir2).numOfFiles());
    }
}
