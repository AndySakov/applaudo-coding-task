package com.applaudo.demo

// The following pattern of numbers is called Pascal’s triangle.
//     1
//    1 1
//   1 2 1
//  1 3 (3) (1)
// 1 4 6 (4) 1
// 1 5 10
// The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers above it. Write a function that computes the elements of Pascal’s triangle by means of a recursive process.
// Do this exercise by implementing the pascal function in Main.scala, which takes a row and a column, counting from 0 and returns the number at that spot in the triangle. For example, pascal(2,0)=1,pascal(2,1)=2 and pascal(3,1)=3​​​​​​​

object Main extends App {

  def pascalRec(row: Int, col: Int): Int = {
      if (col == 0 || col == row) {
        1
      } else {
        // r: 2, c: 1 = (r: 1, c: 0) + (r: 1, c: 1)
        // r: x, c: y = (r: x - 1, c: y - 1) + (r: x - 1, c: y)
        // r: 4, c: 3 = (r: 3, c: 2) + (r: 3, c: 3)
        // r: 4, c: 3 = (r: 3, c: 2) + (r: 3, c: 3)
        pascalRec(row-1, col-1) + pascalRec(row-1, col)
      }
    }

    def pascalPrint(level: Int): Unit = {
        println("Pascal’s Triangle")
        for (row <- 0 to level) {
          for (col <- 0 to row) {
            print(pascalRec(row, col) + " ")
          }
          println()
        }
      }

  println("─" * 100)

  pascalPrint(5)

  println("─" * 100)
}