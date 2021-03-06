package main.java;

public class MyBlock implements Block {

    private final String color;
    private final String material;

    public MyBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
