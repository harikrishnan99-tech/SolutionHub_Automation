package org.solutionhub;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature_files/features/init/login.feature",
                "src/test/resources/feature_files/features/producer/assets.feature"
                },
        glue = {"org.solutionhub.steps.login",
                "org.solutionhub.steps.assets"
        }
)
public class TestRunner {
}
