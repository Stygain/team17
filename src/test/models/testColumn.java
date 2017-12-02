package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class testColumn {

    @Test
    public void testColumnId() {
        Column c = new Column();
        assertNotNull(c);
        Column c2 = new Column(1);
        assertEquals(1, c2.id);
    }

}
