package com.beangou.year2017.day0429;

import com.beangou.year2017.Entity;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by liutongbin on 2017/4/29.
 */
public class RecurseMyDir {

    public static File[] local(File file, String regrex) {
        return file.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regrex);
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("acceptName=" + name);
                boolean result = pattern.matcher(name).matches();
                System.out.println("result=" + result);
                return result;
            }
        });

    }

    public static File[] local(String path, String regrex) {
        return local(new File(path), regrex);
    }

    public static class TreeInfo extends Entity implements Iterable<File> {

        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            files.addAll(other.dirs);
        }


        @Override
        public Iterator<File> iterator() {
            return null;
        }
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDir(start, regex);
    }

    private static TreeInfo recurseDir(File start, String regex) {
        TreeInfo ressult = new TreeInfo();
        for (File item : start.listFiles()) {
            if (item.isDirectory()) {
//                System.out.println("dirName=" + item.getAbsoluteFile());
                if (item.getAbsolutePath().contains("./src/main/java/com/beangou/year2017/day0307")) {
                    System.out.println("find it ..." + item.getAbsoluteFile());
                }
                ressult.dirs.add(item);
                ressult.addAll(recurseDir(item, regex));
            } else {
//                if (item.getName().matches(regex)) {
//                System.out.println("fileName=" + item.getAbsoluteFile());
                if (item.getAbsolutePath().contains("./src/main/java/com/beangou/year2017/day0307")) {
                    System.out.println("file find it ..." + item.getAbsoluteFile());
                }
                ressult.files.add(item);
//                }
            }
        }
        return ressult;
    }

    public static TreeInfo walk(String start) {
        return recurseDir(new File(start), ".java");
    }



    public static void main(String[] args) {

        File file2 = new File("./src/main/java/com/beangou/year2016/day1116");
        System.out.println("is file?" + file2.isFile());

        TreeInfo treeInfo = walk(".");
        System.out.println("treeInfo=" + treeInfo);
        //        PPrint.pPrint(treeInfo.dirs);

//        PPrint.pPrint(walk(".").files);

        System.out.println("***************");
//        System.out.println("result=" + walk("."));
//
//        File[] files = local("src/main/java/com/beangou/year2017/day0429", ".*");
//        System.out.println("files=" + files);
//        for(File file : files) {
//            System.out.println("name=" + file.getName());
//        }
    }


}
