package org.example.project.features.common.data.database

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.example.project.BiteBuddyAppDb
import org.example.project.dbFactory.DatabaseFactory
import orgexampleproject.Recipe

class DbHelper(
    private val driverFactory: DatabaseFactory
) {

    private var db: BiteBuddyAppDb? = null
    private val mutex = Mutex()

    suspend fun <Result : Any?> withDatabase(block: suspend (BiteBuddyAppDb) -> Result) =
        mutex.withLock {
            if (db == null) {
                db = createDb(driverFactory)
            }

            return@withLock block(db!!)
        }

    private suspend fun createDb(driverFactory: DatabaseFactory): BiteBuddyAppDb {
        return BiteBuddyAppDb(
            driver = driverFactory.createDriver(),
            RecipeAdapter = Recipe.Adapter(
                ingredientsAdapter = org.example.project.features.common.data.database.listOfStringsAdapter,
                instructionsAdapter = org.example.project.features.common.data.database.listOfStringsAdapter
            )
        )
    }
}