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

    public String toString(){

        String finalString = this.name + ": (" + this.vectorX + "," + this.vectorY + "), (" + this.vectorStartX + "," + this.vectorStartY + ")";
        return finalString;
    }


}


