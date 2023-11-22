class Main 
{ 
    public static void main(String[] args) 
    { 
        C c_obj = new C();  //create Class C obj 
        c_obj.print_A();    //call grandparent class method
        c_obj.print_B();    //call parent class method
        c_obj.print_C();    //call member method
    } 
}
class A 
{ 
    public void print_A() 
    { 
        System.out.print("Software Testing Help "); 
    } 
} 
class B extends A 
{ 
    public void print_B() 
    { 
        System.out.print("Java Series "); 
    } 
} 
class C extends B 
{ 
    public void print_C() 
    { 
        System.out.print("Tutorials"); 
    } 
} 
  