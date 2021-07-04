package input;

public class RandomStudent implements RandomValue<Student>{

    public Student getRandomValue()
    {
        RandomInteger usn = new RandomInteger();
        RandomString name = new RandomString();
        Student s = new Student(usn.getRandomValue(), name.getRandomValue());
        return s;
    }

}
