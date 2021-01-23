package com.byunghak.hello.datasource.mock

import com.byunghak.hello.datasource.BankDataSource
import com.byunghak.hello.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    val banks = listOf(
        Bank("1", 3.14, 1),
        Bank("2", 3.14, 2),
        Bank("3", 1.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull {it.accountNumber == accountNumber}
        ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
}