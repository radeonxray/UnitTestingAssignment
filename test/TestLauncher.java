import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.LoggingListener;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.util.logging.Level;

public class TestLauncher {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Discover and filter tests
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(
                        selectClass(InterestTest.class))
                .filters(includeClassNamePatterns(".*Test")).build();

        Launcher launcher = LauncherFactory.create();
        TestPlan plan = launcher.discover(request);

        for (TestIdentifier root : plan.getRoots()) {
            System.out.println("Root: " + root.toString());

            for (TestIdentifier test : plan.getChildren(root)) {
                System.out.println("Found test: " + test.toString());
            }
        }

        TestExecutionListener listener = LoggingListener.forJavaUtilLogging(Level.INFO);
        launcher.registerTestExecutionListeners(listener);
        // Executing tests
        //TestExecutionListener listener = new SummaryGeneratingListener();
        //launcher.registerTestExecutionListeners(listener);

        launcher.execute(request, listener);
    }

}
