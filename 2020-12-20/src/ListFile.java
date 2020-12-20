import java.io.File;

public class ListFile {
    public static void main(String[] args) {
        File file=new File("G:\\");
        File files[]=file.listFiles();
        for(int i=0;i<files.length;i++){
            System.out.println(files[i].getName());
        }
    }
}