package com.leetp.designpattern.visitor;

/**
 * @Description 访问者设计模式
 * 实现对不同文件的压缩，解析
 * @Author litianpeng
 * @Date 2020/5/29
 */
public class VisitorDesignPattern {
    public static void main(String[] args) {
        PdfFile pdfFile = new PdfFile();
        pdfFile.accept(new Compressor());
        pdfFile.accept(new Parsing());
    }
}

interface Visitor {
    void visit(PdfFile pdfFile);

    void visit(WordFile wordFile);

    void visit(XmlFile xmlFile);
}

/**
 * 压缩文件
 */
class Compressor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("压缩pdf文件");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("压缩word文件");

    }

    @Override
    public void visit(XmlFile xmlFile) {
        System.out.println("压缩xml文件");

    }
}

/**
 * 解析文件
 */
class Parsing implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("解析pdf文件");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("解析word文件");

    }

    @Override
    public void visit(XmlFile xmlFile) {
        System.out.println("解析xml文件");

    }
}

class PdfFile {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class WordFile {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class XmlFile {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
