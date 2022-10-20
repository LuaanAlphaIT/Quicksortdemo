public class Student {
    private final int stt;
    private final String studentCode;
    private final String name;
    private final float thePoint;

    public float getThePoint() {
        return thePoint;
    }

    public Student(int stt, String studentCode, String name, float thePoint) {
        this.stt = stt;
        this.name = name;
        this.studentCode = studentCode;
        this.thePoint = thePoint;
    }

    public String toString() {
        String str = String.format("%04d   %-15s%-32s", stt, studentCode, name);
        return str + thePoint;
    }
}
