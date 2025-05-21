package org.example.project.dbFactory

import app.cash.sqldelight.db.SqlDriver

actual class DatabaseFactory {
    actual suspend fun createDriver(): SqlDriver {
        TODO("Not yet implemented")
    }
}