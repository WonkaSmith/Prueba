package design.patterns.observe


interface NewsletterListener {
    fun update(courseName: String, courseMax: Int): NewsletterListener
}