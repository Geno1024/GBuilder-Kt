package com.geno1024.gbuilder.db.structures

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

@Suppress("unused")
object User : Table()
{
    val id = long("id").autoIncrement().uniqueIndex()
    val nickname = text("nickname").uniqueIndex()
    val email = text("email").nullable()
    val website = text("website").nullable()
    val motto = text("motto").nullable()
    val location = text("location").nullable()
    val motd = text("motd").nullable()
    val createdAt = datetime("createdAt").default(LocalDateTime.now())
    val updatedAt = datetime("updatedAt").default(LocalDateTime.now())

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
