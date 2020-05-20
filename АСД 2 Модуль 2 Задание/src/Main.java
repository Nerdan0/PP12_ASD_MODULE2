import java.util.LinkedList;
import java.util.Scanner;

 class ASD2 {
    public static void main(String args[]){

        try{
            Scanner in = new Scanner(System.in);
            int n, add;
            System.out.println("Введите количество N и количество Add.");
            n=in.nextInt();
            add=in.nextInt();

            LinkedList a1 = new LinkedList<Integer>();
            System.out.println("Введите значение");

            for(int i=0; i < n; i++){
                System.out.print("N"+(i+1)+" : ");
                a1.add(in.nextInt());
            }
            for(int i=0;i<n;i++){

                System.out.println(a1.get(i));
            }
            System.out.println("Введите доп. элементы");
            for(int i=0; i < add; i++) {
                System.out.print("A"+(i+1)+" : ");
                a1.add(in.nextInt());
            }
            a1.sort(null);
            for(int i=0;i<n+add;i++){
                System.out.println(a1.get(i));
            }
        }
        catch(Exception e){
            System.out.println("Неверно, попробуйте по другому");
            main(new String[]{"Не повторяйтесь"});
            return;
        }
    }
}