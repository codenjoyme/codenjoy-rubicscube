package com.codenjoy.dojo.rubicscube.model;

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


import com.codenjoy.dojo.services.dice.MockDice;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomCommandTest {

    @Test
    public void shouldGenerate() {
        // given
        MockDice dice = new MockDice();
        RandomCommand generator = new RandomCommand(dice);

        dice.whenThen(100,
                6*3);
        dice.whenThen(6*3,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);

        //when
        String next = generator.next();

        //then
        assertEquals("BB2B'DD2D'FF2F'LL2L'RR2R'UU2U'", next);
    }
}
