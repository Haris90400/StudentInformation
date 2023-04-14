package com.example.studentinformatin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, idInput;
    TextView displayText;
    String[] studentNames = new String[100];
    int[] studentIDs = new int[100];
    int studentCount = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.name_input);
        idInput = findViewById(R.id.id_input);
        displayText = findViewById(R.id.display_text);
    }

    public void addStudent(View view) {
        String name = nameInput.getText().toString();
        int id = Integer.parseInt(idInput.getText().toString());
        studentNames[studentCount] = name;
        studentIDs[studentCount] = id;
        studentCount++;
        displayText.setText("Student added successfully!");
    }

    public void displayStudents(View view) {
        if (studentCount == 0) {
            displayText.setText("No students found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < studentCount; i++) {
                sb.append("Student Name: ").append(studentNames[i]).append("\n");
                sb.append("Student ID: ").append(studentIDs[i]).append("\n\n");
            }
            displayText.setText(sb.toString());
        }
    }
}