package dessign.patterns.singleton

/**
 * UNIT TESTING EXAMPLE: SINGLETON PATTERN
 *
 * Purpose:
 * This test class demonstrates how to properly test a Singleton pattern implementation
 * in Kotlin. It serves as an educational example of:
 * - Unit test structure and organization
 * - Test documentation best practices
 * - System output testing
 * - Cross-platform compatibility
 * - JUnit 5 features
 *
 * Key Concepts Demonstrated:
 * 1. Test Setup and Teardown
 * 2. Test Case Organization
 * 3. Platform Independence
 * 4. Output Validation
 * 5. Singleton Pattern Verification
 *
 * @author Your Name
 * @version 1.0
 * @see Singleton
 * @see MyClass
 */

import com.github.stefanbirkner.systemlambda.SystemLambda

import design.patterns.singleton.Singleton
import design.patterns.singleton.MyClass

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals
import kotlin.test.assertSame

@DisplayName("Singleton Pattern Tests")
class SingletonTest {
    // SECTION: Test Environment Setup

    /**
     * Stores the original System.out PrintStream to restore it after tests
     * This is important to prevent affecting other tests in the suite
     */
    private val standardOut = System.out

    /**
     * Captures system output during tests
     * Used to verify what would normally be printed to console
     */
    private val outputStreamCaptor = ByteArrayOutputStream()

    /**
     * Platform-specific line separator
     * Ensures tests work correctly on different operating systems
     */
    private val lineSeparator = System.lineSeparator()

    /**
     * Test Setup Method
     * Executed before each test case
     *
     * Purpose:
     * 1. Redirects system output to our capturer
     * 2. Resets Singleton to initial state
     */
//    @BeforeEach
//    fun setUp() {
//        // Redirect system output to our capturer
//        System.setOut(PrintStream(outputStreamCaptor))
//        // Reset singleton to known initial state
//        Singleton.courseName = "Programación App Móvil"
//    }

    /**
     * Test Cleanup Method
     * Executed after each test case
     *
     * Purpose:
     * 1. Restores original system output
     * 2. Clears output capturer buffer
     */
    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        outputStreamCaptor.reset()
    }

    // SECTION: Test Cases

    /**
     * Nested test class for Singleton behavior
     * Groups related test cases for better organization
     */
    @Nested
    @DisplayName("When using Singleton")
    inner class SingletonBehavior {


        @Test
        @DisplayName("Should maintain single instance state across multiple classes")
        fun `should maintain single instance state`() {


            val output = SystemLambda.tapSystemOut {

                Singleton.printName()

            }


            // el before each simpre va a alterar esto, por lo que si no lo comento nunca será igual.... Para que el before each

            assertEquals(
                "[SE INVOCA LA CLASE SOLO LA PRIMERA VEZ]\r\n"  +
                        "Programación App Móvil\r\n",
                output
            )





        }






        @Test
        @DisplayName("Should have only one instance")
        fun `should verify single instance`() {
            // GIVEN: Two references to the Singleton
            val instance1 = Singleton
            val instance2 = Singleton

            // THEN: Verify both references point to same instance
            assertSame(
                instance1,
                instance2,
                "Multiple Singleton references must point to the same instance"
            )
        }
















    }
}

/**
 * LEARNING OUTCOMES
 *
 * After studying this test class, students should understand:
 *
 * 1. Test Structure:
 *    - How to organize tests using @Nested classes
 *    - Proper use of @BeforeEach and @AfterEach
 *    - How to write clear test case descriptions
 *
 * 2. Testing Practices:
 *    - How to capture and verify system output
 *    - How to handle platform-specific issues
 *    - How to write clear assertions with meaningful messages
 *
 * 3. Documentation:
 *    - How to write clear KDoc comments
 *    - How to document test purposes and steps
 *    - How to organize code sections logically
 *
 * 4. Singleton Pattern Testing:
 *    - How to verify single instance behavior
 *    - How to test state management
 *    - How to verify behavior across multiple classes
 */