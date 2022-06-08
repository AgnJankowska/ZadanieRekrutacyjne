package main.java;

import java.util.ArrayList;
import java.util.List;

public class MyCompositeBlock extends MyBlock implements CompositeBlock {

    private final int numberOfBlocks;

    public MyCompositeBlock(String color, String material, Integer numberOfBlocks) {
        super(color, material);
        this.numberOfBlocks = numberOfBlocks;
    }

    @Override
    public List<Block> getBlocks() {

        List<Block> listOfBlocks = new ArrayList<>();

        if(numberOfBlocks<0) {
            throw new IllegalArgumentException("Number of blocks must be above 0");
        }

        for(int i=0; i<numberOfBlocks; i++) {
            listOfBlocks.add(new MyBlock(super.getColor(), super.getMaterial()));
        }
        return listOfBlocks;
    }
}
