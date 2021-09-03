package com.example.startkotlin

import kotlin.collections.ArrayList

class StudentGenerator(var minValue: Int, var maxValue: Int) {

    val names = arrayListOf(
            "Игорь", "Павел", "Дмитрий", "Евгений", "Андрей", "Михаил", "Вадим", "Влад",
            "Денис", "Олег", "Вячеслав", "Илья", "Артем", "Руслан", "Сергей", "Тимофей"
    );

    val surnames = arrayListOf(
            "Петров", "Карпов", "Королев", "Иванов", "Соловьев", "Волков", "Лазарев", "Куликов",
            "Кузнецов", "Медведев", "Романов", "Муравьев", "Серов", "Хомяков", "Орлов", "Соколов"
    );

    val ages = arrayListOf(
            18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36
    );

    val gradeLevels = arrayListOf(
            "1 курс", "2 курс", "3 курс", "4 курс", "5 курс", "работаю", "в поисках работы"
    );

    val driverLicenses = arrayListOf(
            "есть права", "нет прав", "получаю права"
    );

    var randNumber = (minValue until maxValue + 1).random();

    // массив для хранения объектов типа - класс Student
    val arrObject = arrayListOf<Student>();

    fun generateStudents() : ArrayList<Student>{
        for (i in 0 until randNumber) {
            val student = Student(
                    names[(0 until names.size).random()],
                    surnames[(0 until surnames.size).random()],
                    ages[(0 until ages.size).random()],
                    gradeLevels[(0 until gradeLevels.size).random()],
                    driverLicenses[(0 until driverLicenses.size).random()]
            )
            arrObject.add(student);
        }
        return arrObject;
    }
}
