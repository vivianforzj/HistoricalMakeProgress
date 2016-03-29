package personal;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * StringToIntegerTransformer Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Mar 25, 2016</pre>
 */
public class StringToIntegerTransformerTest {
    static StringToIntegerTransformer transformer;

    @BeforeClass
    public static void before() throws Exception {
        transformer = new StringToIntegerTransformer();
    }

    @Test
    public void testTransformToIntNormal() throws Exception {
        Integer res = transformer.transformToInt("34");
        assertEquals(34, res.intValue());
    }


    @Test
    public void testTransformToIntNegtive() throws Exception {
        Integer res = transformer.transformToInt("-34");
        assertEquals(-34, res.intValue());
    }

    @Test
    public void testTransformToIntPositive() throws Exception {
        Integer res = transformer.transformToInt("+34");
        assertEquals(34, res.intValue());
    }

    @Test
    public void testTransformToIntFloat() throws Exception {
        Integer res = transformer.transformToInt("+34.45");
        assertNull(res);

        res = transformer.transformToInt("34.45");
        assertNull(res);

        res = transformer.transformToInt("-34.45");
        assertNull(res);
    }

    @Test
    public void testTransformToIntChar() throws Exception {
        Integer res = transformer.transformToInt("+344dg5");
        assertNull(res);

        res = transformer.transformToInt("-344dg5");
        assertNull(res);
    }

    @Test
    public void testTransformToIntOutOfRange() throws Exception {
        Integer res = transformer.transformToInt(String.valueOf(Long.MAX_VALUE - 20000000));
        assertNull(res);
    }

    @Test
    public void testTransformToIntNull() throws Exception {
        Integer res = transformer.transformToInt(null);
        assertNull(res);
    }

    @Test
    public void testTransformToIntEmpty() throws Exception {
        Integer res = transformer.transformToInt("");
        assertNull(res);
    }

    @Test
    public void testTransformToIntZero() throws Exception {
        Integer res = transformer.transformToInt("00");
        assertEquals(0, res.intValue());
    }
}
