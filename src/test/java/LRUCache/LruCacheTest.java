package LRUCache;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class LruCacheTest {

    private LruCache cache;

    @Before
    public void init() {
        cache = new LruCache(5);
    }

    @Test
    public void testGetHappyPath() {
        int expectedResult = 10;

        cache.put(1, 10);

        int actualResult = cache.get(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPutHappyPath() {
        int expectedResult = 13;

        cache.put(1, 10);
        cache.put(1, 13);

        int actualResult = cache.get(1);

        assertEquals(expectedResult, actualResult);
    }
}