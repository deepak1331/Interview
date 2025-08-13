package src.main;

import java.util.Objects;

public class Employee {

    private String name;
    private String gender;
    private int age;

    public Employee(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getAge() == employee.getAge() && Objects.equals(getName(), employee.getName()) && Objects.equals(getGender(), employee.getGender());
    }

   /* @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getAge());
    }*/

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getName() == null ? 0 : getName().hashCode());
        System.out.println(result);
        result = prime * result + (getGender() == null ? 0 : getGender().hashCode());
        System.out.println(result);
        result = prime * result + getAge();
        System.out.println(result);
        return result;
    }
}
