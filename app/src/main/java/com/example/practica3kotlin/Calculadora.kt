package com.example.practica3kotlin

class Calculadora {
    //Declarar las variables
    var num1: Int = 0
    var num2: Int = 0

    //Hacer constructor
    constructor(num1:Int,num2:Int){
        this.num2 = num2;
        this.num1 = num1;
    }

    //Hacer Funciones de la calculadora
    fun suma():Int {
        return num1 + num2;
    }

    fun resta():Int {
        return num1 - num2;
    }

    fun multiplicacion():Int {
        return num1 * num2;
    }

    fun division():Int {
        var total = 0;
        if(num2 != 0) {
            total = num1 / num2;
        }
        return total;
    }
}