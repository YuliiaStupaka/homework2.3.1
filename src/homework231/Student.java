package homework231;
public class Student extends Human{
    private long recordBookNumber;
    private String group;

    public Student(long recordBookNumber, String group, String name, String surname, boolean sex, int age) {
        super(name, surname, sex, age);
        this.recordBookNumber = recordBookNumber;
        this.group = group;
    }

    public Student() {
        super();
    }

    public long getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(long recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{"+super.toString()+", recordBookNumber="+ recordBookNumber+", group="+group+'}';
    }
}
