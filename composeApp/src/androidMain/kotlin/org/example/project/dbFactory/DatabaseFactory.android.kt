package org.example.project.dbFactory

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.example.project.BiteBuddyAppDb



actual class DatabaseFactory(
    private val context: Context
) {

    actual suspend fun createDriver():SqlDriver{
        return AndroidSqliteDriver(BiteBuddyAppDb.Schema.synchronous(),context, DB_FILE_NAME,)
    }

}