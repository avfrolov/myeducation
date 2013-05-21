package util;

import org.junit.Assert;
import org.junit.Test;
import org.myeducation.taskexecuter.core.util.DataSourceUtil;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 17.05.13
 * Time: 0:38
 * To change this template use File | Settings | File Templates.
 */
public class DataSourceUtilTest {

    @Test
    public void testCorrectFileName() throws Exception {
        String str = "file:taskexecuter/files/circuit/correct1.xml";
        File file = (File) DataSourceUtil.getSource(str);
        Assert.assertNotNull(file);
    }
}
