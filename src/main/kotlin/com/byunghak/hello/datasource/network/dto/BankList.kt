package com.byunghak.hello.datasource.network.dto

import com.byunghak.hello.model.Bank

data class BankList (
    val results: Collection<Bank>
)