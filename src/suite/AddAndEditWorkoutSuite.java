package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.EditWorkoutTest;
import test.WorkoutAddTest;

@RunWith(Suite.class)
@SuiteClasses({ WorkoutAddTest.class,  EditWorkoutTest.class })

public class AddAndEditWorkoutSuite {

}
