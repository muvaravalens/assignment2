class TestInheritance{  
public static void main(String args[]){  
class Animal{  
void eat(){System.out.println("eating...");}  
}  
class Dog extends Animal{  
void bark(){System.out.println("barking...");}  
}    
Dog d=new Dog();  
d.bark();  
d.eat();  
}}  