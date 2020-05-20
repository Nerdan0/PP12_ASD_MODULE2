import java.util.Scanner;
import java.util.Stack;
 class ASD {

    public static void main(String[] args){

        try{
            Scanner in = new Scanner(System.in);
            int n1, n2, n3;
            int v1=0, v2=0, v3=0;
            System.out.println("Введите значение для N1 N2 N3.");
            n1=in.nextInt();
            n2=in.nextInt();
            n3=in.nextInt();
            Stack a1 = new Stack<Integer>();
            Stack a2 = new Stack<Integer>();
            Stack a3 = new Stack<Integer>();
            System.out.println("Введите стеки");
            System.out.print("N1: ");
            for(int i=0; i < n1; i++){
                int temp = in.nextInt();
                a1.push(temp);
                v1+=temp;
            }
            System.out.print("N2: ");
            for(int i=0; i < n2; i++){
                int temp = in.nextInt();
                a2.push(temp);
                v2+=temp;
            }
            System.out.print("N3: ");
            for(int i=0; i < n3; i++){
                int temp = in.nextInt();
                a3.push(temp);
                v3+=temp;
            }
            int minsize=9999999;
            while(true) {
                if (minsize > v1) minsize = v1;
                if (minsize > v2) minsize = v2;
                if (minsize > v3) minsize = v3;

                while (v1 > minsize) {
                    int temp = (int) a1.pop();
                    v1 = v1 - temp;
                    if (v1 < minsize) {
                        minsize = v1;
                    }

                }
                while (v2 > minsize) {
                    int temp = (int) a2.pop();
                    v2 = v2 - temp;
                    if (v2 < minsize) {
                        minsize = v2;
                    }

                }
                while (v3 > minsize) {
                    int temp = (int) a3.pop();
                    v3 = v3 - temp;
                    if (v3 < minsize) {
                        minsize = v3;
                    }

                }
                if(v1==v2&&v2==v3&&minsize!=0){
                    System.out.println("Max розмер = " + minsize);
                    return;
                }
                if(minsize<=0){
                    System.out.println("Не правильно");
                    return;
                }
            }
        }
        catch(Exception e){
            System.out.println("Не верно");
            main(new String[]{"Зачем делать тоже самое"});
            return;
        }


    }
}