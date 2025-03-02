package design.patterns.observe

import org.junit.jupiter.api.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.DefaultAsserter.assertEquals

/**
 * Unit Tests for the Observer Pattern Implementation
 */
class NewsletterDisplayListenerTest {

    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()
    private val lineSeparator = System.lineSeparator()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        outputStreamCaptor.reset()
    }

    @Nested
    @DisplayName("When using Newsletter Observer")
    inner class NewsletterObserverTests {

        private fun normalizeLineEndings(text: String): String {
            return text.replace("\r\n", "\n").replace("\r", "\n")
        }


        @Test
        @DisplayName("Should notify all displays when new course is opened")
        fun `should notify both displays with the new course opened`() {
            // Given: Initialize newsletter and displays
            val monthlyNewsletter = UniversityNewsletter()
            val mobileDisplay = NewsletterDisplayListener(
                displayName = "Teléfono",
                newsletter = monthlyNewsletter
            )
            val webDisplay = NewsletterDisplayListener(
                displayName = "Pagina Web",
                newsletter = monthlyNewsletter
            )

            // When: Subscribe displays and update course data
            monthlyNewsletter.subscribe(mobileDisplay)
            monthlyNewsletter.subscribe(webDisplay)



            // Then: Verify both displays show correct information
            val expectedLines = listOf(
                "Mostrando en Teléfono [Curso Progra 2 abierto con capacidad de 30]",
                "Mostrando en Pagina Web [Curso Progra 2 abierto con capacidad de 30]"
            )
            val expectedOutput = expectedLines.joinToString(lineSeparator)


        }


    }
}
