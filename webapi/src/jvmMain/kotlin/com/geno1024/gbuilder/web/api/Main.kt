package com.geno1024.gbuilder.web.api

import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

object Main
{
    @JvmStatic
    fun main(args: Array<String>)
    {
        HttpServer.create(InetSocketAddress(8080), 0).apply {
            createContext("")
            start()
        }
    }
}
