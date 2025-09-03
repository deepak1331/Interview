package src.Problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find the department-wise employee count for employees who:
 * Have a salary above 80,000
 * Have worked on at least one project longer than 200 days.
 * From those employees, for each department, find the employee with
 * the highest salary and the name of their longest project.
 * Output as a list of maps like: *
 * [
 * { department=IT, count=3, topEmployee="Alice", longestProject="Data Migration" },
 * { department=Finance, count=2, topEmployee="Bob", longestProject="ERP Upgrade" }
 * ]
 */
public class EmployeeProblem {

    public static void main(String[] args) {

        //Defining Projects
        Project p1 = new Project("BNYM", "Global Liquidity", 150);
        Project p2 = new Project("SCB", "SCB_NetBanking", 240);
        Project p3 = new Project("PayPal", "PayPal_FraudDetection", 150);
        Project p4 = new Project("TL", "TriumphLearning", 220);
        Project p5 = new Project("Delta", "Delta_ConnectTheDots", 120);
        Project p6 = new Project("JRG", "JumpRampGames", 240);
        Project p7 = new Project("PCH", "PublishersClearingHouse", 190);
        Project p8 = new Project("Finserv", "CardOptimization", 210);

        List<Project> mutableList = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);
        List<Project> immutableList = List.of(p1, p2, p3, p4, p5, p6, p7, p8);

        mutableList.sort(Comparator.comparing(Project::getProjectId));
        mutableList.forEach(System.out::println);

//        immutableList.forEach(System.out::println);
//        //throws java.lang.UnsupportedOperationException
//        immutableList.sort(Comparator.comparing(Project::getName));
//        immutableList.forEach(System.out::println);

        //Defining Employees
        Employee e1 = new Employee("S01", "Deepak Yadav", "Development",
                Arrays.asList(p1, p2, p3, p4, p5, p6), 120000.00);

        Employee e2 = new Employee("S02", "Santosh Pandey", "Development",
                Arrays.asList(p5, p6), 85000.00);

        Employee e3 = new Employee("S03", "Mudit Ranjan", "Testing",
                Arrays.asList(p5, p4, p7), 90000.00);

        Employee e4 = new Employee("S04", "Pooja Jha", "Testing",
                Arrays.asList(p5, p7), 85000.00);

        Employee e5 = new Employee("S05", "Raghavendra Jha", "DevOps",
                Arrays.asList(p8, p7), 150000.00);
        Employee e6 = new Employee("S06", "Shailendra", "DevOps",
                Arrays.asList(p8, p7), 75000.00);


        List<Employee> empList = List.of(e1, e2, e3, e4, e5, e6);

        List<Employee> salGreaterThan80k = empList.stream()
                .filter(employee -> employee.getSalary() > 80000)
                .filter(employee -> employee.getProjects().stream()
                        .anyMatch(project -> project.getDurationInDays() > 200))
                .toList();

        salGreaterThan80k.forEach(System.out::println);

//        salGreaterThan80k.stream().filter(employee -> employee.getProjects().stream()
//                    .anyMatch(project -> project.getDurationInDays()>200))
        /*List<Employee> withPrjGreaterThan200days = salGreaterThan80k.stream().filter(employee -> employee.getProjects().stream()
                .anyMatch(project -> project.getDurationInDays() > 200)).toList();
        withPrjGreaterThan200days.forEach(System.out::println);*/

        Map<String, List<Employee>> result = salGreaterThan80k.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        result.forEach((dept, employeeList) -> {
            employeeList.sort(new Project.SalaryComparator());
            Employee higestEarner = employeeList.get(0);
            List<Project> projectsList = higestEarner.getProjects();
            projectsList.sort(new Project.DurationComparator());
            Project project = projectsList.get(0);
            System.out.printf("\nDepartment: %s Highest salary is Rs. %f earned by: %s" +
                            "Project Name: %s, Duration: %d days",
                    dept, higestEarner.getSalary(), higestEarner.getName(),
                    project.getName(), project.getDurationInDays());
        });

        System.out.println("\n\nUsing STREAM API");
        result.forEach((deptName, list) -> {
            list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
            Employee employee = list.get(0);
            employee.getProjects().sort(Comparator.comparingInt(Project::getDurationInDays).reversed());
            System.out.printf("\nDepartment: %s Highest salary is Rs. %f earned by: %s" +
                            "Project Name: %s, Duration: %d days",
                    deptName, employee.getSalary(), employee.getName(),
                    employee.getProjects().get(0).getName(), employee.getProjects().get(0).getDurationInDays());
        });
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
        return "\n\t\t" + projectId +
                " > " + name +
                " | " + durationInDays +
                " days";
    }

    static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare((int) o2.getSalary(), (int) o1.getSalary());
        }
    }

    static class DurationComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o2.getDurationInDays() - o1.getDurationInDays();
        }
    }
}
