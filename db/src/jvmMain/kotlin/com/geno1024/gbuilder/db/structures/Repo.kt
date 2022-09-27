package com.geno1024.gbuilder.db.structures

import org.jetbrains.exposed.sql.ForeignKeyConstraint
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

@Suppress("unused")
object Repo : Table()
{
    val id = long("id").autoIncrement().uniqueIndex()
    val name = text("name")
    val byUser = long("byUser").apply {
        foreignKey = ForeignKeyConstraint(
            mapOf(this to User.id),
            ReferenceOption.NO_ACTION,
            ReferenceOption.NO_ACTION,
            "fk_byuser"
        )
    }
    val description = text("description").nullable()
    val website = text("website").nullable()
    val pathToRepo = text("pathToRepo")

    override val primaryKey: PrimaryKey = PrimaryKey(id)

}
