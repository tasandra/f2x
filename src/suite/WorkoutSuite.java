package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.WorkoutAddTest;

@RunWith(Suite.class)
@SuiteClasses({ WorkoutAddTest.class })
public class WorkoutSuite {

}
