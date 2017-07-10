package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.FilterWorkoutTest;
import test.HeaderTest;
import test.SortWorkoutTest;

@RunWith(Suite.class)
@SuiteClasses({ HeaderTest.class, FilterWorkoutTest.class, SortWorkoutTest.class, })
public class SortAndFilterWorkout {

}
