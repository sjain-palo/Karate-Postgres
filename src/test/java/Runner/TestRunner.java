package Runner;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

class TestRunner {

    @Test
    void apiFunctionalTest() {
        Results results = Runner.path("classpath:Features").parallel(0);
    }
}