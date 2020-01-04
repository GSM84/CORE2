package Lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        readByteArray("test\\test_file.txt");

        linkFileSet("test\\res.txt","test\\1.txt", "test\\2.txt","test\\3.txt","test\\4.txt","test\\5.txt");

        readPage(10, "test\\raf.txt");

        readBack("test\\back.txt");

    }

    static void readByteArray(String _filePath){
        try(FileInputStream inputStream = new FileInputStream(_filePath)){
            byte[] arr = new byte[512];
            int x;
            while((x = inputStream.read(arr)) != -1){
                System.out.println(new String(arr, 0, x));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void linkFileSet(String _destPath, String... _filePathN){
        ArrayList<InputStream> paths = new ArrayList();
        for (int i = 0; i < _filePathN.length; i++) {
            try {
                paths.add(new FileInputStream(_filePathN[i]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try(SequenceInputStream seqIS = new SequenceInputStream(Collections.enumeration(paths));
            FileOutputStream fou      = new FileOutputStream(new File(_destPath));
           ){
            byte[] arr = new byte[512];
            int x;
            while((x = seqIS.read(arr)) != -1){
                fou.write(arr, 0, x);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void readPage(int _pageNum, String _filePath){
        final int pageSize = 1800;
        try(RandomAccessFile raf = new RandomAccessFile(_filePath, "r")){
            long start = System.currentTimeMillis();
            byte[] arr = new byte[pageSize];
            raf.seek(pageSize * _pageNum);
            int x = raf.read(arr);
            System.out.println(new String(arr, 0, x));
            System.out.println("Done in " + (System.currentTimeMillis() - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readBack(String _path){
        try(RandomAccessFile raf = new RandomAccessFile(_path, "r")){
            long startPos = raf.length();
            int x;
            raf.seek(--startPos);
            while((x = raf.read()) != -1){
                System.out.print((char) x);
                if(--startPos < 0)
                    return;
                raf.seek(startPos);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
