package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    //list of all blocks
    private final List<Block> blocks = new ArrayList<>();

    //wall is build from single blocks and composite blocks
    public Wall(List<Block> singleBlocks, List<CompositeBlock> compositeBlocks) {
        compositeBlocks.forEach(e -> blocks.addAll(e.getBlocks()));
        blocks.addAll(singleBlocks);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {

        if (color == null) {
            throw new IllegalArgumentException("Color is not set");
        }

        return blocks.stream()
                .filter(b -> b.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {

        if (material == null) {
            throw new IllegalArgumentException("Material is not set");
        }
        return blocks.stream()
                .filter(b -> b.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
