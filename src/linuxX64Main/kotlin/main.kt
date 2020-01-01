import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.utils.io.core.use
import kotlinx.coroutines.*
suspend fun doFetch() {
    HttpClient().use {
        val htmlContent = it.get<String>("https://en.wikipedia.org/wiki/Main_Page")
        println(htmlContent)
    }
}


fun works() {
    runBlocking {
        doFetch()
    }
}

fun doesNotWork() {
    runBlocking(Dispatchers.Default) {
        doFetch()
    }
}

fun main() {
    doesNotWork()
}