

import java.awt.*;
import java.util.ArrayList;

public class Drawing extends Canvas {

    private ArrayList<VectorClass> vectorList= new ArrayList<VectorClass>();

    int YStart = Main.CanvasH/2;
    int XStart = Main.CanvasW/2;
    int YLength = 0;
    int XLength = 0;
    int Scale = 5;

    public void paint(Graphics g){ //køre når tegningen er åben
        Graphics2D g2 = (Graphics2D) g;


        g2.setColor(Color.LIGHT_GRAY);
        for(int i = 0; i*Scale*2 < Main.CanvasW; i++){
            g2.drawLine(i*Scale*2, 0, i*Scale*2, Main.CanvasH);
            g2.drawLine(0, i*Scale*2, Main.CanvasW, i*Scale*2);
        }

        g2.setColor(Color.BLACK);
        g2.drawLine(XStart,0,XStart,Main.CanvasH);
        g2.drawLine(0,YStart,Main.CanvasW,YStart);




        for (int i = 0; vectorList.size() > i ; i++){

            int XVecStart = Math.round(vectorList.get(i).getVectorStartX());
            int YVecStart = Math.round(vectorList.get(i).getVectorStartY());
            int XVecLength = Math.round(vectorList.get(i).getVectorX());
            int YVecLength = Math.round(vectorList.get(i).getVectorY());


            g2.setColor(Color.RED);

            g2.drawLine(XVecStart+XStart,YVecStart+YStart,XVecLength + XStart + XVecStart,YVecLength + YStart + YVecStart);

        };




    }

    private void addVector(VectorClass vector){

        //add new vector everytime
        VectorClass tempVector = new VectorClass();

        tempVector.setVectorStartY(vector.getVectorStartY()*-Scale); //use new vector instead of this.vector
        tempVector.setVectorStartX(vector.getVectorStartX()*Scale);
        tempVector.setVectorY(vector.getVectorY()*-Scale);
        tempVector.setVectorX(vector.getVectorX()*Scale);
        tempVector.setName(vector.getName());

        vectorList.add(tempVector);

    }


    public void addVectorList(ArrayList<VectorClass> vectorList){ //skal være cleared
        vectorList.forEach((element) -> {
            //System.out.println(element);
            addVector(element);
        });
    }
}
