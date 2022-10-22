package DevpathsQuestions;

public class AFizzBuzz {

    public static void fizzBuzz(int n){
       for(int i=1;i<=n;i++){
           if(i % 3 == 0 && i % 5 == 0)
               System.out.println("FizzBuzz");
           if(i % 3 == 0 && i % 5 != 0)
               System.out.println("Fizz");
           if(i % 5 == 0 && i % 3 != 0)
               System.out.println("Buzz");
           if(i % 3 != 0 || i % 5 != 0)
               System.out.println(i);
       }
    }

    public static void main(String[] args) {
        fizzBuzz(15);
    }
}
