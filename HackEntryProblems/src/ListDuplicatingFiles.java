import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class ListDuplicatingFiles {
    public static void listDuplicatingFiles(File folder, List<File> result)
            throws IOException {
        File[] listOfFiles = folder.listFiles();
        for (File files : listOfFiles) {
            if (files.isFile()) {
                boolean duplicate = false;
                byte[] f1 = Files.readAllBytes(files.toPath());
                for (File file : result) {
                    byte[] f2 = Files.readAllBytes(file.toPath());
                    if (Arrays.equals(f1, f2)) {
                        duplicate = true;
                    }
                }
                if (!duplicate) {
                    result.add(files);
                }
            }
            if (files.isDirectory()) {
                listDuplicatingFiles(files, result);
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        File startingPoint = new File("/users/bojko/desktop/test");
        List<File> result = new ArrayList<File>();
        listDuplicatingFiles(startingPoint, result);
        for (File file : result) {
            System.out.println(file);
        }
    }
}