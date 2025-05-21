package org.example.project.dbFactory

import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.example.project.BiteBuddyAppDb

actual class DatabaseFactory( private val context: Context) {

        actual suspend fun createDriver(): SqlDriver {
            val schema = BiteBuddyAppDb.Schema.synchronous()
            return AndroidSqliteDriver(
                schema, context, DB_FILE_NAME,
                callback = object : AndroidSqliteDriver.Callback(schema) {
                    override fun onOpen(db: SupportSQLiteDatabase) {
                        db.setForeignKeyConstraintsEnabled(true)
                    }
                }
            )
        }

}