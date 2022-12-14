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

    public VectorClass rotate(float angle) {
        VectorClass result  = new VectorClass();

        result.vectorX = (float) (this.vectorX * Math.cos(angle) - this.vectorY * Math.sin(angle));
        result.vectorY = (float) (this.vectorX * Math.sin(angle) + this.vectorY * Math.cos(angle));
        result.name = this.name + " roterede " + angle + " grader";
        result.vectorStartX = this.vectorStartX;
        result.vectorStartY = this.vectorStartY;

        return result;
    }

    public VectorClass dotProdukt(VectorClass Vector) {
        VectorClass result  = new VectorClass();

        result.vectorX = this.vectorX * Vector.vectorX;
        result.vectorY = this.vectorY * Vector.vectorY;
        result.name = this.name + " * " + Vector.name;
        result.vectorStartX = this.vectorStartX;
        result.vectorStartY = this.vectorStartY;

        return result;
    }

    public VectorClass crossProdukt(VectorClass Vector) {
        VectorClass result  = new VectorClass();

        result.vectorX = this.vectorY * Vector.vectorX;
        result.vectorY = this.vectorX * Vector.vectorY;
        result.name = this.name + " x " + Vector.name;
        result.vectorStartX = this.vectorStartX;
        result.vectorStartY = this.vectorStartY;

        return result;
    }

    public String toString(){

        String finalString = this.name + ": (" + this.vectorX + "," + this.vectorY + "), (" + this.vectorStartX + "," + this.vectorStartY + ")";
        return finalString;
    }


}


