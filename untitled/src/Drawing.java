

import java.awt.*;
import java.util.ArrayList;

public class Drawing extends Canvas {

    private ArrayList<VectorClass> vectorList= new ArrayList<VectorClass>();

    int YStart = Main.CanvasH/2;
    int XStart = Main.CanvasW/2;
    int YLength = 0;
    int XLength = 0;
    int Scale = 5;

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g.drawLine(XStart,0,XStart,Main.CanvasH);
        g.drawLine(0,YStart,Main.CanvasW,YStart);




        for (int i = 0; vectorList.size() > i ; i++){

            System.out.println("element: " + vectorList.get(i));
            System.out.println("int: " + i);
            int XVecStart = Math.round(vectorList.get(i).getVectorStartX());
            int YVecStart = Math.round(vectorList.get(i).getVectorStartY());
            int XVecLength = Math.round(vectorList.get(i).getVectorX());
            int YVecLength = Math.round(vectorList.get(i).getVectorY());



            g.drawLine(XVecStart+XStart,YVecStart+YStart,XVecLength + XStart + XVecStart,YVecLength + YStart + YVecStart);
        };




    }

    private void addVector(VectorClass vector){

        //add new vector everytime
        VectorClass tempVector = new VectorClass();

        System.out.println("input " + vector);
        tempVector.setVectorStartY(vector.getVectorStartY()*-Scale); //use new vector instead of this.vector
        tempVector.setVectorStartX(vector.getVectorStartX()*Scale);
        tempVector.setVectorY(vector.getVectorY()*-Scale);
        tempVector.setVectorX(vector.getVectorX()*Scale);
        tempVector.setName(vector.getName());
        System.out.println("output " + tempVector);

        vectorList.add(tempVector);
        System.out.println(vectorList.size());
    }

    public void addVectorList(ArrayList<VectorClass> vectorList){
        vectorList.forEach((element) -> {
            System.out.println(element);
            addVector(element);
            System.out.println(element);
        });
    }
}
