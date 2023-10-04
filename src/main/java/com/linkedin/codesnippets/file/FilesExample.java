package com.linkedin.codesnippets.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {

    public static void main(String[] args) throws IOException {
        File file = new File("");
        Path path = Paths.get("/root/dir/nested/dir2");
        System.out.println(path.toRealPath());
    }
}
