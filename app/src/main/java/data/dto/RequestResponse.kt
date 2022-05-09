package data.dto

class RequestResponse<out T>(val status: Status, val data: T?, val error: Throwable? = null) {
    companion object {
        fun <T> success(data: T?): RequestResponse<T> {
            return RequestResponse(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, throwable: Throwable?): RequestResponse<T> {
            return RequestResponse(Status.ERROR, data, throwable)
        }

        fun <T> loading(data: T?): RequestResponse<T> {
            return RequestResponse(Status.LOADING, data, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}