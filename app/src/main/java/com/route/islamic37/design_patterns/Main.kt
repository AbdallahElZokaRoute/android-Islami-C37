package com.route.islamic37.design_patterns

import android.util.Log

class Main {
    /*
        Design Patterns :- a sets of problems and it has
            corresponding Solutions
            Total Design Patterns = 23 Pattern
            1- Creational Patterns :- (The way you create the objects)
                   1- Singleton (Today's Session)
                   2- Factory
                   3- Abstract Factory
                   4- Builder
                   5- Prototype


            2- Structural Patterns :-(The Way Entities Communicate)

            3- Behavioral Patterns :- (The way objects behave)

            // Singleton :- Single Instance + Global Accessible
            // Factory :-  Create Objects

            //ShapesFactory -> Input (Shape user wants)
            //              Generate Shape Corresponding to Input



     */

    fun doOperations() {
        val appDatabase = AppDataBase2
        val appDatabaseRef2 = AppDataBase2
        Log.e("TAG", "doOperations:(${appDatabase.hashCode()})")
        Log.e("TAG", "doOperations:(${appDatabaseRef2.hashCode()})")
    }

    fun doOperations2() {
        val appDatabase = AppDataBase.getInstance()
        val appDatabaseRef2 = AppDataBase.getInstance()
        Log.e("TAG", "doOperations:(${appDatabase.hashCode()})")
        Log.e("TAG", "doOperations:(${appDatabaseRef2.hashCode()})")


    }
}

interface Shape {
    fun draw(): Shape
}

class Rectangle : Shape {
    override fun draw(): Shape {
        return this
    }

}

class Circle : Shape {
    override fun draw(): Shape {
        return this
    }

}

class Triangle : Shape {
    override fun draw(): Shape {
        return this
    }

}

enum class ShapeType {
    RECTANGLE, CIRCLE, SQUARE, TRIANGLE
}

class ShapesFactory {
    //SOLID
    // O -> Open/Closed Principle -> Open For Extension / Closed For Modification

    fun drawShape(shape: Shape): Shape {
        return shape.draw()
    }
}


object AppDataBase2 {


}

class AppDataBase private constructor(
    databaseName: String
) {
    companion object {
        var INSTANCE: AppDataBase? = null

        fun getInstance(): AppDataBase {
            INSTANCE = INSTANCE ?: synchronized(this) {
                AppDataBase("My-DataBase")
            }
            return INSTANCE!!
        }
    }
}
