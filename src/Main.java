import interfaces.IColorable;
import interfaces.Person;
import interfaces.Table;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Table t = new Table();
        // có truy cập đc phương thức mặc định ko
        t.displayName("hung");

        // gọi phương thức từ tên Interface
        IColorable.makeSound();

//        IColorable s1 = new IColorable() {
//            @Override
//            public void getSide() {
//                System.out.println("100");
//            }
//        };
        IColorable s2 = (a)->10;

        // có thể khởi tạo đối tượng functional interface bằng cú pháp lambda
        // các functional interface được java cung cấp thuộc gói : java.util.function

//        Consumer : (t)-> void
//        Predicate : (t)->boolean
//        Supplier
//        Function : (t)-> v

        // collection
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream1 = list.stream(); // mở stream
        // duyệt các phần tử chia cho 3;
        Stream<Integer> stream2 = stream1.filter(o->o%3==0);
        // bình phương các số đó lên
        Stream<Integer> stream3 = stream2.map(o-> o*o);
        // in các số dó ra
        stream3.forEach(System.out::println);
        list.stream().filter(i -> i%3==0 ).map(i->i*i).forEach(System.out::println);

        // bai tâp

        // tạo 100 số ngẫu nhiên ko trung lặp từ 0-1000
        // sắp xê 100 số dó theo chiều giảm dần
        // loc ra các số nguyên tố và in ra
        // in ra bình phương của các số nguyên tố tìm đc
        // kiểm tra xem có bao nhiêu số nguyên tố trong danh sách 100 so

       String[] names = {"Huỳnh Công Tính","Mai Xuân Sáng","Mỹ Huyền","Mỹ Trân"};
       // yêu cầu chuyển mảng các teen thành các đối tượng Person , tuổi ngẫu nhiên từ 0-100
        Person p = new Person();

        List<Person> people = Arrays.stream(names).map(Person::new).toList();

        LocalDate date = LocalDate.now(); // thời gian hiện tại của hệ thống
        LocalDate birthDay = LocalDate.of(1999,10,10);

        // format : DateTimeFormatter
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(birthDay.format(dft));

        // Tính khoảng cách thời gian : nanos giây
//        Period
//        Duration
        LocalTime t1 = LocalTime.now();
        LocalTime t2 = t1.plusMinutes(10);
        Duration gap = Duration.between(t1,t2);
        System.out.println(gap);
        long time = gap.toNanos();
        System.out.println(time);
        System.out.println(ChronoUnit.DAYS.between(birthDay,date));
        System.out.println(ChronoUnit.WEEKS.between(birthDay,date));


        // Optional
        String a = null;
        Optional<String> s = Optional.ofNullable(a);
        // sử dụng


        // tim người có tên bắt đầu bằng M
          Optional<Person>  optionalPerson = people.stream().filter(person -> person.getName().startsWith("N")).findFirst();

          if (optionalPerson.isPresent()){
              // nếu khác null thì làm gì đó ở đây
              Person current = optionalPerson.get();
              System.out.println(current.getName());
          }

//          Person p2 = optionalPerson.orElse(new Person(null,0));
          Person p2 = optionalPerson.orElseThrow(() -> new RuntimeException("ko tồn tại người nào có tên bắt đầu bằng M"));
          System.out.println(p2.getName());

    }
}