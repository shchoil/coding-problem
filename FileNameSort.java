import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FileNameSort {
    public static void main(String[] args) throws Exception {
        String[] files = {"F-5 Freedom Fighter", "muzi1asd5.png", "MUZI01.zip", "B-50 Superfortress", "A-10 Thunderbolt II", "a-0010 Thunderbolt II", "F-14 Tomcat" , "o1", "a0"};
        String[] result = solution(files);

        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] files) {

        if (files.length != 0) {
                Arrays.sort(files, new Comparator<String>() {
                @Override
                public int compare(String currentFile, String nextFile) {
                    String [] sCurrentFile = splitFileName(currentFile);
                    String [] sNextFile = splitFileName(nextFile);
                    int headResult = sCurrentFile[0].compareTo(sNextFile[0]);

                    if (headResult == 0) {
                        int sCurrentFileNum = Integer.parseInt(sCurrentFile[1]);
                        int sNextFileNum = Integer.parseInt(sNextFile[1]);

                        return sCurrentFileNum - sNextFileNum;
                    } else {
                        return headResult;
                    }
                }

                private String[] splitFileName (String fileName) {
                    String fileHeadName = "";
                    String fileNumberName = "";
                    String fileTailName = "";

                    for (int i = 0; i < fileName.length(); i++) {
                        char character  = fileName.charAt(i);

                        if (!Character.isDigit(character)) {
                            if (fileNumberName.isEmpty()) {
                                fileHeadName += character;
                                continue;
                            }
                            fileTailName += character;
                        }

                        if (Character.isDigit(character) && fileTailName.isEmpty()) {
                            fileNumberName += character;
                        }
                    }
                    String [] sortedFileName = {fileHeadName.toLowerCase(), fileNumberName, fileTailName};

                    return sortedFileName;
                }
            });
        } else {
            return files;
        }

        return files;
    }
}

