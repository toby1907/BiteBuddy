package org.example.project.dbFactory

import app.cash.sqldelight.db.SqlDriver

const val DB_FILE_NAME = "biteBuddy.db"

expect class DatabaseFactory {
    suspend fun createDriver(): SqlDriver
}