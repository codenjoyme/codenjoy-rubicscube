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
public class U implements Command {

    @Override
    public void apply(Map<Face, FaceValue> cube) {
        Line frontLine0 = cube.get(Face.FRONT).getLine(0);
        Line rightLine0 = cube.get(Face.RIGHT).getLine(0);
        Line backLine0 = cube.get(Face.BACK).getLine(0);
        Line leftLine0 = cube.get(Face.LEFT).getLine(0);

        cube.get(Face.FRONT).updateLine(0, rightLine0);
        cube.get(Face.RIGHT).updateLine(0, backLine0);
        cube.get(Face.BACK).updateLine(0, leftLine0);
        cube.get(Face.LEFT).updateLine(0, frontLine0);

        cube.get(Face.UP).rotateClockwise();
    }
}
