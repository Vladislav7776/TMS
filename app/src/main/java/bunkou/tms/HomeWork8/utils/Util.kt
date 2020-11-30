package bunkou.tms.HomeWork8.utils

import kotlinx.coroutines.*

fun launchIo(task: suspend () -> Unit) {
    CoroutineScope(Dispatchers.IO).launch {
        task()
    }
}

fun launchUi(task: suspend () -> Unit) {

    CoroutineScope(Dispatchers.Main).launch {
        task()
    }
}

suspend fun <R> launchForResult(task: suspend () -> R): R? {

    return CoroutineScope(Dispatchers.IO).async {
        task()
    }.await()

}