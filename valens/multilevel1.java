class TestMultilevel
{
public static void main(String args[]) 
{
Shipment shipment1 = new Shipment(1, 2, 3, 5, 3.41);
Shipment shipment2 = new Shipment(2, 4, 6, 10, 1.28);

double vol;
vol = shipment1.volume();

System.out.println("The volume of shipment1 is " + vol);
System.out.println("The weight of shipment1 is " + shipment1.weight);
System.out.println("Shipping cost: Rs." + shipment1.cost);
System.out.println();

vol = shipment2.volume();
System.out.println("The volume of shipment2 is " + vol);
System.out.println("The weight of shipment2 is " + shipment2.weight);
System.out.println("Shipping cost: Rs." + shipment2.cost);
}
}
class Box {
private double width;
private double height;
private double depth;

Box(double w, double h, double d) 
{
width = w;
height = h;
depth = d;
}

double volume() {
return width * height * depth;
}
}

class BoxWeight extends Box 
{
double weight; // weight of box

BoxWeight(double w, double h, double d, double m) {
super(w, h, d); // calling superclass constructor
weight = m;
}
}

class Shipment extends BoxWeight {
double cost;

Shipment(double w, double h, double d, double m, double c) {
super(w, h, d, m); // calling superclass constructor
cost = c;
}

}

