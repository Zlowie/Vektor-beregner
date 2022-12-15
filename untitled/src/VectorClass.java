public class VectorClass {
    private float vectorX = 0;
    private float vectorY = 0;
    private float vectorStartX = 0;
    private float vectorStartY = 0;

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public void setVectorX(float vectorX) {
        this.vectorX = vectorX;
    }
    public void setVectorY(float vectorY) {
        this.vectorY = vectorY;
    }
    public void setVectorStartX(float vectorStartX) {
        this.vectorStartX = vectorStartX;
    }
    public void setVectorStartY(float vectorStartY) {
        this.vectorStartY = vectorStartY;
    }

    public String getName() {
        return name;
    }
    public float getVectorX() {
        return vectorX;
    }
    public float getVectorY() {
        return vectorY;
    }
    public float getVectorStartX() {
        return vectorStartX;
    }
    public float getVectorStartY() {
        return vectorStartY;
    }

    public VectorClass add(VectorClass Vector) {
        VectorClass result  = new VectorClass();

        result.vectorX = this.vectorX + Vector.vectorX;
        result.vectorY = this.vectorY + Vector.vectorY;
        result.name = this.name + " + " + Vector.name;
        result.vectorStartX = this.vectorStartX;
        result.vectorStartY = this.vectorStartY;

        return result;
    }

    public VectorClass sub(VectorClass Vector) {
        VectorClass result  = new VectorClass();

        result.vectorX = this.vectorX - Vector.vectorX;
        result.vectorY = this.vectorY - Vector.vectorY;
        result.name = this.name + " - " + Vector.name;
        result.vectorStartX = this.vectorStartX;
        result.vectorStartY = this.vectorStartY;

        return result;
    }

    public VectorClass move(int x, int y) {
        VectorClass result  = new VectorClass();

        result.vectorX = this.vectorX;
        result.vectorY = this.vectorY;
        result.name = "moved " + this.name ;
        result.vectorStartX = this.vectorStartX + x;
        result.vectorStartY = this.vectorStartY + y;

        return result;
    }

public VectorClass scale(float scale) {
        VectorClass result  = new VectorClass();

        result.vectorX = this.vectorX * scale;
        result.vectorY = this.vectorY * scale;
        result.name = this.name + " * " + scale;
        result.vectorStartX = this.vectorStartX;
        result.vectorStartY = this.vectorStartY;

        return result;
    }

    public VectorClass rotate(double angle) {
        VectorClass result  = new VectorClass();

        result.vectorX = (float) (this.vectorX * Math.cos(angle) - this.vectorY * Math.sin(angle));
        result.vectorY = (float) (this.vectorX * Math.sin(angle) + this.vectorY * Math.cos(angle));
        result.name = this.name + " roteret " + angle * 180/Math.PI + " grader";
        result.vectorStartX = this.vectorStartX;
        result.vectorStartY = this.vectorStartY;

        return result;
    }

    public float dotProdukt(VectorClass Vector) {
        float result;

        result = this.vectorX * Vector.vectorX + this.vectorY * Vector.vectorY;

        return result;
    }

    public float crossProdukt(VectorClass Vector) {
        float result;

        result= this.vectorX * Vector.vectorY - this.vectorY * Vector.vectorX;
        if(result < 0) {
            result = result * -1;
        }

        return result;
    }

    public String toString(){

        String finalString = this.name + ": (" + this.vectorX + "," + this.vectorY + "), (" + this.vectorStartX + "," + this.vectorStartY + ")";
        return finalString;
    }


}


