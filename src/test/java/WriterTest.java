import enumeration.OperationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.declaration.Writer;
import service.implementation.DuplicateRemovalRule;
import service.implementation.StringWriter;
import service.implementation.StupidRemovalRule;

class WriterTest {

    @Test
    void stupidWordRemovalTest() {
        StupidRemovalRule stupidRemovalRule = new StupidRemovalRule();
        String testString = "Stupid stupid stupid STUPID";
        String result = stupidRemovalRule.fireRule(testString);
        Assertions.assertEquals("Stupid s***** s***** STUPID", result);
    }

    @Test
    void duplicateWordRemovalTest() {
        DuplicateRemovalRule duplicateRemovalRule = new DuplicateRemovalRule();
        String testString = "This is is it";
        String result = duplicateRemovalRule.fireRule(testString);
        Assertions.assertEquals("This is it", result);
    }

    @Test
    void stringWriterTest() {
        Writer stringWriter = new StringWriter(OperationType.DEDUPLICATE, OperationType.DESTUPIFY);
        stringWriter.write("This is really really stupid!!!");
        stringWriter.close();
        stringWriter.write("Something redundant");

        String result = stringWriter.readWrittenInputs();
        Assertions.assertEquals("This is really s*****!!!", result);
    }
}
