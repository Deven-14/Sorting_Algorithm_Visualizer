package input;

public class Student implements Comparable<Student>{
    
    private int usn;
    private String name;

    public Student() { usn = 0; name = null; }

    public Student(int usn, String name)
    {
        this.usn = usn;
        this.name = name;
    }

    public int compareTo(Student s2)
    {
        if(usn < s2.usn)
            return -1;
        else if(usn > s2.usn)
            return 1;
        return 0;
    }

    public String toString()
    {
        return "USN : " + usn + ", Name : " + name;
    }
}
