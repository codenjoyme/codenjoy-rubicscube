package com.codenjoy.dojo.rubicscube.model.command;

import com.codenjoy.dojo.rubicscube.model.Command;
import com.codenjoy.dojo.rubicscube.model.Face;
import com.codenjoy.dojo.rubicscube.model.FaceValue;
import com.codenjoy.dojo.rubicscube.model.Line;

import java.util.Map;

/**
 * User: sanja
 * Date: 08.10.13
 * Time: 6:17
 */
public class R implements Command {

    @Override
    public void apply(Map<Face, FaceValue> cube) {
        Line upRow2 = cube.get(Face.UP).getRow(2);
        Line downRow2 = cube.get(Face.DOWN).getRow(2);
        Line frontRow2 = cube.get(Face.FRONT).getRow(2);
        Line backRow0 = cube.get(Face.BACK).getRow(0);

        cube.get(Face.UP).updateRow(2, frontRow2);
        cube.get(Face.DOWN).updateRow(2, backRow0.invert());
        cube.get(Face.FRONT).updateRow(2, downRow2);
        cube.get(Face.BACK).updateRow(0, upRow2.invert());

        cube.get(Face.RIGHT).rotateClockwise();
    }

}
