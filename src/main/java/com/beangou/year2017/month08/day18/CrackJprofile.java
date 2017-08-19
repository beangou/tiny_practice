package com.beangou.year2017.month08.day18;

import javassist.*;

import java.io.IOException;

/**
 * Created by liutongbin on 2017/8/18.
 */
public class CrackJprofile {

        public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
            ClassPool pool = ClassPool.getDefault();
            // 解压jar包后的路径
            pool.insertClassPath("/Users/liutongbin/.m2/repository/com/alibaba/fastjson/1.2.16");
//            pool.insertClassPath("/Applications/JProfiler.app/Contents/Resources/app/bin");
//            pool.insertClassPath("\\Applications\\JProfiler.app\\Contents\\Resources\\app\\bin\\jprofiler");

//            CtClass cc = pool.getOrNull("com.ejt.framework.e.e");
            CtClass cc = pool.get("com.alibaba.fastjson.JSON");
//            CtClass cc = pool.get("com.oracle.javafx.jmx.json.JSONFactory");


            CtClass[] param = new CtClass[3];
            param[0] = pool.get("java.lang.String");
            param[1] = pool.get("java.lang.String");
            param[2] = pool.get("java.lang.String");

//            assert cc != null;
//            CtMethod method = cc.getDeclaredMethod("a", param);
//
//            assert method != null;
//            method.setBody("{return 1;}");
//
//            cc.writeFile("/Applications/JProfiler.app/Contents/Resources/app/bin/jprofiler_modified");
        }

}
