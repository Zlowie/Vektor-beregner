import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
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

        System.out.println("1. Lav 1 vektor");
        System.out.println("2. Pluse 2 vektorer");
        System.out.println("3. Minuse 2 vektorer");
        System.out.println("4. Find prikprodukt");
        System.out.println("5. Find Areal");
        System.out.println("6. Flyt vektor");
        System.out.println("7. Roter vektor");
        System.out.println("8. Skaler vektor");
        System.out.println("9. Tegn vektorer");
        System.out.println("10. Fjern vektor");
        System.out.println("0. Exit");

        try {
            operation = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Du skal indtaste et tal fra 0-10");
            sc.nextLine();
            menu();
            return;
        }

       switch (operation) {
           case 1:

               VectorClass Vector = askVector(1);
               vectorList.add(Vector);

               System.out.println(Vector);

               menu();

               break;
           case 2:
               System.out.println("hvilken vektorer vil du pluse?" );
               VectorClass vector10 = ChooseVector(1);

               VectorClass vector11 = ChooseVector(2);


               VectorClass result = vector10.add(vector11);
               vectorList.add(result);

               System.out.println(vector10 + " + " + vector11 + " = " + result);

               menu();
               break;
           case 3:

               System.out.println("hvilken vektor vil du minuse?" );
               VectorClass vector8 = ChooseVector(1);

               System.out.println("hvilken vektor vil du trække fra?" );
               VectorClass vector9 = ChooseVector(2);


               VectorClass result2 = vector8.sub(vector9);
               vectorList.add(result2);

               System.out.println(vector8 + " - " + vector9 + " = " + result2);

               menu();
                break;
           case 4:

                System.out.println("hvilken vektorer vil du finde prikproduktet af?" );
                VectorClass vector6 = ChooseVector(1);
                VectorClass vector7 = ChooseVector(2);
                float result4 = vector6.dotProdukt(vector7);

                //vectorList.add(result4);
                System.out.println(vector6 + " Dot " + vector7 + " = " + result4);

                menu();

                break;
           case 5:
               System.out.println("hvilket vektorer vil du finde arealet af?");

               VectorClass vector4 = ChooseVector(1);

               VectorClass vector5 = ChooseVector(2);

               float result3 = vector4.crossProdukt(vector5);
               //vectorList.add(result3);

               System.out.println("alrealet af " + vector4 + " og " + vector5 + " er: " + result3);

               menu();
                break;
           case 6:
               System.out.println("hvilken vektor vil du flytte?");

               VectorClass vector3 = ChooseVector(1);

               System.out.println("Hvor meget vil du flytte den?");
               int moveX = sc.nextInt();
                int moveY = sc.nextInt();
                sc.nextLine();


               vectorList.add(vector3.move(moveX, moveY));
               System.out.println(vector3 + " er blevet flyttet til " + vector3.move(moveX, moveY));

               menu();

                break;
           case 7:
               System.out.println("hvilken vektor vil du rotere?");
                VectorClass vector2 = ChooseVector(1);

                System.out.println("hvor mange grader vil du rotere den?");
                double rotation =(sc.nextInt() * Math.PI / 180);
                sc.nextLine();

                vectorList.add(vector2.rotate(rotation));
                System.out.println(vector2.rotate(rotation));

                menu();

                break;
           case 8:
                System.out.println("hvilken vektor vil du skaler?");

                VectorClass vector1 = ChooseVector(1);

                System.out.println("hvor meget vil du skaler den?");
                float scale = sc.nextFloat();
                sc.nextLine();

                vectorList.add(vector1.scale(scale));
                System.out.println(vector1.scale(scale) + " er " + vector1 + " skaleret med " + scale);

                menu();
                  break;
           case 9:
                    DrawResult();
                    menu();

                    break;
              case 10:
                    System.out.println("hvilken vektor vil du fjerne?");
                    VectorClass vector = ChooseVector(1);

                    vectorList.remove(vector);

                    menu();
                    break;
           case 0:
               System.exit(1);
               sc.close();
               break;
       }

    }

    static VectorClass askVector(int nr){
        System.out.println("indtast " + nr + ". Vektors navn");
        String name = sc.nextLine();

        try {
            System.out.println("indtast " + name + "'s længde på x-aksen");
            float vec1x = sc.nextFloat();
            System.out.println("indtast " + name + "'s længde på y-aksen");
            float vec1y = sc.nextFloat();
            System.out.println("indtast " + name + "'s start på x-aksen");
            float vecxStart = sc.nextFloat();
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
        }catch (Exception e){
            sc.nextLine();

            askVector(nr);
            System.out.println("Du skal indtaste tal");
        }

        return null;
    }

    static VectorClass ChooseVector(int nr) {

        try{
            for (int i = 0; i < vectorList.size(); i++) {
                System.out.println(i + 1 + ". " + vectorList.get(i).getName());
            }

            int vectorNr = sc.nextInt();
            sc.nextLine();

            VectorClass vector = vectorList.get(vectorNr - 1);

            return vector;
        } catch (Exception e) {
            sc.nextLine();

            System.out.println("Der er ikke nogen vektorer med det nummer");
            menu();
        }
         return null;
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
            case 1: //tegner alle vektorer
                tegneVectorList.clear();
                //tegneVectorList = vectorList;

                for (int i = 0; i < vectorList.size(); i++) {
                    tegneVectorList.add(vectorList.get(i));
                }

                canvas.addVectorList(tegneVectorList);
                break;
            case 2://tegner en specefik vektor
                System.out.println("hvilken vektor vil du tegne?");
                tegneVectorList.clear();

                for(int i = 0; i < vectorList.size(); i++) {
                    System.out.print(i+1 + ". " + vectorList.get(i) + "\n");
                }
                int vektorNummer;

                vektorNummer = sc.nextInt();
                sc.nextLine();

                        tegneVectorList.add(vectorList.get(vektorNummer - 1));
                        canvas.addVectorList(tegneVectorList);
                break;
            case 3://tegner et givet mængde vektorer
                System.out.println("Hvor mange vektorer vil du tegne?");
                tegneVectorList.clear();

                int antalVektorer;
                antalVektorer = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < antalVektorer; i++){
                    System.out.println("hvilken vektor vil du tegne?");
                    for(int j = 0; j < vectorList.size(); j++) {
                        System.out.print(j+1 + ". " + vectorList.get(j) + "\n");
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
    }
}