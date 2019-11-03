package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.EmailServiceTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {EmailAddressTest.class, LogBuilderTest.class, EmailServiceTestSuite.class, UtilsTestSuite.class})
public class ServicesTestSuite {

}
