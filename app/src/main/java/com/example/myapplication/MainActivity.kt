package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        variables()
        condicional_if()
        condicional_when()
        arreglos()
        maps()
        loops()
        nullSafety()
        funciones()
    }
    //////////////////////////////////////////////////////////////////////

    fun variables(){
        //String
        val saludo : String = "Hola"
        println(saludo)
        val sujeto : String = "mundo"
        println(sujeto)
        val saludo_completo : String = saludo + " " + sujeto
        println(saludo_completo)
        //Enteros (Byte,Short,Int,Long)
        //Decimales (float,Double)
        //Boolean (Bool=true/false)
    }

    fun condicional_if(){
        //Operadores logicos
        // && - and
        // || - or
        // ! - no
        val number : Int = 7
        if(number <= 10 && number > 5) {
            println("$number es menor o igual que que 10")
        } else {
            println ("$number es mayor que 10 o menor o igual que 5")
        }
    }

    fun condicional_when(){
        val country : String = "Colombia"
        when(country){
            //Puede hacerse una operación evaluando multiples usuarios
            "México","Colombia","Argentina" -> {
                println("El idioma es español")
            }
            "Japon" -> {
                println("El idioma es japones")
            }
            "Francia" -> {
                println("El idioma es frances")
            }
            //Para todos los ingresos no validos
            else -> {
                println("País no valido")
            }
        }
        //////////
        val age : Int = 20
        when(age){
            0,1,2 -> {
                println("Es un bebe")
            }
            in 3 .. 10 ->{
                println("Eres un niño")
            }
            in 11 .. 18 ->{
                println("Eres un adolescente")
            }
            else -> {
                println("Eres un adulto")
            }
        }
    }

    fun arreglos(){
        val name : String = "Aldo"
        val apellidoP : String = "Tena"
        val apellidoM : String = "Garcia"

        //Creación de array
        val arrayNombre : ArrayList<String> = arrayListOf<String>()
        //Añadir elementos a array
        arrayNombre.add(name)
        arrayNombre.add(apellidoP)
        arrayNombre.add(apellidoM)
        //Imprimir un arreglo
        println(arrayNombre)

        // Creación de un arreglo llenado automaticamente
        val myNumericArray : IntRange  = (0..20)

        //Añadir un conjunto de datos
        arrayNombre.addAll(listOf("Fernanda","Tena"))
        println(arrayNombre)

        //Acceder a un elemento en especifico
        val nombre1 : String = arrayNombre[0]
        println("El elemento de la posición 0 es: " + nombre1)

        //Ver la cantidad de elementos de un array
        val arraySize : Int = arrayNombre.size
        println("El tamaño del array es de: $arraySize")

        //Modificar el valor de un elemento
        arrayNombre[4] = "Cambio del valor 5"
        println(arrayNombre)

        //Eliminación de datos
        arrayNombre.removeAt(3)
        println(arrayNombre)

        //Recorrer el arreglo
        arrayNombre.forEach {
            println(it)
        }

        //Eliminar todos los elementos de un array
        //arrayNombre.clear()

        //Primer elemento y ultimo elemento de un array
        //arrayNombre.first()
        //arrayNombre.last()

        //Sort de un array - depende del tipo de datos
        //arrayNombre.sort()
    }

    fun maps(){
        //Tambien conocido como diccionarios
        var myMap: Map<String,Int> = mapOf()

        //Añadir elementos (mapOf reinicia el mapa)
        myMap = mutableMapOf("Aldo" to 1, "Tena" to 2, "Garcia" to 3)
        println(myMap)

        //Añadir elementos a un mapa, necesario que el mapa sea mutable
        myMap["Ana"] = 7
        myMap.put("Maria",7) //Pueden actualizar datos
        println(myMap)

        //Acceder a valores de un mapa
        println(myMap["Aldo"])

        //Eliminar un dato
        myMap.remove("Maria")
        println(myMap)
    }

    fun loops(){
        //Estructuras for y while
        val myArray : List<String> = listOf("Hola","como","estas")
        val myMap: Map<String,Int> = mutableMapOf("Aldo" to 1, "Tena" to 2, "Garcia" to 3)

        //For
        for (myString : String in myArray){
            println(myString)
        }

        for ((operation, symbol) in myMap) {
            println("$operation -> $symbol")
        }
        // Este va del limite inferior al superior tocando ambos
        for (x : Int in 1..10) {
            println(x)
        }

        //Este llega hasta el nueve (limite superior-1)
        for (x : Int in 0 until 10) {
            println(x)
        }

        //Step define los saltos
        for (x : Int in 0..10 step 2) {
            println(x)
        }

        //Incrementos negativos (puede incluir step)
        for (x : Int in 10 downTo 0) {
            println(x)
        }

        val myNumericArray : IntRange  = (0..20)
        for (myNum : Int in myNumericArray){
            println(myNum)
        }

        //---------------------------------------------

        //While
        var x : Int = 0

        while(x<10){
            println(x)
            //x++
            x += 2
        }
    }

    fun nullSafety(){
        //Seguridad contra apuntadores a nulos

        val myString = "Hola"
        //myString = null Esto daria un error
        println(myString)

        var mySafetyString : String? = "Variable null safety"
        mySafetyString = null
        println(mySafetyString)

        mySafetyString = "Cambio de null"
        //println(mySafetyString)

        //mySafetyString!! - Obliga a que no sea nula, solo si sabemos que no lo es

        /*if(mySafetyString != null){
            println(mySafetyString!!)
        }*/

        //Safe calls
        println(mySafetyString?.length)

        mySafetyString?.let {
            println(it) //Esto se ejecuta cuando no es nula la variable
        } ?: run {
            println(mySafetyString)
        }
    }

    fun funciones(){
        //Función simple
        sayHello()
        //Funciones con parametros
        sayMyName("Aldo")
        sayMyNameAndAge("Aldo", 20)
        //Funciones con parametros y return
        val sum : Int = suma2numeros(15,8)
        println(sum)
        println(suma2numeros(10,8))
        println(suma2numeros(10,suma2numeros(10,10)))
    }

    fun sayHello(){
        println("Hello")
    }

    fun sayMyName(name: String){
        println("Hola, mi nombre es $name")
    }

    fun sayMyNameAndAge(name: String, age: Int){
        println("Hola, mi nombre es $name y mi edad es $age años")
    }

    fun suma2numeros(firstNumber: Int, secondNumber: Int) : Int{
        val sum = firstNumber + secondNumber
        return sum
    }

    ///////////////////////////////////////////////////////////////////////
}