import java.io.File;

public class ShowFile {
    public static void main(String[] args) {
        File file=new File("G:\\aa");
        showFile(file);
    }
    /*
    递归显示子目录
     */
    static void showFile(File file){
        if(file.isDirectory()){
            File files[]=file.listFiles();
            for (File f:files){
                System.out.println(f.getName());
                showFile(f);
            }
        }
    }
}
