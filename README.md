# Polynom

Codding by : Tomer Maabari and Ortal Hanoch
Computer since and Math , Ariel Uni

Usage
gral-core-0.11.jar java library
LinePlotTest jaca class
(For detailed description and examples see Main.java)

#Implements
1) public class Monom implements function
2) public class Monom_Comperator implements Comparator<Monom>
3) public class Polynom implements Polynom_able

#Monom's Constructors:
Monom(double a, int b)
Monom(Monom ot)

#Monom's Methods:
double f(double x)
Monom add (Monom m)
Monom multiply (Monom m)
Monom derivative ()
String toString()
Monom (String str)

#Polynom's Constructors:
Polynom() - Creates "x^0" polynomial, which is exactly "1.0".
Polynom (Polynom p) -Creates a*x^deg polynomial.

#Polynom's Methods:
double f(double x)-value of polynomial at x
add(Polynom_able p1)-Addition
add(Monom m1)-Addition Monom to a Polynom
substract(Polynom_able p1)-Subtraction
multiply(Polynom_able p1)-Multiplication
boolean equals(Polynom_able p1)-Compare two polynomial
void removeZero()
boolean isZero()
double root(double x0, double x1, double eps)
Polynom_able copy()
Polynom_able derivative()
double area(double x0, double x1, double eps)
double areaUnder(double x0, double x1, double eps)
Iterator<Monom> iteretor()
String toString()
Polynom (String str)
