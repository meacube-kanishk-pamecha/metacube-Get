package Q3;

import java.util.*;

public class Placements {
    public static void main(String[] args) {
        
        // for Storing the data
        HashMap<String, Integer> program = new HashMap<>();
        List<Students> studentsList = new ArrayList<>();
        HashMap<Students, Programs> ans = new HashMap<>();

        //  adding the programs
        Programs p1 = new Programs("CSE", 1);
        Programs p2 = new Programs("IT", 10);
        program.put(p1.course, p1.seats);
        program.put(p2.course, p2.seats);

        // adding the students
        Students s1 = new Students(1, "Kanishk", List.of(p1, p2));
        Students s2 = new Students(10, "Maynk", List.of(p2, p1));
        Students s3 = new Students(8, "Ram", List.of(p1, p2));
        studentsList.add(s3);
        studentsList.add(s2);
        studentsList.add(s1);

        // sorting the list
        studentsList.sort(Comparator.comparingInt(Students::getRank));
        Queue<Students> studentsQueue = new QueueArray<>(studentsList.size());

        // adding the elements in queue
        for (Students students : studentsList) {
            studentsQueue.offer(students);
        }
        // 
        while (!studentsQueue.isEmpty()) {
            Students s = studentsQueue.remove();
            // checking the avilable seats
            for (Programs pref : s.getProgram()) {
                if (program.get(pref.course) > 0) {
                    program.put(pref.course, program.get(pref.course) - 1);
                    ans.put(s, pref);
                    break;
                } else {

                    // if no matching for the current preference found put null there
                    ans.put(s, null);
                }
            }

        }

        // print the values in the map
        for (Students s : ans.keySet()) {
            System.out.println(s + "" + ans.get(s));
        }

    }
}
