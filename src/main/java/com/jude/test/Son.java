package com.jude.test;

class Father {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;
    int age;

    public void test() {
        System.out.println("我是父类的test()方法");
        System.out.println("父类姓名=" + this.name + " 父类年龄=" + this.age);
    }

}

public class Son extends Father {

    public void test() {
        /**
         在Son类的test()方法中的super.test();这行代码的意思是调用父类的test()方法，我对这行代码有点疑
         惑，super代表父对象,那么很明显，就是去调用Father类中的test()方法，那么此时，在执
         行到Father类中的test()方
         法中的System.out.println("父类姓名=" + this.name + " 父类年龄=" + this.age);这行代码的时候，这
         行代码中的this表示的是父对象还是子对象(我们都知道this表示的是当前对象，我就想知
         道此时this表示的当前对象到底是父类对象还是子类对象)，知道的人请帮忙解答下？谢谢!
         */
        super.test();
        System.out.println("我是子类的test()方法");
        System.out.println("子类姓名=" + this.name + " 子类年龄=" + this.age);
    }

    public static void main(String[] args) {
        Son son = new Son();

        son.name = "杨过";
        son.age = 12;
        System.out.println(son.getName());
        son.test();
    }

}