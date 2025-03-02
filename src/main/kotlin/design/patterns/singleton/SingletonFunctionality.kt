package design.patterns.singleton

object Singleton {

    init {
        println("[SE INVOCA LA CLASE SOLO LA PRIMERA VEZ]")  // Cambio a println()
    }

    var courseName = "Programación App Móvil"

    fun printName() {
        println(courseName)  // Cambio a println() para asegurar un salto de línea
    }

    fun printNameGabriel123() {
        println(courseName)  // Cambio a println() para asegurar un salto de línea
    }

    fun wilson() {
        println(courseName)  // Cambio a println() para asegurar un salto de línea
    }
}

class MyClass {
    init {
        println("[MÉTODO INICIAL]") // Corrección del error tipográfico y cambio a println()
        Singleton.printName()
    }
}
