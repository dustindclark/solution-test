import org.apache.commons.io.FileUtils
import org.apache.tools.ant.filters.StringInputStream

/**
 * Created by dustin on 6/15/16.
 */
class SolutionTest extends groovy.util.GroovyTestCase {
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
3
SENIOR 75
JUNIOR 45
SENIOR 40
""".trim()

    }

    String getOutput() {
return """
Senior Member
Spend: 75
Budget Left: 25
Junior Member
Spend: 45
Budget Left: 5
Senior Member
Spend: 40
Budget Left: 60
""".trim()
    }
}
