@file:Suppress("unused")

package io.github.yangentao.httpbasic

import java.util.*

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