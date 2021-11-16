package JavaParser;

import java.io.File;
import java.util.Scanner;

public class FileFetcher {
    File sourceFile;
    String filePath;
    FileFetcherFactory factoryObject = new FileFetcherFactory();
    Loader loaderObject;

    // Checks the file path, select the respective class and loads the file from file path.

    public File fetchFile() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the FilePath: ");
        filePath = in.nextLine();

        loaderObject = factoryObject.checkFile(filePath);
        sourceFile = loaderObject.loadFile(filePath);

        return sourceFile;
    }
}
