
package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tenis.system.Main;

/**
 *
 * @author Marcin
 */
public class MainTest {

    Main main;

    @Before
    public void setUp() {
        main = new Main();
    }

    @Test
    public void generalScoreTrackingTest() {
        // Phase 1: track points Test        
        // When
        main.playerAWonPoint();
        main.playerBWonPoint();
        // Then
        assertEquals("0/0 0/0 15/15", main.currentScore());

        // When
        main.playerAWonPoint();
        main.playerBWonPoint();
        // Then
        assertEquals("0/0 0/0 30/30", main.currentScore());

        // When
        main.playerAWonPoint();
        main.playerBWonPoint();
        // Then
        assertEquals("0/0 0/0 40/40", main.currentScore());

        // When
        main.playerBWonPoint();
        // Then
        assertEquals("0/0 0/0 40/AD", main.currentScore());

        // When
        main.playerAWonPoint();
        // Then
        assertEquals("0/0 0/0 40/40", main.currentScore());

        // When
        main.playerAWonPoint();
        // Then
        assertEquals("0/0 0/0 AD/40", main.currentScore());

        // Phase 2: track games Test
        // When
        main.playerAWonPoint();
        // Then
        assertEquals("0/0 1/0 0/0", main.currentScore());

        // When
        for (int i = 0; i < 4; i++) {
            main.playerBWonPoint();
        }
        // Then
        assertEquals("0/0 1/1 0/0", main.currentScore());

        // When
        for (int i = 0; i < 4; i++) {
            main.playerBWonPoint();
        }
        // Then
        assertEquals("0/0 1/2 0/0", main.currentScore());

        // When
        for (int i = 0; i < 12; i++) {
            main.playerBWonPoint();
        }
        for (int i = 0; i < 20; i++) {
            main.playerAWonPoint();
        }
        // Then
        assertEquals("0/0 6/5 0/0", main.currentScore());

        // Phase 3: tie-break Test
        // When
        for (int i = 0; i < 4; i++) {
            main.playerBWonPoint();
        }
        for (int i = 0; i < 2; i++) {
            main.playerAWonPoint();
            main.playerBWonPoint();
        }
        // Then
        assertEquals("0/0 6/6 2/2", main.currentScore());

        // When
        for (int i = 0; i < 4; i++) {
            main.playerBWonPoint();
        }
        // Then
        assertEquals("0/0 6/6 2/6", main.currentScore());

        // When
        for (int i = 0; i < 4; i++) {
            main.playerAWonPoint();
        }
        // Then
        assertEquals("0/0 6/6 6/6", main.currentScore());

        // Phase 4: set track Test
        // When
        main.playerAWonPoint();
        main.playerAWonPoint();
        // Then
        assertEquals("1/0 0/0 0/0", main.currentScore());

        // When
        for (int i = 0; i < 24; i++) {
            main.playerAWonPoint();
        }
        // Then
        assertEquals("2/0 0/0 0/0", main.currentScore());

        // When
        for (int i = 0; i < 48; i++) {
            main.playerBWonPoint();
        }
        // Then
        assertEquals("2/2 0/0 0/0", main.currentScore());

        // Phase 5: tie-break at 5th set at 12/12 gem Test
        // When
        for (int i = 0; i < 20; i++) {
            main.playerBWonPoint();
        }
        for (int i = 0; i < 40; i++) {
            main.playerAWonPoint();
        }
        // Then
        assertEquals("2/2 10/5 0/0", main.currentScore());

        // When
        main.playerAWonPoint();
        main.playerAWonPoint();
        main.playerAWonPoint();
        main.playerBWonPoint();
        main.playerBWonPoint();
        main.playerBWonPoint();
        main.playerAWonPoint();
        // Then
        assertEquals("2/2 10/5 AD/40", main.currentScore());

        // When
        main.playerAWonPoint();
        for (int i = 0; i < 28; i++) {
            main.playerBWonPoint();
        }
        // Then
        assertEquals("2/2 11/12 0/0", main.currentScore());

        // When
        for (int i = 0; i < 4; i++) {
            main.playerAWonPoint();
        }
        for (int i = 0; i < 6; i++) {
            main.playerBWonPoint();
        }
        // Then
        assertEquals("2/2 12/12 0/6", main.currentScore());

        // When
        for (int i = 0; i < 6; i++) {
            main.playerAWonPoint();
        }
        // Then
        assertEquals("2/2 12/12 6/6", main.currentScore());

        // When
        main.playerAWonPoint();
        // Then
        assertEquals("2/2 12/12 7/6", main.currentScore());

        // Phase 5: match Test
        // When
        main.playerAWonPoint();
        // Then
        assertEquals("3/2 0/0 0/0", main.currentScore());
        
         // Phase 6: End match Test
        // When
        main.playerAWonPoint();
        // Then
        assertEquals("3/2 0/0 0/0", main.currentScore());
        // When
        main.playerBWonPoint();
        // Then
        assertEquals("3/2 0/0 0/0", main.currentScore());
    }
}
