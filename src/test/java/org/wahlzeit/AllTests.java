package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.persistence.PersistenceTestSuite;
import org.wahlzeit.services.ServicesTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {HandlersTestSuite.class, PersistenceTestSuite.class, ModelTestSuite.class, ServicesTestSuite.class})
public class AllTests {

}
