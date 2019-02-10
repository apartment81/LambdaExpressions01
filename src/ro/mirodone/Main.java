package ro.mirodone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Employee employee1 = new Employee("Bruce Banner", 33);
        Employee employee2 = new Employee("Bruce Wayne ", 45);
        Employee employee3 = new Employee("Peter Parker", 23);
        Employee employee4 = new Employee("Tony Stark", 42);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);



/*        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/

//using lambda expressions:

//        Collections.sort(employees, (Employee e1, Employee e2) ->
//                e1.getName().compareTo(e2.getName()));


        Collections.sort(employees, Comparator.comparing(Employee::getName));


        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }


//        String funnyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase()+ s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(funnyString);

        //using lambda expressions :

        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase()+s2.toUpperCase();

        String funnyString = doStringStuff(uc, employees.get(0).getName(),employees.get(1).getName());
        System.out.println(funnyString);




    }

    private static String doStringStuff ( UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }

}

class Employee {

    private String name;
    private int age;

     Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }
}

interface UpperConcat {
     String upperAndConcat (String s1, String s2);
}
