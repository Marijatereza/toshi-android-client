/*
 * 	Copyright (c) 2017. Toshi Inc
 *
 *  This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.toshi.keystore

import com.toshi.crypto.keyStore.WalletKeystore.WalletKeyStoreHandler
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class WalletKeystoreTests {

    private val testWalletAlias = "testWalletAlias"
    private val masterSeed = "abandon abandon abandon abandon abandon abandon abandon abandon abandon abandon abandon abandon"
    private val walletKeystore by lazy { WalletKeyStoreHandler(testWalletAlias) }

    @Test
    fun testEncryptionAndDecryption() {
        val encryptedMasterSeed = walletKeystore.encrypt(masterSeed)
        val decryptedMasterSeed = walletKeystore.decrypt(encryptedMasterSeed, {})
        assertNotEquals(encryptedMasterSeed, decryptedMasterSeed)
        assertEquals(masterSeed, decryptedMasterSeed)
    }

    @After
    fun after() {
        walletKeystore.delete(testWalletAlias)
    }
}