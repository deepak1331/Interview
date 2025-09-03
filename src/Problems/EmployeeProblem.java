package src.Problems;

import java.util.List;

public class EmployeeProblem {

    public static void main(String[] args) {

        //Defining Projects
        Project p1 = new Project("BNYM", "Global Liquidity", 350);
        Project p2 = new Project("SCB", "SCB_NetBanking", 400);
        Project p3 = new Project("PayPal", "PayPal_FraudDetection", 150);
        Project p4 = new Project("TL", "TriumphLearning", 420);
        Project p5 = new Project("Delta", "Delta_ConnectTheDots", 120);
        Project p6 = new Project("JRG", "JumpRampGames", 240);
        Project p7 = new Project("PCH", "PublishersClearingHouse", 510);
        Project p8 = new Project("Finserv", "CardOptimization", 210);


        //Defining Employees
        Employee e1 = new Employee("S01", "Deepak Yadav", "Development",
                List.of(p1, p2, p3, p4, p5, p6), 120000.00);

        Employee e2 = new Employee("S02", "Santosh Pandey", "Development",
                List.of(p5, p6), 75000.00);

        Employee e3 = new Employee("S03", "Mudit Ranjan", "Testing",
                List.of(p5,p4, p7), 90000.00);

        Employee e4 = new Employee("S04", "Pooja Jha", "Testing",
                List.of(p5,p8, p7), 40000.00);

        Employee e5 = new Employee("S05", "Raghavendra Jha", "DevOps",
                List.of(p8, p7), 150000.00);
        Employee e6 = new Employee("S06", "Shailendra", "DevOps",
                List.of(p8, p7), 75000.00);


        List<Employee> empList = List.of(e1, e2, e3, e4, e5, e6);

        List<Employee> salGreaterThan80k = empList.stream()
                .filter(employee -> employee.getSalary() > 80000)
                .toList();

        salGreaterThan80k.forEach(System.out::println);
    }
}


class Employee {
    String id;
    String name;
    String department;
    List<Project> projects;
    double salary;

    public Employee(String id, String name, String department, List<Project> projects, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.projects = projects;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "\n" + id +
                " | " + name +
                " (" + department +
                "), Rs." + salary +
                ", Projects" + projects;
    }
    // getters, constructors...
}

class Project {
    String projectId;
    String name;
    int durationInDays;
    // getters, constructors...


    public Project(String projectId, String name, int durationInDays) {
        this.projectId = projectId;
        this.name = name;
        this.durationInDays = durationInDays;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    @Override
    public String toString() {
        return  "\n\t\t" +projectId +
                " > " + name +
                " | " + durationInDays +
                " days";
    }
}
