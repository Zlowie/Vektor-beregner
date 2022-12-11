import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static VectorClass Vector1 = new VectorClass();

    static int CanvasW = 600;
    static int CanvasH = 600;

    static ArrayList<VectorClass> vectorList = new ArrayList();

    public static void main(String[] args) {

        menu();
    }

    static void menu(){

        int operation;

        System.out.println("1. tegn 1 vektor");
        System.out.println("2. Pluse 2 vektorer");
        System.out.println("3. Minuse 2 vektorer");
        System.out.println("4. finde skalarprodukt");
        System.out.println("5. Dividere 2 vektorer");
        System.out.println("6. Finde prikprodukt");
        System.out.println("7. Finde krydsprodukt");
        System.out.println("0. Exit");

        operation = sc.nextInt();
        sc.nextLine();

       switch (operation) {
           case 1:
               VectorClass Vector = askVector(1);
               vectorList.add(Vector);

               System.out.println(Vector);
               DrawResult(Vector);

               break;
           case 2:
               VectorClass Vector1 = askVector(1);
               vectorList.add(Vector1);

               VectorClass Vector2 = askVector(2);
               vectorList.add(Vector2);


               VectorClass result = Vector1.add(Vector2);
               vectorList.add(result);

               System.out.print(Vector1);
               System.out.println(Vector2);
               System.out.println(result);

               DrawResult(result);

               break;
           // case 3:
           //     multiplyVectors();
           //     break;
           // case 4:
           //     divideVectors();
           //     break;
           // case 5:
           //     dotProduct();
           //     break;
           //case 8:

           //     break;
           case 9:
               break;
           case 0:
               System.exit(0);
               sc.close();
               break;
       }

    }

    static VectorClass askVector(int nr){
        System.out.println("indtast " + nr + ". Vektors navn");
        String name = sc.nextLine();
        System.out.println("indtast " + name + "'s længde på x-aksen");
        float vec1x = sc.nextFloat();
        System.out.println("indtast " + name + "'s længde på y-aksen");
        float vec1y = sc.nextFloat();
        System.out.println("indtast " + name + "'s start på x-aksen");
        float vecxStart= sc.nextFloat();
        System.out.println("indtast " + name + "'s start på y-aksen");
        float vecyStart = sc.nextFloat();
        sc.nextLine();

        VectorClass vector = new VectorClass();

        vector.setName(name);
        vector.setVectorX(vec1x);
        vector.setVectorY(vec1y);
        vector.setVectorStartX(vecxStart);
        vector.setVectorStartY(vecyStart);

        //System.out.println("vektor1 = " + vec1x + ", " + vec1y + " og starter i " + vecxStart + ", " + vecyStart);

        return vector;

    }


    static void DrawResult(VectorClass finalVector){
        JFrame frame = new JFrame("My Drawing");
        Drawing canvas = new Drawing();
        canvas.addVectorList(vectorList);
        canvas.setSize(CanvasW, CanvasH);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        canvas.setBackground(Color.white);

    }


}