package com.codenjoy.dojo.rubicscube.model.command;

import com.codenjoy.dojo.rubicscube.model.Command;
import com.codenjoy.dojo.rubicscube.model.Face;
import com.codenjoy.dojo.rubicscube.model.FaceValue;
import com.codenjoy.dojo.rubicscube.model.Line;

import java.util.Map;

/**
 * User: sanja
 * Date: 08.10.13
 * Time: 5:23
 */
public class F implements Command {

    @Override
    public void apply(Map<Face, FaceValue> cube) {
        Line upLine2 = cube.get(Face.UP).getLine(2);
        Line downLine0 = cube.get(Face.DOWN).getLine(0);
        Line leftRow2 = cube.get(Face.LEFT).getRow(2);
        Line rightRow0 = cube.get(Face.RIGHT).getRow(0);

        cube.get(Face.UP).updateLine(2, leftRow2.invert());
        cube.get(Face.LEFT).updateRow(2, downLine0);
        cube.get(Face.DOWN).updateLine(0, rightRow0.invert());
        cube.get(Face.RIGHT).updateRow(0, upLine2);

        cube.get(Face.FRONT).rotateClockwise();
    }
}
