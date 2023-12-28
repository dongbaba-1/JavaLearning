import java.io.File;

public class recursiveFile {
    public static void main(String[] args) {
        //searchFile("F:/study_file","array.cpp");
        deleteNoEmptyDir("F:/empty");
    }

    /**
     * 查找path路径下是否存在fileName的文件
     * @param path
     * @param fileName
     */
    public static void searchFile(String path,String fileName){
        File f = new File(path);
        //System.out.println("当前路径："+ f.getAbsolutePath());
        if(!f.exists() || !f.isDirectory())
            return;
        File[] fIles = f.listFiles();
        if (fIles != null) {
            for (File file : fIles) {
                if(file.getName().contains(fileName)){
                    System.out.println(file.getAbsolutePath());
                    break;
                }
                else {
                    searchFile(file.getPath(),fileName);
                }
            }
        }
    }

    /**
     * 如果f是文件或空文件夹,则直接删除
     * 否则，遍历文件夹
     * @param path
     */
    public static void deleteNoEmptyDir(String dirPath){
        File f = new File(dirPath);
        System.out.println("当前路径：" + f.getAbsolutePath());
        //System.out.println(f.list().length);
        if(f.isFile() || f.list().length == 0){
            f.delete();
        }
        else {
            File[] files = f.listFiles();
            for (File file : files) {
                deleteNoEmptyDir(file.getPath());
                file.delete();
            }

        }




    }
}
