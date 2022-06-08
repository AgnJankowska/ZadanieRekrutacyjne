package test.java;

import main.java.*;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;

public class WallTest {

    Block block1 = new MyBlock("red", "concrete");
    Block block2 = new MyBlock("blue", "concrete");
    Block block3 = new MyBlock("red", "wood");

    CompositeBlock compositeBlock1 = new MyCompositeBlock("yellow", "wood", 3);
    CompositeBlock compositeBlock2 = new MyCompositeBlock("gray", "sandstone", 2);

    List<Block> singleBlocksList = new ArrayList<>(
            Arrays.asList(block1, block2, block3));

    List<CompositeBlock> compositeBlocksList = new ArrayList<>(
            Arrays.asList(compositeBlock1, compositeBlock2));


    @Test
    public void shouldReturnBlockForSuitableColorAndOptionalEmptyForUnsuitableColor() {

        //given
        //when
        Wall myWall = new Wall(singleBlocksList, compositeBlocksList);

        //then
        Assertions.assertAll(
                () -> MatcherAssert.assertThat(myWall.findBlockByColor("red"), not(Optional.empty())),
                () -> MatcherAssert.assertThat(myWall.findBlockByColor("yellow"), not(Optional.empty())),
                () -> MatcherAssert.assertThat(myWall.findBlockByColor("black"), is(Optional.empty()))
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNullColorArgument() {

        //given
        //when
        Wall myWall = new Wall(singleBlocksList, compositeBlocksList);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> myWall.findBlockByColor(null));
    }

    @Test
    public void shouldReturnListForSuitableMaterialOrEmptyListForUnsuitableMaterial() {

        //given
        //when
        Wall myWall = new Wall(singleBlocksList, compositeBlocksList);

        //then
        Assertions.assertAll(
                () -> MatcherAssert.assertThat(myWall.findBlocksByMaterial("concrete").size(), equalTo(2)),
                () -> MatcherAssert.assertThat(myWall.findBlocksByMaterial("wood").size(), equalTo(4)),
                () -> MatcherAssert.assertThat(myWall.findBlocksByMaterial("sand").size(), equalTo(0))
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNullMaterialArgument() {

        //given
        //when
        Wall myWall = new Wall(singleBlocksList, compositeBlocksList);

        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> myWall.findBlocksByMaterial(null));
    }

    @Test
    public void shouldReturnSizeOfBlocksList() {
        //given
        List<Block> emptyBlocksList = new ArrayList<>();
        List<CompositeBlock> emptyCompositeBlocksList = new ArrayList<>();

        //when
        Wall myWall1 = new Wall(singleBlocksList, compositeBlocksList);
        Wall myWall2 = new Wall(singleBlocksList, emptyCompositeBlocksList);
        Wall myWall3 = new Wall(emptyBlocksList, emptyCompositeBlocksList);

        //then
        Assertions.assertAll(
                () -> MatcherAssert.assertThat(myWall1.count(), equalTo(8)),
                () -> MatcherAssert.assertThat(myWall2.count(), equalTo(3)),
                () -> MatcherAssert.assertThat(myWall3.count(), equalTo(0))
        );
    }

}
