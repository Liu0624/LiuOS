package com.example.liuos.learning;

/**
 * 装饰器模式
 * 对应 xss中的wrapper类
 */
public class DecoratorModel {
    public static void main(String[] args) {
        SchoolReport sr = new FouthGradeSchoolReport();
        sr = new HighScoreDecorator(sr);
        sr.report();
    }
}

abstract class SchoolReport {
    //成绩单主要展示的就是你的成绩情况
    public abstract void report();
    //成绩单要家长签字，这个是最要命的
    public abstract void sign(String name);
}

class FouthGradeSchoolReport extends SchoolReport {
    //我的成绩单
    @Override
    public void report() {
        //成绩单的格式是这个样子的
        System.out.println("  ......");
        System.out.println("  语文 62  数学65 体育 98  自然  63");
    }
    //家长签名
    @Override
    public void sign(String name) {
        System.out.println("家长签名为："+name);
    }
}

abstract class Decorator extends SchoolReport{
    //首先我要知道是哪个成绩单
    private SchoolReport sr;
    //构造函数，传递成绩单过来
    public Decorator(SchoolReport sr){
        this.sr = sr;
    }
    //成绩单还是要被看到的
    public void report(){
        this.sr.report();
    }
    //看完还是要签名的
    public void sign(String name){
        this.sr.sign(name);
    }
}

class HighScoreDecorator extends Decorator {
    //构造函数
    public HighScoreDecorator(SchoolReport sr){
        super(sr);
    }
    //我要汇报最高成绩
    private void reportHighScore(){
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }
    //我要在老爸看成绩单前告诉他最高成绩，否则等他一看，就抡起扫帚揍我，我哪里还有机会说啊
    @Override
    public void report(){
        this.reportHighScore();
        super.report();
    }
}

