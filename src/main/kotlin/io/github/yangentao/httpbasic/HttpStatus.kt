package io.github.yangentao.httpbasic

class HttpStatus(val code: Int, val reason: String = valueOf(code).reason) {

    override fun toString(): String {
        return "$code $reason"
    }

    companion object {
        val CONTINUE: HttpStatus = newStatus(100, "Continue")
        val SWITCHING_PROTOCOLS: HttpStatus = newStatus(101, "Switching Protocols")
        val PROCESSING: HttpStatus = newStatus(102, "Processing")
        val EARLY_HINTS: HttpStatus = newStatus(103, "Early Hints")
        val OK: HttpStatus = newStatus(200, "OK")
        val CREATED: HttpStatus = newStatus(201, "Created")
        val ACCEPTED: HttpStatus = newStatus(202, "Accepted")
        val NON_AUTHORITATIVE_INFORMATION: HttpStatus = newStatus(203, "Non-Authoritative Information")
        val NO_CONTENT: HttpStatus = newStatus(204, "No Content")
        val RESET_CONTENT: HttpStatus = newStatus(205, "Reset Content")
        val PARTIAL_CONTENT: HttpStatus = newStatus(206, "Partial Content")
        val MULTI_STATUS: HttpStatus = newStatus(207, "Multi-Status")
        val MULTIPLE_CHOICES: HttpStatus = newStatus(300, "Multiple Choices")
        val MOVED_PERMANENTLY: HttpStatus = newStatus(301, "Moved Permanently")
        val FOUND: HttpStatus = newStatus(302, "Found")
        val SEE_OTHER: HttpStatus = newStatus(303, "See Other")
        val NOT_MODIFIED: HttpStatus = newStatus(304, "Not Modified")
        val USE_PROXY: HttpStatus = newStatus(305, "Use Proxy")
        val TEMPORARY_REDIRECT: HttpStatus = newStatus(307, "Temporary Redirect")
        val PERMANENT_REDIRECT: HttpStatus = newStatus(308, "Permanent Redirect")
        val BAD_REQUEST: HttpStatus = newStatus(400, "Bad Request")
        val UNAUTHORIZED: HttpStatus = newStatus(401, "Unauthorized")
        val PAYMENT_REQUIRED: HttpStatus = newStatus(402, "Payment Required")
        val FORBIDDEN: HttpStatus = newStatus(403, "Forbidden")
        val NOT_FOUND: HttpStatus = newStatus(404, "Not Found")
        val METHOD_NOT_ALLOWED: HttpStatus = newStatus(405, "Method Not Allowed")
        val NOT_ACCEPTABLE: HttpStatus = newStatus(406, "Not Acceptable")
        val PROXY_AUTHENTICATION_REQUIRED: HttpStatus = newStatus(407, "Proxy Authentication Required")
        val REQUEST_TIMEOUT: HttpStatus = newStatus(408, "Request Timeout")
        val CONFLICT: HttpStatus = newStatus(409, "Conflict")
        val GONE: HttpStatus = newStatus(410, "Gone")
        val LENGTH_REQUIRED: HttpStatus = newStatus(411, "Length Required")
        val PRECONDITION_FAILED: HttpStatus = newStatus(412, "Precondition Failed")
        val REQUEST_ENTITY_TOO_LARGE: HttpStatus = newStatus(413, "Request Entity Too Large")
        val REQUEST_URI_TOO_LONG: HttpStatus = newStatus(414, "Request-URI Too Long")
        val UNSUPPORTED_MEDIA_TYPE: HttpStatus = newStatus(415, "Unsupported Media Type")
        val REQUESTED_RANGE_NOT_SATISFIABLE: HttpStatus = newStatus(416, "Requested Range Not Satisfiable")
        val EXPECTATION_FAILED: HttpStatus = newStatus(417, "Expectation Failed")
        val MISDIRECTED_REQUEST: HttpStatus = newStatus(421, "Misdirected Request")
        val UNPROCESSABLE_ENTITY: HttpStatus = newStatus(422, "Unprocessable Entity")
        val LOCKED: HttpStatus = newStatus(423, "Locked")
        val FAILED_DEPENDENCY: HttpStatus = newStatus(424, "Failed Dependency")
        val UNORDERED_COLLECTION: HttpStatus = newStatus(425, "Unordered Collection")
        val UPGRADE_REQUIRED: HttpStatus = newStatus(426, "Upgrade Required")
        val PRECONDITION_REQUIRED: HttpStatus = newStatus(428, "Precondition Required")
        val TOO_MANY_REQUESTS: HttpStatus = newStatus(429, "Too Many Requests")
        val REQUEST_HEADER_FIELDS_TOO_LARGE: HttpStatus = newStatus(431, "Request Header Fields Too Large")
        val INTERNAL_SERVER_ERROR: HttpStatus = newStatus(500, "Internal Server Error")
        val NOT_IMPLEMENTED: HttpStatus = newStatus(501, "Not Implemented")
        val BAD_GATEWAY: HttpStatus = newStatus(502, "Bad Gateway")
        val SERVICE_UNAVAILABLE: HttpStatus = newStatus(503, "Service Unavailable")
        val GATEWAY_TIMEOUT: HttpStatus = newStatus(504, "Gateway Timeout")
        val HTTP_VERSION_NOT_SUPPORTED: HttpStatus = newStatus(505, "HTTP Version Not Supported")
        val VARIANT_ALSO_NEGOTIATES: HttpStatus = newStatus(506, "Variant Also Negotiates")
        val INSUFFICIENT_STORAGE: HttpStatus = newStatus(507, "Insufficient Storage")
        val NOT_EXTENDED: HttpStatus = newStatus(510, "Not Extended")
        val NETWORK_AUTHENTICATION_REQUIRED: HttpStatus = newStatus(511, "Network Authentication Required")

        private fun newStatus(statusCode: Int, reasonPhrase: String): HttpStatus {
            return HttpStatus(statusCode, reasonPhrase)
        }

        fun valueOf(code: Int): HttpStatus {
            return valueOf0(code) ?: HttpStatus(code, "reasonless")
        }

        private fun valueOf0(code: Int): HttpStatus? {
            when (code) {
                100 -> return CONTINUE
                101 -> return SWITCHING_PROTOCOLS
                102 -> return PROCESSING
                103 -> return EARLY_HINTS
                200 -> return OK
                201 -> return CREATED
                202 -> return ACCEPTED
                203 -> return NON_AUTHORITATIVE_INFORMATION
                204 -> return NO_CONTENT
                205 -> return RESET_CONTENT
                206 -> return PARTIAL_CONTENT
                207 -> return MULTI_STATUS
                300 -> return MULTIPLE_CHOICES
                301 -> return MOVED_PERMANENTLY
                302 -> return FOUND
                303 -> return SEE_OTHER
                304 -> return NOT_MODIFIED
                305 -> return USE_PROXY
                307 -> return TEMPORARY_REDIRECT
                308 -> return PERMANENT_REDIRECT
                400 -> return BAD_REQUEST
                401 -> return UNAUTHORIZED
                402 -> return PAYMENT_REQUIRED
                403 -> return FORBIDDEN
                404 -> return NOT_FOUND
                405 -> return METHOD_NOT_ALLOWED
                406 -> return NOT_ACCEPTABLE
                407 -> return PROXY_AUTHENTICATION_REQUIRED
                408 -> return REQUEST_TIMEOUT
                409 -> return CONFLICT
                410 -> return GONE
                411 -> return LENGTH_REQUIRED
                412 -> return PRECONDITION_FAILED
                413 -> return REQUEST_ENTITY_TOO_LARGE
                414 -> return REQUEST_URI_TOO_LONG
                415 -> return UNSUPPORTED_MEDIA_TYPE
                416 -> return REQUESTED_RANGE_NOT_SATISFIABLE
                417 -> return EXPECTATION_FAILED
                421 -> return MISDIRECTED_REQUEST
                422 -> return UNPROCESSABLE_ENTITY
                423 -> return LOCKED
                424 -> return FAILED_DEPENDENCY
                425 -> return UNORDERED_COLLECTION
                426 -> return UPGRADE_REQUIRED
                428 -> return PRECONDITION_REQUIRED
                429 -> return TOO_MANY_REQUESTS
                431 -> return REQUEST_HEADER_FIELDS_TOO_LARGE
                500 -> return INTERNAL_SERVER_ERROR
                501 -> return NOT_IMPLEMENTED
                502 -> return BAD_GATEWAY
                503 -> return SERVICE_UNAVAILABLE
                504 -> return GATEWAY_TIMEOUT
                505 -> return HTTP_VERSION_NOT_SUPPORTED
                506 -> return VARIANT_ALSO_NEGOTIATES
                507 -> return INSUFFICIENT_STORAGE
                510 -> return NOT_EXTENDED
                511 -> return NETWORK_AUTHENTICATION_REQUIRED
            }
            return null
        }
    }
}
