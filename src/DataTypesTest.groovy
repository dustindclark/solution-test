import org.apache.commons.io.FileUtils
import org.apache.tools.ant.filters.StringInputStream

/**
 * Created by dustin on 6/15/16.
 */
class DataTypesTest extends groovy.util.GroovyTestCase {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    void testSolutionMain() {
        System.setIn(new StringInputStream(getInput()))
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        Solution.main(new String()[])

        String left = outContent.toString()?.trim()
        String right = getOutput()

        if(!left.equals(right)) {
            FileUtils.writeStringToFile(new File("/Users/dustin/Desktop/left.txt"), left)
            FileUtils.writeStringToFile(new File("/Users/dustin/Desktop/right.txt"), right)
        }

        assert left.equals(right);
    }

    String getInput() {
return """
17
9223372036854775808
9223372036854775807
-9223372036854775808
-9223372036854775807
4294967296
4294967295
-4294967296
-4294967295
65536
65535
-65536
-65535
256
255
-256
-255
12222222222222222222222222222222222222222221
""".trim()

    }

    String getOutput() {
return """
9223372036854775808 can't be fitted anywhere.
9223372036854775807 can be fitted in:
* long
-9223372036854775808 can be fitted in:
* long
-9223372036854775807 can be fitted in:
* long
4294967296 can be fitted in:
* long
4294967295 can be fitted in:
* long
-4294967296 can be fitted in:
* long
-4294967295 can be fitted in:
* long
65536 can be fitted in:
* int
* long
65535 can be fitted in:
* int
* long
-65536 can be fitted in:
* int
* long
-65535 can be fitted in:
* int
* long
256 can be fitted in:
* short
* int
* long
255 can be fitted in:
* short
* int
* long
-256 can be fitted in:
* short
* int
* long
-255 can be fitted in:
* short
* int
* long
12222222222222222222222222222222222222222221 can't be fitted anywhere.
""".trim()
    }
}
