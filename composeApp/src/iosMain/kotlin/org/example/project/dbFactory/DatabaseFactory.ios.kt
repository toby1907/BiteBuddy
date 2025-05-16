package org.example.project.dbFactory

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.cash.sqldelight.db.SqlDriver
import org.example.project.BiteBuddyAppDb
import app.cash.sqldelight.async.coroutines.synchronous
import co.touchlab.sqliter.DatabaseConfiguration

actual class DatabaseFactory {
    actual suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            BiteBuddyAppDb.Schema.synchronous(), DB_FILE_NAME,
            onConfiguration = {
                it.copy(
                    extendedConfig = DatabaseConfiguration.Extended(
                        foreignKeyConstraints = true
                    )
                )
            }
        )
    }
}