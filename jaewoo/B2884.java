import java.util.Scanner;
public class B2884{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);           
        int H = scan.nextInt();
        int M = scan.nextInt();

        if(M<45){
            M=60-(45-M);
            H--;
        }
        else M -= 45;
           
        if(H<0) H=23;
        System.out.println(H + " " + M);
        
    }
}