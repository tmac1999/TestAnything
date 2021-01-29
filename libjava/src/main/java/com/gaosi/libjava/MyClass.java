package com.gaosi.libjava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class MyClass {
    public static void main(String[] args) {
//        try {
//            String path = "/Users/lianhua/Downloads/react.zip";
//            File file = new File(path);
//            ZipFile zf = new ZipFile(path);
//
//            InputStream in = null;
//            in = new BufferedInputStream(new FileInputStream(path));
//            Charset gbk = Charset.forName("gbk");
//            ZipInputStream zin = new ZipInputStream(in,gbk);
//            ZipEntry ze;
//            while((ze = zin.getNextEntry()) != null){
//                if(ze.toString().endsWith("json")){
//                    BufferedReader br = new BufferedReader(
//                            new InputStreamReader(zf.getInputStream(ze)));
//                    String line;
//                    while((line = br.readLine()) != null){
//                        System.out.println("v:"+line.toString());
//                        set(file.toPath(),"v:"+line);
//                    }
//                    br.close();
//                }
//                System.out.println();
//            }
//            zin.closeEntry();
//            getVersion(file.toPath());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String pathStr = "/Users/lianhua/Downloads/react.zip";
        File file = new File(pathStr);
        Path path = file.toPath();
        path.getFileSystem().supportedFileAttributeViews();
        String name = "user.mimetype";
//        ByteBuffer buf = ByteBuffer.allocate(view.size(name));
//        view.read(name, buf);
//        buf.flip();
//        String value = Charset.defaultCharset().decode(buf).toString();

//        try{
//            System.out.println(Files.getAttribute(path, "owner:encryption used"));
//        }catch(IOException e){
//            System.out.println(e.getMessage());
//        }
        new Thread(){
            @Override
            public void run() {
                super.run();

            }
        }.start();
    }


    /**
     * 设置文件的最后修改时间/创建时间/最后访问时间
     * @param path
     */
    private static void set(Path path) {
        long time = System.currentTimeMillis();

        FileTime fileTime = FileTime.fromMillis(time);

        try {
            Files.setAttribute(path, "basic:lastModifiedTime", fileTime, LinkOption.NOFOLLOW_LINKS);
            Files.setAttribute(path, "basic:creationTime", fileTime, LinkOption.NOFOLLOW_LINKS);
            Files.setAttribute(path, "basic:lastAccessTime", fileTime, LinkOption.NOFOLLOW_LINKS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取文件的最后修改时间/创建时间/访问时间
     * @param path
     */
    private static void get(Path path) {
        try {
            FileTime lastModifiedTime = (FileTime) Files.getAttribute(path, "basic:lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
            FileTime creationTime = (FileTime) Files.getAttribute(path, "basic:creationTime", LinkOption.NOFOLLOW_LINKS);
            FileTime lastAccessTime = (FileTime) Files.getAttribute(path, "basic:lastAccessTime", LinkOption.NOFOLLOW_LINKS);

            System.out.println("New last modified time: " + lastModifiedTime);
            System.out.println("New creation time: " + creationTime);
            System.out.println("New last access time: " + lastAccessTime);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    private static void set(Path path,String version) {
        try {
            Files.setAttribute(path, "version", version);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void getVersion(Path path) {
        try {
            FileTime lastModifiedTime = (FileTime) Files.getAttribute(path, "version", LinkOption.NOFOLLOW_LINKS);

            System.out.println("version" + lastModifiedTime);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
