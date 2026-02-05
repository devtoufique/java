class Student {

    String name;
    int id;
    double cgpa;

    void showDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("CGPA: " + cgpa);
    }

    public static void main(String[] args) {
        Student s1 = new Student();

        s1.name = "Rahul";
        s1.id = 101;
        s1.cgpa = 4.00;

        s1.showDetails();
    }
}
