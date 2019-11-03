/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.services.mailing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.services.EmailAddress;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailServiceTest {

	private EmailService emailService = null;
	private EmailAddress validAddress = null;

	@Before
	public void setup() throws Exception {
		emailService = EmailServiceManager.getDefaultService();
		validAddress = EmailAddress.getFromString("test@test.de");
	}

	@Test
	public void testSendEmailIgnoreExceptionInvalidInputShouldReturnFalse() {
		try {
			assertFalse(emailService.sendEmailIgnoreException(null, validAddress, "hi", "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, null, "hi", "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, null, "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, "", "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, "hi", null));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, "hi", ""));
		} catch (Exception ex) {
			Assert.fail("Silent mode does not allow exceptions");
		}
	}

	@Test
	public void testSendEmailIgnoreExceptionValidInputShouldReturnTrue() {
		try {
			assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, "hi", "body"));
		} catch (Exception ex) {
			Assert.fail("Silent mode does not allow exceptions");
		}
	}

	@Test(expected = MailingException.class)
	public void testSendEmailInvalidInputShouldThrowException() throws MailingException {
		emailService.sendEmail(validAddress, validAddress, "hi", null);
	}

	@Test
	public void testSendEmailValidInputShouldNotThrowAnException() throws MailingException {
		emailService.sendEmail(validAddress, validAddress, "hi", "body");
	}

	@Test
	public void testSendEmailIgnoreExceptionWithBccInvalidInputShouldReturnFalse() {
		try {
			assertFalse(emailService.sendEmailIgnoreException(null, validAddress, null, "hi", "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, null, null, "hi", "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, null, null, "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, null, "", "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, null, "hi", null));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, validAddress, null, "hi", ""));
		} catch (Exception ex) {
			Assert.fail("Silent mode does not allow exceptions");
		}
	}

	@Test
	public void testSendEmailIgnoreExceptionWithBccValidInputShouldReturnTrue() {
		try {
			assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, validAddress, "hi", "test"));
			assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, null, "hi", "test"));
		} catch (Exception ex) {
			Assert.fail("Silent mode does not allow exceptions");
		}
	}

	@Test(expected = MailingException.class)
	public void testSendEmailWithBccInvalidInputShouldThrowException() throws MailingException {
		emailService.sendEmail(validAddress, validAddress, validAddress, "hi", null);
	}

	@Test
	public void testSendEmailWithBccValidInputShouldNotThrowAnException() throws MailingException {
		emailService.sendEmail(validAddress, validAddress, validAddress, "hi", "body");
	}
}
