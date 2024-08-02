package interfaces;

import java.util.Random;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age=age;
    }
    public Person() {}

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

    // phuwogn thức bình thường
    public Person mapper(String name){
        Random random = new Random();
        int ageRan = random.nextInt(100);
        Person p = new Person(name,ageRan);
        return p;
    }
    // phuwogn thức tĩnh
    public static Person mapperStatic(String name){
        Random random = new Random();
        int ageRan = random.nextInt(100);
        Person p = new Person(name,ageRan);
        return p;
    }
    // constructor
    public Person(String name){
        Random random = new Random();
        this.age = random.nextInt(100);
        this.name = name;
    }
}
