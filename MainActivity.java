package com.example.amrez.reportcard;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Inner Class to set and get subjects and grades
    public class StudentsGrade {
        //for student name
        private String studentName;
        //for Student Subjects
        private String Subject1;
        private String Subject2;
        private String Subject3;
        //for student grades
        private String grade1;
        private String grade2;
        private String grade3;


        //Constructor to init the subs and grades value
        public StudentsGrade(String student_Name, String S_subject1, String S_subject2, String S_subject3, String S_grade1, String S_grade2, String S_grade3) {
            //student name
            studentName = student_Name;
            //Subjects
            Subject1 = S_subject1;
            Subject2 = S_subject2;
            Subject3 = S_subject3;

            //grades
            grade1 = S_grade1;
            grade2 = S_grade2;
            grade3 = S_grade3;
        }

        //get student name
        public String getStudentName() {
            return studentName;
        }

        //get Subjects
        public String getSbject1() {
            return Subject1;
        }

        public String getSbject2() {
            return Subject2;
        }

        public String getSbject3() {
            return Subject3;
        }

        //get grades
        public String getgrade1() {
            return grade1;
        }

        public String getgrade2() {
            return grade2;
        }

        public String getgrade3() {
            return grade3;
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ArrayList for grades and subjects
        ArrayList<StudentsGrade> studentsGrad = new ArrayList<StudentsGrade>();
        studentsGrad.add(new StudentsGrade("Student 1", "Math", "Science", "Biology", "30", "30", "20"));
        studentsGrad.add(new StudentsGrade("Student 2", "Math", "Science", "Biology", "15", "50", "40"));
        studentsGrad.add(new StudentsGrade("Student 3", "Math", "Science", "Biology", "10", "30", "10"));
        studentsGrad.add(new StudentsGrade("Student 4", "Math", "Science", "Biology", "10", "30", "45"));
        studentsGrad.add(new StudentsGrade("Student 5", "Math", "Science", "Biology", "5", "30", "40"));
        studentsGrad.add(new StudentsGrade("Student 6", "Math", "Science", "Biology", "10", "5", "40"));
        studentsGrad.add(new StudentsGrade("Student 7", "Math", "Science", "Biology", "10", "30", "5"));
        studentsGrad.add(new StudentsGrade("Student 8", "Math", "Science", "Biology", "5", "30", "40"));
        studentsGrad.add(new StudentsGrade("Student 9", "Math", "Science", "Biology", "10", "7", "45"));
        studentsGrad.add(new StudentsGrade("Student 10", "Math", "Science", "Biology", "10", "30", "40"));
        //Adapter to get values from ArrayList and Create ListView
        myAdapter stAdapter = new myAdapter(this, studentsGrad);
        ListView listView = (ListView) findViewById(R.id.studentList);
        listView.setAdapter(stAdapter);
    }

    //inner Adapter Class
    public class myAdapter extends ArrayAdapter<StudentsGrade> {

        //Constructor
        public myAdapter(Activity context, ArrayList<StudentsGrade> studentsGrad) {
            super(context, 0, studentsGrad);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            // ListView Checker
            View list_Item = convertView;
            if (list_Item == null) {
                list_Item = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }

            //to get value from array and create TextView
            StudentsGrade studentsGrade = getItem(position);
            // give value to student Name textView
            TextView students = (TextView) list_Item.findViewById(R.id.st_Name);
            students.setText(studentsGrade.getStudentName());
            // give value to Subject textView
            TextView sub1 = (TextView) list_Item.findViewById(R.id.math);
            sub1.setText(studentsGrade.getSbject1());
            TextView sub2 = (TextView) list_Item.findViewById(R.id.science);
            sub2.setText(studentsGrade.getSbject2());
            TextView sub3 = (TextView) list_Item.findViewById(R.id.biology);
            sub3.setText(studentsGrade.getSbject3());

            // give value to Grade textView
            TextView grade1 = (TextView) list_Item.findViewById(R.id.math_grade);
            grade1.setText(studentsGrade.getgrade1());
            TextView grade2 = (TextView) list_Item.findViewById(R.id.science_grade);
            grade2.setText(studentsGrade.getgrade2());
            TextView grade3 = (TextView) list_Item.findViewById(R.id.biology_grade);
            grade3.setText(studentsGrade.getgrade3());

            //return the new view
            return list_Item;
        }


    }


}
