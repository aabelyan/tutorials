package org.baeldung.ehcache;

import org.baeldung.ehcache.calculator.SquaredCalculator;
import org.baeldung.ehcache.config.CacheHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SquareCalculatorTest {
    private SquaredCalculator squaredCalculator = new SquaredCalculator();
    private CacheHelper cacheHelper = new CacheHelper();

    @Before
    public void setup() {
        squaredCalculator.setCache(cacheHelper);
    }

    @Test
    public void whenCalculatingSquareValueOnce_thenCacheDontHaveValues() {
        for (int i = 10; i < 15; i++) {
            assertFalse(cacheHelper.getSquareNumberCache().containsKey(i));
            System.out.println("Square value of " + i + " is: "
              + squaredCalculator.getSquareValueOfNumber(i) + "\n");
        }
    }

    @Test
    public void whenCalculatingSquareValueAgain_thenCacheHasAllValues() {
        for (int i = 10; i < 15; i++) {
            assertFalse(cacheHelper.getSquareNumberCache().containsKey(i));
            System.out.println("Square value of " + i + " is: "
              + squaredCalculator.getSquareValueOfNumber(i) + "\n");
        }

        for (int i = 10; i < 15; i++) {
            assertTrue(cacheHelper.getSquareNumberCache().containsKey(i));
            System.out.println("Square value of " + i + " is: "
              + squaredCalculator.getSquareValueOfNumber(i) + "\n");
        }
    }
}
