package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO-07: Perform component-scanning and run the test again
 * - Add an appropriate annotation to this class to cause component scanning.
 * - Set the base package to pick up all the classes we have annotated so far.
 * - Save all changes, Re-run the RewardNetworkTests.  It should now pass.
 */
@Configuration
// Turns on a feature called component scanning which looks for all classes annotated with annotations
// such as @Component, @Repository or @Service and creates Spring beans from those classes
@ComponentScan("rewards.internal")
public class RewardsConfig {
	// TODO-02: Remove all of the @Bean methods above.
	// - Remove the code that autowires DataSource as well.
    // - Run the RewardNetworkTests test. It should fail. Why?
}
