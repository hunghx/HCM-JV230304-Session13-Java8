package interfaces;
@FunctionalInterface
public interface IColorable {
    // truớc java8 chỉ cho khai bao phương thức trừu tượng

    // phương thư mặc định
    default void displayName(String name){
        System.out.println(name);
    }

    default void  printColor(){

    }

    // phương thức tĩnh
    static void makeSound(){

    }
    int getSide(int side);
}
