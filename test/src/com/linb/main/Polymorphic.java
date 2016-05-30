package com.linb.main;

/**
 * @ClassName Polymorphic
 * @Description 多态
 * @author linb
 * @date 2016年3月18日 下午5:40:04
 */
public class Polymorphic {
    
    public static void main(String[] args) {
        Man man = new AsiaMan();
        System.out.println(man.getEyesColor());
        Woman woman = new Woman();
        woman.marry(new EuroMan());
    }
}

class Woman {
    public void marry(Man man) {
        System.out.println("woman's man has " + man.getEyesColor() + " eyes");
    }
}

class Man {
    int eyeNum = 2;
    String getEyesColor() {
        return null;
    }
}

class AsiaMan extends Man {
    String getEyesColor() {
        return "black";
    }
}

class EuroMan extends Man {
    String getEyesColor() {
        return "blue";
    }
}




