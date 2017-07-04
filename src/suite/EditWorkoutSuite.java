package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.EditWorkoutTest;

@RunWith(Suite.class)
@SuiteClasses({ WorkoutSuite.class,  EditWorkoutTest.class })
public class EditWorkoutSuite {

}
