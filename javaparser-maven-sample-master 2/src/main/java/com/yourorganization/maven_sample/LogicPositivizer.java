package com.yourorganization.maven_sample;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.utils.CodeGenerationUtils;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;

import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LogicPositivizer {

    public static boolean checkFilePath(String filePath){
        String regex = "^(([a-zA-Z]:)|((\\\\|/){1,2}\\w+)\\$?)((\\\\|/)(\\w[\\w ]*.*))+\\.([a-zA-Z0-9]+)$";


        Pattern p = Pattern.compile(regex);


        if (filePath == null) {
            return false;
        }

        Matcher m = p.matcher(filePath);

        return m.matches();
    }

    public static void main(String[] args) {
        String text = "/Users/mrithika/eclipse-workspace/Test/bin/com/Hello.java";
        System.out.println(checkFilePath(text));
    }


}
