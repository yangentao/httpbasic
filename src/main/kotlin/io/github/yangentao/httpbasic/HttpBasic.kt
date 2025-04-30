@file:Suppress("unused")

package io.github.yangentao.httpbasic

import java.io.File
import java.util.*

/**
 * Multipart form data, file upload
 */
open class HttpFileParam(val name: String, val httpFile: HttpFile) {
    val filename: String get() = httpFile.filename
    val file: File get() = httpFile.file
    val mime: String get() = httpFile.mime

    override fun toString(): String {
        return "HttpFileParam(name=$name, filename=$filename, length:${file.length()}, file:${file.canonicalPath}, mime:$mime)"
    }
}

open class HttpFile(val file: File, val filename: String = file.name, val mime: String = Mimes.ofFile(filename)) {
    override fun toString(): String {
        return "HttpFile(file:${file.canonicalPath}, filename=$filename, mime:$mime)"
    }
}

fun File.httpFile(filename: String? = null, mime: String? = null) = HttpFile(this, filename ?: this.name, mime ?: Mimes.ofFile(filename ?: this.name))

/**
 * Ignore case map, http headers
 */
open class HeaderMap(map: Map<String, String>? = null, pairs: Iterable<Pair<String, String>>? = null, private val treeMap: TreeMap<String, String> = TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER)) :
    MutableMap<String, String> by treeMap {
    init {
        if (map != null) putAll(map)
        if (pairs != null) putAll(pairs)
    }
}

/**
 * Ignore case map, http parameters
 */
open class ParameterMap(
    map: Map<String, List<String>>? = null,
    pairs: Iterable<Pair<String, List<String>>>? = null,
    private val treeMap: TreeMap<String, ArrayList<String>> = TreeMap<String, ArrayList<String>>(String.CASE_INSENSITIVE_ORDER)
) :
    MutableMap<String, ArrayList<String>> by treeMap {
    init {
        if (map != null) {
            for (e in map.entries) {
                appendAll(e.key, e.value)
            }
        }
        if (pairs != null) {
            for (p in pairs) {
                appendAll(p.first, p.second)
            }
        }
    }

    fun getValue(key: String): String? {
        return this[key]?.firstOrNull()
    }

    fun setValue(key: String, value: String) {
        this[key] = arrayListOf(value)
    }

    fun appendValue(key: String, value: String) = getOrPut(key) { ArrayList() }.add(value)
    fun appendAll(key: String, value: Iterable<String>) = getOrPut(key) { ArrayList() }.addAll(value)
    fun listValue(key: String): ArrayList<String> = getOrPut(key) { ArrayList() }
    fun firstValue(key: String): String? = this[key]?.firstOrNull()
}