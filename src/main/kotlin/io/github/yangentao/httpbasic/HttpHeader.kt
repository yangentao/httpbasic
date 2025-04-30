@file:Suppress("unused")

package io.github.yangentao.httpbasic

import java.text.SimpleDateFormat
import java.util.*

class HttpHeader(val name: String, val value: String) {

    companion object {
        const val X_FORWARDED_FOR = "X-Forwarded-For"
        const val X_REAL_IP = "X-Real-IP"
        const val CONTENT_DISPOSITION = "Content-Disposition"

        const val ACCEPT = "Accept"
        const val ACCEPT_CHARSET = "Accept-Charset"
        const val ACCEPT_ENCODING = "Accept-Encoding"
        const val ACCEPT_LANGUAGE = "Accept-Language"
        const val ACCEPT_RANGES = "Accept-Ranges"
        const val ACCEPT_PATCH = "Accept-Patch"
        const val ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials"
        const val ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers"
        const val ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods"
        const val ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin"
        const val ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers"
        const val ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age"
        const val ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers"
        const val ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method"
        const val AGE = "Age"
        const val ALLOW = "Allow"
        const val AUTHORIZATION = "Authorization"
        const val CACHE_CONTROL = "Cache-Control"
        const val CONNECTION = "Connection"
        const val CONTENT_BASE = "Content-Base"
        const val CONTENT_ENCODING = "Content-Encoding"
        const val CONTENT_LANGUAGE = "Content-Language"
        const val CONTENT_LENGTH = "Content-Length"
        const val CONTENT_LOCATION = "Content-Location"
        const val CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding"
        const val CONTENT_MD5 = "Content-MD5"
        const val CONTENT_RANGE = "Content-Range"
        const val CONTENT_TYPE = "Content-Type"
        const val COOKIE = "Cookie"
        const val DATE = "Date"
        const val ETAG = "ETag"
        const val EXPECT = "Expect"
        const val EXPIRES = "Expires"
        const val FROM = "From"
        const val HOST = "Host"
        const val IF_MATCH = "If-Match"
        const val IF_MODIFIED_SINCE = "If-Modified-Since"
        const val IF_NONE_MATCH = "If-None-Match"
        const val IF_RANGE = "If-Range"
        const val IF_UNMODIFIED_SINCE = "If-Unmodified-Since"
        const val LAST_MODIFIED = "Last-Modified"
        const val LOCATION = "Location"
        const val MAX_FORWARDS = "Max-Forwards"
        const val ORIGIN = "Origin"
        const val PRAGMA = "Pragma"
        const val PROXY_AUTHENTICATE = "Proxy-Authenticate"
        const val PROXY_AUTHORIZATION = "Proxy-Authorization"
        const val RANGE = "Range"
        const val REFERER = "Referer"
        const val RETRY_AFTER = "Retry-After"
        const val SEC_WEBSOCKET_KEY1 = "Sec-WebSocket-Key1"
        const val SEC_WEBSOCKET_KEY2 = "Sec-WebSocket-Key2"
        const val SEC_WEBSOCKET_LOCATION = "Sec-WebSocket-Location"
        const val SEC_WEBSOCKET_ORIGIN = "Sec-WebSocket-Origin"
        const val SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol"
        const val SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version"
        const val SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key"
        const val SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept"
        const val SERVER = "Server"
        const val SET_COOKIE = "Set-Cookie"
        const val SET_COOKIE2 = "Set-Cookie2"
        const val TE = "TE"
        const val TRAILER = "Trailer"
        const val TRANSFER_ENCODING = "Transfer-Encoding"
        const val UPGRADE = "Upgrade"
        const val USER_AGENT = "User-Agent"
        const val VARY = "Vary"
        const val VIA = "Via"
        const val WARNING = "Warning"
        const val WEBSOCKET_LOCATION = "WebSocket-Location"
        const val WEBSOCKET_ORIGIN = "WebSocket-Origin"
        const val WEBSOCKET_PROTOCOL = "WebSocket-Protocol"
        const val WWW_AUTHENTICATE = "WWW-Authenticate"

        private val formatterLocal: ThreadLocal<SimpleDateFormat> = ThreadLocal.withInitial { SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).apply { this.timeZone = TimeZone.getTimeZone("GMT") } }
        val httpDateFormater: SimpleDateFormat get() = formatterLocal.get()

        fun formatHttpDate(date: Long): String {
            return httpDateFormater.format(Date(date / 1000 * 1000))
        }

        fun parseHttpDate(value: String): Long {
            return ((httpDateFormater.parse(value)?.time) ?: -1) / 1000 * 1000
        }

    }
}
//
//fun main() {
//    val date = java.util.Date()
//    val s = HttpHeader.formatHttpDate(date.time)
//    val d = HttpHeader.parseHttpDate(s)
//    println(date.time)
//    println(s)
//    println(d)
//    println(Date(d))
//}