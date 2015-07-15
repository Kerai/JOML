package org.joml.test;

import junit.framework.TestCase;

import org.joml.*;

/**
 * Test class for {@link Quaternionf}.
 * @author Sebastian Fellner
 */
public class QuaternionTest extends TestCase {
	
	public void testMulQuaternionQuaternionQuaternion() {
		// Multiplication with the identity quaternion should change nothing
		Quaternionf testQuat = new Quaternionf(1f, 23.3f, -7.57f, 2.1f);
		Quaternionf identityQuat = new Quaternionf().identity();
		Quaternionf resultQuat = new Quaternionf();
		
		testQuat.mul(identityQuat, resultQuat);
		assertTrue(TestUtil.quatEqual(testQuat, resultQuat, TestUtil.STANDARD_AROUND_ZERO_PRECISION_FLOAT));
		
		identityQuat.mul(testQuat, resultQuat);
		assertTrue(TestUtil.quatEqual(testQuat, resultQuat, TestUtil.STANDARD_AROUND_ZERO_PRECISION_FLOAT));

		// Multiplication with conjugate should give (0, 0, 0, dot(this, this))
		Quaternionf conjugate = new Quaternionf();
		testQuat.conjugate(conjugate);
		testQuat.mul(conjugate, resultQuat);
		
		Quaternionf wantedResultQuat = new Quaternionf(0, 0, 0, testQuat.dot(testQuat));
		assertTrue(TestUtil.quatEqual(resultQuat, wantedResultQuat, TestUtil.MANY_OPS_AROUND_ZERO_PRECISION_FLOAT));
	}

	public static void main(String[] args) {
        System.err.println(Integer.toString(Float.floatToRawIntBits(1.0f), 16));
    }
	
}
