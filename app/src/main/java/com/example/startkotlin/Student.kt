package com.example.startkotlin

class Student {
    var name: String = "";
    var surname: String = "";
    var age: Int = 0;
    var gradeLevel: String = "";
    var driverLicense: String = "";

    constructor(name: String, surname: String, age: Int, gradeLevel: String, driverLicense: String) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gradeLevel = gradeLevel;
        this.driverLicense = driverLicense;
    }
}