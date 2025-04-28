package io.github.yangentao.httpbasic

import java.io.File

class HttpFileParam(val name: String, val filename: String, val file: File, val mime: String = Mimes.ofFile(filename)) {
    override fun toString(): String {
        return "HttpFileParam(name=$name, filename=$filename, length:${file.length()}, file:${file.canonicalPath}, mime:$mime)"
    }
}