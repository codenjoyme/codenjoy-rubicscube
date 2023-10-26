package com.codenjoy.dojo.rubicscube.services;

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


import com.codenjoy.dojo.rubicscube.TestGameSettings;
import com.codenjoy.dojo.services.event.ScoresMap;
import com.codenjoy.dojo.utils.scorestest.AbstractScoresTest;
import org.junit.Test;

import static com.codenjoy.dojo.rubicscube.services.GameSettings.Keys.FAIL_PENALTY;
import static com.codenjoy.dojo.rubicscube.services.GameSettings.Keys.SUCCESS_SCORE;

public class ScoresTest extends AbstractScoresTest {

    @Override
    public GameSettings settings() {
        return new TestGameSettings()
                .integer(SUCCESS_SCORE, 10)
                .integer(FAIL_PENALTY, -5);
    }

    @Override
    protected Class<? extends ScoresMap> scores() {
        return Scores.class;
    }

    @Override
    protected Class<? extends Enum> eventTypes() {
        return Event.class;
    }

    @Test
    public void shouldCollectScores() {
        assertEvents("100:\n" +
                "SUCCESS > +10 = 110\n" +
                "SUCCESS > +10 = 120\n" +
                "SUCCESS > +10 = 130\n" +
                "SUCCESS > +10 = 140\n" +
                "FAIL > -5 = 135");
    }

    @Test
    public void shouldNotBeLessThanZero() {
        assertEvents("10:\n" +
                "FAIL > -5 = 5\n" +
                "FAIL > -5 = 0\n" +
                "FAIL > +0 = 0");
    }

    @Test
    public void shouldCleanScore() {
        assertEvents("100:\n" +
                "SUCCESS > +10 = 110\n" +
                "(CLEAN) > -110 = 0\n" +
                "SUCCESS > +10 = 10");
    }

    @Test
    public void shouldCollectScores_whenSuccess() {
        // given
        settings.integer(SUCCESS_SCORE, 10);

        // when then
        assertEvents("100:\n" +
                "SUCCESS > +10 = 110\n" +
                "SUCCESS > +10 = 120");
    }

    @Test
    public void shouldCollectScores_whenFail() {
        // given
        settings.integer(FAIL_PENALTY, -5);

        // when then
        assertEvents("100:\n" +
                "FAIL > -5 = 95\n" +
                "FAIL > -5 = 90");
    }
}