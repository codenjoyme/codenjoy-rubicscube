package com.codenjoy.dojo.rubicscube.model.command;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2022 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */



import com.codenjoy.dojo.rubicscube.model.Command;
import com.codenjoy.dojo.rubicscube.model.Face;
import com.codenjoy.dojo.rubicscube.model.FaceValue;
import com.codenjoy.dojo.rubicscube.model.Line;

import java.util.Map;

public class B implements Command {

    @Override
    public void apply(Map<Face, FaceValue> cube) {
        Line upLine0 = cube.get(Face.UP).getLine(0);
        Line leftRow0 = cube.get(Face.LEFT).getRow(0);
        Line downLine2 = cube.get(Face.DOWN).getLine(2);
        Line rightRow2 = cube.get(Face.RIGHT).getRow(2);

        cube.get(Face.UP).updateLine(0, rightRow2);
        cube.get(Face.LEFT).updateRow(0, upLine0.invert());
        cube.get(Face.DOWN).updateLine(2, leftRow0);
        cube.get(Face.RIGHT).updateRow(2, downLine2.invert());

        cube.get(Face.BACK).rotateClockwise();
    }
}
