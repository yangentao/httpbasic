@file:Suppress("unused")

package io.github.yangentao.httpbasic

import java.io.File

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