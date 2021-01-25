package com.byunghak.hello.datasource.mock

import com.byunghak.hello.datasource.BankDataSource
import com.byunghak.hello.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository
class MockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank("1", 3.14, 1),
        Bank("2", 3.14, 2),
        Bank("3", 1.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull {it.accountNumber == accountNumber}
        ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any{it.accountNumber == bank.accountNumber}) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists.")
        }
        banks.add(bank)
        return bank
    }
}