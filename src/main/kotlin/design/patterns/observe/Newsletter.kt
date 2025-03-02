package design.patterns.observe


internal interface Newsletter<T> {
    fun subscribe(subscriber: NewsletterListener)
    fun unsubscribe(subscriber: NewsletterListener)
    fun notifySubscribers()
}