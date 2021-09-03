package com.example.startkotlin

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton: Button = findViewById(R.id.generate);
        val minCount: EditText = findViewById(R.id.minCount);
        val maxCount: EditText = findViewById(R.id.maxCount);

        generateButton.setOnClickListener() {
            // проверка на непустые edit text
            if (minCount.text.toString().trim().isEmpty() || maxCount.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Введите параметры!", Toast.LENGTH_SHORT).show();
            }
            // проверка на условие - верхняя граница > нижней
            else if ((minCount.text.toString().trim()).toInt() > (maxCount.text.toString().trim()).toInt()) {
                Toast.makeText(this, "Значение нижней границы не может быть больше верхней!", Toast.LENGTH_SHORT).show();
            }
            else {
                val minValue: Int = (minCount.text.toString().trim()).toInt();
                val maxValue: Int = (maxCount.text.toString().trim()).toInt();
                generateFunction(minValue, maxValue);
            }
        }
    }

    private fun generateFunction(minValue: Int, maxValue: Int) {
        // вывод списка на экран
        val listView: ListView = findViewById(R.id.listView);

        val generatorStudent = StudentGenerator(minValue, maxValue);

        // массив объектов класса Student
        var result = arrayListOf<Student>();

        result = generatorStudent.generateStudents();

        // массив результирующих строк
        val resultStr = arrayListOf<String>();

        for (i in 0 until (result.size)) {
            // временная переменная для сбора строки
            var tmp: String =
                        "студент: " + result[i].name + " " + result[i].surname + " \n" +
                        "возраст: " + result[i].age + " \n" +
                        "статус учёбы / работы: " + result[i].gradeLevel + " \n" +
                        "наличие водительских прав: " + result[i].driverLicense;
            
            // готовую строку -> результирующий список
            resultStr.add(tmp);
        }

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
        this, android.R.layout.simple_list_item_1, resultStr
        );
        
        // вывод списка на экран
        listView.adapter = adapter
    }
}
