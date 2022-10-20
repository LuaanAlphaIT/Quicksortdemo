import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListStudents {
    private final List<Student> list = new ArrayList<>();

    public ListStudents() {

    }

    public void out() {
        try {
            FileWriter file = new FileWriter("res/quicksort.txt");
            for (Student student : list) {
                System.out.println(student.toString());
                file.write(student.toString() + "\n");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void quickSort(List<Student> list, int l, int r) {
        if (l >= r) {
            return;
        }
        float pivot = list.get(r).getThePoint();
        int i = l - 1;
        int j = r;
        while (true) {
            while (list.get(++i).getThePoint() > pivot) {
                if (i == r) break;
            }
            while (list.get(--j).getThePoint() < pivot) {
                if (j == l) break;
            }
            if (i >= j) {
                break;
            }
            Student swap = list.get(i);
            list.set(i, list.get(j));
            list.set(j, swap);
        }
        Student swap = list.get(i);
        list.set(i, list.get(r));
        list.set(r, swap);
        quickSort(list, l, i - 1);
        quickSort(list, i + 1, r);
    }

    public static void main(String[] args) {
        ListStudents listStudents = new ListStudents();
        try {
            File file = new File("res/list.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String dataLine = bufferedReader.readLine();
                if (dataLine == null) {
                    break;
                }
                String[] data = dataLine.split(", ");
                int stt = Integer.parseInt(data[0]);
                float thePoint = Float.parseFloat(data[3]);
                Student student = new Student(stt, data[1], data[2], thePoint);
                listStudents.list.add(student);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        listStudents.quickSort(listStudents.list, 0,
                listStudents.list.size() - 1);
        listStudents.out();

    }
}
