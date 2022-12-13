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
    static ArrayList<VectorClass> tegneVectorList = new ArrayList();

    public static void main(String[] args) {

        menu();
    }

    static void menu(){

        int operation;

        System.out.println("1. Tegn 1 vektor");
        System.out.println("2. Pluse 2 vektorer");
        System.out.println("3. Minuse 2 vektorer");
        System.out.println("4. Finde skalarprodukt");
        System.out.println("5. Dividere 2 vektorer");
        System.out.println("6. Finde prikprodukt");
        System.out.println("7. Finde krydsprodukt");
        System.out.println("7. Flyt vektor");
        System.out.println("9. Tegn vektorer");
        System.out.println("0. Exit");

        operation = sc.nextInt();
        sc.nextLine();

       switch (operation) {
           case 1:
               VectorClass Vector = askVector(1);
               vectorList.add(Vector);

               System.out.println(Vector);

               menu();

               break;
           case 2:
               VectorClass Vector1 = askVector(1);
               vectorList.add(Vector1);

               VectorClass Vector2 = askVector(2);
               vectorList.add(Vector2);


               VectorClass result = Vector1.add(Vector2);
               vectorList.add(result);

               System.out.print(Vector1 + "\n");
               System.out.println(Vector2);
               System.out.println(result);

               menu();
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
           case 8:
               System.out.println("hvilken vektor vil du flytte?");

               for(int i = 0; i < vectorList.size(); i++) {
                   System.out.print(vectorList.get(i) + "\n");
               }
               int vektorNummer;

               vektorNummer = sc.nextInt();
               sc.nextLine();

               VectorClass moveVector = (vectorList.get(vektorNummer - 1));

               System.out.println("Hvor meget vil du flytte den?");
               int moveX = sc.nextInt();
                int moveY = sc.nextInt();
                sc.nextLine();


               vectorList.add(moveVector.move(moveX, moveY));

               menu();

                break;
           case 9:
               DrawResult();
               menu();
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

        return vector;

    }


    static void DrawResult() {

        JFrame frame = new JFrame("My Drawing");
        Drawing canvas = new Drawing();
        canvas.setSize(CanvasW, CanvasH);


        System.out.println("1. tegn alle vektorer");
        System.out.println("2. tegn specefik vektor");
        System.out.println("3. tegn flere vektorer");

        int operation;

        operation = sc.nextInt();
        sc.nextLine();

        switch (operation) {
            case 1:

                tegneVectorList = vectorList;
                canvas.addVectorList(tegneVectorList);
                break;
            case 2:
                System.out.println("hvilken vektor vil du tegne?");

                for(int i = 0; i < vectorList.size(); i++) {
                    System.out.print(vectorList.get(i) + "\n");
                }
                int vektorNummer;

                vektorNummer = sc.nextInt();
                sc.nextLine();

                        tegneVectorList.add(vectorList.get(vektorNummer - 1));
                        canvas.addVectorList(tegneVectorList);
                break;
            case 3:
                System.out.println("Hvor mange vektorer vil du tegne?");

                int antalVektorer;
                antalVektorer = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < antalVektorer; i++){
                    System.out.println("hvilken vektor vil du tegne?");
                    for(int j = 0; j < vectorList.size(); j++) {
                        System.out.print(j-1 + "" + vectorList.get(j) + "\n");
                    }
                    int vektorNummer2;
                    vektorNummer2 = sc.nextInt();
                    sc.nextLine();
                    tegneVectorList.add(vectorList.get(vektorNummer2 - 1));
                    canvas.addVectorList(tegneVectorList);
                }

                break;


        }
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        canvas.setBackground(Color.white);

        //menu();

    }
}